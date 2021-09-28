
import java.util.*;

class Calculator{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = in.next();
            List<String> operationNumber = new ArrayList<String>();

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temp = "";
            for (int index = 0; index < nextLine.length(); index++) {
                if (nextLine.charAt(index) == '+' || nextLine.charAt(index) == '-' || nextLine.charAt(index) == '/') {
                    operationNumber.add(temp);
                    operationNumber.add(String.valueOf(nextLine.charAt(index)));

                    temp = "";
                } else {
                    temp = temp + String.valueOf(nextLine.charAt(index));
                }

                if (index == nextLine.length() - 1) {
                    operationNumber.add(temp);
                    temp = "";
                }
            }

            //perhitungan

            double t = 0;
            for (int index = 0; index < operationNumber.size(); index++) {
                switch (operationNumber.get(index)) {
                    case "+":
                        index++;
                        t = t + Double.parseDouble(operationNumber.get(index));
                        break;
                    case "-":
                        index++;
                        t = t - Double.parseDouble(operationNumber.get(index));
                        break;
                    case "/":
                        index++;
                        t = t / Double.parseDouble(operationNumber.get(index));
                        break;
                    default:
                        t = Double.parseDouble(operationNumber.get(index));
                }
            }

            System.out.println("** Result: " + t);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}
