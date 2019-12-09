import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contacts {

    public static Scanner scanner = new Scanner(System.in);

    final static String dir = "contacts";
    final static String fileName = "contacts.txt";
    private static boolean run = true;

    public static Path directory = Paths.get(dir);
    public static Path path = Paths.get(dir, fileName);

    public static List<Person> newLines = new ArrayList<>();

    public static void menu() {
        System.out.println("What would you like to do(enter a number)?\n" +
                "1: View all contacts\n" +
                "2: Add a new contact\n" +
                "3: Search for a contact\n" +
                "4: Delete a contact\n" +
                "5: Exit\n");
        String input = scanner.nextLine();
        switch (input){
            case "1":{
                viewAll();
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
                run = false;
                break;
            }
            default:{
                System.out.println("Please enter a valid command");
                break;
            }
        }
    }
    public static List<String> openFile() {
        try {
            List<String> tempLines = Files.readAllLines(Paths.get(dir, fileName));
            List<Person> tempPersons = new ArrayList<Person>();
            for (String i : tempLines){
                tempPersons.add(new Person("name", "143824"));
            }
//            return ;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void viewAll(List<Person> n){ // displays all contacts
        for (Person item : n) {
            System.out.println(item.getName() + ": " + item.getPhoneNumber());
        }
    }

    public static void addContact(List<Person> list){ // adds contact to the List
        System.out.println("What is their name?");
        String name = scanner.nextLine();
        System.out.println("What is their phone number?");
        String num = scanner.nextLine();
        list.add(new Person(name, num));
        updateContacts(path, (ArrayList<Person>) list);
//        System.out.println(list.get(list.size() - 1).getName() + " " + list.get(list.size() - 1).getPhoneNumber());
    }

    public static void updateContacts(Path path, ArrayList<Person> contacts) { // writes all contacts into .txt file
        for (Person contact : contacts) {
            try {
                Files.writeString(path, contact.getContactInfo(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkFiles() {
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
    }


    public static void main(String[] args) {
        while (run) {
            checkFiles();
            menu();
        }
    }
}