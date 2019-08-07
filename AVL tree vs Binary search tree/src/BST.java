/**
 * Contains constructor for a binary search tree as well methods used by a binary search tree
 */
public class BST
{
    private static BSTNode root;
    public int height; //NEW
    static int searchCount=0;
    static int insertCount=0;

    /**
     * Function that initiates recursive insert function to insert a key value pair into a tree
     * @param key key of inserted node
     * @param value value of inserted node
     * @param bst tree being appended
     */
    public static void insert ( String key, String value, BST bst ){
        if (root==null)
            root = new BSTNode(key,value);
        else
        insert (key,value,root);
    }

    /**
     *Recursive function to insert a node into a BST tree or update a value if the
     * key of the inserted node exists already.
     * Source: notes
     * @param key Key of inserted node
     * @param value value of inserted node
     * @param node node either being inserted or moved
     */
    public static void insert ( String key, String value, BSTNode node ) {
        insertCount++;
        if (key.compareTo(node.key) <= 0) {
            if (node.left == null)
                node.left = new BSTNode(key, value);
            else
                insert(key, value, node.left);
        } else {
            if (node.right == null)
                node.right = new BSTNode(key, value);
            else
                insert(key, value, node.right);
        }
    }


    /**
     * returns value for a key being searched
     * @param key key being searched for
     * @return returns key or starts recursive step
     */
    public Object get( String key )
    {
        searchCount++; return root == null ? null : root.get( key );
    }

    /**
     *returns root
     * @return returns root
     */
    public static BSTNode getRoot(){return root;}
    public static void setRoot(BSTNode newRoot){root=newRoot;}

    /**
     * Recursive function for checking if node exists in a BST.
     * @param current current node being checked
     * @param key key being searched for in the nodes
     * @return either returns true or false or starts next recursive step
     */
    private boolean containsNode(BSTNode current, String key) {
        searchCount++;
        if (current == null) {
            return false;
        }
        if (key.equals(current.key)) {
            return true;
        }
        return key.compareTo(current.key) < 0
                ? containsNode(current.left, key)
                : containsNode(current.right, key);
    }

    /**
     * Returns whether the BST contains a given node or not
     * @param data key being searched for in the nodes
     * @return returns the outcome of the recursive containsNode function
     */
    public boolean containsNode(String data) {
        ; return containsNode(BST.getRoot(), data);
    }




}