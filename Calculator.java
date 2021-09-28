package com.cleancode.calc;

import java.util.*;

class Calculator {

    private static String userInput;
    private static List<String> operatorList = new ArrayList<String>();
    private static double result = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try{
            userInput = sc.next();
            parsingInput();
            System.out.println("** Result: " + calculateNumbers());
        }catch (Exception e){
            System.err.println(e);
        }
    }

    private static void parsingInput() {

        String temp = "";
        for (int i = 0; i < userInput.length(); i++) {
            if(userInput.charAt(i) == '+' || userInput.charAt(i) == '-'
                    || userInput.charAt(i) == '/' || userInput.charAt(i) == '*') {

                operatorList.add(temp);
                operatorList.add(String.valueOf(userInput.charAt(i)));

                temp = "";
            } else {
                temp = temp + String.valueOf(userInput.charAt(i));
            }

            if (i == userInput.length() - 1) {
                operatorList.add(temp);
                temp = "";
            }
        }
    }

    private static double calculateNumbers() {

        for (int i = 0; i < operatorList.size(); i++) {

            if(operatorList.get(i).equalsIgnoreCase("+")){
                i++;
                addingNumbers(i);
            } else if(operatorList.get(i).equalsIgnoreCase("-")){
                i++;
                substracingNumbers(i);
            } else if(operatorList.get(i).equalsIgnoreCase("/")){
                i++;
                dividingNumbers(i);
            } else if(operatorList.get(i).equalsIgnoreCase("*")){
                i++;
                multiplyingNumbers(i);
            } else {
                result = Double.parseDouble(operatorList.get(i));
            }
        }
        return result;
    }

    private static void multiplyingNumbers(int index) {
        result *= Double.parseDouble(operatorList.get(index));
    }

    private static void dividingNumbers(int index) {
        result /= Double.parseDouble(operatorList.get(index));
    }

    private static void substracingNumbers(int index) {
        result -= Double.parseDouble(operatorList.get(index));
    }

    private static void addingNumbers(int index) {
        result += Double.parseDouble(operatorList.get(index));
    }
}
