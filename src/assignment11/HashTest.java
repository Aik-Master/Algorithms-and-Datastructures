package assignment11;

public class HashTest{

    public static void main(String[] args){

        LogManager logMan = new LogManager();
        
        HashTable hashTable = new HashTable();

        logMan.generateLog("ipLogs.txt", 50, 100);
        logMan.fillLogsInHashtable(hashTable);

        new GUI(hashTable);
        
        
        String ip = "192:168:1:1";
        
        
//        HashTable hashTable;      
        long time1, time2;
        int N = 100000;
        
        //for(int i = 1 ; i < 6 ; i++){
            N *=10;
        System.out.println(N);
        for(int i = 0 ; i < 2; i++){
    

            
                hashTable = new HashTable();

                logMan.generateLog("ipLogs.txt", 50, N);
                logMan.fillLogsInHashtable(hashTable);
                hashTable.insert(ip, "jaja TestIp");
                
                time1 = System.nanoTime();
                hashTable.get(ip);
                time2 = System.nanoTime();
         
                //System.out.println(N + " elemente,  " + (time2 - time1) + "ns.");
        //}
                System.out.println(time2 - time1);

        }       
    }
}

