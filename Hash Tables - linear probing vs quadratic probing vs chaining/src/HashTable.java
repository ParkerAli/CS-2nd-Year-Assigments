import java.util.ArrayList;

public class HashTable {
    static Node[] table;
    static ArrayList<ArrayList<Node>> chainTable;
    static String collisionType; //collision resolution type parameter
    static int size; //instance variable for table size
    static int insertProbes=0;
    static ArrayList <Integer> searchProbes=new ArrayList<>();
    static int load;
    static int zeroes;

    /**
     * creates new hashtable arraylist of a specified size with all indices set to zero
     * @param size size specified for hashtable array
     */
    //public static HashTable(
    public HashTable(int size){
        this.size=size;
        table = new Node[size];

        for(int x=0;x<size;x++){
            table[x]=new Node("0","0");     //adds empty nodes
        }
    }
    public  HashTable(int size, int v){ //hashtable for chaining
        chainTable = new ArrayList<ArrayList<Node>>(size);
        ArrayList<Node> empty=new ArrayList<>(1);
        empty.add(new Node("0","0"));
        for(int x=0;x<size;x++){
            chainTable.add(empty);
                    //.add(new Node("0","0")); //adds empty node to first index of every 2d arraylist
        }
    }


    /**
     * sets collision resolution type to a string variable
     * @param type string specifying the collision resolution type
     */
    public static void setCollisionType(String type){collisionType=type;}


// max=170143
// min=161724
// range = min-max = 8419

    /**
     The hash function to generate index estimates. The hashgod. This function is perfect and had to be replaced.
     * @param key value being processed by hash function
     * @return returns the index calculation
     */
    public static int perfectHash (String key){ //this is creative af gimme my marks (please)
        int value = HashBank.toInt(key);
        double num = value-161724; //input - minimum possible input to get numerator of ratio
        double ratio =  num/8419;
        int size = table.length; //prime number
        int position = (int)Math.round(ratio*size);

        return Math.round(position);
    }

    /**
     *The hash function to generate index estimates.
     * @param key value being processed by hash function
     * @return returns the index calculation
     */
    public static int hash(String key){
        if(size!=0) {
            return HashBank.toInt(key) % size;
        }
        else return 0;
    }

    /**
     * searches a hash table using linear probing for a specified date key
     * @param date date to be searched for
     * @return not found or value of date key
     */
    public static String linearSearch(String date){
        int count=0;
        try {
            int h = hash(date);
            while (h < size) {
                if ((table[h]).key.equals(date)) {
                    break;
                } else {
                    h = (h + 1) % size;
                    count++;
                }
            }
            if (h > size) {
                return "not found";
            }
            searchProbes.add(count);
            return table[h].value;
        }
        catch(ArrayIndexOutOfBoundsException e){e.printStackTrace();System.out.println("Insert probing failed. Consider bigger table size!");return "0";}
    }

    /**
     * inserts a Node into a hash table using linear probing
     * @param date key of node
     * @param value value of node
     */
    public static void linearInsert(String date, String value){
        Node inserted = new Node(date, value);
        int h = hash(date);
        while (h < size) {
            if (!(table[h]).key.equals("0")) {
                h = (h + 1) % size;
                insertProbes++;
            } else {
                break;
            }
        }
        table[h] = inserted;
    }


    /**
     * searches a hash table using quadratic probing for a specified date key
     * @param date date to be searched for
     * @return not found or value of date key
     */
    public static String quadraticSearch(String date){
        int count = 0;
        try {
            int h = hash(date);
            int i = 1;
            while (h < size) {
                if (table[h].key.equals(date)) {
                    break;
                } else if (!(table[h]).key.equals("0")) {
                    h = (h + 2 * i - 1) % size; //updated f***ing rule
                    i++;
                    count++;
                }
            }
            if (h > size) {
                return "not found";
            } else {
                searchProbes.add(count);
                return table[h].value;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){e.printStackTrace();System.out.println("Insert probing failed. Consider bigger table size!");return "0";}
    }

    /**
     * inserts a Node into a hash table using quadratic probing
     * @param date key of node
     * @param value value of node
     */
    public static void quadraticInsert(String date, String value){

        int h = hash(date);

        int i = 1;
        while (h < size) {
            if (!(table[h]).key.equals("0")) {
                h = (h + 2 * i - 1) % size; //updated rule
                i++;
                insertProbes++;

            } else break;
        }
        Node inserted = new Node(date, value);
        table[h] = inserted;

    }


    /**
     * searches a hash table using chaining for a specified date key
     * @param date date to be searched for
     * @return not found or value of date key
     */
    public static String chainingSearch(String date){
        int h= hash(date);
        int subSize = chainTable.get(h).size();
        int count = 0;
        int a=1;

        if (chainTable.get(h).get(0).key.equals(date)){
            searchProbes.add(count);
            return chainTable.get(h).get(0).value;

        }
        else {
            while  (a!=subSize+1){//(chainTable.get(h).get(a).key == date) {
                if (chainTable.get(h).get(a).key.equals(date)){
                    break;
                }
                else{a++;}
            }
            if(a==subSize+1){return "not found";}
            else{ count = a; searchProbes.add(count);return chainTable.get(h).get(a).value;}
        }
    }
    /**
     * inserts a Node into a hash table chaining
     * @param date key of node
     * @param value value of node
     */
    public static void chainingInsert(String date, String value) {

        int h = hash(date);

        Node inserted = new Node(date, value);

        if (chainTable.get(h).get(0).key.equals("0")) {
            chainTable.get(h).set(0, inserted);
        } else {
            insertProbes+= chainTable.get(h).size();
            chainTable.get(h).add(inserted);
        }


    }

}





