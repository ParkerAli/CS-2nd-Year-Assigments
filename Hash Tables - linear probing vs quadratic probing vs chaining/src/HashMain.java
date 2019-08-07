import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HashMain {
    static File data = new File("cleaned_data.csv");
    static HashTable table;
    static String[] arguments =new String[4];
    static String scheme;
    static String name;
    static int size=0;
    static int k=0;

    /**
     * main method to implement hash table
     * @param args arguments for main method
     */
    public static void main(String[]args){

        if (args.length==0) {return;}
        else{
            arguments = args[0].split(" ");
            //1st index is size, 2nd is conflict resolution scheme, 3rd is input data file, 4th is number of keys to be searched
            size = Integer.parseInt(arguments[0]); //size input
            scheme = arguments[1];
            name = arguments[2];
            k = Integer.parseInt(arguments[3]);
        }
        if(!HashBank.isPrime(size)){System.out.println("Size entered is not a prime number!");return;} //returns if not prime
        if(!scheme.equals("linear") && !scheme.equals("quadratic") && !scheme.equals("chaining")){System.out.println("Incorrect scheme!");return;} //checks scheme

        if (scheme.equals("linear")){Implementation.linear(size,data,k);}
        else if (scheme.equals("quadratic")){Implementation.quadratic(size,data,k);}
        else {Implementation.chaining(size,data,k);}
    }
}
