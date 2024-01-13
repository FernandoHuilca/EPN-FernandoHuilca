// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //String azul = "azul";


        Recipiente recipiente = new Recipiente("verde", 30,"vidrio",40);
        Recipiente otroRecipiente = new Botella("azul", 2, "plástico", 20);

        //Botella otroRecipienteMas = new Recipiente("verde", 30,"vidrio",40);


        Botella botella = new Botella("azul", 2, "plástico", 20);
        Botella botella2 = new Botella("rojo", 3, "oro", 40);
        botella.llenar(1); //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.destapar(); //Tapado = false
        botella.llenar(10); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();
        botella.vaciar(); //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.llenar(-10); //ERROR!! //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.llenar(2); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();
        botella.tapar(); //Tapado = true
        botella.vaciar(); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();

        botella2.destapar();
        botella2.llenar();
        botella2.imprimirCapacidadActual(); //3
        botella.destapar();
        botella.vaciar(-1);
        botella.llenar(botella2);
        botella.imprimirCapacidadActual(); //0
        botella2.imprimirCapacidadActual(); //2

    }
}
