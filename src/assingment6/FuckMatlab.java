package assingment6;

public class FuckMatlab{

    /**
     * @param args
     */
    public static void main(String[] args){

        int i;
        System.out.print("nlogn = [");
        for(i = 1 ; i < 1000000000 ; i *= 10){
            System.out.print(i + "*log2("+i+"), ");
        }
        
        System.out.println(i + "*log2("+i+")];");
    
    
        
        System.out.print("nmaln = [");
        for(i = 1 ; i < 1000000000 ; i *= 10){
            System.out.print(i + "*"+i+", ");
        }
        
        System.out.println(i + "*"+i+"];");
    
    
    }

}
