package assignment1;

import java.util.LinkedList;

public class Testframe{

    private static final int exponent = 4;

    public static void main(String[] args){ // Das KotMonster beginnt hier...

        // creating da shit
        List<String> list = null;
        LinkedList<String> linkedList = null;

        // list.head.info = "Yo yo yo, hier ist der head";
        // list.tail.info = "tail = Schwanz hehehehehehehe";

        long listTimeTotal = 0;
        long javaTimeTotal = 0;
        long listTime = 0;
        long javaTime = 0;
        Node<String> insertPosition;
        for(int iterationCounter = 1 ; iterationCounter <= exponent ; iterationCounter++){

            list = new List<String>();
            listTimeTotal = System.nanoTime();
            list.insert("Lars baut Kotmänchen", list.tail);
            for(int elementCounter = 0 ; elementCounter < (int) Math.pow(10, iterationCounter) / 2 ; elementCounter++){
                list.insert("die arme Wurst :( " + elementCounter + " ", list.tail);
                list.insert("braun und traurig " + (elementCounter + Math.pow(10, iterationCounter) / 2) + " ", list.head);
            }
            listTimeTotal = System.nanoTime() - listTimeTotal;

            linkedList = new LinkedList<>();
            javaTimeTotal = System.nanoTime();
            linkedList.add("Lars baut Kotmänchen");
            for(int elementCounter = 0 ; elementCounter < (int) Math.pow(10, iterationCounter) / 2 ; elementCounter++){
                linkedList.add("die arme Wurst :( " + elementCounter + " ");
                linkedList.add(0, "braun und traurig " + (elementCounter + Math.pow(10, iterationCounter) / 2) + " ");
            }
            javaTimeTotal = System.nanoTime() - javaTimeTotal;

            System.out.println(Math.pow(10, iterationCounter) + " Elements: ");

            // inserting an element and stop the time
        
            // CAUTION!!! SUPER FUCKING BULLSHIT CODE BELOW!
            
            list.counter = 0; // reseting the counter
            listTime = System.nanoTime();
            list.insert("fucking element", list.head);
            listTime = System.nanoTime() - listTime;

            javaTime = System.nanoTime();
            linkedList.add(0, "fucking String");
            javaTime = System.nanoTime() - javaTime;
            
            
            System.out.println("Adding one element at the beginning: ");
            System.out.println("Time ......List needed in ns: " + listTime + " and the Number of JavaOperations needed: " + list.counter);
            System.out.println("Time LinkedList needed in ns: " + javaTime);

            list.counter = 0; // reseting the counter
            listTime = System.nanoTime();
            list.insert("fucking element", list.tail);
            listTime = System.nanoTime() - listTime;
            
            javaTime = System.nanoTime();
            linkedList.add((int)(Math.pow(10, iterationCounter)-1), "fucking String");
            javaTime = System.nanoTime() - javaTime;

            System.out.println("Adding one element at the end: ");
            System.out.println("Time ......List needed in ns: " + listTime + " and the Number of JavaOperations needed: " + list.counter);
            System.out.println("Time LinkedList needed in ns: " + javaTime);


            
            // System.out.println("Time List needed in ns: " + listTimeTotal + " ; Number of JavaOperations needed: " + list.counter);
            // System.out.println("Time LinkedList needed in ns: " + javaTimeTotal);

        }

    }
}
