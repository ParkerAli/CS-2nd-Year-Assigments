import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * Base class to store methods and instance variables
 */
public class Methods {
    static long startTime = 0; //start time for time
    static Vector [][][] wind; // in-plane regular grid of wind vectors, that evolve over time
    static int [][][] classification; // cloud type per grid point, evolving over time
    static int dimx, dimy, dimt; // data dimensions
    static String fileIn;
    static String fileOut;
    static double totalX = 0;
    static double totalY= 0;
    static Vector avg;
    static final ForkJoinPool fjPool = new ForkJoinPool();

    /**
     *method to start timer
     */
    public static void tick(){
        startTime = System.currentTimeMillis();
    }

    /**
     *method to stop timing and return time elapsed
     * @return float value containing time elapsed
     */
    public static float tock(){
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }

    /**
     *reads in file
     */
    public static void read(){
        try {
            Scanner sc = new Scanner(new File(fileIn), "UTF-8");

            // input grid dimensions and simulation duration in timesteps
            dimt = sc.nextInt();
            dimx = sc.nextInt();
            dimy = sc.nextInt();

            // initialize and wind vector (wind direction, strength and convection)
            wind = new Vector[dimt][dimx][dimy];
            for (int t = 0; t < dimt; t++)
                for (int x = 0; x < dimx; x++)
                    for (int y = 0; y < dimy; y++) {
                        wind[t][x][y] = new Vector();
                        wind[t][x][y].x = Double.parseDouble(sc.next());
                        wind[t][x][y].y = Double.parseDouble(sc.next());
                        wind[t][x][y].u = Math.abs(Double.parseDouble(sc.next()));
                    }

            classification = new int[dimt][dimx][dimy]; //initialises classification array
            sc.close();
        } catch (IOException e) {
            System.out.println("Unable to open input file " + fileIn);
            e.printStackTrace();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Malformed input file " + fileIn);
            e.printStackTrace();
        }

    }

    /**
     * writes to file
     */
    public static void write(){
        try{
            FileWriter fileWriter = new FileWriter(fileOut);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("%d %d %d\n", dimt, dimx, dimy);
            printWriter.print((float)avg.x + " " + (float)avg.y + "\n");

            for(int t = 0; t < dimt; t++){
                for(int x = 0; x < dimx; x++){
                    for(int y = 0; y < dimy; y++){
                        printWriter.printf("%d ", classification[t][x][y]);
                    }
                }
                printWriter.printf("\n");
            }

            printWriter.close();
        }
        catch (IOException e){
            System.out.println("Unable to open output file "+fileOut);
            e.printStackTrace();
        }
    }

    /**
     * convert linear position into 3D location in simulation grid
     * @param pos linear position
     * @param ind input array to contain parameters
     */
    public static void locate(int pos, int [] ind){
        ind[0] = (int) pos / (dimx*dimy); // t
        ind[1] = (pos % (dimx*dimy)) / dimy; // x
        ind[2] = pos % (dimy); // y
    }

    /**
     *Returns the mean of items in a float array list
     * @param list input arraylist
     * @return mean of list
     */
    static public float mean(ArrayList<Float> list){
        int temp=0;
        float total=0;
        while (temp!=list.size()){
            total+=list.get(temp);
            temp++;
        }
        return total/temp;
    }

    /**
     * calculates classification and populates the classification array
     * @param t dimt
     * @param x dimx
     * @param y dimy
     */
    public static void setClassification(int t, int x, int y){
                    double localXTotal = 0;
                    double localYTotal = 0;
                    double numNeighbours = 0;
                    for (int i = Math.max(0, x - 1); i < Math.min(dimx, x + 2); i++) {
                        for (int j = Math.max(0, y - 1); j < Math.min(dimy, y + 2); j++) {
                            localXTotal += wind[t][i][j].x;
                            localYTotal += wind[t][i][j].y;
                            numNeighbours++;
                        }
                    }
                    double locXAv = localXTotal / numNeighbours;
                    double locYav = localYTotal / numNeighbours;
                    double mag = Math.sqrt(locXAv*locXAv + locYav*locYav);
                    if(mag>0.2 && wind[t][x][y].u<= mag){
                        classification[t][x][y] = 1;
                    }
                    else if(mag < wind[t][x][y].u){
                        classification[t][x][y] = 0;
                    }
                    else{
                        classification[t][x][y] = 2;
                    }
    }
}
