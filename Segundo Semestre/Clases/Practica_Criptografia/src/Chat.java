import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Chat {
    private Mensaje[] mensajes;
    private int contadorDeMensajes;

    public Chat(){
        mensajes = new Mensaje[1000];
        contadorDeMensajes = 0;
    }

    public Mensaje enviarMensaje() {
        // Crear un objeto Scanner para leer desde la consola
        Scanner scanner = new Scanner(System.in);
        //--------------------------------------

        System.out.println("Escriba el mensaje a ser cifrado: ");
        String mensaje = scanner.nextLine(); // Lee toda la línea

        Mensaje nuevoMensaje = new Mensaje(mensaje, LocalDateTime.now());

        mensajes[contadorDeMensajes++] = nuevoMensaje;

        return nuevoMensaje;
    }

    public void imprimirMensaje(int numMensaje) {
        System.out.println(mensajes[numMensaje]);
    }
}
