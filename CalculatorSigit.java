package calculator;

import java.util.*;

class Calculator {
    public static void main(String args[]) {
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String readInput = inputUser.next();
            List<String> lineCalculation= new ArrayList<String>();

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temporaryCalculation = "";
            for (int indexInput = 0; indexInput < readInput.length(); indexInput++) {
                if(readInput.charAt(indexInput) == '+' || readInput.charAt(indexInput) == '-' || readInput.charAt(indexInput) == '/' || readInput.charAt(indexInput) == '*') {
                    lineCalculation.add(temporaryCalculation);
                    lineCalculation.add(String.valueOf(readInput.charAt(indexInput)));

                    temporaryCalculation = "";
                } else {
                    temporaryCalculation = temporaryCalculation + String.valueOf(readInput.charAt(indexInput));
                }

                if ( indexInput == readInput.length() - 1) {
                    lineCalculation.add(temporaryCalculation);
                    temporaryCalculation = "";
                }
            }

            //perhitungan
            double valueCalculation = 0;
            for (int indexInput = 0; indexInput < lineCalculation.size(); indexInput++) {
                switch (lineCalculation.get(indexInput)) {
                    case "+":
                        indexInput++;
                        valueCalculation = valueCalculation + Double.parseDouble(lineCalculation.get(indexInput));
                        break;
                    case "-":
                        indexInput++;
                        valueCalculation = valueCalculation - Double.parseDouble(lineCalculation.get(indexInput));
                        break;
                    case "/":
                        indexInput++;
                        valueCalculation = valueCalculation / Double.parseDouble(lineCalculation.get(indexInput));
                        break;
                    case "*":
                        indexInput++;
                        valueCalculation = valueCalculation * Double.parseDouble(lineCalculation.get(indexInput));
                        break;
                    default:
                        valueCalculation = Double.parseDouble(lineCalculation.get(indexInput));
                }
            }
            System.out.println("** Result: " + valueCalculation);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}