import java.util.*;

class CalculatorCleanCode {
    static int bilangan1, bilangan2, hasil;
    private static char operator;
    Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        masukkanBilangan();
        operasiBilangan();
    }

    //perintah memasukkan bilangan
    public static void masukkanBilangan() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bilangan pertama: ");
        bilangan1 = input.nextInt();

        System.out.print("Bilangan kedua: ");
        bilangan2 = input.nextInt();

        System.out.print("Operator: ");
        operator = input.next().charAt(0);
    }

    public static void operasiBilangan() {
        if (operator == '+') {
            hasil = bilangan1 + bilangan2;
        } else if (operator == '-') {
            hasil = bilangan1 - bilangan2;
        } else if (operator == '/') {
            hasil = bilangan1 / bilangan2;
        } else if (operator == '*') {
            hasil = bilangan1 * bilangan2;
        }

        System.out.println("** Result: " + hasil);

    }
}


