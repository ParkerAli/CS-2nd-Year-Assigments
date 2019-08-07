import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Contains main method to implement AVL tree
 */
public class PowerAVLApp {
    static File file = new File("cleaned_data.csv");
    static BST tree = new BST();

    /**
     * main method  to implement the AVL.
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

                AVL.insert(key,value,tree);

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
        else if(args.length==0){AVL.printAllDateTimes(tree);}

        System.out.println("insertCount = "+AVL.getInsertCount());
        System.out.println("searchCount = "+tree.searchCount);
        int opCount=AVL.getInsertCount()+tree.searchCount;

        System.out.println("opCount = "+opCount);

    }
}
