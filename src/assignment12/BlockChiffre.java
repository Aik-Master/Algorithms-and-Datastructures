package assignment12;

import java.util.Random;

public class BlockChiffre{

    public int[] encode(int[] clear, int[] keys){
        int[] chiffre = new int[clear.length + 8];
        chiffre[0] = keys[0];
        chiffre[1] = keys[1];

        for(int i = 0 ; i < clear.length ; i += 2){
            chiffre[i + 8] = (clear[i] + keys[0]) % 95;
            if(i + 1 + 8 < chiffre.length){
                chiffre[i + 8 + 1] = (clear[i + 1] + keys[1]) % 95;
            }
        }
        return chiffre;
    }

    public char[] decode(int[] krypt){
        char[] decode = new char[krypt.length - 8];

        for(int i = 0 ; i < krypt.length - 8 ; i += 2){
            krypt[i + 8] = (krypt[i + 8] - krypt[0]) % 95;
            if(krypt[i + 8] < 0)
                krypt[i + 8] = 95 + krypt[i + 8];
            if(i + 1 < krypt.length - 8){
                krypt[i + 9] = (krypt[i + 9] - krypt[1]) % 95;
                if(krypt[i + 9] < 0)
                    krypt[i + 9] = 95 + krypt[i + 9];
            }

            decode[i] = (char) (krypt[i + 8] + 32);
            if(i + 1 + 8 < krypt.length){
                decode[i + 1] = (char) ((krypt[i + 9] + 32));
            }
        }
        return decode;
    }

    public int[] stringToInt(String message){
        char[] tmp = message.toCharArray();
        int[] intClearArray = new int[tmp.length];

        for(int i = 0 ; i < tmp.length ; i++){
            intClearArray[i] = (int) (tmp[i] - 32);
        }
        return intClearArray;
    }

    public int[] genKeys(){
        Random rand = new Random();
        int[] key = {rand.nextInt(94), rand.nextInt(94)};
        return key;
    }
}
