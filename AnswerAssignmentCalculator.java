package com.calculator;
import java.util.*;

public class AnswerAssignmentCalculator {
    static List<String> mathProblem= new ArrayList<String>();

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
        for (int i = 0; i < mathProblem.size(); i++) {
            getOperator = mathProblem.get(i);

            if(getOperator.equals("+")){
                getNextNum = Double.parseDouble(mathProblem.get(i+1));
                total = addition(getNextNum, total);
            }else if(getOperator.equals("-")){
                getNextNum = Double.parseDouble(mathProblem.get(i+1));
                total = subtraction(getNextNum, total);
            }else if(getOperator.equals("/")){
                getNextNum = Double.parseDouble(mathProblem.get(i+1));
                total = division(getNextNum, total);
            }else if(getOperator.equals("*")){
                getNextNum = Double.parseDouble(mathProblem.get(i+1));
                total = multiplication(getNextNum, total);
            }
        }
        return total;
    }



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = in.next();
            double total = 0;

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temp = "";
            for (int i = 0; i < nextLine.length(); i++) {
                char readNextChar = nextLine.charAt(i);
                if(isOperator(readNextChar)) {
                    mathProblem.add(temp);
                    mathProblem.add(String.valueOf(readNextChar));

                    temp = "";
                } else {
                    temp = temp + String.valueOf(readNextChar);
                }

                if (i == nextLine.length() - 1) {
                    mathProblem.add(temp);
                    temp = "";
                }
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
