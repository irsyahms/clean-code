package com.refactorcalculator;

import java.util.Scanner;

class RefactorCalculator {
    static char operator;
    static Double firstNumber, secndNumber, result;

    public static void main(String args[]) {
            inputNumber();
            operator();
    }

        public static void inputNumber(){

            Scanner input = new Scanner(System.in);
            System.out.print("Enter first numbers: ");
            firstNumber = input.nextDouble();

            // nextDouble() reads the next double from the keyboard
            System.out.print("Enter second numbers: ");
            secndNumber = input.nextDouble();

            System.out.print("Enter an operator ((+), (-), (*) : ");
            operator = input.next().charAt(0);
        }

        public static void operator(){
            if (operator == '+') {
                sumOperation();
            } else if (operator == '-') {
               subtractOperation();
            } else if (operator == '*') {
               multiplyOperation();
            } else {
                System.out.printf("Error! operator is not correct");
                return;
            }
                System.out.println("** Result: " + result);

        }

    public static void sumOperation(){
        result = firstNumber + secndNumber;
    }

    public static void subtractOperation(){
        result = firstNumber - secndNumber;
    }

    public static void multiplyOperation(){
        result = firstNumber * secndNumber;
    }
}