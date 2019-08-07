import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * contains methods to implement a search test. derived from Implementation class.
 */
public class SearchImp {
    static HashTable table;
    static ArrayList<String> keys=new ArrayList<>();
    public static void makeKeyBase(){
        try{
            File data =new File("shuffled_data.csv");
            Scanner file=new Scanner(data);
            while (file.hasNextLine()){
                String line = file.nextLine();
                keys.add(line);
            }
        }
        catch(FileNotFoundException e){e.printStackTrace();}
    }
    public static void linear(int size, File data){
        makeKeyBase();
        table = new HashTable(size);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.linearInsert(key,value);
            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        for(int x=0;x<400;x++){table.linearSearch(keys.get(x));}

        System.out.println("Total search probes = "+HashBank.sum(table.searchProbes));
        double average = (double)HashBank.sum(table.searchProbes) / (double)400;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));

    }
    public static void quadratic(int size, File data){
        makeKeyBase();
        table = new HashTable(size);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.quadraticInsert(key,value);

            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        for(int x=0;x<400;x++){table.quadraticSearch(keys.get(x));}

        System.out.println("Total search probes = "+HashBank.sum(table.searchProbes));
        double average = (double)HashBank.sum(table.searchProbes) / (double)400;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));
    }
    public static void chaining(int size, File data){
        makeKeyBase();
        table = new HashTable(size,0);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.chainingInsert(key,value);
            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        for(int x=0;x<400;x++){table.chainingSearch(keys.get(x));}

        System.out.println("Total search probes = "+HashBank.sum(table.searchProbes));
        double average = (double)HashBank.sum(table.searchProbes) / (double)400;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));
    }
}
