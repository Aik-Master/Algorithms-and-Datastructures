package assignment8and9;

/**
 * Implementation of the Interface for Binary Trees(assignment8and9.BinaryTree). Another Implementation can be found at class BinaryTreeInArray <br>
 * This Implementation realizes the Three with linked Nodes(assignment8and9.Node).
 * 
 * @author Aiko Klostermann
 * 
 * @param <T>
 *            T must implement java.lang.Comparable
 */
public class BinaryTreeLinked<T extends Comparable<T>> implements BinaryTree<T>{

    private Node<T> root;

    @Override
    public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if(root == null){
            root = newNode;
        } else{
            findInsertPosition(newNode, root);
        }
    }

    private void findInsertPosition(Node<T> newNode, Node<T> positionCandidate){// versickern
        if(newNode.data.compareTo(positionCandidate.data) < 0){ // newNode.data is "smaller" than nodeInList.data
            if(positionCandidate.leftSon == null){
                positionCandidate.leftSon = newNode;
                newNode.father = positionCandidate;
            } else{
                findInsertPosition(newNode, positionCandidate.leftSon);
            }
        } else{ // newNode.data is "bigger" than nodeInList.data 
            if(positionCandidate.rightSon == null){
                positionCandidate.rightSon = newNode;
                newNode.father = positionCandidate;
            } else{
                findInsertPosition(newNode, positionCandidate.rightSon);
            }
        }
    }

    @Override
    public void printPreOrder(){
        printPreOrder(root);
    }

    private void printPreOrder(Node<T> node){
        if(node != null){
            System.out.print(" " + node.data);
            printPreOrder(node.leftSon);
            printPreOrder(node.rightSon);
        }
    }

    @Override
    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(Node<T> node){
        if(node != null){
            printInOrder(node.leftSon);
            System.out.print(" " + node.data);
            printInOrder(node.rightSon);
        }
    }

    @Override
    public void printPostOrder(){
        printPostOrder(root);
    }

    private void printPostOrder(Node<T> node){
        if(node != null){
            printPostOrder(node.leftSon);
            printPostOrder(node.rightSon);
            System.out.print(" " + node.data);
        }
    }

    @Override
    public void printReverseOrder(){
        printReverseOrder(root);
    }

    private void printReverseOrder(Node<T> node){
        if(node != null){
            printReverseOrder(node.rightSon);
            System.out.print(" " + node.data);
            printReverseOrder(node.leftSon);
        }
    }

    @Override
    public int sumBetween(int m1, int m2){
        Node<T> aM1 = findAm1(m1, root);
        Node<T> aM2 = findAm2(m2, root);
        System.out.println(aM1.data + " <-am1...am2-> " + aM2.data);

        return aM2.sequenceSum - aM1.sequenceSum + (Integer)aM2.data;
    }

    private Node<T> findAm1(int m1, Node<T> node){
        if((Integer) node.data < m1){
            if(node.rightSon != null){
                return findAm1(m1, node.rightSon);
            }
        } else if((Integer) node.data > m1){
            if(node.leftSon != null){
                return findAm1(m1, node.leftSon);
            }
        }
        return node;
    }

    private Node<T> findAm2(int m2, Node<T> node){
        if((Integer) node.data > m2){
            if(node.leftSon != null){
                return findAm1(m2, node.leftSon);
            }
        } else if((Integer) node.data < m2){
            if(node.rightSon != null){
                return findAm1(m2, node.rightSon);
            }
        }
        return node;
    }
}
