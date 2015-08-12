package assignment12;

import java.util.Random;

import assignment3.Primzahlen;

public class RSA{

    public int getHauptmodul(int[] prims){
        return prims[0]*prims[1];
    }
    
    public int getNebenmodul(int[] prims){
        return (prims[0] - 1) * (prims[1] - 1);
    }

    public int chiffrieren(long msg, int key, int hauptmodul){
        long result = 1;

        for(int i = 0 ; i < key ; i++){
            result *= msg;
            result = result % hauptmodul;
        }
        return (int) result;
    }

    public int calculateD(int e, int nebenmodul){
        int d = 1;

        while((e * d) % nebenmodul != 1){
            d++;
        }
        return d;
    }

    private int euklidGGT(int a, int b){
        if(b == 0)
            return a;
        else
            return euklidGGT(b, a % b);
    }

    public int genRelativePrime(int nebenmodul){

        int i = 2;// (int) (Math.random()*1000);
        while(euklidGGT(nebenmodul, i) != 1){
            i++;
        }
        return i;
    }

    public int[] genRandPrimes(){
        boolean[] primBoole = Primzahlen.schnell(Primzahlen.trueArray(1000));
        int[] primes = new int[900];
        int noPrimes = 0;
        for(int i = 100 ; i < primBoole.length ; i++){
            if(primBoole[i])
                primes[noPrimes++] = i;
        }
        int[] ret = new int[2];
        final Random random = new Random();

        ret[0] = primes[random.nextInt(noPrimes)];

        do{
            ret[1] = primes[random.nextInt(noPrimes)];
        } while(ret[0] == ret[1]);

        return ret;
    }
}
