public class BST
{
    private static BSTNode root;

    /**
     * put method is used to add a key-value to the Data Structure
     * or update if key already exists
     * @param key key of node
     * @param value value of node
     *
     */
    public void put( String key, Object value )
    {
        if ( root == null )
        {
            root = new BSTNode( key, value );
        }
        else
        {
            root.put( key, value );
        }
    }

    /**
     * returns value for a key being searched
     * @param key key being searched for
     * @return returns key or starts recursive step
     */
    public Object get( String key )
    {
        return root == null ? null : root.get( key );
    }

    /**
     *returns root
     * @return returns root
     */
    public static BSTNode getRoot(){return root;}

    /**
     * Recursive function for checking if node exists in a BST.
     * @param current current node being checked
     * @param key key being searched for in the nodes
     * @return either returns true or false or starts next recursive step
     */
    private boolean containsNode(BSTNode current, String key) {
        PowerBSTApp.opCount++;
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
        return containsNode(BST.getRoot(), data);
    }

}