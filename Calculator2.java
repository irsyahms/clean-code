package Assignment1;

import java.util.*;

public class Calculator2 {

    static Scanner scanner = new Scanner(System.in);
    static double hasil;
    static List<String> listInputanKalkulator= new ArrayList<String>();
    static String operasiInputan;

    public static void main(String args[]) {
        menuUtama();
    }

    private static void menuUtama() {
        print("Input number and operators that you want to calculate: ");
        try{
            operasiInputan = scanner.next();
            //buat masukin inputan ke
            parsingArray();
            print("** Result: " + perhitungan());
//            System.out.println("** Result: " + perhitungan()); //perhitungan
        } catch (Exception e){
            System.err.println(e);
        }

    }

    private static void print(String masukan) {
        System.out.println( masukan);

    }

    private static double perhitungan() {
        for (int indekPerulanganPerhitungan = 0; indekPerulanganPerhitungan < listInputanKalkulator.size(); indekPerulanganPerhitungan++) {
            switch (listInputanKalkulator.get(indekPerulanganPerhitungan)) {
                case "+":
                    indekPerulanganPerhitungan++;
                    penjumlahan(indekPerulanganPerhitungan);
                    break;
                case "-":
                    indekPerulanganPerhitungan++;
                    pengurangan(indekPerulanganPerhitungan);
                    break;
                case "/":
                    indekPerulanganPerhitungan++;
                    pembagian(indekPerulanganPerhitungan);
                    break;
                case "*":
                    indekPerulanganPerhitungan++;
                    perkalian(indekPerulanganPerhitungan);
                    break;
                default:
                    hasil = Double.parseDouble(listInputanKalkulator.get(indekPerulanganPerhitungan));
            }
        }return hasil;
    }

    private static void parsingArray() {
        String inputanArray = "";
        for (int indekPerulanganParsing = 0; indekPerulanganParsing < operasiInputan.length(); indekPerulanganParsing++) {
            if(operasiInputan.charAt(indekPerulanganParsing) == '+' || operasiInputan.charAt(indekPerulanganParsing) == '-' || operasiInputan.charAt(indekPerulanganParsing) == '/' ||operasiInputan.charAt(indekPerulanganParsing)== '*') {
                listInputanKalkulator.add(inputanArray);
                listInputanKalkulator.add(String.valueOf(operasiInputan.charAt(indekPerulanganParsing)));

                inputanArray = "";
            } else {
                inputanArray = inputanArray + String.valueOf(operasiInputan.charAt(indekPerulanganParsing));
            }

            if (indekPerulanganParsing == operasiInputan.length() - 1) {
                listInputanKalkulator.add(inputanArray);
                inputanArray = "";
            }
        }
    }

    private static void perkalian(int index) {
        hasil = hasil * Double.parseDouble(listInputanKalkulator.get(index));

    }

    private static void pembagian(int index) {
        hasil = hasil / Double.parseDouble(listInputanKalkulator.get(index));

    }

    private static void pengurangan(int index) {
        hasil = hasil - Double.parseDouble(listInputanKalkulator.get(index));

    }

    private static void penjumlahan(int index) {
        hasil = hasil + Double.parseDouble(listInputanKalkulator.get(index));
    }


}



