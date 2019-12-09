import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Contacts {

    final static String dir = "contacts";

    final static String fileName = "contacts.txt";

    public static void main(String[] args) {

        Path directory = Paths.get(dir);
        Path path = Paths.get(dir, fileName);

        if (!Files.exists(directory)){
            try {
                Files.createDirectories(directory);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        while (true){
            try {
                List<String> lines = Files.readAllLines(Paths.get(dir, fileName));
                List<String> newLines = new ArrayList<>();
            } catch (IOException e){
                System.out.println("no work-\ning");
            }
        }
    }
}