import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PowerArrayApp {
    static File file = new File("cleaned_data.csv");
    static String [][] data= new String[500][8];
    static int count = 0;
    static int opCount =0;

    /**
     * main method.
     * iterates over csv file then attaches info into a 500x8 2D array.
     * then either executes printAllDateTimes or printDateTime
     * outputs operation count.
     * @param args used to determine which function to execute
     */
    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String temp[] = line.split(",");

                for (int x = 0; x < 8; x++){
                    data[count][x]= temp[x];}
                count++;

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
     * prints row of array containing the dateTime if it exists
     * or prints that it doesn't
     * @param dateTime date to searched for in array
     */
    public static void printDateTime (String dateTime){
        int check=0;
        int match=501;

        while (check<500){
            if ((data[check][0]).equals(dateTime)){
                match= check;
                opCount++;
                break;

            }
            check++;
            opCount++;
        }
        if (match!=501) {
            System.out.println(data[match][0]+","+data[match][1]+","+data[match][2]+","+data[match][3]);
        }
        else{
            System.out.println("Date/time not found");
        }
    }

    /**
     *prints all values in array
     */
    public static void printAllDateTimes (){
        int checker = 0;
        while (checker<500){
            System.out.println(data[checker][0]+","+data[checker][1]+","+data[checker][2]+","+data[checker][3]);
            checker++;
        }




    }
}
