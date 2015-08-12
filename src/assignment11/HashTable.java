package assignment11;

public class HashTable{

    public HashTableNode[] nodes;
    private int            noEntries;
    private double         loadMin = 0.5;
    private double         loadMax = 0.8;

    public HashTable(){
        nodes = new HashTableNode[findPrevPrime(15)];
        noEntries = 0;
    }

    public void insert(HashTableNode input){
        if(noEntries > nodes.length * loadMax){
            reHash(resize());
        }

        long hashVal;
        long hashVal1 = hashVal = hashFunc1(input.key);
        long hashVal2 = hashFunc2(input.key);
        int i = 1;
        while(nodes[(int) hashVal] != null && nodes[(int) hashVal].key != input.key){
            hashVal = hashVal1 + (hashVal2 * i * i);
            hashVal %= nodes.length;
            i++;
        }
        if(nodes[(int) hashVal] == null){
            nodes[(int) hashVal] = input;
            noEntries++;
        } else if(nodes[(int) hashVal].key == input.key){
            HashTableNode node = nodes[(int) hashVal];
            while(node.next != null){
                node = node.next;
            }
            node.next = input;
        }
    }

    public void insert(String ip, String log){
        insert(new HashTableNode(ip, log));
    }

    private long hashFunc1(long key){
        return key % nodes.length;
    }

    private long hashFunc2(long key){
        return 1 + (key % (nodes.length - 2));
    }

    private void reHash(int size){
        noEntries = 0;
        HashTableNode[] tmp = nodes;
        nodes = new HashTableNode[findPrevPrime(size)];
        for(int i = 0 ; i < tmp.length ; i++){
            if(tmp[i] != null){
                insert(tmp[i]);
            }
        }
    }

    private int resize(){
        return (int) (noEntries / loadMin);
    }

    private int findPrevPrime(int size){
        boolean isPrime;
        for(int j = size ; ; j--){
            isPrime = true;
            for(int i = 2 ; i < j ; i++){
                if(j % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                return j;
            }
        }
    }

    public HashTableNode get(String ip){
        HashTableNode node = new HashTableNode();
        long key = node.getIpLong(ip);

        long hashVal;
        long hashVal1 = hashVal = hashFunc1(key);
        long hashVal2 = hashFunc2(key);
        int i = 1;
        while(nodes[(int) hashVal] != null && nodes[(int) hashVal].key != key){
            hashVal = hashVal1 + (hashVal2 * i * i);
            hashVal %= nodes.length;
            i++;
        }
        if(nodes[(int) hashVal] == null){
            node = null;
        } else if(nodes[(int) hashVal].key == key){
            node = nodes[(int) hashVal];
        }
        return node;
    }
}
