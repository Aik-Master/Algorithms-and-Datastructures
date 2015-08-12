package assignment2;

/**
 * Implementation for the ADT Queue / FIFO
 * with a ringbuffered array
 * 
 * @author Aiko Klostermann
 * 
 */
public class RingbufferQueue<E> implements Queue_I<E>{

    private Object[] ring; // hmmm..
    private int      head;
    private int      tail;

    /**
     * Constructor
     * @param size
     * the max -1 number of elements in the queue
     */
    public RingbufferQueue(int size){
        this.ring = new Object[size];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * &bull; complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public E front(){
        return (E) ring[head];
    }

    /**
     * &bull; complexity: O(1)
     */
    public void enqueue(E x){
        ring[tail] = x;
        tail = (tail + 1) % ring.length;
        if(head == tail){
            head = (head + 1) % ring.length;
        }
    }

    /**
     * &bull; complexity: O(1)
     */
    public void dequeue(){
        head = ((head + 1)) % ring.length;
    }

    /**
     * &bull; complexity: O(1)
     */
    public boolean isempty(){
        if(head == tail){
            return true;
        }
        return false;
    }

}