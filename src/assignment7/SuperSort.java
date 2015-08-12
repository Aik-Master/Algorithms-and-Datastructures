package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import assingment6.*;

public class SuperSort{

    static private Elem[] elements = new Elem[100_000_000];

    public static void main(String[] args){

        SuperSort superS = new SuperSort();
        Quicksort quicksort = new QuicksortPivotIsRandom();

        int IterationsPerN = 10;
        int k = 3;
        
        long time1, time2;
        long[] durationsSuperSort = new long[k];
        long[] durationsQuicksort = new long[k];
        int N = 1;
        Elem[] toBeSorted;
        for(int i = 0 ; i < k ; i++){
            N *= 10; // N = 10,100,1000 ...

            for(int j = 0 ; j < IterationsPerN ; j++){

                toBeSorted = getShuffledElemArray(N);
                elements = new Elem[100_000_000];

                //System.out.println(Arrays.toString(toBeSorted));
                time1 = System.nanoTime();
                superS.sort(toBeSorted);
                time2 = System.nanoTime();
                //System.out.println(Arrays.toString(toBeSorted));
                durationsSuperSort[i] += time2 - time1;
                
                elements = new Elem[100_000_000];
                // Testing the same Array with Quicksort
                toBeSorted = getShuffledElemArray(N);
                time1 = System.nanoTime();
                quicksort.sort(toBeSorted);
                time2 = System.nanoTime();
                durationsQuicksort[i] += time2 - time1;

            }
            
            durationsSuperSort[i] = durationsSuperSort[i] / IterationsPerN; // calculate the mean
            durationsQuicksort[i] = durationsQuicksort[i] / IterationsPerN; // calculate the mean

        }
        N = 1;
        for(int i = 0 ; i < k ; i++){
            N *= 10;
            System.out.printf("the mean(%d iterations) time for sorting N = %7d Elements with SuperSort is: %10d ns | Quicksort needs: %10d ns\n", IterationsPerN , N , durationsSuperSort[i], durationsQuicksort[i]);
        }
    }

    /**
     * Dieser Sortieralgorithmus ist für N <= 1.000.000 Elemente ausgelegt,
     * dessen keys sich im Bereich N*700 bis N*800 befinden.<br><br>
     * 
     * 
     * Es wird ein Array erzeugt in das jedes Element des zu sortierenden Arrays eingefügt wird. 
     * Die Position des Elements ergibt sich aus dem key, damit ergibt sich dass, die Elemente danach nur noch zurück in das Ausgangsarray verlegt werden müssen damit dier sortiert ist.
     * <br><br>
     * Die Komplexität beträgt: O(N)
     * 
     * @param toBeSorted
     * &bull; das Array mit den zu sortierenden Elem(enten)
     */
    public void sort(Elem[] toBeSorted){

        for(int i = 0 ; i < toBeSorted.length ; i++){
            elements[(toBeSorted[i].key) - toBeSorted.length * 700] = toBeSorted[i];
        }
        int sortedIndex = 0;
        for(int i = 0 ; sortedIndex < toBeSorted.length ; i++){
            if(elements[i] != null){
                toBeSorted[sortedIndex++] = elements[i];
            }
        }
    }

    private static Elem[] getShuffledElemArray(int numberOfElements){
        ArrayList<Elem> unsorted = new ArrayList<Elem>();
        for(int i = 1 ; i <= numberOfElements ; i++){
            unsorted.add(new Elem((numberOfElements * 700) + ((i - 1) * 100) + (int) (Math.random() * 100)));
        }
        Collections.shuffle(unsorted);
        return unsorted.toArray(new Elem[unsorted.size()]);
    }
}
