import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * contins methods to implement a hash table for the different types of probing
 */
public class Implementation {
    static HashTable table;

    /**
     * implements a linear probing hash table
     * @param size size of table
     * @param data file from data is used
     * @param k number keys to be searched
     */
    public static void linear(int size, File data, int k){
        table = new HashTable(size);
        ArrayList<String> keyBase =new ArrayList<>(size);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.linearInsert(key,value);

                keyBase.add(key);
            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        Collections.shuffle(keyBase);
        for (int x=0;x<k;x++){
            System.out.println(table.linearSearch(keyBase.get(x)));
        }
        System.out.println("Total search probes = "+table.searchProbes);
        double average = (double)HashBank.sum(table.searchProbes) / (double)k;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));

    }
    /**
     * implements a quadratic probing hash table
     * @param size size of table
     * @param data file from data is used
     * @param k number keys to be searched
     */
    public static void quadratic(int size, File data, int k){
        table = new HashTable(size);
        ArrayList<String> keyBase =new ArrayList<>(size);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.quadraticInsert(key,value);

                keyBase.add(key);
            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        Collections.shuffle(keyBase);
        for (int x=0;x<k;x++){
            System.out.println(table.quadraticSearch(keyBase.get(x)));
        }
        System.out.println("Total search probes = "+table.searchProbes);
        double average = (double)HashBank.sum(table.searchProbes) / (double)k;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));
    }

    /**
     * implements a chaining hash table
     * @param size size of table
     * @param data file from data is used
     * @param k number keys to be searched
     */
    public static void chaining(int size, File data, int k){
        table = new HashTable(size,0);
        ArrayList<String> keyBase =new ArrayList<>(size);
        try{
            Scanner file= new Scanner(data);
            file.nextLine();
            while(file.hasNextLine()){
                String[] line = file.nextLine().split(",");
                String key= line[0];
                String value = line[0]+","+line[1]+","+line[3];
                table.chainingInsert(key,value);

                keyBase.add(key);
            }
        }
        catch (IOException e){e.printStackTrace();System.out.println("File Not Found!");}
        Collections.shuffle(keyBase);
        for (int x=0;x<k;x++){
            System.out.println(table.chainingSearch(keyBase.get(x)));
        }
        System.out.println("Total search probes = "+HashBank.sum(table.searchProbes));
        double average = (double)HashBank.sum(table.searchProbes) / (double)k;
        System.out.println("Average search probes = "+ average);
        System.out.println("Max probe size = "+Collections.max(table.searchProbes));

    }
}
