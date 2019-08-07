//public class AVLNode {
//    public String key;
//    public Object value;
//    public BSTNode left, right;
//    public
//
//    /**
//     * source from https://www.moreofless.co.uk/binary-search-tree-bst-java/
//     * Constructor for the BSTNode class
//     * @param key key from Node
//     * @param value value from Node
//     */
//    public AVLNode(String key, Object value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    /**
//     * source from https://www.moreofless.co.uk/binary-search-tree-bst-java/
//     * Adds a node to the BST if the key doesn't already exist, if it does then it updates the value.
//     * First checks for if a key exists or not.
//     * If it doesn't then adds the new node pair,
//     * If not then updates the value of the existing node
//     * @param key key from node to be added
//     * @param value value from the node to be added
//     */
//    void put(String key, Object value) {
//        if (key.compareTo(this.key) < 0) {
//            if (left != null) {
//                left.put(key, value);
//            } else {
//                left = new BSTNode(key, value);
//
//            }
//        } else if (key.compareTo(this.key) > 0) {
//            if (right != null) {
//                right.put(key, value);
//            } else {
//                right = new BSTNode(key, value);
//            }
//        } else {
//            //update this one
//            this.value = value;
//        }
//    }
//
//    /**
//     * source from https://www.moreofless.co.uk/binary-search-tree-bst-java/
//     * finds node with given key and returns it's value.
//     * First checks if the given node contains the key being searched for.
//     * Then checks the left and right nodes recursively.
//     * @param key the key being searched for in the BST
//     * @return used to return  value when the correct node is found or to initiate the next recursive step.
//     */
//
//    public Object get(String key) {
//        if (this.key.equals(key)) {
//            return value;
//        }
//
//        if (key.compareTo(this.key) < 0) {
//            return left == null ? null : left.get(key);
//        } else {
//            return right == null ? null : right.get(key);
//        }
//    }
//
//    static class Values
//    {
//        int max, min;
//    }
//    static Values val = new Values();
//
//    /**
//     * source from https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
//     * A utility function to find min and max distance with respect to root.
//     * First checks if null for base case.
//     * Then updates the min and max depending on comparison with the distance.
//     * Then recurs for the left and right subtrees.
//     * @param node node to checked for the min/max value
//     * @param min the min value
//     * @param max the max value
//     * @param hd distance from root
//     * @author Mayank Jaiswal
//     */
//    private static void findMinMax(BSTNode node, Values min, Values max, int hd)
//    {
//        // Base case
//        if (node == null)
//            return;
//
//        // Update min and max
//        if (hd < min.min)
//            min.min = hd;
//        else if (hd > max.max)
//            max.max = hd;
//
//        // Recur for left and right subtrees
//        findMinMax(node.left, min, max, hd - 1);
//        findMinMax(node.right, min, max, hd + 1);
//    }
//
//    // A utility function to print all nodes on a given line_no.
//    // hd is horizontal distance of current node with respect to root.
//
//    /**
//     * source from https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
//     * This is a recursive utility function to print all nodes on a given line_no.
//     * Checks if node is null for best case.
//     * Then checks if the node is on a given line number.
//     * Recurs for the left and right subtrees.
//     * @param node the current node being checked
//     * @param line_no the number of the line which we are printing
//     * @param hd is the horizontal distance of current node with respect to root
//     * @author Mayank Jaiswal
//     */
//    static void printVerticalLine(BSTNode node, int line_no, int hd)
//    {
//        // Base case
//        if (node == null)
//            return;
//
//        // If this node is on the given line number
//        if (hd == line_no)
//            System.out.println(node.value);
//
//        // Recur for left and right subtrees
//        printVerticalLine(node.left, line_no, hd - 1);
//        printVerticalLine(node.right, line_no, hd + 1);
//    }
//
//
//
//    /**
//     * source from https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
//     * Main function which prints a given binary tree in vertical order.
//     * It uses findMinMax to find min and max distances with respect to root.
//     * Method then iterates through all possible vertical lines starting
//     * from the leftmost line and print nodes line by line.
//     * @param node the root node which is the starting point of the search
//     * @author Mayank Jaiswal.
//     */
//    static void verticalOrder(BSTNode node)
//    {
//
//        findMinMax(node, val, val, 0);
//
//
//        for (int line_no = val.min; line_no <= val.max; line_no++)
//        {
//            printVerticalLine(node, line_no, 0);
//
//        }
//    }
//
//}
