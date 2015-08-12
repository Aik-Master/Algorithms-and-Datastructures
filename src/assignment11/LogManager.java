package assignment11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class LogManager{

    public void generateLog(String source, int stringSize, int noStrings){
        RandomString randS = new RandomString(stringSize);
        Random random = new Random();
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(source, "UTF-8");
            for(int i = 0 ; i < noStrings ; i++){
                writer.println((random.nextInt(254) + 1) + ":" + (random.nextInt(254) + 1) + ":" + (random.nextInt(254) + 1) + ":" + (random.nextInt(254) + 1)
                        + " MSG: " + randS.nextString());
            }
        } catch(FileNotFoundException | UnsupportedEncodingException e){
            e.printStackTrace();
        } finally{
            writer.close();
        }
    }
    
    public void fillLogsInHashtable(HashTable tableToBeFilled){
        String[] strings = new String[2];
        try(BufferedReader br = new BufferedReader(new FileReader("ipLogs.txt"))){
            String sCurrentLine;
            while((sCurrentLine = br.readLine()) != null){
                strings = sCurrentLine.split(" MSG: ");
                tableToBeFilled.insert(strings[0], strings[1]);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

