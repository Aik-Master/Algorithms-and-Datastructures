package assignment2;

public abstract class Testframe{

    public static void main(String[] args){

        // testing the javadoc
        Stack<String> stack = new Stack<>(2);
        stack.empty();
        stack.isEmpty();
        stack.pop();
        stack.push("");
        stack.top();

        Vollst�ndigGeklammerteAlgebraischeAusdr�cke wtfWasIstDasDennF�rEinName = new Vollst�ndigGeklammerteAlgebraischeAusdr�cke();
        System.out.println(wtfWasIstDasDennF�rEinName.solve("((6*(4*28))+(9-((12/4)*2)))"));

        System.out.println(wtfWasIstDasDennF�rEinName.solve("(((3+5)*34)+(((408/34)+(21-123))+666))"));
    }
}
