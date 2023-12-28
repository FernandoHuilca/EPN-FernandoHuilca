// Author Fernando Huilca

import java.awt.image.CropImageFilter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Chat chat = new Chat();
        Mensaje mensaje1 = chat.enviarMensaje();
        chat.imprimirMensaje(0);

        Mensaje mensaje2 = chat.enviarMensaje();
        chat.imprimirMensaje(1);

        CriptograficaSimetrica critoSimetrica = new CriptograficaSimetrica();
        critoSimetrica.imprimirAlfabetoConSuClave();
        critoSimetrica.enviarMensajeParaSerCriptado("Hola como estas veamos si esto funciona");

    }
}