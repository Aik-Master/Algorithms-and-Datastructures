package assignment4;

public class RekursiveSummeDerGanzenZahlenMain{

    public static void main(String[] args){

        int N = 7855;
        SummeDerGanzenZahlen objekt = new SummeDerGanzenZahlen();
        System.out.println(objekt.rekursiv(N));
        System.out.println(objekt.iterativ(N));
        System.out.println(objekt.gaussRechnung(N));

    }
}

class SummeDerGanzenZahlen{
    int ergRekursiv = 0;
    public int rekursiv(int N){
        if(N >= 0){
            ergRekursiv += N;
            return(rekursiv(N - 1));
        }
        return ergRekursiv;
    }

    public int iterativ(int N){
        int ergIterativ = 0;
        for(int i = 1 ; i <= N ; i++){
            ergIterativ += i;
        }
        return ergIterativ;
    }
    
    public int gaussRechnung(int N){
        return (N*N+N)/2;
    }
}