package assignment2;

public class VollständigGeklammerteAlgebraischeAusdrücke{

    Stack<Integer>   operanden;
    Stack<Character> operatoren;

    public int solve(String expression){

        operanden = new Stack<Integer>(20);
        operatoren = new Stack<Character>(20);

        char[] chars = expression.toCharArray();

        int numeral = 0;
        for(int i = 0 ; i < chars.length ; i++){
            if(Character.isDigit(chars[i])){
                numeral = numeral * 10 + Character.getNumericValue(chars[i]);
                if(i + 1 <= chars.length){
                    if(!Character.isDigit(chars[i + 1])){
                        operanden.push(numeral);// save to stack if number ends after this numeral
                        numeral = 0;
                    }
                }
            } else if(chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/'){
                operatoren.push(chars[i]);
            } else if(chars[i] == ')'){
                int second = operanden.top();
                operanden.pop();
                int first = operanden.top();
                operanden.pop();
                switch(operatoren.top()){
                    case '+':
                        operanden.push(first + second);
                        break;
                    case '-':
                        operanden.push(first - second);
                        break;
                    case '*':
                        operanden.push(first * second);
                        break;
                    case '/':
                        operanden.push(first / second);
                        break;
                    default:
                        // throws Exception
                }// switch operator
                operatoren.pop();
            } else{
                // throws Exception;
            }// if isDigit
        }// for
        return operanden.top();
    }
}
