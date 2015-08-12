package assignment7;

public class Elem implements Comparable<Elem>{

    public int key;

    public Elem(int key){
        this.key = key;
    }
    
    @Override
    public String toString(){
        return String.valueOf(key);
    }

    @Override
    public int compareTo(Elem o){
        return this.key - o.key;
    }
}
