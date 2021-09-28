import java.util.*;

class Calculator {
    static Calculator calculator = new Calculator();

    public static void main(String args[]) {
        Calculator cal = new Calculator();
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
        String temp = "";

        for (int i = 0; i < inputanScanner.length(); i++) {
            if(inputanScanner.charAt(i) == '+' || inputanScanner.charAt(i) == '-' || inputanScanner.charAt(i) == '/' || inputanScanner.charAt(i) == '*') {
                listSplitOperatorAngka.add(temp);
                listSplitOperatorAngka.add(String.valueOf(inputanScanner.charAt(i)));
                temp = "";
            } else {
                temp = temp + String.valueOf(inputanScanner.charAt(i));
            }
            if (i == inputanScanner.length() - 1) {
                listSplitOperatorAngka.add(temp);
                temp = "";
            }
        }
        System.out.println(listSplitOperatorAngka);
        return listSplitOperatorAngka;
    }

    public void hasilPerhitungan(List<String> listAngkaOperator){
        int i = 0;
        double hasilPerhitungan = 0;
        for(i=0;i<listAngkaOperator.size();i++){
            switch (listAngkaOperator.get(i)){
                case "+":
                    i++;
                    hasilPerhitungan = calculator.tambahAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(i)));
                    break;
                case "-":
                    i++;
                    hasilPerhitungan = calculator.kurangAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(i)));
                    break;
                case "/":
                    i++;
                    hasilPerhitungan = calculator.bagiAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(i)));
                    break;
                case "*":
                    i++;
                    hasilPerhitungan = calculator.kaliAngka(hasilPerhitungan,Double.parseDouble(listAngkaOperator.get(i)));
                    break;
                default:
                    hasilPerhitungan = Double.parseDouble(listAngkaOperator.get(i));
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
