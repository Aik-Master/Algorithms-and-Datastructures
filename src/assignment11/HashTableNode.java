package assignment11;

public class HashTableNode{
    
    String ip;
    String log;
    long key;
    boolean deleted;
    HashTableNode next;
    
    public HashTableNode(String ip, String log){
        this.ip = ip;
        this.log = log;
        this.next = null;
        key = getIpLong(ip);
    }

    public HashTableNode(){
    }

    long getIpLong(String ip){
        String[] bitSectors = ip.split(":");
        return Long.valueOf(bitSectors[0]) * 1000_000_000
             + Long.valueOf(bitSectors[1]) * 1000_000
             + Long.valueOf(bitSectors[2]) * 1000
             + Long.valueOf(bitSectors[3]);
    }
}
