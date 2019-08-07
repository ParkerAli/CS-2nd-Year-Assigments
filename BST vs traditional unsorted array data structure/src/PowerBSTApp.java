import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PowerBSTApp {
    static File file = new File("cleaned_data.csv");
    static BST tree = new BST();
    static int opCount;

    /**
     * main method for to implement the BST.
     * First creates BST.
     * Then executes either the printDateTimes or printAllDateTimes functions based on args
     * Outputs the operator count
     * @param args used for execution
     */
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] hold = scanner.nextLine().split(",");
                String value = (hold[0]+","+hold[1]+","+hold[2]+","+hold[3]);

                String key = hold[0];

                tree.put(key,value);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(args.length==1){
            String date= args[0];
            printDateTime(date);
        }
        else if(args.length==0){printAllDateTimes();}


        System.out.println("opCount = "+opCount);

    }

    /**
     * prints out value from BST of the dateTime param if node exists
     * otherwise says it does not exist.
     * @param dateTime key being searched for
     */
    public static void printDateTime (String dateTime){
        if (tree.containsNode(dateTime)) {
            System.out.println(tree.get(dateTime));

        }
        else{System.out.println("Date/time not found");
        }
    }

    /**
     *prints out values from all nodes
     */
    public static void printAllDateTimes () {
        BSTNode.verticalOrder(tree.getRoot());
    }

}
