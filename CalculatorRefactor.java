package com.assignment;

import java.util.*;

class CalculatorRefactor {
    static List<String> numberOperators= new ArrayList<String>();
    static String tempCharacter = "";
    static double calculationResult = 0;

    static Scanner inputCalculation = new Scanner(System.in);


    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = inputCalculation.next();
            numberOperators = parseInputIntoArrayList(nextLine);
            calculateNumber();
            System.out.println("** Result: " + calculationResult);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    static List<String> parseInputIntoArrayList(String input){ //method untuk parse setiap char dalam input kedalam ArrayList
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            addEachCharIntoArrayList(inputIndex,input);
            isLastInput(inputIndex,input);
        }
        return numberOperators; //hasil parsing dikembalikan menjadi isi numberOperators
    }

    static void addEachCharIntoArrayList(int inputIndex, String input){ //method penambahan char di array list
        if(input.charAt(inputIndex) == '+' || input.charAt(inputIndex) == '-' || input.charAt(inputIndex) == '/' ||input.charAt(inputIndex)=='*') {
            numberOperators.add(tempCharacter);
            numberOperators.add(String.valueOf(input.charAt(inputIndex)));

            tempCharacter = "";
        } else {
            tempCharacter += String.valueOf(input.charAt(inputIndex));
        }
    }

    static void isLastInput(int inputIndex, String input){ // method menghentinkan penambahan char setelah diinput
        if (inputIndex == input.length() - 1) {
            numberOperators.add(tempCharacter);
            tempCharacter = "";
        }
    }
    static void calculateNumber(){ // method untuk kalkulasi data input yang sudah dimasukkan ke arraylist
        for (int calcIndex = 0; calcIndex < numberOperators.size(); calcIndex++) {
            switch (numberOperators.get(calcIndex)) {
                case "+":
                    calcIndex++;
                    calculationResult = calcSum(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                case "-":
                    calcIndex++;
                    calculationResult = calcSubtraction(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                case "/":
                    calcIndex++;
                    calculationResult = calcDistribution(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                case "*":
                    calcIndex++;
                    calculationResult = calcMultiplication(calculationResult, Double.parseDouble(numberOperators.get(calcIndex)));
                    break;
                default:
                    calculationResult = calcNumber(Double.parseDouble(numberOperators.get(calcIndex)));

            }
        }
    }

    static double calcSum(double firstNumber, double secNumber){ //method hitung penambahan
        return firstNumber + secNumber;
    }

    static double calcSubtraction(double firstNumber, double secondNumber){ //method hitung pengurangan
        return firstNumber - secondNumber;
    }

    static double calcMultiplication(double firstNumber,double secondNumber){
        return firstNumber * secondNumber;
    }

    static double calcDistribution(double firstNumber, double secNumber){ //method untuk menghitung pembagian
        return firstNumber / secNumber;
    }

    static double calcNumber(double firstNumber){ //method untuk angka pertama dalam input
        return firstNumber;

    }

}