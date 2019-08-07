/**
 * Contains methods unique to an AVL and also those that differ slightly from those in a BST.
 */
public class AVL { //Methods to transform from BST to AVL
    static int insertCount=0;
    /**
     * returns the height by executing the recursive getHeight() function defined below
     * Source: Notes
     * @return returns the height
     */
    public int getHeight (){
        return getHeight (BST.getRoot());
    }

    /**
     *recursively calculates the height the tree
     * Source: Notes
     * @param node
     * @return either -1 for a null root or recurses itself
     */
    public int getHeight ( BSTNode node ){
        if (node == null)
            return -1;
        else
            return 1 + Math.max (getHeight (node.left), getHeight (node.right));
    }

    /**
     *returns the stored height of a node
     * Source: Notes
     * @param node node's height
     * @return node's height or -1
     */
    public static int height ( BSTNode node ){
        if (node != null)
            return node.height;
        return -1;
    }

    /**
     *gives the balance of a node
     * Source: Notes
     * @param node node who's balance is to be determined
     * @return returns the balance of the parameter node
     */
    public static int balanceFactor ( BSTNode node ){
        return height (node.right) - height (node.left);
    }

    /**
     *corrects the height value stored by a node
     * Source: Notes
     * @param node node that stores the height to be changed
     */
    public static void fixHeight ( BSTNode node ){
        node.height = Math.max (height (node.left),
                height (node.right)) + 1;
    }

    /**
     *rotates node to the right
     * Source: Notes
     * @param p the node to be rotated
     * @return returns rotated node
     */
    public static BSTNode rotateRight ( BSTNode p ){
        BSTNode q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight (p);
        fixHeight (q);
        return q;
    }

    /**
     *Rotates node to the left
     * Source: notes
     * @param q node to be rotated
     * @return returns rotated node
     */
    public static BSTNode rotateLeft ( BSTNode q ){
        BSTNode p = q.right;
        q.right = p.left;p.left = q;
        fixHeight (q);
        fixHeight (p);
        return p;
    }


    /**
     * Balances the parameterised node by rotating left or right
     * depending on the balance factor.
     * Source: Notes
     * @param p the node to be balanced
     * @return returns the balance node
     */
    public static BSTNode balance ( BSTNode p ){
        fixHeight (p);
        if (balanceFactor (p) == 2){
            if (balanceFactor (p.right) < 0)p.right = rotateRight (p.right);
            return rotateLeft (p);
        }
        if (balanceFactor (p) == -2){
            if (balanceFactor (p.left) > 0)
                p.left = rotateLeft (p.left);
            return rotateRight (p);
        }
        return p;
    }

    /**
     * Inserts a node into the AVL tree by initiating the recursive insert function.
     * Source: notes
     * @param key Key of node being inserted
     * @param value Value of node being inserted
     * @param bst Tree the node is being inserted into
     */
    public static void insert ( String key, String value, BST bst ){
        bst.setRoot(insert (key,value, BST.getRoot()));
    }

    /**
     *Recursive function to insert a node into an AVL tree or update a value if the
     * key of the inserted node exists already.
     * Source: notes
     * @param key Key of inserted node
     * @param value value of inserted node
     * @param node root node
     * @return
     */
    public static BSTNode insert ( String key, String value, BSTNode node ){

            if (node == null) {
                return new BSTNode(key, value); //new root
            }
            insertCount++;
            if (value.compareTo (node.value)<= 0) {
                node.left = insert(key, value, node.left);
            }
            else
                node.right = insert (key, value, node.right);
            return balance (node);
    }

    /**
     * prints out the details for the parameterised dateTime if the key is present
     * in the parameterised AVL tree.
     * If not then says it isn't found.
     * @param dateTime time to be searched for
     * @param tree AVL tree being searched
     */
    public static void printDateTime (String dateTime, BST tree){
        if (tree.containsNode(dateTime)) {
            System.out.println(tree.get(dateTime));

        }
        else{System.out.println("Date/time not found");
        }
    }

    /**
     *prints out values from all nodes in a tree
     */
    public static void printAllDateTimes (BST tree) {
        BSTNode.verticalOrder(tree.getRoot());
    }

    public static int getInsertCount() {
        return insertCount;
    }
}
