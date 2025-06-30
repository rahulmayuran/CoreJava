package com.security.folder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FolderDecryptor {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_LENGTH = 256; // AES-256
    private static final int GCM_IV_LENGTH = 12; // Recommended IV length for GCM
    private static final int GCM_TAG_LENGTH = 128; // Authentication tag length in bits
    private static final int SALT_LENGTH = 16; // Salt length for PBKDF2
    private static final int ITERATIONS = 100000; // PBKDF2 iterations

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Prompt for folder path
            System.out.print("Enter the folder path to scan for .bin files (e.g., D:\\Documents): ");
            String folderPath = scanner.nextLine().trim();

            // Prompt for password
            System.out.print("Enter the decryption password: ");
            String password = scanner.nextLine().trim();

            // Scan for .bin files with .encYYYYMMDD.bin pattern
            List<Path> binFiles = Files.list(Paths.get(folderPath))
                    .filter(path -> path.toString().toLowerCase().matches(".*\\.\\d{8}\\.bin$"))
                    .collect(Collectors.toList());

            if (binFiles.isEmpty()) {
                System.out.println("No .bin files with .YYYYMMDD.bin pattern found in the specified folder: " + folderPath);
                return;
            }

            // Decrypt each .bin file
            for (Path binFile : binFiles) {
                String encryptedFile = binFile.toString();
                String decryptedFile = getDecryptedFileName(encryptedFile);

                decryptFile(encryptedFile, decryptedFile, password);
                System.out.println("Decrypted: " + encryptedFile + " -> " + decryptedFile);
            }

            System.out.println("Decryption completed for all .bin files.");
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Decrypts the encrypted file and writes the result to decryptedFile
    public static void decryptFile(String encryptedFile, String decryptedFile, String password) throws Exception {
        // Validate input file
        File file = new File(encryptedFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Encrypted file does not exist: " + encryptedFile);
        }

        // Read the encrypted file
        byte[] fileBytes = readFileAsBytes(encryptedFile);

        // Extract salt, IV, and encrypted data
        if (fileBytes.length < SALT_LENGTH + GCM_IV_LENGTH) {
            throw new IllegalArgumentException("Invalid encrypted file format");
        }
        byte[] salt = new byte[SALT_LENGTH];
        byte[] iv = new byte[GCM_IV_LENGTH];
        byte[] encryptedData = new byte[fileBytes.length - SALT_LENGTH - GCM_IV_LENGTH];

        System.arraycopy(fileBytes, 0, salt, 0, SALT_LENGTH);
        System.arraycopy(fileBytes, SALT_LENGTH, iv, 0, GCM_IV_LENGTH);
        System.arraycopy(fileBytes, SALT_LENGTH + GCM_IV_LENGTH, encryptedData, 0, encryptedData.length);

        // Derive the AES key from the password
        SecretKey key = deriveKey(password, salt);

        // Initialize cipher for decryption
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

        // Decrypt the content
        byte[] decryptedBytes = cipher.doFinal(encryptedData);

        // Write decrypted content to the output file
        try (FileOutputStream fos = new FileOutputStream(decryptedFile)) {
            fos.write(decryptedBytes);
        }
    }

    // Derives a SecretKey from a password and salt using PBKDF2
    private static SecretKey deriveKey(String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = skf.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }

    // Reads the content of a file as bytes
    private static byte[] readFileAsBytes(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Gets the decrypted file name by removing .YYYYMMDD.bin suffix
    private static String getDecryptedFileName(String encryptedFile) {
        File file = new File(encryptedFile);
        String fileName = file.getName();
        // Remove .YYYYMMDD.bin suffix
        String pattern = "\\.\\d{8}\\.bin$";
        if (fileName.matches(".*" + pattern)) {
            fileName = fileName.replaceAll(pattern, "");
            return file.getParent() + File.separator + fileName + ".rtf";
        } else {
            // Fallback: remove .bin and add .rtf
            return file.getParent() + File.separator + fileName.replace(".bin", ".rtf");
        }
    }
}