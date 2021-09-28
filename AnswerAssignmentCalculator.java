package com.calculator;
import java.util.*;

public class AnswerAssignmentCalculator {
    static List<String> mathProblem= new ArrayList<String>();
    static String tempChar = "";

    static boolean isOperator(char readNextChar){
        if(readNextChar == '+' || readNextChar == '-' || readNextChar == '/' || readNextChar == '*'){
            return true;
        }else return false;
    }

    static double addition(double nextNum, double total){
        return total + nextNum;
    }

    static double subtraction(double nextNum, double total){
        return total - nextNum;
    }

    static double multiplication(double nextNum, double total){
        return total * nextNum;
    }

    static double division(double nextNum, double total){
        return total / nextNum;
    }

    static double calculate(List<String> mathProblem){
        String getOperator = "";
        double getNextNum = 0;

        double total = Double.parseDouble(mathProblem.get(0)); //get angka pertama
        //perhitungan
        for (int indexCharInMathProblem = 0; indexCharInMathProblem < mathProblem.size(); indexCharInMathProblem++) {
            getOperator = mathProblem.get(indexCharInMathProblem);

            if(getOperator.equals("+")){
                indexCharInMathProblem++;
                getNextNum = Double.parseDouble(mathProblem.get(indexCharInMathProblem));
                total = addition(getNextNum, total);
            }else if(getOperator.equals("-")){
                indexCharInMathProblem++;
                getNextNum = Double.parseDouble(mathProblem.get(indexCharInMathProblem));
                total = subtraction(getNextNum, total);
            }else if(getOperator.equals("/")){
                indexCharInMathProblem++;
                getNextNum = Double.parseDouble(mathProblem.get(indexCharInMathProblem));
                total = division(getNextNum, total);
            }else if(getOperator.equals("*")){
                indexCharInMathProblem++;
                getNextNum = Double.parseDouble(mathProblem.get(indexCharInMathProblem));
                total = multiplication(getNextNum, total);
            }
        }
        return total;
    }

    static void addParsingChar(int indexParsingChar, String inputFromCommand){
        char readNextChar = inputFromCommand.charAt(indexParsingChar);
        if(isOperator(readNextChar)) {
            mathProblem.add(tempChar);
            mathProblem.add(String.valueOf(readNextChar));

            tempChar = "";
        } else {
            tempChar = tempChar + String.valueOf(readNextChar);
        }
    }

    static boolean isLastChar(int indexParsingChar, String inputFromCommand){
        if(indexParsingChar == inputFromCommand.length() - 1){
            return true;
        }else return false;
    }

    static void lastChar(int indexParsingChar,  String nextLine){
        if (isLastChar(indexParsingChar, nextLine)) {
            mathProblem.add(tempChar);
            tempChar = "";
        }
    }

    static void printResult(double total ){
        if(mathProblem.size() < 3){
            System.out.println("** Result: " + mathProblem.get(0));
        }else{
            total = calculate(mathProblem);
            System.out.println("** Result: " + total);
        }
    }



    public static void main(String args[]) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String inputFromCommand = inputScanner.next();
            double total = 0;

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            for (int indexParsingChar = 0; indexParsingChar < inputFromCommand.length(); indexParsingChar++) {
                addParsingChar(indexParsingChar, inputFromCommand);
                lastChar(indexParsingChar, inputFromCommand);
            }

            //perhitungan
            if(mathProblem.size() < 3){
                System.out.println("** Result: " + mathProblem.get(0));
            }else{
                total = calculate(mathProblem);
                System.out.println("** Result: " + total);
            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

}
