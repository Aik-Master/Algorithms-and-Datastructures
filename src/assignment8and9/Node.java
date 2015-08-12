package assignment8and9;

/**
 * This is the Node used for assigment8.BinaryTreeLinked
 * 
 * @author Aiko Klostermann
 *
 * @param <T> T must implement java.lang.Comparable
 */
public class Node<T extends Comparable<T>> {

    T       data;

    Node<T> father;
    Node<T> leftSon;
    Node<T> rightSon;
    int sequenceSum;
    
    public Node(T data){
        this.data = data;
        leftSon = null;
        rightSon = null;
        sequenceSum = ((Integer)data*((Integer)data-1))/2;
    }
}
