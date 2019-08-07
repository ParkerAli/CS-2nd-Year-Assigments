import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Contains main method to simulate PowerAVLApp for a subset of size N
 */
public class test {
    static File file = new File("cleaned_data_timesorted.csv");
    static File file2 = new File("cleaned_data_timesorted.csv");
    static BST tree = new BST();
    static String[] dataset= new String[500];
    static int count=0;
    static int opCount;

    /**
     * main method  to implement the AVL simulation.
     * First creates BST.
     * args used for N sized data subset
     * Then executes either the printDateTimes or printAllDateTimes functions based on args
     * Outputs the operator count
     * @param args used for execution
     */
    public static void main(String[] args){
        try { // makes data structure
            Scanner scanner = new Scanner(file);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] hold = scanner.nextLine().split(",");
                String value = (hold[0]+","+hold[1]+","+hold[2]+","+hold[3]);

                String key = hold[0];

                AVL.insert(key,value,tree);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(args.length==1){
            String date= args[0];
            AVL.printDateTime(date,tree);
        }
        else if(args.length==0){AVL.printAllDateTimes(tree);}

        try { // makes the data set
            Scanner scanner2 = new Scanner(file2);
            scanner2.nextLine();

            while (scanner2.hasNextLine()) {
                String[] hold = scanner2.nextLine().split(",");
                dataset[count]= hold[0];
                count++;

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //now make a loop to initiate printDateTime for a subset N and print opCount.
        int N= Integer.parseInt(args[0]);
        String[] subset = Arrays.copyOfRange(dataset, 0, N);
        for(int x=0;x<N;x++){
            AVL.printDateTime(subset[x],tree);

        }
        System.out.println("N = "+ N);
        System.out.println("insertCount = "+AVL.getInsertCount());
        System.out.println("searchCount = "+tree.searchCount);
        int opCount=AVL.getInsertCount()+tree.searchCount;

        System.out.println("opCount = "+opCount);
    }
}