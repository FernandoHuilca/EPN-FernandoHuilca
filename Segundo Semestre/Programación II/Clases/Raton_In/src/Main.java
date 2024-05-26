import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Raton raton1 = new Raton("Logitech", 800, true, true, true, "Blanco");

        System.out.print(raton1.getMarca());
        /************************************************/

        // Entrada de datos:
        Scanner cout = new Scanner(System.in);
        String nombre;
        System.out.print("Escriba su nombre: ");
        nombre = cout.next();

        System.out.println("Su nombre es: " + nombre + " Bienvenido");

    }
}
