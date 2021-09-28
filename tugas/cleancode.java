package tugas;

import java.io.IOException;
import java.util.*;

class cleancode {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

       // try {
            String nextLine = in.next();
            List<String> Operator = new ArrayList<String>();

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temp = "";
            for (int index = 0; index < nextLine.length(); index++) {
                if(nextLine.charAt(index) == '+' || nextLine.charAt(index) == '-' || nextLine.charAt(index) == '/') {
                    Operator.add(temp);
                    Operator.add(String.valueOf(nextLine.charAt(index)));

                    temp = "";
                } else {
                    temp = temp + String.valueOf(nextLine.charAt(index));
                }

                if (index == nextLine.length() - 1) {
                    Operator.add(temp);
                    temp = "";
                }
            }

            //perhitungan
            double Datainput = 0;
            for (int i = 0; i < Operator.size(); i++) {
                switch (Operator.get(i)) {
                    case "+":
                        i++;
                        Datainput = Datainput + Double.parseDouble(Operator.get(i));
                        break;
                    case "-":
                        i++;
                        Datainput = Datainput - Double.parseDouble(Operator.get(i));
                        break;
                    case "/":
                        i++;
                        Datainput = Datainput / Double.parseDouble(Operator.get(i));
                        break;
                    default:
                        Datainput = Double.parseDouble(Operator.get(i));
                }
            }

            System.out.println("** Result: " + Datainput);

       // } catch (InputMismatchException e) {
            //System.out.println("Invalid input");
        }
    }
