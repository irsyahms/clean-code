import java.util.*;

class Calculator {
    static Calculator calculator = new Calculator();

    public static void main(String args[]) {
        //untuk inputan
        Scanner in = new Scanner(System.in);
        calculator.printMessage("Input number and operators that you want to calculate: ");

        try {
            //inputan
            String nextLine = in.next();
            //split string
            List<String> listSplitNumberOperator = calculator.splitOperatorAngka(nextLine);

            //perhitungan
            calculator.hasilPerhitungan(listSplitNumberOperator);

            //atau
            //calculator.hasilPerhitungan(calculator.splitOperatorAngka(nextLine));


        } catch (InputMismatchException e) {
            calculator.printMessage("Input Salah");
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public List<String> splitOperatorAngka(String inputanScanner){
        List<String> listSplitOperatorAngka = new ArrayList<String>();
        String tempList = "";

        for (int index = 0; index < inputanScanner.length(); index++) {
            if(inputanScanner.charAt(index) == '+' || inputanScanner.charAt(index) == '-' || inputanScanner.charAt(index) == '/' || inputanScanner.charAt(index) == '*') {
                listSplitOperatorAngka.add(tempList);
                listSplitOperatorAngka.add(String.valueOf(inputanScanner.charAt(index)));
                tempList = "";
            } else {
                tempList = tempList + String.valueOf(inputanScanner.charAt(index));
            }
            if (index == inputanScanner.length() - 1) {
                listSplitOperatorAngka.add(tempList);
                tempList = "";
            }
        }

        printAngkaYangDiJumlahkan(listSplitOperatorAngka);

        return listSplitOperatorAngka;
    }

    public void printAngkaYangDiJumlahkan(List<String> listAngkaOperator){
        String tempPrintAngkaYangDiJumlahkan = "";
        for(int index = 0;index<listAngkaOperator.size();index++){
            tempPrintAngkaYangDiJumlahkan = tempPrintAngkaYangDiJumlahkan +" "+ listAngkaOperator.get(index);
        }
        printMessage("Angka Yang Di Jumlahkan \n"+tempPrintAngkaYangDiJumlahkan);

    }

    public void hasilPerhitungan(List<String> listAngkaOperator){
        int index = 0;
        double hasilPerhitungan = 0;
        for(index=0;index<listAngkaOperator.size();index++){
            switch (listAngkaOperator.get(index)){
                case "+":
                    index++;
                    hasilPerhitungan = calculator.tambahAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(index)));
                    break;
                case "-":
                    index++;
                    hasilPerhitungan = calculator.kurangAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(index)));
                    break;
                case "/":
                    index++;
                    hasilPerhitungan = calculator.bagiAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(index)));
                    break;
                case "*":
                    index++;
                    hasilPerhitungan = calculator.kaliAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(index)));
                    break;
                default:
                    hasilPerhitungan = Double.parseDouble(listAngkaOperator.get(index));
            }
        }
        printMessage("**Result : "+hasilPerhitungan);
    }


    public double tambahAngka(double angkapertama, double angkakedua){
        double hasilPertambahan = (angkapertama+angkakedua);
        return hasilPertambahan;
    }

    public double kurangAngka(double angkapertama, double angkakedua){
        double hasilPengurangan = (angkapertama-angkakedua);
        return hasilPengurangan;
    }

    public double bagiAngka(double angkapertama, double angkakedua){
        double hasilPembagian = (angkapertama/angkakedua);
        return hasilPembagian;
    }


    public double kaliAngka(double angkapertama, double angkakedua){
        double hasilPerkalian = (angkapertama*angkakedua);
        return hasilPerkalian;
    }
}
