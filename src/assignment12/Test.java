package assignment12;

public class Test{

    public static void main(String[] args){

        RSA WuTang = new RSA();

        int[] prims = WuTang.genRandPrimes();
        int haupt = WuTang.getHauptmodul(prims);
        int neben = WuTang.getNebenmodul(prims);
        int e = WuTang.genRelativePrime(neben);
        int d = WuTang.calculateD(e, neben);

        long text = 666;

        int save = WuTang.chiffrieren(text, e, haupt);
        int clear = WuTang.chiffrieren(save, d, haupt);

        System.out.println(text + " => " + save + " => " + clear);
        
        BlockChiffre block = new BlockChiffre();
        
        int[] keys = block.genKeys();
        System.out.println(keys[0] + " " +keys[1]);
        int[] ret = block.encode(block.stringToInt("Test"), keys);
        System.out.println(block.decode(ret));

    }

}
