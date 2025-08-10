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
import java.security.SecureRandom;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MasterEncryptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MasterEncryptor.class.getName());
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

            // Prompt for folder path
            LOGGER.info("Enter the folder path to encrypt files under (e.g., D:\\Documents): ");
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

            ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
            String dateTimeSuffix = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            List<Path> files = Files.list(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            if (files.isEmpty()) {
                LOGGER.info("No files found in the specified folder: {}", folderPath);
                return;
            }

            // Encrypt each file
            for (Path file : files) {
                String inputFile = file.toString();
                String encryptedFile = folderPath + File.separator +
                        getFileNameWithoutExtension(file.getFileName().toString()) +
                        "." + dateTimeSuffix + ".bin";

                encryptFile(inputFile, encryptedFile, password);
                LOGGER.info("Encrypted: {} -> {}", inputFile, encryptedFile);

                try {
                    Files.delete(file);
                    LOGGER.info("Deleted original file: {}", inputFile);
                } catch (IOException e) {
                    LOGGER.error("Warning: Could not delete original file: {} ({})", inputFile, e.getMessage());
                }
            }

            LOGGER.info("Encryption completed for all files.");
            scanner.close();
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }
    public static void encryptFile(String inputFile, String encryptedFile, String password) throws Exception {
        // Validate input file
        File file = new File(inputFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Input file does not exist: " + inputFile);
        }

        byte[] fileBytes = readFileAsBytes(inputFile);

        // Generate a random salt and IV
        byte[] salt = generateRandomBytes(saltLength);
        byte[] iv = generateRandomBytes(gcmLength);

        // Derive the AES key from the password
        SecretKey key = deriveKey(password, salt);

        // Initialize cipher for encryption
        Cipher cipher = Cipher.getInstance(algorithm);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(gcmTagLength, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

        // Encrypt the content
        byte[] encryptedBytes = cipher.doFinal(fileBytes);

        // Get the file extension
        String extension = getFileExtension(inputFile);
        byte[] extensionBytes = extension.getBytes(StandardCharsets.UTF_8);
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
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
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

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex == -1 ? "" : fileName.substring(dotIndex);
    }
}