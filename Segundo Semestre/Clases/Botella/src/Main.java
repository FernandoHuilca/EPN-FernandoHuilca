import Botella.Botella;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Botella botella = new Botella(azul, 2, plástico, 20);
        botella.llenar(1); //capacidadActualLitros = 0
        botella.destapar(); //Tapado = false
        botella.llenar(10); //capacidadActualLitros = 2
        botella.vaciar(); //capacidadActual = 0
        botella.llenar(-10) // Mensaje de ERROR!! //capacidadActualLitros = 0
    }
}