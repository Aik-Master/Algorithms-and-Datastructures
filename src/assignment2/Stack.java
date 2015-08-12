package assignment2;

/**
 * Implementation of the ADT Stack / LIFO
 * 
 * @author Aiko Klostermann
 * 
 */
public class Stack<E> {

    private int      stacksize;
    private int      top;      // empty
    private Object[] elements; // WARNING!!! This is not Typesave!!

    /**
     * 
     * <b>Warning! This Stack is not Typesave!</b>
     * 
     * @param stacksize
     *            &bull; the number of elements the stack shall contain.
     */
    public Stack(int stacksize){
        this.stacksize = stacksize;
        // WARNING!!! This is not Typesave!!
        elements = new Object[stacksize]; // WARNING!!! not Typesave!!
        top = 0;
    }

    /**
     * Clears the stack.<br>
     * &bull; complexity: O(1) After this operation there is no Element left on the stack.
     */
    public void empty(){
        top = 0;
    }

    /**
     * Adds an element to the stack.<br>
     * &bull; complexity: O(1)
     * 
     * @param elem
     *            Element to be added
     * 
     * @throws Assertion
     *             if the stack is full.
     */
    public void push(E elem){
        assert top <= stacksize - 1 : "(zu lesen in Roboterstimme): Computer - kann - Auftrag - nicht - verarbeiten, - Speicherallokation - mangelhaft.";
        elements[top++] = elem;
    }

    /**
     * Deletes the top element of the stack<br>
     * &bull; complexity: O(1)
     */
    public void pop(){
        if(!isEmpty()){
            top--;
        }
    }

    /**
     * Returns the top element, does not delete it.<br>
     * &bull; complexity: O(1)
     * 
     * @return &bull; <b>Top element</b> of the stack.<br>
     *         &bull; <b>null</b> if stack is empty!
     */
    @SuppressWarnings("unchecked")
    public E top(){
        if(!isEmpty()){
            return (E) elements[top - 1];// WARNING!!! not Typesave!!
        } else{
            return null;
        }
    }

    /**
     * Indicates if the stack is empty or not<br>
     * &bull; complexity: O(1)
     * 
     * @return &bull; <b>true</b> if the stack is empty.<br>
     *         &bull; otherwise returns <b>false</b>
     */
    public boolean isEmpty(){
        return top == 0;
    }
}
