
import java.util.*;

class CalculatorRefactor {
   static double number1;
   static double number2;
   static char operator;
   static double result;
    public static void main(String[] args) {
        input();
        operation();
    }

    public static void input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number1: ");
         number1 = in.nextDouble();
        System.out.print("Input number2: ");
         number2 = in.nextDouble();
        System.out.print("Enter an operation ((+), (-), (*), (/): ");
        operator = in.next().charAt(0);
    }

    public static void add() {
        result = number1 + number2;
    }
    public static void substract() {
        result = number1 - number2;
    }
    public static void multiply() {
        result = number1 * number2;
    }
    public static void divide() {
        result = number1 / number2;
    }
    public static void operation(){
        //ArrayList<Object> operationNumber = null;
          //  for (int index = 0; index < operationNumber.size(); index++) {
        if (operator == '+') {
            add();
        } else if (operator == '-') {
            substract();
        } else if (operator == '*') {
            multiply();
        } else if (operator == '/') {
            divide();
        }
        System.out.printf("** Result: " + result);

    }





        }


