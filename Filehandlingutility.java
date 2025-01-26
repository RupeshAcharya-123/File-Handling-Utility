import java.io.*;
import java.util.Scanner;

public class Filehandlingutility {
    public static void create(String filename) {
    	try {
			File obj = new File("C:\\Users\\RUPESH ACHARYA\\OneDrive\\Desktop\\Online Internship\\"+filename);
			if(obj.createNewFile()) {
				System.out.println("File: "+obj.getName()+" created successfully");
			}
			else {
				System.out.println("File is already exists.");
			}
		}catch(IOException e) {
			System.out.println("An exception occurs");
			e.printStackTrace();
		}
    }
    // Method to write content to a file
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();  // Adds a new line after writing content
            System.out.println("Content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read content from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to modify a file's content
    public static void modifyFile(String fileName, String oldText, String newText) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replace(oldText, newText)).append("\n");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content.toString());
                System.out.println("File modified successfully.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for file name and operation choice
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        create(fileName);
        System.out.println("Choose an operation: ");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Modify file");
        int choice = scanner.nextInt();
        scanner.nextLine();  // To consume the newline character left by nextInt()

        switch (choice) {
            case 1:
                System.out.print("Enter the content to write: ");
                String content = scanner.nextLine();
                writeToFile(fileName, content);
                break;

            case 2:
                readFromFile(fileName);
                break;

            case 3:
                System.out.print("Enter the text to replace: ");
                String oldText = scanner.nextLine();
                System.out.print("Enter the new text: ");
                String newText = scanner.nextLine();
                modifyFile(fileName, oldText, newText);
                break;

            default:
                System.out.println("Invalid choice. Exiting...");
        }

        scanner.close();
    }
}
