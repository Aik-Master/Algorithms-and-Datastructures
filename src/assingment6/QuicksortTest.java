package assingment6;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import assignment7.Elem;

public class QuicksortTest{

    private Elem[]            list;
    private final static int SIZE = 60;
    private final static int MAX  = 120;

    @Before
    public void setUp() throws Exception{
        list = new Elem[SIZE];
        Random generator = new Random();
        for(int i = 0 ; i < list.length ; i++){            
            list[i]= new Elem(generator.nextInt(MAX));
        }
    }

    @Test
    public void testEmpty(){
        Quicksort sorter = new Quicksort();
        sorter.sort(new Elem[0]);
    }

    @Test
    public void testSimpleElement(){
        Quicksort sorter = new Quicksort();
        Elem[] test = new Elem[1];
        test[0] = new Elem(5);
        sorter.sort(test);
    }

    @Test
    public void testSpecial(){
        Quicksort sorter = new Quicksort();
        Elem[] test = {new Elem(5), new Elem(5), new Elem(6), new Elem(6), new Elem(4), new Elem(4), new Elem(5), new Elem(5), new Elem(4), new Elem(4), new Elem(6), new Elem(6), new Elem(5), new Elem(5)};
        sorter.sort(test);
        if(!validate(test)){
            fail("Should not happen");
        }
        printResult(test);
    }

    @Test
    public void testQuickSort(){
        for(Elem i : list){
            System.out.println(i.key + " ");
        }
        long startTime = System.currentTimeMillis();

        Quicksort sorter = new QuicksortPivotIsRandom();
        sorter.sort(list);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if(!validate(list)){
            fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testStandardSort(){
        long startTime = System.currentTimeMillis();
        Arrays.sort(list);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if(!validate(list)){
            fail("Should not happen");
        }
        assertTrue(true);
    }

    private boolean validate(Elem[] test){
        for(int i = 0 ; i < test.length - 1 ; i++){
            if(test[i].key > test[i + 1].key){
                return false;
            }
        }
        return true;
    }

    private void printResult(Elem[] test){
        for(int i = 0 ; i < test.length ; i++){
            System.out.print(test[i].key);
        }
        System.out.println();
    }
}