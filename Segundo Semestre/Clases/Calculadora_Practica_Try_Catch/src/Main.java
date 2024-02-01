// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Calculadora policalculadora = new Calculadora();

        try {
            System.out.println(policalculadora.dividir(4,0));
        } catch (DividirPorCero e) {
            System.out.println(e.getMessage());
        }


    }
}