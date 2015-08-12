package assignment3;

public class Primzahlen{

    public static void main(String[] args){

        int versuche = 4;
        int N = 10; // basis, wird pro versuch verzehnfacht

        // [versuchNr][ergebnissArray]
        boolean[][] ergebnisseLangsam = new boolean[versuche][];
        boolean[][] ergebnisseSchnell = new boolean[versuche][];
        boolean[][] ergebnisseSieb = new boolean[versuche][];

        for(int i = 0 ; i < versuche ; i++){
            ergebnisseLangsam[i] = langsam(trueArray(N));
            ergebnisseSchnell[i] = schnell(trueArray(N));
            ergebnisseSieb[i] = sieb(trueArray(N));
            N *= 10;
        }
        
            istZahlPrimzahl(12497);
            istZahlPrimzahl(24989);
            istZahlPrimzahl(49999);
            istZahlPrimzahl(99991);
            istZahlPrimzahl(5);

            
            
        for(int i = 0 ; i < versuche ; i++){
            for(int j = 0 ; j < ergebnisseLangsam[i].length ; j++){
                if(!(ergebnisseLangsam[i][j] == ergebnisseSchnell[i][j] && ergebnisseSchnell[i][j] == ergebnisseSieb[i][j]))
                    System.out.println("Fuck!@ i=" + i + ", j=" + j + " " + ergebnisseLangsam[i][j] + ", " + ergebnisseSchnell[i][j] + ", "+ ergebnisseSieb[i][j]);
            }
        }
    }

    public static boolean[] langsam(boolean[] prim){
        long counter = 0;
        for(int i = 2 ; i < prim.length ; i++){
            for(int j = 2 ; j < prim.length ; j++){
                counter++;
                if(i % j == 0 && i != j){
                    prim[i] = false;
                }
            }
        }
        System.out.println("langsam braucht bei N=" + prim.length + ": " + counter + " Schritte.");
        return prim;
    }

    public static boolean[] schnell(boolean[] prim){
        int counter = 0;
        prim[4] = false;
        for(int i = 3 ; i < prim.length ; i += 2){
            for(int j = 2 ; j <= Math.sqrt(i) ; j++){
                if(i < prim.length - 1)
                    prim[i + 1] = false;
                counter++;
                if(i % j == 0 && i != j){
                    prim[i] = false;
                    break;
                }
            }
        }
        //System.out.println("schnell braucht bei N=" + prim.length + ": " + counter + " Schritte.");
        return prim;
    }

    public static boolean[] sieb(boolean[] prim){
        int counter = 0;

        for(int i = 2 ; i < Math.sqrt(prim.length) ; i++){
            if(prim[i] == true){
                for(int j = 2 ; i * j < prim.length ; j++){
                    counter++;
                    prim[i * j] = false;
                }
            }
        }

        System.out.println("Das Sieb braucht bei N=" + prim.length + ": " + counter + " Schritte.");
        return prim;
    }

    public static boolean istZahlPrimzahl(int zahl){
        int counter = 0;

        if(zahl < 2){
            System.out.println(zahl + " ist keine Primzahl");
            return false;
        }
        if(zahl == 2 || zahl == 3){
            System.out.println(zahl + " ist eine Primzahl");
            return true;
        }
        if(zahl % 2 == 0 || zahl % 3 == 0){
            System.out.println(zahl + " ist keine Primzahl");
            return false;
        }
        for(int i = 6 ; i <= (Math.sqrt(zahl) + 1) ; i += 6){
            counter++;
            if(zahl % (i - 1) == 0 || zahl % (i + 1) == 0){
                System.out.println(zahl + " ist keine Primzahl");
                return false;
            }
        }
        System.out.println(zahl + " ist eine Primzahl, es wurden " + counter + " Schritte benötigt");
        return true;
    }

    public static boolean[] trueArray(int size){
        boolean[] array = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = true;
        }
        return array;
    }
}
