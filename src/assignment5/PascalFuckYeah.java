package assignment5;

public class PascalFuckYeah{

    private static int recCounter  = 0;
    private static int itCounter   = 0;
    private static int fastCounter = 0;

    public static void main(String[] args){

        int N = 19;

        int a[] = recursive(N);
        long b[] = iterativ((long)N);
        int c[] = fast(N);
        for(int i = 0 ; i < N ; i++)
            System.out.println(a[i]+ " "+ b[i]+ " "+ c[i]);

        System.out.println("recCounter: "+recCounter+"; fastCounter: "+fastCounter);
    }
    
    static long[] iterativ (long N) {
        long erg[] = new long[(int)N];
        for (long K = 0; K < N; K++) {
            erg[(int)K] = fak(N) / (fak(K)* fak(N - K));
        }
        return erg;
    }
    static long fak(long N) {
        long erg = 1;
        for(long i = 1; i<=N ;i++) {
            erg *= i;
        }
        return erg;
    }
    
    
    

    static int[] recursive(int N){
        int[] erg = new int[N];
        for(int i = 1 ; i <= N ; i++){
            erg[i - 1] = realRecursion(N, i);
        }
        return erg;
    }
    static int realRecursion(int N, int K){
        recCounter++;
        if(K == 1 || N == K){
            return 1;
        } else{
            return realRecursion(N - 1, K - 1) + realRecursion(N - 1, K);
        }
    }

    static int[] fast(int N){
        int[][] triForce = new int[N + 1][N];
        triForce[0][0] = 1;
        for(int i = 1 ; i <= N ; i++){
            triForce[i][0] = 1;
            for(int j = 1 ; j < i ; j++){
                triForce[i][j] = triForce[i - 1][j - 1] + triForce[i - 1][j];
                fastCounter++;
            }
        }
        return triForce[N];
    }
}
