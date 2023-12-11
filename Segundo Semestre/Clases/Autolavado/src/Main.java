import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] numerosDecimales;
        numerosDecimales = new int[10];
        for (int i = 0; i < numerosDecimales.length; i++){
            numerosDecimales[i] = i;
        }
        for (int Magia : numerosDecimales ){
            System.out.println(Magia);
        }
        System.out.println("**************************");
        System.out.println(numerosDecimales.length);

    }
}