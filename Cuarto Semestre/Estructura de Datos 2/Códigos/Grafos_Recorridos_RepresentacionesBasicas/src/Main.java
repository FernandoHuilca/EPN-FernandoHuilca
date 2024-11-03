
// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        //Material necesario para hacer las pruebas
        App app = App.getInstance();
        //NodoGrafo<String> nodo11 = new NodoGrafo<String>("A");
        NodoGrafo<String> nodo22 = new NodoGrafo<String>("B");
        NodoGrafo<String> nodo33 = new NodoGrafo<String>("C");
        NodoGrafo<String> nodo44 = new NodoGrafo<String>("D");
        NodoGrafo<String> nodo55 = new NodoGrafo<String>("E");
        NodoGrafo<String> nodo66 = new NodoGrafo<String>("F");


        NodoGrafo<String> nodo1 = new NodoGrafo<String>("1");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("2");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("3");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("4");
        NodoGrafo<String> nodo5 = new NodoGrafo<String>("5");
        NodoGrafo<String> nodo6 = new NodoGrafo<String>("6");


        System.out.println("CASO 1 Agregar un grafo dirigido a la App _______________________________");
        //Hacemos un Grafo y definimos de qué tipo es, dado que hemos estudiado algunos
        GrafoDirigido grafoDirigido1 = new GrafoDirigido();
        //Agregamos los nodos
        //grafoDirigido1.agregarNodo(nodo11);
        grafoDirigido1.agregarNodo(nodo22);
        grafoDirigido1.agregarNodo(nodo33);
        grafoDirigido1.agregarNodo(nodo44);
        grafoDirigido1.agregarNodo(nodo55);
        grafoDirigido1.agregarNodo(nodo66);

        //Dirigimos los nodos
        grafoDirigido1.dirigirAristaANodo(1, 0);
        grafoDirigido1.dirigirAristaANodo(1, 2);
        grafoDirigido1.dirigirAristaANodo(1, 4);
        grafoDirigido1.dirigirAristaANodo(3, 2);
        grafoDirigido1.dirigirAristaANodo(3, 4);
        grafoDirigido1.dirigirAristaANodo(3, 0);
        grafoDirigido1.dirigirAristaANodo(0, 4);
        grafoDirigido1.dirigirAristaANodo(4, 0);


        //Agregamos el grafo a la App
        if (app.agregarGrafoDirigido(grafoDirigido1)) {
            System.out.println("Se ha agregado en grafo con éxito");
        } else {
            System.out.println("ERROR: No se ha agregado el grafo con éxito");
        }
        ;


        // Capturar el tiempo de inicio
        long tiempoInicio = System.nanoTime();
        System.out.println("CASO 2 Imprimir la lista de Adyacencia de un grafo dirigido __________");
        //Imprimimos la Lista de Adyacencia
        imprimirListaDeAdyacenciaGrafoDirigido(0);
        // Capturar el tiempo de finalización
        long tiempoFin = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal = tiempoFin - tiempoInicio;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 3 Agregar un grafo NO dirigido a la App _______________________________");
        //Hacemos un Grafo y definimos de qué tipo es, dado que hemos estudiado algunos
        GrafoNoDirigido grafoNoDirigido0 = new GrafoNoDirigido();
        //Agregamos los nodos
        grafoNoDirigido0.agregarNodo(nodo1);
        grafoNoDirigido0.agregarNodo(nodo2);
        grafoNoDirigido0.agregarNodo(nodo3);
        grafoNoDirigido0.agregarNodo(nodo4);
        grafoNoDirigido0.agregarNodo(nodo5);
        grafoNoDirigido0.agregarNodo(nodo6);
        //Dirigimos los nodos
        grafoNoDirigido0.dirigirAristaANodo(0, 1);
        grafoNoDirigido0.dirigirAristaANodo(0, 2);
        grafoNoDirigido0.dirigirAristaANodo(0, 3);
        grafoNoDirigido0.dirigirAristaANodo(1, 0);
        grafoNoDirigido0.dirigirAristaANodo(1, 2);
        grafoNoDirigido0.dirigirAristaANodo(1, 4);
        grafoNoDirigido0.dirigirAristaANodo(3, 2);
        grafoNoDirigido0.dirigirAristaANodo(3, 0);
        grafoNoDirigido0.dirigirAristaANodo(3, 5);
        grafoNoDirigido0.dirigirAristaANodo(5, 3);
        grafoNoDirigido0.dirigirAristaANodo(5, 2);
        grafoNoDirigido0.dirigirAristaANodo(5, 4);


        //Agregamos el grafo a la App
        if (app.agregarGrafoNoDirigido(grafoNoDirigido0)) {
            System.out.println("Se ha agregado en grafo con éxito");
        } else {
            System.out.println("ERROR: No se ha agregado el grafo con éxito");
        }
        ;

        //Imprimimos la Lista de Adyacencia
        System.out.println("CASO 4 Imprimir la lista de Adyacencia de un grafo NO dirigido __________");
        // Capturar el tiempo de inicio
        long tiempoInicio1 = System.nanoTime();
        imprimirListaDeAdyacenciaGrafoNoDirigido(0);
        // Capturar el tiempo de finalización
        long tiempoFin1 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal1 = tiempoFin1 - tiempoInicio1;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal1 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal1 / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 4 Imprimir matriz de adyacencia de un grafo NO Dirigido _______________");
        // Capturar el tiempo de inicio
        long tiempoInicio2 = System.nanoTime();
        imprimirMatrizDeAdyacenciaGrafoNoDirigido(0);
        // Capturar el tiempo de finalización
        long tiempoFin2 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal2 = tiempoFin2 - tiempoInicio2;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal2 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal2 / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 5 Imprimir matriz de adyacencia de un grafo Dirigido _______________");
        // Capturar el tiempo de inicio
        long tiempoInicio3 = System.nanoTime();
        imprimirMatrizDeAdyacenciaGrafoDirigido(0);
        // Capturar el tiempo de finalización
        long tiempoFin3 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal3 = tiempoFin3 - tiempoInicio3;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal3 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal3 / 1_000_000)); // Convertir a milisegundos



        System.out.println("CASO 6 Imprimir recorrido en profundidad grafo Dirigido _________________");
        // Capturar el tiempo de inicio
        long tiempoInicio4 = System.nanoTime();
        app.imprimirTrazaRecorridoProfundidadGrafoDirigido(nodo22, app.getGrafoDirigido(0));
        // Capturar el tiempo de finalización
        long tiempoFin4 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal4 = tiempoFin4 - tiempoInicio4;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal4 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal4 / 1_000_000)); // Convertir a milisegundos



        System.out.println("CASO 7 Imprimir recorrido en profundidad grafo No Dirigido _________________");
        // Capturar el tiempo de inicio
        long tiempoInicio5 = System.nanoTime();
        app.imprimirTrazaRecorridoProfundidadGrafoNoDirigido(nodo1, app.getGrafoNoDirigido(0));
        // Capturar el tiempo de finalización
        long tiempoFin5 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal5 = tiempoFin5 - tiempoInicio5;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal5 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal5 / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 8 Imprimir recorrido en anchura grafo Dirigido _________________");
        // Capturar el tiempo de inicio
        long tiempoInicio6 = System.nanoTime();
        app.imprimirTrazaRecorridoAnchuraGrafoDirigido(nodo22, app.getGrafoDirigido(0));
// Capturar el tiempo de finalización
        long tiempoFin6 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal6 = tiempoFin6 - tiempoInicio6;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal6 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal6 / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 9 Imprimir recorrido en anchura grafo No Dirigido _________________");
        // Capturar el tiempo de inicio
        long tiempoInicio7 = System.nanoTime();
        app.imprimirTrazaRecorridoAnchuraGrafoNoDirigido(nodo1, app.getGrafoNoDirigido(0));
        // Capturar el tiempo de finalización
        long tiempoFin7 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal7 = tiempoFin7 - tiempoInicio7;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal7 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal7 / 1_000_000)); // Convertir a milisegundos

    }

    private static void imprimirMatrizDeAdyacenciaGrafoDirigido(int numeroGrafoDirigido) {
        App app = App.getInstance();
        boolean[][] matrizDeAdyacenciaCopia1 = app.getGrafoDirigido(numeroGrafoDirigido).getMatrizDeAdyacencia();
        System.out.println(" _______________ MATRIZ DE ADYACENCIA GRAFO DIRIGIDO N# " + numeroGrafoDirigido + " ____________________");
        for (int i = 0; i < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); i++) {
            for (int j = 0; j < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); j++) {
                System.out.print("  " + matrizDeAdyacenciaCopia1[i][j]);
            }
            System.out.println(" ");
        }
    }


    private static void imprimirMatrizDeAdyacenciaGrafoNoDirigido(int numeroGrafoNoDirigido) {
        App app = App.getInstance();
        boolean[][] matrizDeAdyacenciaCopia = app.getGrafoNoDirigido(numeroGrafoNoDirigido).getMatrizDeAdyacencia();
        System.out.println(" _______________ MATRIZ DE ADYACENCIA GRAFO NO DIRIGIDO N# " + numeroGrafoNoDirigido + " ____________________");
        for (int i = 0; i < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); i++) {
            for (int j = 0; j < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); j++) {
                System.out.print("  " + matrizDeAdyacenciaCopia[i][j]);
            }
            System.out.println(" ");
        }

    }


    private static void imprimirListaDeAdyacenciaGrafoNoDirigido(int numeroGrafoNoDirigido) {
        App app = App.getInstance();
        System.out.println(" ____________________ LISTA DE ADYACENCIA GRAFO NO DIRIGIDO N# " + numeroGrafoNoDirigido + " ____________________");
        NodoGrafo<String>[] nodos = app.getNodosGrafosNoDirigidos(numeroGrafoNoDirigido);

        for (int i = 0; i < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); i++) {
            System.out.print(" " + nodos[i].getInfo() + " ➡ ️ ");
            for (NodoGrafo<String> magia : nodos[i].getNodosApuntados()) {
                System.out.print(magia.getInfo() + " ➡ ️ ");
            }
            System.out.print("null");
            System.out.println(" ");
        }
    }

    private static void imprimirListaDeAdyacenciaGrafoDirigido(int numeroGrafoDirigido) {
        App app = App.getInstance();
        System.out.println(" ____________________ LISTA DE ADYACENCIA GRAFO DIRIGIDO N# " + numeroGrafoDirigido + " ____________________");
        NodoGrafo<String>[] nodos = app.getNodosGrafosDirigidos(numeroGrafoDirigido);

        for (int i = 0; i < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); i++) {
            System.out.print(" " + nodos[i].getInfo() + " ➡ ️ ");
            for (NodoGrafo<String> magia : nodos[i].getNodosApuntados()) {
                System.out.print(magia.getInfo() + " ➡ ️ ");
            }
            System.out.print("null");
            System.out.println(" ");
        }
    }






    //------------------------------

}