package assignment1;


public class List<T> {

    Node<T>    head, tail;
    public int counter;
    

    public List(){
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.next = tail;
        tail.next = head;
        counter = 0;
    }

    private Node<T> findPosPrev(Node<T> pos){
        Node<T> searchNode = new Node<T>(null);
        searchNode = head; // starting from the beginning
        while(searchNode.next != pos && searchNode.next != tail){// Iterate until "pos" is found or "tail" is reached
            searchNode = searchNode.next;
            counter += 1;
        }
        return searchNode;
    }

    public void insert(T elem, Node<T> pos){
        Node<T> inserted = new Node<T>(elem);
        if(pos == head){
            inserted.next = head.next;
            head.next = inserted;
        } else {
            inserted.next = pos;
        findPosPrev(pos).next = inserted;
        }
    }// insert

    public void delete(Node<T> pos){
        Node<T> tmp = findPosPrev(pos);
        tmp.next = pos.next;
        if(pos.next == head) {
            head.next = tmp;
        }
    }

    public Node<T> find(T elem){// LIST x ELEM -> POS
        Node<T> searchNode = new Node<T>(elem);
        searchNode.next = head.next; // starting from the beginning
        tail.setInfo(elem);// Stopper at the end
        while(searchNode.next.getInfo() != elem){// Iterate until "elem" is found
            searchNode = searchNode.next;
            counter += 1;
        }
        return searchNode.next;
    }

    public Node<T> retrieve(Node<T> pos){// LIST x POS -> ELEM
        return findPosPrev(pos).next;
    }

    public void concat(List<T> list){// LIST x LIST -> LIST
        tail.next.next = list.head.next;
        tail = list.tail.next;
    }

    public boolean isEmpty(){
        if(head.next.next == head){
            return(true);
        }// if
        return(false);
    }// isEmpty

    @Override
    public String toString(){
        String returnString = "Nodes: ";
        Node<T> node = head;
        while(node.next != tail){
            node = node.next;
            returnString = returnString + node.toString();
        }
        return returnString;
    }

    public Node<T> getHead(){
        return head;
    }
    
    public Node<T> getTail(){
        return head;
    }
}
