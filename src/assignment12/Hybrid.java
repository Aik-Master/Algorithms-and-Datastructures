package assignment12;

public class Hybrid{

    static RSA          WuTang     = new RSA();
    static int[]        prims      = WuTang.genRandPrimes();
    static int          hauptModul = WuTang.getHauptmodul(prims);
    static int          nebenModul = WuTang.getNebenmodul(prims);
    static int          publicKey  = WuTang.genRelativePrime(nebenModul);
    static int          privateKey = WuTang.calculateD(publicKey, nebenModul);
    static BlockChiffre block      = new BlockChiffre();
    static int[]        keys       = block.genKeys();

    public static void main(String[] args){

        char[] encrypted = encrypt("Pareigis ist der beste Prof.");
        System.out.println(decrypt(encrypted));
    }

    private static char[] decrypt(char[] encrypted){

        int[] intAr = new int[encrypted.length];
        for(int i = 0 ; i < encrypted.length ; i++){
            intAr[i] = (int) (encrypted[i] - 32);
        }

        long s0 = ((intAr[3] + (intAr[2] * 95)) + (intAr[1] * 9025)) + (intAr[0] * 857375);
        long s1 = ((intAr[7] + (intAr[6] * 95)) + (intAr[5] * 9025)) + (intAr[4] * 857375);

        int s0Clear = WuTang.chiffrieren(s0, privateKey, hauptModul);
        int s1Clear = WuTang.chiffrieren(s1, privateKey, hauptModul);

        intAr[0] = s0Clear;
        intAr[1] = s1Clear;

        return block.decode(intAr);
    }

    private static char[] encrypt(String message){

        int[] msg = block.stringToInt(message);
        int[] intKryptArray = block.encode(msg, keys);

        int s0Clear = intKryptArray[0];
        int s1Clear = intKryptArray[1];

        int s0Save = WuTang.chiffrieren(s0Clear, publicKey, hauptModul);
        int s1Save = WuTang.chiffrieren(s1Clear, publicKey, hauptModul);

        intKryptArray[0] = (int) (s0Save / (int) Math.pow(95.0, 3.0));
        intKryptArray[1] = (int) ((int) (s0Save % (int) Math.pow(95.0, 3.0)) / Math.pow(95.0, 2.0));
        intKryptArray[2] = ((int) (s0Save % (int) Math.pow(95.0, 2.0)) / 95);
        intKryptArray[3] = (int) (s0Save % 95);

        intKryptArray[4] = (int) (s1Save / (int) Math.pow(95.0, 3.0));
        intKryptArray[5] = (int) ((int) (s1Save % (int) Math.pow(95.0, 3.0)) / Math.pow(95.0, 2.0));
        intKryptArray[6] = ((int) (s1Save % (int) Math.pow(95.0, 2.0)) / 95);
        intKryptArray[7] = (int) (s1Save % 95);

        char[] charAr = new char[intKryptArray.length];
        for(int i = 0 ; i < intKryptArray.length ; i++){
            charAr[i] = (char) (intKryptArray[i] + 32);
        }
        return charAr;
    }
}
