import java.util.*;

class CalculatorRefactoredKent {
    static List<String> numberOperators= new ArrayList<String>();
    static String temp = "";
    static Scanner in = new Scanner(System.in);
    static double calculationResult = 0;

    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = in.next();
            numberOperators = parseInputIntoArrayList(nextLine);
            calculateArray();
            System.out.println("** Result: " + calculationResult);          

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    static List<String> parseInputIntoArrayList(String input){ //method untuk parse setiap char dalam input kedalam ArrayList
        for (int i = 0; i < input.length(); i++) {
            addEachCharIntoArrayList(i,input);
            isLastInput(i,input);
        }
        return numberOperators; //hasil parsing dikembalikan menjadi isi numberOperators
    } 

    static void addEachCharIntoArrayList(int i, String input){ //method untuk menambahkan setiap char kedalam ArrayList
        if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/') {
            numberOperators.add(temp);  
            numberOperators.add(String.valueOf(input.charAt(i)));

            temp = "";
        } else {
            temp += String.valueOf(input.charAt(i));
        }
    }

    static void isLastInput(int i, String input){ // method untuk menghentikan penambahan setelah char terakhir dalam input
        if (i == input.length() - 1) {
            numberOperators.add(temp);
            temp = "";
        }
    }
    static void calculateArray(){ // method untuk kalkulasi data input yang sudah dimasukkan ke arraylist
        for (int i = 0; i < numberOperators.size(); i++) {
            switch (numberOperators.get(i)) {
                case "+":
                    i++;
                    calcSum(i);
                    break;
                case "-":
                    i++;
                    calcSub(i);
                    break;
                case "/":
                    i++;
                    calcDivide(i);
                    break;
                default:
                    calcNumber(i);
            }
        }
    }

    static void calcSum(int i){ //method untuk menghitung penambahan
        calculationResult += Double.parseDouble(numberOperators.get(i));
    }

    static void calcSub(int i){ //method untuk menghitung pengurangan
        calculationResult -= Double.parseDouble(numberOperators.get(i));
    }

    static void calcDivide(int i){ //method untuk menghitung pembagian
        calculationResult /= Double.parseDouble(numberOperators.get(i));
    }

    static void calcNumber(int i){ //method untuk angka pertama dalam input
        calculationResult = Double.parseDouble(numberOperators.get(i));

    }

}
