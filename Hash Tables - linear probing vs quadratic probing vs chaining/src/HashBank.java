import java.util.ArrayList;
import java.util.Arrays;

/**
 * some abstract methods to be used for the assignment
 */
public class HashBank {
    /**
     * Source: https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
     * checks if an integer is a prime number through iteration
     * @param n number to checked if prime
     * @return boolean true if number prime else false
     */
    public static boolean isPrime(int n){

        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    /**
     * converts dateTimes string to integer which can be placed into a hash function
     * @param dateTime dateTime key to be converted to hash function
     * @return integer value
     */
    public static int toInt(String dateTime){ //        161951
        String hold= dateTime.substring(0,2)+dateTime.substring(11,13)
                +dateTime.substring(14,16);
        return Integer.parseInt(hold);
    }

    /**
     * calculates load fsctor of hash table using linear or quadratic probing
     * @param table hashtable being checked
     * @return load factor
     */
    public static double loadFactor(HashTable table){
        double size = table.size;
        double zeroes=0;

        for (int x=0;x<size;x++) {
            if (table.table[x].key.equals("0")) {
                zeroes++;
            }
        }
        return (size-zeroes)/size;
    }

    /**
     * returns load factor for hash table using chaining
     * @param table hashtable
     * @return double that is the load factor
     */
    public static double loadFactorChain(HashTable table){
        double size = table.size;
        double zeroes= table.zeroes;
        if(size!=0){return (size-zeroes)/size;}
        else return 0;
    }

    /**
     * sums up the elements in an Integer ArrayList
     * @param b an ArrayList
     * @return sum of elements
     */
    public static int sum(ArrayList<Integer> b){
        int a =b.size();
        int total=0;
        for(int x=0;x<a;x++){total+=b.get(x);}
        return total;
    }

}
