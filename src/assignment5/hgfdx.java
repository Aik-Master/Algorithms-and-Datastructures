package assignment5;

public class hgfdx{


    public static void main(String[] args) {
        
        for(int i=1; i<15;i++){
            System.out.printf("%2d te fak: %15d \n", i, fak(i));
        }
        System.out.println();
        int n = 5;

        for (long k = 0; k <= n; k++) {
            System.out.printf("%3d ", binomial(n, k));
        }
        System.out.printf("\n");
    }

    static long binomial(long n, long k) {
        return fak(n) / (fak(k) * fak(n - k));
    }

    static long fak(long N) {
        long erg = 1;
        for(long i = 1; i<=N ;i++) {
            erg *= i;
        }
        return erg;
    }

}

