import java.util.*;

class Calculator {
    private static List<String> numberOperator = new ArrayList<String>();
    private static double calculationResult = 0;
    private static String temporaryCharacter = "";

    private static Scanner inputCalculation = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = inputCalculation.next();
            numberOperator = parseInputIntoArrayList(nextLine);
            calculateNumber();
            System.out.println("** Result: " + calculationResult);
        }catch (InputMismatchException e) {System.out.println("Invalid input");}
    }

    private static List<String> parseInputIntoArrayList(String input) {
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            addCharIntoArrayList(inputIndex, input);
            isLastInput(inputIndex, input);
        }
        return numberOperator;
    }

    private static void addCharIntoArrayList(int inputIndex, String input){
        if(input.charAt(inputIndex) == '+' ||
           input.charAt(inputIndex) == '-' ||
           input.charAt(inputIndex) == '/' ||
           input.charAt(inputIndex) == '*') {
            numberOperator.add(temporaryCharacter);
            numberOperator.add(String.valueOf(input.charAt(inputIndex)));

            temporaryCharacter = "";
        } else {
            temporaryCharacter += String.valueOf(input.charAt(inputIndex));
        }
    }

    private static void isLastInput(int inputIndex, String input){
        if (inputIndex == input.length() - 1) {
            numberOperator.add(temporaryCharacter);
            temporaryCharacter = "";
        }
    }

    private static void calculateNumber() {
        for (int calculationIndex = 0; calculationIndex < numberOperator.size(); calculationIndex++) {
            switch (numberOperator.get(calculationIndex)) {
                case "+":
                    calculationIndex++;
                    calculationResult = calculationResult + Double.parseDouble(numberOperator.get(calculationIndex));
                    break;
                case "-":
                    calculationIndex++;
                    calculationResult = calculationResult - Double.parseDouble(numberOperator.get(calculationIndex));
                    break;
                case "/":
                    calculationIndex++;
                    calculationResult = calculationResult / Double.parseDouble(numberOperator.get(calculationIndex));
                    break;
                case "*":
                    calculationIndex++;
                    calculationResult = calculationResult * Double.parseDouble(numberOperator.get(calculationIndex));
                    break;
                default:
                    calculationResult = calcNumber(Double.parseDouble(numberOperator.get(calculationIndex)));
            }
        }
    }

    public double adding(double number1, double number2) {
        return number1 + number2;
    }

    public double substracing(double number1, double number2) {
        return number1 - number2;
    }

    public double dividing(double number1, double number2) {
        return number1 / number2;
    }

    public double multiplying(double number1, double number2) {
        return number1 * number2;
    }

    public static double calcNumber(double Number1){
        return Number1;
    }
}