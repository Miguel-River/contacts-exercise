import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contacts {

    public static Scanner scanner = new Scanner(System.in);

    final static String dir = "contacts";
    final static String fileName = "contacts.txt";

    public static void viewAll(List<Person> n){
        for (Person item : n) {
            System.out.println(item.getName() + ": " + item.getPhoneNumber());
        }
    }
    public static void addContact(List<Person> list){
        System.out.println("What is their name?");
        String name = scanner.nextLine();
        System.out.println("What is their phone number?");
        String num = scanner.nextLine();
        list.add(new Person(name, num));
        System.out.println(list.get(list.size() - 1).getName() + " " + list.get(list.size() - 1).getPhoneNumber());
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

        while (true) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(dir, fileName));
                List<Person> newLines = new ArrayList<>();

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
                        addContact(newLines);
                        break;
                    }
                    case "3":{

                        break;
                    }
                    case "4":{

                        break;
                    }
                    case "5":{

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