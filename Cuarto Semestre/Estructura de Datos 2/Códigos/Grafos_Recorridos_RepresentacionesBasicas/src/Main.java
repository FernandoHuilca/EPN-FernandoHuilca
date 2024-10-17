
// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        //Material necesario para hacer las pruebas
        App app = App.getInstance();
        Nodo nodo11 = new Nodo("A");
        Nodo nodo22 = new Nodo("B");
        Nodo nodo33 = new Nodo("C");
        Nodo nodo1 = new Nodo("A");
        Nodo nodo2 = new Nodo("B");
        Nodo nodo3 = new Nodo("C");
        Nodo nodo4 = new Nodo("D");
        Nodo nodo5 = new Nodo("E");
        Nodo nodo6 = new Nodo("F");


        System.out.println("CASO 1 Agregar un grafo dirigido a la App _______________________________");
        //Hacemos un Grafo y definimos de qué tipo es, dado que hemos estudiado algunos
        GrafoDirigido grafoDirigido1 = new GrafoDirigido();
        //Agregamos los nodos
        grafoDirigido1.agregarNodo(nodo11);
        grafoDirigido1.agregarNodo(nodo22);
        grafoDirigido1.agregarNodo(nodo33);
        //Dirigimos los nodos
        grafoDirigido1.dirigirAristaANodo(0, 1);
        grafoDirigido1.dirigirAristaANodo(2, 0);
        //Agregamos el grafo a la App
        if(app.agregarGrafoDirigido(grafoDirigido1)){
            System.out.println("Se ha agregado en grafo con éxito");
        }else {
            System.out.println("ERROR: No se ha agregado el grafo con éxito");
        };

        System.out.println("CASO 2 Imprimir la lista de Adyacencia de un grafo dirigido __________");
        //Imprimimos la Lista de Adyacencia
        imprimirListaDeAdyacenciaGrafoDirigido(0);


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
        grafoNoDirigido0.dirigirAristaANodo(0, 2);
        grafoNoDirigido0.dirigirAristaANodo(2, 3);
        grafoNoDirigido0.dirigirAristaANodo(2, 5);
        grafoNoDirigido0.dirigirAristaANodo(3, 4);
        grafoNoDirigido0.dirigirAristaANodo(5, 1);

        //Agregamos el grafo a la App
        if(app.agregarGrafoNoDirigido(grafoNoDirigido0)){
            System.out.println("Se ha agregado en grafo con éxito");
        }else {
            System.out.println("ERROR: No se ha agregado el grafo con éxito");
        };

        //Imprimimos la Lista de Adyacencia
        System.out.println("CASO 4 Imprimir la lista de Adyacencia de un grafo NO dirigido __________");
        imprimirListaDeAdyacenciaGrafoNoDirigido(0);



        System.out.println("CASO 4 Imprimir matriz de adyacencia de un grafo NO Dirigido _______________");
        imprimirMatrizDeAdyacenciaGrafoNoDirigido(0);


        System.out.println("CASO 5 Imprimir matriz de adyacencia de un grafo Dirigido _______________");
        imprimirMatrizDeAdyacenciaGrafoDirigido(0);

    }

    private static void imprimirMatrizDeAdyacenciaGrafoDirigido(int numeroGrafoDirigido) {
        App app = App.getInstance();
        boolean[][] matrizDeAdyacenciaCopia1 = app.getGrafoDirigido(numeroGrafoDirigido).getMatrizDeAdyacencia();
        System.out.println(" _______________ MATRIZ DE ADYACENCIA GRAFO DIRIGIDO N# " + numeroGrafoDirigido + " ____________________");
        for (int i = 0 ; i < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); i++){
            for (int j = 0; j < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); j++){
                System.out.print("  " + matrizDeAdyacenciaCopia1[i][j]);
            }
            System.out.println(" ");
        }
    }




    private static void imprimirMatrizDeAdyacenciaGrafoNoDirigido(int numeroGrafoNoDirigido) {
        App app = App.getInstance();
        boolean[][] matrizDeAdyacenciaCopia = app.getGrafoNoDirigido(numeroGrafoNoDirigido).getMatrizDeAdyacencia();
        System.out.println(" _______________ MATRIZ DE ADYACENCIA GRAFO NO DIRIGIDO N# " + numeroGrafoNoDirigido + " ____________________");
        for (int i = 0 ; i < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); i++){
            for (int j = 0; j < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); j++){
                System.out.print("  " + matrizDeAdyacenciaCopia[i][j]);
            }
            System.out.println(" ");
        }

    }


    private static void imprimirListaDeAdyacenciaGrafoNoDirigido(int numeroGrafoNoDirigido) {
        App app = App.getInstance();
        System.out.println(" ____________________ LISTA DE ADYACENCIA GRAFO NO DIRIGIDO N# " + numeroGrafoNoDirigido + " ____________________");
        Nodo[] nodos = app.getNodosGrafosNoDirigidos(numeroGrafoNoDirigido);

        for (int i = 0; i < app.getGrafoNoDirigido(numeroGrafoNoDirigido).getCantidadDeNodos(); i++){
            System.out.print(" " + nodos[i].getInfo() + " ➡ ️ ");
            for (Nodo magia: nodos[i].getNodosApuntados()){
                System.out.print(magia.getInfo() + " ➡ ️ " );
            }
            System.out.print("null");
            System.out.println(" ");
        }
    }

    private static void imprimirListaDeAdyacenciaGrafoDirigido(int numeroGrafoDirigido) {
        App app = App.getInstance();
        System.out.println(" ____________________ LISTA DE ADYACENCIA GRAFO DIRIGIDO N# " + numeroGrafoDirigido + " ____________________");
        Nodo[] nodos = app.getNodosGrafosDirigidos(numeroGrafoDirigido);

        for (int i = 0; i < app.getGrafoDirigido(numeroGrafoDirigido).getCantidadDeNodos(); i++){
            System.out.print(" " + nodos[i].getInfo() + " ➡ ️ ");
            for (Nodo magia: nodos[i].getNodosApuntados()){
                System.out.print(magia.getInfo() + " ➡ ️ " );
            }
            System.out.print("null");
            System.out.println(" ");
        }
    }
}