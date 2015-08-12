package assignment8and9;

/**
 * Interface for Binary Trees. Implementations can be found at class BinaryTreeLinked and class BinaryTreeInArray
 * 
 * @author Aiko Klostermann
 *
 * @param <T> T must implement java.lang.Comparable
 */
public interface BinaryTree<T extends Comparable<T>> {
    
    /** adds an element of T to the Tree
     * 
     * @param data
     * the data to be added to the Tree
     */
    void add(T data);
    
    /**
     * prints the all the elements of the tree in preOrder (symmetrisch)
     */
    void printPreOrder();
    /**
     * prints the all the elements of the tree in inOrder (Hauptreihenfolge)
     */
    void printInOrder();
    /**
     * prints the all the elements of the tree in postOrder (Nebenreihenfolge)
     */
    void printPostOrder();

    /**
     * prints the all the elements of the tree in reverseOrder
     */
    void printReverseOrder();
    
    /**
     * returns the sum of the nodes which Integer-data is bigger than or equal m1 and smaller than or equal m2
     */
    int sumBetween(int m1, int m2);
}
