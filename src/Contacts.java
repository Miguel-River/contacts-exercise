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
    public static Scanner intScanner = new Scanner(System.in);

    final static String dir = "contacts";
    final static String fileName = "contacts.txt";
    private static boolean run = true;

    public static Path directory = Paths.get(dir);
    public static Path path = Paths.get(dir, fileName);

    public static List<Person> pulledAsPerson = new ArrayList<>(); // contact Person Objects in List TODO: would like to change name to allContacts
    public static List<String> pulledContacts = new ArrayList<>(); // pulled all contacts from contacts.txt

    // ----- display all contacts -----
    public static void displayAllContacts() {
        for (Person contact : pulledAsPerson) {
            System.out.printf("Name: %s Phone: %s\n", contact.getName(), contact.getPhoneNumber());
        }
    }

    //
    // ----- grab all existing contacts -----  TODO: need to make a method to format these 'Strings' into Person objects which are then added to 'newLines' so we may edit contacts in the future
    public static void grabContacts() {        //DONE
        try {
//            List<Person> temp = new ArrayList<>();
            pulledContacts = Files.readAllLines(Paths.get(dir,fileName));
            pulledAsPerson.clear();
            for (String i : pulledContacts) {
                pulledAsPerson.add(new Person( i.substring(0, i.indexOf("|")), i.substring(i.indexOf("|") + 1)));
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
//        return null;
    }
//    ----------------------------------------
    public static void addContact(){ // adds contact to the List and updates the txt file
        System.out.println("What is their name?");
        String name = scanner.nextLine();
        System.out.println("What is their phone number?");
        String num = scanner.nextLine();
        pulledAsPerson.add(new Person(name, num));
        updateContacts();
    }

    public static void updateContacts() { // writes all contacts into .txt file
//        grabContacts();
        try {
            Files.writeString(path, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Person contact : pulledAsPerson) {
            try {
                Files.writeString(path, contact.getContactInfo(), StandardOpenOption.APPEND); //
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

    public static void search(){
        System.out.println("Search by name or number:");
        String search = scanner.nextLine();
        System.out.println("Results:");
        boolean found = false;
        for (Person i : pulledAsPerson){
            if (i.getName().equalsIgnoreCase(search) || i.getName().contains(search) || i.getPhoneNumber().contains(search)){
                System.out.printf("Name: %s Phone: %s\n", i.getName(), i.getPhoneNumber());
                found = true;
            }
        }
        if (!found){
            System.out.println("No contacts match the name or number given.");
        }
    }

    public static void delete(){
        for (int i = 0; i < pulledAsPerson.size(); i++) {
            System.out.printf("%s Name: %s Phone: %s\n", i + 1, pulledAsPerson.get(i).getName(), pulledAsPerson.get(i).getPhoneNumber());
        }
        while (true) {
            try {
                System.out.println("Enter the id you would like to delete:");
                int input = intScanner.nextInt();
                System.out.printf("Removing '%s' from contacts\n", pulledAsPerson.get(input - 1).getName());
                pulledAsPerson.remove(input - 1);
                updateContacts();
                break;
            } catch (Exception e){
                System.out.println("Invalid input, please enter a valid option.");
            }
        }
    }

    public static void menu() {
        System.out.println("What would you like to do(enter a number)?\n" +
                "1: View all contacts\n" +
                "2: Add a new contact\n" +
                "3: Search for a contact\n" +
                "4: Delete a contact\n" +
                "5: Exit");
        String input = scanner.nextLine();
        switch (input){
            case "1":{
                displayAllContacts();
                break;
            }
            case "2":{
                addContact();
                break;
            }
            case "3":{
                search();
                break;
            }
            case "4":{
                delete();
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

    public static void main(String[] args) {
        while (run) {
            checkFiles();
            grabContacts();
            menu();
//            updateContacts();
        }
    }
}