package com.security.master;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MasterEncryptor {
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
            System.out.print("Enter the folder path to encrypt files under (e.g., D:\\Documents): ");
            String folderPath = scanner.nextLine().trim();

            // Prompt for password
            System.out.print("Enter the encryption password: ");
            String password = scanner.nextLine().trim();

            // Generate date-time suffix
            ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
            String dateTimeSuffix = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            // Scan for all files in the folder (exclude directories)
            List<Path> files = Files.list(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            if (files.isEmpty()) {
                System.out.println("No files found in the specified folder: " + folderPath);
                return;
            }

            // Encrypt each file
            for (Path file : files) {
                String inputFile = file.toString();
                String encryptedFile = folderPath + File.separator +
                        getFileNameWithoutExtension(file.getFileName().toString()) +
                        "." + dateTimeSuffix + ".bin";

                encryptFile(inputFile, encryptedFile, password);
                System.out.println("Encrypted: " + inputFile + " -> " + encryptedFile);
            }

            System.out.println("Encryption completed for all files.");
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Encrypts the input file and writes the result to encryptedFile
    public static void encryptFile(String inputFile, String encryptedFile, String password) throws Exception {
        // Validate input file
        File file = new File(inputFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Input file does not exist: " + inputFile);
        }

        // Read the input file as bytes
        byte[] fileBytes = readFileAsBytes(inputFile);

        // Generate a random salt and IV
        byte[] salt = generateRandomBytes(SALT_LENGTH);
        byte[] iv = generateRandomBytes(GCM_IV_LENGTH);

        // Derive the AES key from the password
        SecretKey key = deriveKey(password, salt);

        // Initialize cipher for encryption
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

        // Encrypt the content
        byte[] encryptedBytes = cipher.doFinal(fileBytes);

        // Get the file extension
        String extension = getFileExtension(inputFile);
        byte[] extensionBytes = extension.getBytes("UTF-8");
        byte[] extensionLengthBytes = ByteBuffer.allocate(4).putInt(extensionBytes.length).array();

        // Write salt, IV, extension length, extension, and encrypted data to the output file
        try (FileOutputStream fos = new FileOutputStream(encryptedFile)) {
            fos.write(salt); // Write salt (16 bytes)
            fos.write(iv);   // Write IV (12 bytes)
            fos.write(extensionLengthBytes); // Write extension length (4 bytes)
            fos.write(extensionBytes); // Write extension
            fos.write(encryptedBytes); // Write encrypted data
        }
    }

    // Derives a SecretKey from a password and salt using PBKDF2
    private static SecretKey deriveKey(String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = skf.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }

    // Generates random bytes for salt or IV
    private static byte[] generateRandomBytes(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return bytes;
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

    // Gets the file name without extension
    private static String getFileNameWithoutExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
    }

    // Gets the file extension (including the dot, e.g., ".json")
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? "" : fileName.substring(dotIndex);
    }
}