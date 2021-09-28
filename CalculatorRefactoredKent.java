import java.util.*;

class CalculatorRefactoredKent {
    static List<String> numberOperators= new ArrayList<String>(); //List to store the numbers and operators
    static String tempCharacter = ""; // as a temporary string to store each number/operator
    static Scanner inputCalculation = new Scanner(System.in); //as a input to calculate
    static double calculationResult = 0; //initial state of result

    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = inputCalculation.next();
            numberOperators = parseInputIntoList(nextLine);
            calculateArray();
            System.out.println("** Result: " + calculationResult);          

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    static List<String> parseInputIntoList(String input){ //a method to parse every char in the input into the List
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            addEachCharIntoList(inputIndex,input);
            isLastInput(inputIndex,input);
        }
        return numberOperators; //return parsing result into the list values
    } 

    static void addEachCharIntoList(int inputIndex, String input){ //a method to insert every char into the list
        if(input.charAt(inputIndex) == '+' || input.charAt(inputIndex) == '-' || input.charAt(inputIndex) == '/') {
            numberOperators.add(tempCharacter);  // storing the number into the List
            numberOperators.add(String.valueOf(input.charAt(inputIndex)));// adding the operator into the list

            tempCharacter = "";
        } else {
            tempCharacter += String.valueOf(input.charAt(inputIndex)); // to keep more than 1 digits number into 1 index
        }
    }

    static void isLastInput(int inputIndex, String input){ // a method to store last number in inputCalculation
        if (inputIndex == input.length() - 1) {
            numberOperators.add(tempCharacter);
            tempCharacter = ""; //clear tempCharacter
        }
    }
    static void calculateArray(){ // a method to calculate inputCalculation
        for (int calcIndex = 0; calcIndex < numberOperators.size(); calcIndex++) {
            switch (numberOperators.get(calcIndex)) {
                case "+":
                    calcIndex++;
                    calculationResult = calcSum(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                case "-":
                    calcIndex++;
                    calculationResult = calcSub(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                case "/":
                    calcIndex++;
                    calculationResult = calcDivide(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                default:
                    calculationResult = calcNumber(Double.parseDouble(numberOperators.get(calcIndex)));
                    
            }
        }
    }

    static double calcSum(double firstNum, double secNum){ //a method to do addition
        return firstNum + secNum;
    }

    static double calcSub(double firstNum, double secNum){ //a method to do subtraction
        return firstNum - secNum;
    }

    static double calcDivide(double firstNum, double secNum){ //a method to do division
        return firstNum / secNum;
    }

    static double calcNumber(double firstNum){ //method to store first number in the list
        return firstNum;

    }

}
