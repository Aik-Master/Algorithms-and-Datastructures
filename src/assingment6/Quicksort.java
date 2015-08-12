package assingment6;

import java.util.Arrays;

import assignment7.Elem;

public class Quicksort{

    public static void main(String[] args){

        // pivot is median of 3
        Quicksort test1 = new Quicksort();
        Elem[] pivotIsMedianBestCase = {new Elem(0), new Elem(1), new Elem(2), new Elem(3), new Elem(4), new Elem(5), new Elem(6), new Elem(7), new Elem(8),
                new Elem(9)};
        Elem[] pivotIsMedianAvgCase = {new Elem(5), new Elem(7), new Elem(9), new Elem(1), new Elem(3), new Elem(4), new Elem(0), new Elem(6), new Elem(8),
                new Elem(2)};

        test1.sort(pivotIsMedianBestCase);
        test1.sort(pivotIsMedianAvgCase);

        // pivot is left
        Quicksort test2 = new QuicksortPivotIsLeft();
        Elem[] pivotIsleftWorstCase = {new Elem(9), new Elem(8), new Elem(7), new Elem(6), new Elem(5), new Elem(4), new Elem(3), new Elem(2), new Elem(1),
                new Elem(0)};
        Elem[] pivotIsleftBestCase = {new Elem(0), new Elem(1), new Elem(2), new Elem(3), new Elem(4), new Elem(5), new Elem(6), new Elem(7), new Elem(8),
                new Elem(9)};
        Elem[] pivotIsleftAvgCase = {new Elem(5), new Elem(7), new Elem(9), new Elem(1), new Elem(3), new Elem(4), new Elem(0), new Elem(6), new Elem(8),
                new Elem(2)};
        test2.sort(pivotIsleftWorstCase);
        test2.sort(pivotIsleftBestCase);
        test2.sort(pivotIsleftAvgCase);

        // Pivot is random
        Quicksort test3 = new QuicksortPivotIsRandom();
        test3.sort(new Elem(5), new Elem(23), new Elem(81), new Elem(8), new Elem(6), new Elem(2), new Elem(7), new Elem(5), new Elem(86), new Elem(5),
                   new Elem(56), new Elem(5), new Elem(56), new Elem(4), new Elem(4), new Elem(3), new Elem(828), new Elem(7), new Elem(576), new Elem(275));

    }

    public void sort(Elem... toBeSorted){
        quicksort(toBeSorted, 0, toBeSorted.length - 1);
    }

    public void quicksort(Elem[] toBeSorted, int left, int right){
        if(toBeSorted.length < 2)
            return;

        Elem pivot = toBeSorted[getPivot(toBeSorted, left, right)];
        int l = left;
        int r = right;

        while(l <= r){

            while(toBeSorted[l].key < pivot.key){
                l++;
            }

            while(toBeSorted[r].key > pivot.key){
                r--;
            }

            if(l <= r){
                swap(toBeSorted, l, r);
                l++;
                r--;
            }
        }
        // Recursion
        if(left < r)
            quicksort(toBeSorted, left, r);
        if(l < right)
            quicksort(toBeSorted, l, right);
    }

    // Pivot is median of three
    public int getPivot(Elem[] toBeSorted, int left, int right){
        int median = 0;
        int middle = toBeSorted[((right - left) / 2) + left].key;
        if((toBeSorted[left].key - toBeSorted[right].key) * (middle - toBeSorted[left].key) >= 0) // a >= b and a <= c OR a <= b and a >= c
            median = left;
        else if((toBeSorted[right].key - toBeSorted[left].key) * (middle - toBeSorted[right].key) >= 0) // b >= a and b <= c OR b <= a and b >= c
            median = toBeSorted[right].key;
        else
            median = middle;
        return median;
    }

    private void swap(Elem[] toBeSorted, int x, int y){
        Elem tmp = toBeSorted[x];
        toBeSorted[x] = toBeSorted[y];
        toBeSorted[y] = tmp;
    }
}
