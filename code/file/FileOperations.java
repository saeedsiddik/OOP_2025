package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.File; // Still needed for the cleanup at the end


public class FileOperations {

    private static final String FILE_NAME = "simple_data.txt";
    private static final Path FILE_PATH = Path.of(FILE_NAME);


    public static void writeFile(String content) {
        System.out.println("--- 1. WRITE Operation ---");
        try {
            // Simplest way to write a String to a file, overwriting existing content.
            Files.writeString(FILE_PATH, content);
            System.out.println("Content successfully written to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }


    public static String readFile() {
        System.out.println("\n--- 2. READ Operation ---");
        try {
            // Simplest way to read the entire file into a single String.
            String content = Files.readString(FILE_PATH);
            System.out.println("Content successfully read.");
            return content;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }


    public static void updateFile(String oldString, String newString) {
        System.out.println("\n--- 3. UPDATE Operation ---");
        try {
            // 1. Read all existing content
            String fileContent = Files.readString(FILE_PATH);

            if (fileContent.contains(oldString)) {
                // 2. Modify the content in memory
                String updatedContent = fileContent.replace(oldString, newString);

                // 3. Write the modified content back (overwrites)
                Files.writeString(FILE_PATH, updatedContent);

                System.out.println("Successfully updated all occurrences of '" + oldString + "' to '" + newString + "'.");
            } else {
                System.out.println("String '" + oldString + "' not found. No update performed.");
            }
        } catch (IOException e) {
            System.err.println("Error during file update: " + e.getMessage());
        }
    }



//    Main function
    public static void main(String[] args) {
        String initialContent = "First line of text.\nSecond line is important for update.\nThird line ends the file.";

        // 1. WRITE
        writeFile(initialContent);

        // 2. READ and display
        String readContent = readFile();
        System.out.println("\n[Current File Content]\n" + readContent);

        // 3. UPDATE
        updateFile("important for update", "now modified");

        // 4. READ and verify
        String verifiedContent = readFile();
        System.out.println("\n[Verified File Content After Update]\n" + verifiedContent);

        // Cleanup: Delete the file after the demonstration
        File file = new File(FILE_NAME);
        if (file.delete()) {
            System.out.println("\nSuccessfully deleted the demo file: " + FILE_NAME);
        }
    }
}
