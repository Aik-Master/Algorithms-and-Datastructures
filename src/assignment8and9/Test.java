package assignment8and9;

import java.util.ArrayList;
import java.util.Collections;

public class Test{

    private static int numberOfElements = 10;

    public static void main(String[] args){

        BinaryTree<String> stringTreeInArray = new BinaryTreeInArray<>();
        BinaryTree<String> stringTreeLinked = new BinaryTreeLinked<>();

        ArrayList<String> unsorted = new ArrayList<String>();
        for(int i = 1 ; i <= numberOfElements ; i++){
            unsorted.add(String.format("%3d", i));
        }
        Collections.shuffle(unsorted);

        for(String string : unsorted){
            stringTreeInArray.add(string);
            stringTreeLinked.add(string);
        }

        System.out.print("Tree in Array");
        System.out.print("\nPreOrder:");
        stringTreeInArray.printPreOrder();
        System.out.print("\nInOrder:");
        stringTreeInArray.printInOrder();
        System.out.print("\nPostOrder:");
        stringTreeInArray.printPostOrder();
        System.out.print("\nReverseOrder:");
        stringTreeInArray.printReverseOrder();

        System.out.print("\n\nLinked Tree");
        System.out.print("\nPreOrder:");
        stringTreeLinked.printPreOrder();
        System.out.print("\nInOrder:");
        stringTreeLinked.printInOrder();
        System.out.print("\nPostOrder:");
        stringTreeLinked.printPostOrder();
        System.out.print("\nReverseOrder:");
        stringTreeLinked.printReverseOrder();
        
        for(int i = 0 ; i < 6 ; i++){
            stringTreeInArray.add(""+i);
        }
    }
}
