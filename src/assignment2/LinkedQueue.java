package assignment2;

import assignment1.*;

/**
 * Implementation for the ADT Queue / FIFO with a "Linked List"(not java.util)
 * 
 * @author Aiko Klostermann
 * 
 */
public class LinkedQueue<E> implements Queue_I<E>{

    List<E> list;
    
    /**
     * Constructor
     */
    public LinkedQueue(){
        this.list = new List<E>();
    }

    /**
     * &bull; complexity: O(1)
     */
    @Override
    public E front(){
        return list.retrieve(list.getHead().next).getInfo();
    }

    /**
     * &bull; complexity: O(N)
     */
    @Override
    public void enqueue(E element){
        list.insert(element, list.getTail());
    }

    /**
     * &bull; complexity: O(N)
     */
    @Override
    public void dequeue(){
        list.delete(list.getHead().next);
    }

    /**
     * &bull; complexity: O(1)
     */
    @Override
    public boolean isempty(){
        return list.isEmpty();
    }

}
