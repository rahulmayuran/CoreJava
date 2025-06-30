package com.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileEncryptor {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_LENGTH = 256; // AES-256
    private static final int GCM_IV_LENGTH = 12; // Recommended IV length for GCM
    private static final int GCM_TAG_LENGTH = 128; // Authentication tag length in bits
    private static final int SALT_LENGTH = 16; // Salt length for PBKDF2
    private static final int ITERATIONS = 100000; // PBKDF2 iterations

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Prompt for input file
            System.out.print("Enter the path of the file to encrypt: ");
            String inputFile = scanner.nextLine().trim();

            // Prompt for password
            System.out.print("Enter the encryption password: ");
            String password = scanner.nextLine().trim();

            // Generate encrypted file name with date suffix in the same directory
            String dateSuffix = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File inputFileObj = new File(inputFile);
            String parentDir = inputFileObj.getParent() != null ? inputFileObj.getParent() : ".";
            String encryptedFile = parentDir + File.separator + getFileNameWithoutExtension(inputFile) + ".enc" + dateSuffix + ".bin";

            // Encrypt the file
            encryptFile(inputFile, encryptedFile, password);
            System.out.println("File encrypted successfully to: " + encryptedFile);

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

        // Write salt, IV, and encrypted data to the output file
        try (FileOutputStream fos = new FileOutputStream(encryptedFile)) {
            fos.write(salt); // Write salt
            fos.write(iv);   // Write IV
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
    private static String getFileNameWithoutExtension(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
    }
}