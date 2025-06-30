package com.security.file;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;

public class JavaEncryptorDecrypt {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_LENGTH = 256; // AES-256
    private static final int GCM_IV_LENGTH = 12; // Recommended IV length for GCM
    private static final int GCM_TAG_LENGTH = 128; // Authentication tag length in bits
    private static final int SALT_LENGTH = 16; // Salt length for PBKDF2
    private static final int ITERATIONS = 100000; // PBKDF2 iterations

    public static void main(String[] args) {
        try {
            String inputFile = "April.rtf"; // Input WordPad file (RTF)
            String encryptedFile = "encrypted.bin"; // Encrypted output file
            String decryptedFile = "decrypted.rtf"; // Decrypted output file
            String password = "MySecurePassword123"; // User-provided password

            // Encrypt the file
            encryptFile(inputFile, encryptedFile, password);
            System.out.println("File encrypted successfully to: " + encryptedFile);

            // Decrypt the file
            decryptFile(encryptedFile, decryptedFile, password);
            System.out.println("File decrypted successfully to: " + decryptedFile);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Encrypts the input file and writes the result to encryptedFile
    public static void encryptFile(String inputFile, String encryptedFile, String password) throws Exception {
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

        // Write salt, IV, and encrypted data to the output file
        try (FileOutputStream fos = new FileOutputStream(encryptedFile)) {
            fos.write(salt); // Write salt
            fos.write(iv);   // Write IV
            fos.write(encryptedBytes); // Write encrypted data
        }
    }

    // Decrypts the encrypted file and writes the result to decryptedFile
    public static void decryptFile(String encryptedFile, String decryptedFile, String password) throws Exception {
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
}