package com.Calculator;
import java.util.*;

class CleanCalculator {
    static List<String> listnumberOperators= new ArrayList<String>(); // Membuat array list
    static String tempCharacter = ""; //menghasilkan inputan angka
    static double hasil = 0;

    static Scanner inputCalculation = new Scanner(System.in);


    public static void main(String args[]) {
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = inputCalculation.next();
            listnumberOperators = parseInputArrayList(nextLine);
            perhitungan(); //Memanggil method perhitungan
            System.out.println("** Result: " + hasil);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    static List<String> parseInputArrayList(String input){ //method untuk parse setiap char dalam input kedalam ArrayList
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            addEachCharIntoArrayList(inputIndex,input);
            isLastInput(inputIndex,input);
        }
        return listnumberOperators; //hasil parsing dikembalikan menjadi isi listnumberOperators
    }

    static void addEachCharIntoArrayList(int inputIndex, String input){ //method penambahan char di array list
        if(input.charAt(inputIndex) == '+' || input.charAt(inputIndex) == '-' || input.charAt(inputIndex) == '/' ||input.charAt(inputIndex)=='*') {
            listnumberOperators.add(tempCharacter);
            listnumberOperators.add(String.valueOf(input.charAt(inputIndex)));
            tempCharacter = "";
        } else {
            tempCharacter += String.valueOf(input.charAt(inputIndex));
        }
    }

    static void isLastInput(int inputIndex, String input){ // method menghentinkan penambahan char setelah diinput
        if (inputIndex == input.length() - 1) {
            listnumberOperators.add(tempCharacter);
            tempCharacter = "";
        }
    }
    static void perhitungan(){ // method untuk melakukan perhitungan tidak perlu balikan/return
        for (int index = 0; index < listnumberOperators.size(); index++) {
            switch (listnumberOperators.get(index)) {
                case "+":
                    index++;
                    hasil = pertambahan(hasil, Double.parseDouble(listnumberOperators.get(index)));
                    break;
                case "-":
                    index++;
                    hasil = pengurangan(hasil, Double.parseDouble(listnumberOperators.get(index)));
                    break;
                case "/":
                    index++;
                    hasil = pembagian(hasil, Double.parseDouble(listnumberOperators.get(index)));
                    break;
                case "*":
                    index++;
                    hasil = perkalian(hasil, Double.parseDouble(listnumberOperators.get(index)));
                    break;
                default:
                    hasil = inputAwal(Double.parseDouble(listnumberOperators.get(index)));

            }
        }
    }

    static double pertambahan(double angkaPertama, double angkaKedua){ //Method untuk melakukan Pertambahan
        return angkaPertama + angkaKedua;
    }

    static double pengurangan(double angkaPertama, double angkaKedua){ //Method untuk melakukan Pegurangan
        return angkaPertama - angkaKedua;
    }

    static double pembagian(double angkaPertama, double angkaKedua){ //Method untuk Melakukan Pembagian
        return angkaPertama / angkaKedua;
    }

    static double perkalian(double angkaPertama,double angkaKedua){ //Method untuk Melakukan Perkalian
        return angkaPertama * angkaKedua;
    }

    static double inputAwal(double angkaPertama){ //Method untuk inputan pertama
        return angkaPertama;

    }

}


