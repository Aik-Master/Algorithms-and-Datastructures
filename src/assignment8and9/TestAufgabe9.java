package assignment8and9;

import java.util.ArrayList;
import java.util.Collections;

public class TestAufgabe9{

    public static void main(String[] args){

        BinaryTree<Integer> intergerTreeLinked = new BinaryTreeLinked<>();

        ArrayList<Integer> unsorted = new ArrayList<Integer>();
        for(int i = 9 ; i <= 20 ; i++){
            unsorted.add(i);
        }

        for(Integer integer : unsorted){
            intergerTreeLinked.add(integer);
        }
        intergerTreeLinked.printPreOrder();
        System.out.println();


        
        System.out.println(intergerTreeLinked.sumBetween(6, 45));

        int sum = 0;
        for(int i = 9 ; i <= 20 ; i++){
            sum += i;
        }
        System.out.println("das sollte rauskommen " +sum);
    }
}
