package assignment8and9;

/**
 * Implementation of the Interface for Binary Trees(aufgabenblatt8.BinaryTree). Another Implementation can be found at class BinaryLinked
 * <br> This Implementation realizes the Three within an Array.
 * 
 * @author Aiko Klostermann
 *
 * @param <T> T must implement java.lang.Comparable
 */
public class BinaryTreeInArray<T extends Comparable<T>> implements BinaryTree<T>{

    private Object[] array = new Object[1000];

    @Override
    public void add(T data){
        if(array[1] == null){
            array[1] = data;
        } else{
            findInsertPosition(data, 1);
        }
    }

    private void findInsertPosition(T data, int positionCandidate){// versickern
        if(data.compareTo((T) array[positionCandidate]) < 0){ // newNode.data is "smaller" than the node-data at positionCandidate
            if(array[positionCandidate * 2] == null){
                array[positionCandidate * 2] = data;
            } else{
                findInsertPosition(data, positionCandidate * 2);
            }
        } else{ // newNode.data is "bigger" than the node-data at positionCandidate
            if(array[positionCandidate * 2 + 1] == null){
                array[positionCandidate * 2 + 1] = data;
            } else{
                findInsertPosition(data, positionCandidate * 2 + 1);
            }
        }
    }
    
    @Override
    public void printPreOrder(){
        printPreOrder(1);
    }

    private void printPreOrder(int index){
        if(array[index] != null){
            System.out.print(" "+(T)array[index]);
            printPreOrder(index * 2);
            printPreOrder(index * 2 + 1);
        }
    }
    
    @Override
    public void printInOrder(){
        printInOrder(1);
    }

    private void printInOrder(int index){
        if(array[index] != null){
            printInOrder(index * 2);
            System.out.print(" "+(T)array[index]);
            printInOrder(index * 2 + 1);
        }
    }
    
    @Override
    public void printPostOrder(){
        printPostOrder(1);
    }

    public void printPostOrder(int index){
        if(array[index] != null){
            printPostOrder(index * 2);
            printPostOrder(index * 2 + 1);
            System.out.print(" "+(T)array[index]);
        }
    }

    @Override
    public void printReverseOrder(){
        printReverseOrder(1);
    }

    private void printReverseOrder(int index){
        if(array[index] != null){
            printReverseOrder(index * 2 + 1);
            System.out.print(" "+(T)array[index]);
            printReverseOrder(index * 2);
        }
    }

    @Override
    public int sumBetween(int m1, int m2){
        return 0;        
    }
}
