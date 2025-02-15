
// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        //Material necesario para hacer las pruebas
        App app = App.getInstance();


        //Crear los nodos:
        NodoGrafo<String> nodo0 = new NodoGrafo<String>("1");
        NodoGrafo<String> nodo1 = new NodoGrafo<String>("2");
        NodoGrafo<String> nodo2 = new NodoGrafo<String>("3");
        NodoGrafo<String> nodo3 = new NodoGrafo<String>("4");
        NodoGrafo<String> nodo4 = new NodoGrafo<String>("5");
        NodoGrafo<String> nodo5 = new NodoGrafo<String>("6");
        NodoGrafo<String> nodo6 = new NodoGrafo<String>("7");
        NodoGrafo<String> nodo7 = new NodoGrafo<String>("8");
        NodoGrafo<String> nodo8 = new NodoGrafo<String>("9");
        NodoGrafo<String> nodo9 = new NodoGrafo<String>("10");
        NodoGrafo<String> nodo10 = new NodoGrafo<String>("11");
        NodoGrafo<String> nodo11= new NodoGrafo<String>("12");
        NodoGrafo<String> nodo12 = new NodoGrafo<String>("13");
        NodoGrafo<String> nodo13 = new NodoGrafo<String>("14");
        NodoGrafo<String> nodo14 = new NodoGrafo<String>("15");
        NodoGrafo<String> nodo15 = new NodoGrafo<String>("16");
        NodoGrafo<String> nodo16 = new NodoGrafo<String>("17");
        NodoGrafo<String> nodo17 = new NodoGrafo<String>("18");
        NodoGrafo<String> nodo18 = new NodoGrafo<String>("19");
        NodoGrafo<String> nodo19 = new NodoGrafo<String>("20");
        NodoGrafo<String> nodo20 = new NodoGrafo<String>("21");
        NodoGrafo<String> nodo21 = new NodoGrafo<String>("22");
        NodoGrafo<String> nodo22 = new NodoGrafo<String>("23");
        NodoGrafo<String> nodo23 = new NodoGrafo<String>("24");
        NodoGrafo<String> nodo24 = new NodoGrafo<String>("25");
        NodoGrafo<String> nodo25 = new NodoGrafo<String>("26");


        System.out.println("CASO 1 Agregar un grafo dirigido a la App _______________________________");
        //Hacemos un Grafo y definimos de qué tipo es, dado que hemos estudiado algunos
        GrafoNoDirigido grafoNoDirigido00 = new GrafoNoDirigido();

        grafoNoDirigido00.agregarNodo(nodo0);
        grafoNoDirigido00.agregarNodo(nodo1);
        grafoNoDirigido00.agregarNodo(nodo2);
        grafoNoDirigido00.agregarNodo(nodo3);
        grafoNoDirigido00.agregarNodo(nodo4);
        grafoNoDirigido00.agregarNodo(nodo5);
        grafoNoDirigido00.agregarNodo(nodo6);
        grafoNoDirigido00.agregarNodo(nodo7);
        grafoNoDirigido00.agregarNodo(nodo8);
        grafoNoDirigido00.agregarNodo(nodo9);
        grafoNoDirigido00.agregarNodo(nodo10);
        grafoNoDirigido00.agregarNodo(nodo11);
        grafoNoDirigido00.agregarNodo(nodo12);
        grafoNoDirigido00.agregarNodo(nodo13);
        grafoNoDirigido00.agregarNodo(nodo14);
        grafoNoDirigido00.agregarNodo(nodo15);
        grafoNoDirigido00.agregarNodo(nodo16);
        grafoNoDirigido00.agregarNodo(nodo17);
        grafoNoDirigido00.agregarNodo(nodo18);
        grafoNoDirigido00.agregarNodo(nodo19);
        grafoNoDirigido00.agregarNodo(nodo20);
        grafoNoDirigido00.agregarNodo(nodo21);
        grafoNoDirigido00.agregarNodo(nodo22);
        grafoNoDirigido00.agregarNodo(nodo23);
        grafoNoDirigido00.agregarNodo(nodo24);
        grafoNoDirigido00.agregarNodo(nodo25);


        grafoNoDirigido00.dirigirAristaANodo(0, 1);
        grafoNoDirigido00.dirigirAristaANodo(1, 2);
        grafoNoDirigido00.dirigirAristaANodo(2, 3);
        grafoNoDirigido00.dirigirAristaANodo(3, 4);
        grafoNoDirigido00.dirigirAristaANodo(4, 5);
        grafoNoDirigido00.dirigirAristaANodo(5, 6);
        grafoNoDirigido00.dirigirAristaANodo(6, 7);
        grafoNoDirigido00.dirigirAristaANodo(7, 8);
        grafoNoDirigido00.dirigirAristaANodo(8, 9);
        grafoNoDirigido00.dirigirAristaANodo(9, 10);
        grafoNoDirigido00.dirigirAristaANodo(10, 11);
        grafoNoDirigido00.dirigirAristaANodo(11, 12);
        grafoNoDirigido00.dirigirAristaANodo(9, 13);
        grafoNoDirigido00.dirigirAristaANodo(13, 14);
        grafoNoDirigido00.dirigirAristaANodo(14, 15);
        grafoNoDirigido00.dirigirAristaANodo(15, 16);
        grafoNoDirigido00.dirigirAristaANodo(16, 17);
        grafoNoDirigido00.dirigirAristaANodo(15, 18);
        grafoNoDirigido00.dirigirAristaANodo(18, 19);
        grafoNoDirigido00.dirigirAristaANodo(18, 20);
        grafoNoDirigido00.dirigirAristaANodo(0, 21);
        grafoNoDirigido00.dirigirAristaANodo(21, 22);
        grafoNoDirigido00.dirigirAristaANodo(22, 23);
        grafoNoDirigido00.dirigirAristaANodo(23, 24);
        grafoNoDirigido00.dirigirAristaANodo(24, 25);




        //Agregamos el grafo a la App
        if (app.agregarGrafoNoDirigido(grafoNoDirigido00)) {
            System.out.println("Se ha agregado en grafo con éxito");
        } else {
            System.out.println("ERROR: No se ha agregado el grafo con éxito");
        }
        // Capturar el tiempo de inicio
        long tiempoInicio = System.nanoTime();
        System.out.println("CASO 2 Imprimir la lista de Adyacencia de un grafo NO dirigido __________");
        //Imprimimos la Lista de Adyacencia
        imprimirListaDeAdyacenciaGrafoNoDirigido(0);
        // Capturar el tiempo de finalización
        long tiempoFin = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal = tiempoFin - tiempoInicio;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal / 1_000_000)); // Convertir a milisegundos


        System.out.println("CASO 3 Imprimir recorrido en profundidad grafo NO Dirigido _________________");
        // Capturar el tiempo de inicio
        long tiempoInicio4 = System.nanoTime();
        app.imprimirTrazaRecorridoProfundidadGrafoNoDirigido(nodo0,grafoNoDirigido00);
        // Capturar el tiempo de finalización
        long tiempoFin4 = System.nanoTime();

        // Calcular el tiempo total de ejecución
        long tiempoTotal4 = tiempoFin4 - tiempoInicio4;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + tiempoTotal4 + " nanosegundos.");
        System.out.println("Duración en milisegundos aproximados: " + (tiempoTotal4 / 1_000_000)); // Convertir a milisegundos

        System.out.println("CASO 4 Imprimir Matriz de adyacencia NO Dirigido _________________");
        imprimirMatrizDeAdyacenciaGrafoNoDirigido(0);


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



}