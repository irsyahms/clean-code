import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorRefactor {
    static List<String> listLineSplitCalculation= new ArrayList<String>();
    static String temporaryList = "";
    static double ResultCalculation = 0;

    //main
    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");
        Scanner inputUser = new Scanner(System.in);
        try {
            String rowInputUser = inputUser.next(); //
            listLineSplitCalculation = InputParseForEachCharToArrayList(rowInputUser);
            operatorCalculationArrayList();
            System.out.println("** Result: " + ResultCalculation);

        } catch (InputMismatchException e) {
            System.out.println("Input Invalid");
        }
    }

    static List<String> InputParseForEachCharToArrayList(String input){
        for (int indexArrayList = 0; indexArrayList < input.length(); indexArrayList++) {
            splitNumberAndOperator(indexArrayList,input);
            lastInputInLine(indexArrayList,input);
        }
        return listLineSplitCalculation;
    }

    static void splitNumberAndOperator(int indexArrayList, String input){
        if(input.charAt(indexArrayList) == '+' || input.charAt(indexArrayList) == '-' || input.charAt(indexArrayList) == '/' || input.charAt(indexArrayList) == '*') {
            listLineSplitCalculation.add(temporaryList);
            listLineSplitCalculation.add(String.valueOf(input.charAt(indexArrayList)));

            temporaryList = "";
        } else {
            temporaryList += String.valueOf(input.charAt(indexArrayList));
        }
    }

    static void lastInputInLine(int indexInput, String input){
        if (indexInput == input.length() - 1) {
            listLineSplitCalculation.add(temporaryList);
            temporaryList = "";
        }
    }
    static void operatorCalculationArrayList(){
        for (int indexOperator = 0; indexOperator < listLineSplitCalculation.size(); indexOperator++) {
            switch (listLineSplitCalculation.get(indexOperator)) {
                case "+":
                    indexOperator++;
                    additionCalculation(indexOperator);
                    break;
                case "-":
                    indexOperator++;
                    subtractionCalculation(indexOperator);
                    break;
                case "/":
                    indexOperator++;
                    divideCalculation(indexOperator);
                    break;
                case "*":
                    indexOperator++;
                    multipleCalculation(indexOperator);
                    break;
                default:
                    justNumber(indexOperator);
            }
        }
    }

    static void additionCalculation(int indexAddition){
        ResultCalculation += Double.parseDouble(listLineSplitCalculation.get(indexAddition));
    }

    static void subtractionCalculation(int indexSubtraction){
        ResultCalculation -= Double.parseDouble(listLineSplitCalculation.get(indexSubtraction));
    }

    static void divideCalculation(int indexDivide){
        ResultCalculation /= Double.parseDouble(listLineSplitCalculation.get(indexDivide));
    }

    static void multipleCalculation(int indexMultiple){
        ResultCalculation *= Double.parseDouble(listLineSplitCalculation.get(indexMultiple));
    }

    static void justNumber(int indexNumber){
        ResultCalculation = Double.parseDouble(listLineSplitCalculation.get(indexNumber));
    }
}
