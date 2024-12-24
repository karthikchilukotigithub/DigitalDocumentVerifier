import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class DigitalDocumentVerifier {

    // Function to generate hash for a file
    public static String generateHash(String filePath) throws Exception {
        FileInputStream fileInput = new FileInputStream(filePath);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] byteArray = new byte[1024];
        int bytesRead;

        while ((bytesRead = fileInput.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesRead);
        }
        fileInput.close();

        // Convert byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest.digest()) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    // Function to verify a document's integrity
    public static boolean verifyHash(String filePath, String originalHash) throws Exception {
        String currentHash = generateHash(filePath);
        return currentHash.equals(originalHash);
    }

    // Save the generated hash to a file
    public static void saveHashToFile(String hash, String outputFilePath) throws IOException {
        FileWriter writer = new FileWriter(outputFilePath);
        writer.write(hash);
        writer.close();
        System.out.println("Hash saved to " + outputFilePath);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("     Digital Document Verifier");
        System.out.println("=====================================");
        System.out.println("1. Generate Document Hash");
        System.out.println("2. Verify Document Integrity");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            switch (choice) {
                case 1: // Generate hash for a file
                    System.out.print("Enter the path of the document to hash: ");
                    String filePath = scanner.nextLine();
                    String hash = generateHash(filePath);
                    System.out.println("Hash of the document:");
                    System.out.println(hash);

                    System.out.print("Do you want to save the hash to a file? (yes/no): ");
                    String saveOption = scanner.nextLine();
                    if (saveOption.equalsIgnoreCase("yes")) {
                        System.out.print("Enter the output file path: ");
                        String outputFilePath = scanner.nextLine();
                        saveHashToFile(hash, outputFilePath);
                    }
                    break;

                case 2: // Verify document integrity
                    System.out.print("Enter the path of the document to verify: ");
                    String verifyFilePath = scanner.nextLine();
                    System.out.print("Enter the original hash: ");
                    String originalHash = scanner.nextLine();

                    if (verifyHash(verifyFilePath, originalHash)) {
                        System.out.println("The document is authentic and has not been altered.");
                    } else {
                        System.out.println("The document has been tampered with or is not authentic.");
                    }
                    break;

                case 3: // Exit the program
                    System.out.println("Exiting the Digital Document Verifier. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the file path.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
