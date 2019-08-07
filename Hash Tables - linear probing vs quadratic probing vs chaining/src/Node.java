/**
 * node class to store key-value pairs
 */
public class Node {
    String key;
    String value;
    Node right;

    /**
     * constructor fode class
     * @param key key of node
     * @param value value of node
     */
    public Node(String key, String value){
        this.key=key;
        this.value =value;
    }

}
