//Author Fernando Huilca

public class Main {
    public static void main(String[] args) {

        Botella botella = new Botella("azul", 2, "plástico", 20);
        Botella botella2 = new Botella("rojo", 3, "oro", 40);

        System.out.println("\n\t\u001B[34m Caso 1.  _____________________________________________\u001B[0m");
        botella.llenarCiertaCantidad(1); //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.destapar(); //Tapado = false
        botella.llenarCiertaCantidad(10); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();
        botella.vaciarPorCompleto(); //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.llenarCiertaCantidad(-10); //ERROR!! //capacidadActualLitros = 0
        botella.imprimirCapacidadActual();
        botella.llenarCiertaCantidad(2); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();
        botella.tapar(); //Tapado = true
        botella.vaciarPorCompleto(); //capacidadActualLitros = 2
        botella.imprimirCapacidadActual();
        /*******************************************/


        botella.vaciarCiertaCantidad(1); // capacidadActualLitros = 2 porque esta tapada
        botella.imprimirCapacidadActual();
        botella.destapar();
        botella.vaciarCiertaCantidad(1); // capacidadActualLitros = 1
        botella.imprimirCapacidadActual();




        /*Botella2*/
        botella2.destapar();
        botella2.imprimirCapacidadActual(); // capacidadActualLitros = 0
        botella.destapar();
        botella2.llenarConOtraBotella(botella);
        botella2.imprimirCapacidadActual(); // capacidadActualLitros = 1
        botella.imprimirCapacidadActual(); // capacidadActualLitros = 0

        botella2.llenarPorCompleto();
        botella2.imprimirCapacidadActual(); // capacidadActualLitros = 3
        botella.llenarConOtraBotella(botella2);
        botella.imprimirCapacidadActual(); // capacidadActualLitros = 2
        botella2.imprimirCapacidadActual(); // capacidadActualLitros = 1


    }
}