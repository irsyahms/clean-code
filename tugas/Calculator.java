package tugas;

import java.io.IOException;
import java.util.*;

class Calculator {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");
            String nextLine = in.next();
            List<String> Operator = new ArrayList<String>();
            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temp = "";
            for (int indexOperator = 0; indexOperator < nextLine.length(); indexOperator++) {
                if(nextLine.charAt(indexOperator) == '+' || nextLine.charAt(indexOperator) == '-' || nextLine.charAt(indexOperator) == '/') {
                    Operator.add(temp);
                    Operator.add(String.valueOf(nextLine.charAt(indexOperator)));

                    temp = "";
                } else {
                    temp = temp + String.valueOf(nextLine.charAt(indexOperator));
                }

                if (indexOperator == nextLine.length() - 1) {
                    Operator.add(temp);
                    temp = "";
                }
            }

            //perhitungan
            double DatainputOperator = 0;
            for (int index = 0; index < Operator.size(); index++) {
                switch (Operator.get(index)) {
                    case "+":
                        index++;
                        DatainputOperator = DatainputOperator + Double.parseDouble(Operator.get(index));
                        break;
                    case "-":
                        index++;
                        DatainputOperator = DatainputOperator - Double.parseDouble(Operator.get(index));
                        break;
                    case "/":
                        index++;
                        DatainputOperator = DatainputOperator / Double.parseDouble(Operator.get(index));
                        break;
                    default:
                        DatainputOperator = Double.parseDouble(Operator.get(index));
                }
            }

            System.out.println("** Result: " + DatainputOperator);

       // } catch (InputMismatchException e) {
            //System.out.println("Invalid input");
        }
    }
