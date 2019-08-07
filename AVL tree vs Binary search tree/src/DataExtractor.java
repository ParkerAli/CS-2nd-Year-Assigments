import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains main method to extract data containing the operation counts from a text file
 */
public class DataExtractor {
    static File file = new File("dataoutputAVL.txt");

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] hold = scanner.nextLine().split(" ");
                if (hold[0].equals("opCount")){
                    System.out.println(hold[2]);
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
