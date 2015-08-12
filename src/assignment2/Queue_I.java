package assignment2;

/**
 * Interface for the ADT Queue / FIFO
 * 
 * 
 * @author Aiko Klostermann
 * 
 */
public interface Queue_I<E> {

    /**
     * Returns the front element of the queue and does <b>not</b> remove it<br>
     * 
     * @return &bull; <b>front</b> element of the queue
     */
    public E front();

    /**
     * Enqueues an element at the back of the queue<br>
     * 
     * @param element
     *            &bull; the element to be enqueued
     */
    public void enqueue(E element);

    /**
     * Deletes the front element of the queue<br>
     * 
     */
    public void dequeue();

    /**
     * Indicates if the queue is empty or not<br>
     * 
     * @return &bull; <b>true</b> if the queue is empty.<br>
     *         &bull; otherwise returns <b>false</b>
     */
    public boolean isempty();

}
