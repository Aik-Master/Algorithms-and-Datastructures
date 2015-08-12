package assingment6;

public class QuicksortPivotIsRandom extends Quicksort{

    @Override
    public int getPivot(assignment7.Elem[] a, int left, int right){
        return (int) (Math.random() * (right - left)) + left;
    }
    
}
