package com.security.file;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Scanner;

public class FileDecryptor {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_LENGTH = 256; // AES-256
    private static final int GCM_IV_LENGTH = 12; // Recommended IV length for GCM
    private static final int GCM_TAG_LENGTH = 128; // Authentication tag length in bits
    private static final int SALT_LENGTH = 16; // Salt length for PBKDF2
    private static final int ITERATIONS = 100000; // PBKDF2 iterations

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Prompt for encrypted file
            System.out.print("Enter the path of the .bin file to decrypt: ");
            String encryptedFile = scanner.nextLine().trim();

            // Prompt for password
            System.out.print("Enter the decryption password: ");
            String password = scanner.nextLine().trim();

            // Generate decrypted file name by removing .encYYYYMMDD.bin suffix
            String decryptedFile = getDecryptedFileName(encryptedFile);

            // Decrypt the file
            decryptFile(encryptedFile, decryptedFile, password);
            System.out.println("File decrypted successfully to: " + decryptedFile);

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

    // Gets the decrypted file name by removing .encYYYYMMDD.bin suffix
    private static String getDecryptedFileName(String encryptedFile) {
        File file = new File(encryptedFile);
        String fileName = file.getName();
        // Remove .encYYYYMMDD.bin suffix (e.g., .enc20250630.bin)
        String pattern = "\\.enc\\d{8}\\.bin$";
        if (fileName.matches(".*" + pattern)) {
            fileName = fileName.replaceAll(pattern, "");
            // Assume .rtf extension for WordPad files; adjust if needed
            return file.getParent() + File.separator + fileName + ".rtf";
        } else {
            // Fallback: remove .bin and add .rtf
            return file.getParent() + File.separator + fileName.replace(".bin", ".rtf");
        }
    }
}