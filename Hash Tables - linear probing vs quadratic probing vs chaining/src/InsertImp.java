import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * contains methods to implement a search test. derived from Implementation class.
 */
public class InsertImp {
    static HashTable table;

    public static void linear(int size, File data){
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
        System.out.println(table.insertProbes);
        System.out.println(HashBank.loadFactor(table));

    }
    public static void quadratic(int size, File data){
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
        System.out.println(table.insertProbes);
        System.out.println(HashBank.loadFactor(table));
    }
    public static void chaining(int size, File data){
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
        System.out.println(table.insertProbes);

        System.out.println(HashBank.loadFactorChain(table));

}

}
