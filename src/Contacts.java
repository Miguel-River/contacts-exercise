import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contacts {

    final static String dir = "contacts";
    final static String fileName = "contacts.txt";
    private static boolean run = true;

    public static void viewAll(List<String> n){
        for (String item : n) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {

        Path directory = Paths.get(dir);
        Path path = Paths.get(dir, fileName);

        if (!Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (run) {
            try {
                Scanner scanner = new Scanner(System.in);
                List<String> lines = Files.readAllLines(Paths.get(dir, fileName));
                List<String> newLines = new ArrayList<>();

                System.out.println("What would you like to do(enter a number)?\n" +
                        "1: View all contacts\n" +
                        "2: Add a new contact\n" +
                        "3: Search for a contact\n" +
                        "4: Delete a contact\n" +
                        "5: Exit\n");
                String input = scanner.nextLine();
                switch (input){
                    case "1":{
                        viewAll(newLines);
                        break;
                    }
                    case "2":{

                        break;
                    }
                    case "3":{

                        break;
                    }
                    case "4":{

                        break;
                    }
                    case "5":{
                        run = false;
                        break;
                    }
                    default:{
                        System.out.println("Please enter a valid command");
                        break;
                    }
                }

            } catch (IOException e) {
                System.out.println("no work-\ning");
            }
        }
    }
}