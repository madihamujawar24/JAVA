import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class ReadFile {
    private String filename;

    public ReadFile(String filename) {
        this.filename = filename;
    }

    public void readFile() {
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            System.out.println("\nFile Content:");
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + filename + "' does not exist.");
        }
    }

    public void writeToFile(String data) {
        try (FileOutputStream fos = new FileOutputStream(filename, true);
             PrintWriter writer = new PrintWriter(fos)) {
            writer.println(data);
            System.out.println("Data appended to '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get filename from user
        System.out.print("Enter the filename (it will create if it does not exist): ");
        String filename = scanner.nextLine();

        // Create ReadFile object
        ReadFile fileHandler = new ReadFile(filename);

        // Read the file contents
        fileHandler.readFile();

        // Ask user if they want to add contents to the file
        System.out.print("\nDo you want to add contents to the file? (yes/no): ");
        String addContent = scanner.nextLine().trim().toLowerCase();

        if (addContent.equals("yes")) {
            System.out.print("Enter the content you want to add: ");
            String newContent = scanner.nextLine();
            fileHandler.writeToFile(newContent);
        } else {
            System.out.println("No content added to the file.");
        }

        scanner.close();
    }
}
