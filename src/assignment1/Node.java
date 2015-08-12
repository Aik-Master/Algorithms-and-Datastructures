package assignment1;

public class Node<T> {
    public Node<T> next;
    private T       info;

    Node(T info){
        next = null;
        this.info = info;
    }// Node(

    @Override
    public String toString(){
        return String.format("<|Node|> info:%s", info);
    }// toString

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }
}// Node<T>
