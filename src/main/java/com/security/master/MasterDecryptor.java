package com.security.master;

import com.security.constants.EncryptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MasterDecryptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterDecryptor.class.getName());
    static String algorithm = EncryptionConstants.ALGORITHM.getStringValue();
    static int keyLength = EncryptionConstants.KEY_LENGTH.getIntValue();
    static int gcmLength = EncryptionConstants.GCM_IV_LENGTH.getIntValue();
    static int gcmTagLength = EncryptionConstants.GCM_TAG_LENGTH.getIntValue();
    static int saltLength = EncryptionConstants.SALT_LENGTH.getIntValue();
    static int iterations = EncryptionConstants.ITERATIONS.getIntValue();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Console console = System.console();

            LOGGER.info("Enter the folder path to decrypt .bin files under (e.g., D:\\Documents): ");
            String folderPath = scanner.nextLine().trim();

            char[] passwordChars;
            if (console != null) {
                // Console available - secure password input without echo
                passwordChars = console.readPassword("Enter the decryption password: ");
            } else {
                // Fallback for IDEs or non-interactive environments
                LOGGER.error("Warning: Console not available. Password will be visible.");
                LOGGER.info("Enter the decryption password: ");
                String password = scanner.nextLine().trim();
                passwordChars = password.toCharArray();
            }
            if (passwordChars == null || passwordChars.length == 0) {
                LOGGER.info("No password entered. Exiting.");
                return;
            }
            String password = new String(passwordChars);
            Arrays.fill(passwordChars, ' ');
            List<Path> binFiles = Files.list(Paths.get(folderPath))
                    .filter(path -> path.toString().toLowerCase().matches(".*\\.\\d{8}-\\d{6}+\\.bin$"))
                    .collect(Collectors.toList());
            if (binFiles.isEmpty()) {
                LOGGER.info("No .bin files with .YYYYMMDD-HHMMSS-ZZZ.bin pattern found in the specified folder: {}", folderPath);
                return;
            }
            for (Path binFile : binFiles) {
                String encryptedFile = binFile.toString();
                String decryptedFile = getDecryptedFileName(encryptedFile);
                decryptFile(encryptedFile, decryptedFile, password);
                LOGGER.info("Decrypted: {} -> {}",encryptedFile, decryptedFile);
                try {
                    Files.delete(binFile);
                    LOGGER.info("Deleted encrypted file: {} ", encryptedFile);
                } catch (IOException e) {
                    LOGGER.error("Warning: Could not delete encrypted file: {} ({})", encryptedFile, e.getMessage());
                }
            }
            LOGGER.info("Decryption completed for all .bin files.");
            scanner.close();
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    public static void decryptFile(String encryptedFile, String decryptedFile, String password) throws Exception {
        // Validate input file
        File file = new File(encryptedFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Encrypted file does not exist: " + encryptedFile);
        }
        byte[] fileBytes = readFileAsBytes(encryptedFile);
        if (fileBytes.length < saltLength + gcmLength + 4) {
            throw new IllegalArgumentException("Invalid encrypted file format");
        }
        byte[] salt = new byte[saltLength];
        byte[] iv = new byte[gcmLength];
        byte[] extensionLengthBytes = new byte[4];

        System.arraycopy(fileBytes, 0, salt, 0, saltLength);
        System.arraycopy(fileBytes, saltLength, iv, 0, gcmLength);
        System.arraycopy(fileBytes, saltLength + gcmLength, extensionLengthBytes, 0, 4);

        int extensionLength = ByteBuffer.wrap(extensionLengthBytes).getInt();
        if (fileBytes.length < saltLength + gcmLength + 4 + extensionLength) {
            throw new IllegalArgumentException("Invalid encrypted file format: extension length mismatch");
        }

        byte[] extensionBytes = new byte[extensionLength];
        System.arraycopy(fileBytes, saltLength + gcmLength + 4, extensionBytes, 0, extensionLength);

        byte[] encryptedData = new byte[fileBytes.length - saltLength - gcmLength - 4 - extensionLength];
        System.arraycopy(fileBytes, saltLength + gcmLength + 4 + extensionLength, encryptedData, 0, encryptedData.length);

        // Derive the AES key from the password
        SecretKey key = deriveKey(password, salt);

        // Initialize cipher for decryption
        Cipher cipher = Cipher.getInstance(algorithm);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(gcmTagLength, iv);
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
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
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

    // Gets the decrypted file name by removing .YYYYMMDD-HHMMSS-ZZZ.bin suffix and using stored extension
    private static String getDecryptedFileName(String encryptedFile) throws IOException {
        File file = new File(encryptedFile);
        String fileName = file.getName();
        String parentDir = file.getParent() != null ? file.getParent() : ".";

        // Read the extension from the encrypted file
        try (FileInputStream fis = new FileInputStream(encryptedFile)) {
            byte[] salt = new byte[saltLength];
            byte[] iv = new byte[gcmLength];
            byte[] extensionLengthBytes = new byte[4];

            if (fis.read(salt) != saltLength || fis.read(iv) != gcmLength || fis.read(extensionLengthBytes) != 4) {
                throw new IOException("Invalid encrypted file format");
            }

            int extensionLength = ByteBuffer.wrap(extensionLengthBytes).getInt();
            byte[] extensionBytes = new byte[extensionLength];
            if (fis.read(extensionBytes) != extensionLength) {
                throw new IOException("Invalid extension length in encrypted file");
            }

            String extension = new String(extensionBytes, StandardCharsets.UTF_8);

            // Remove .YYYYMMDD-HHMMSS-ZZZ.bin suffix
            String pattern = "\\.\\d{8}-\\d{6}+\\.bin$";
            String baseName = fileName.replaceAll(pattern, "");
            return parentDir + File.separator + baseName + extension;
        }
    }
}