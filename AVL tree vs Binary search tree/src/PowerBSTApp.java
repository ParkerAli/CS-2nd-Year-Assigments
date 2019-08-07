import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * contains main method to implement BST
 */
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
                String value = (hold[0]+","+hold[1]+","+hold[3]);

                String key = hold[0];

                BST.insert(key,value,tree);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(args.length==1){
            if(args[0].contains("txt"))
                try
                {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()) {
                        AVL.printDateTime(scanner.nextLine(), tree);
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            else{
                String date= args[0];
                AVL.printDateTime(date,tree);
            }
        }
        else if(args.length==0){printAllDateTimes();}


        System.out.println("insertCount = "+tree.insertCount);
        System.out.println("searchCount = "+tree.searchCount);
        int opCount=tree.insertCount+tree.searchCount;

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
