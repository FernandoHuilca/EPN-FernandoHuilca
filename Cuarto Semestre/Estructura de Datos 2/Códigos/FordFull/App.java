import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private static App app;

    Pila<NodoGrafo> pila = new Pila<>();

    ArrayList<GrafoDirigido> grafosDirigidos;
    ArrayList<GrafoNoDirigido> grafosNoDirigidos;
    private App() {
        this.grafosDirigidos = new ArrayList<>();
        this.grafosNoDirigidos = new ArrayList<>();
    }

    public static App getInstance(){
        if(app == null){
            app = new App();
        }
        return app;
    }
    public boolean agregarGrafoDirigido(GrafoDirigido nuevoGrafoDirigido) {
        grafosDirigidos.add(nuevoGrafoDirigido);
        return true;
    }

    public NodoGrafo<String>[] getNodosGrafosDirigidos(int numeroGrafoDirigido) {
    return grafosDirigidos.get(numeroGrafoDirigido).getNodos();
    }

    public GrafoDirigido getGrafoDirigido(int numeroGrafoDirigido) {
        return grafosDirigidos.get(numeroGrafoDirigido);
    }

    public boolean agregarGrafoNoDirigido(GrafoNoDirigido NuevoGrafoNoDirigido) {
    grafosNoDirigidos.add(NuevoGrafoNoDirigido);
    return true;
    }

    public NodoGrafo[] getNodosGrafosNoDirigidos(int numeroGrafoNoDirigido) {
        return grafosNoDirigidos.get(numeroGrafoNoDirigido).getNodos();
    }


    public GrafoNoDirigido getGrafoNoDirigido(int numeroGrafoNoDirigido) {
        return grafosNoDirigidos.get(numeroGrafoNoDirigido);
    }
    // Declara la lista 'salida' fuera del método si quieres que acumule el recorrido
    private ArrayList<String> salida1 = new ArrayList<>();
    public void imprimirTrazaRecorridoProfundidadGrafoDirigido(NodoGrafo<String> nodoInicial, GrafoDirigido grafoAlQuePertenece) {
        pila.add(nodoInicial); // Agregar el nodo a la pila
        nodoInicial.setEstadoVisitado(true); // Marcar como visitado

        // Imprimir el estado actual de la pila
        for (int i = 0; i < pila.getNumDeDatos(); i++) {
            System.out.print(" " + pila.getDato(i).getInfo());
        }
        System.out.println(" ");

        // Recorrer los nodos adyacentes (nodos apuntados)
        for (int i = 0; i < nodoInicial.getNumNodosApuntados(); i++) {
            NodoGrafo<String> nodoApuntado = nodoInicial.getNodosApuntados().get(i);

            // Si el nodo no ha sido visitado, se realiza la llamada recursiva
            if (!nodoApuntado.estaVisitado()) {
                imprimirTrazaRecorridoProfundidadGrafoDirigido(nodoApuntado, grafoAlQuePertenece);
            }
        }

        // Al terminar de visitar todos los nodos adyacentes, eliminamos el nodo de la pila
        salida1.add(pila.eliminarDato().getInfo());

        // Imprimir el estado actual de la pila
        for (int i = 0; i < pila.getNumDeDatos(); i++) {
            System.out.print(" " + pila.getDato(i).getInfo());
        }
        System.out.println(" ");

        // Verificar si quedan nodos no visitados en el grafo y continuar con otro nodo
        if (pila.estaVacia() && !yaRecorriTodosLosNodos(grafoAlQuePertenece)) {
            NodoGrafo<String> siguienteNodoNoVisitado = grafoAlQuePertenece.getNoVisitado();
            if (siguienteNodoNoVisitado != null) {
                imprimirTrazaRecorridoProfundidadGrafoDirigido(siguienteNodoNoVisitado, grafoAlQuePertenece);
            }
        }

        // Mostrar la salida solo al final del recorrido completo
        if (yaRecorriTodosLosNodos(grafoAlQuePertenece) && pila.estaVacia()) {
            System.out.println("La salida del recorrido es la siguiente: " + salida1);
        }
    }

    // Declara la lista 'salida' fuera del método si quieres que acumule el recorrido
    private ArrayList<String> salida = new ArrayList<>();

    public void imprimirTrazaRecorridoProfundidadGrafoNoDirigido(NodoGrafo<String> nodoInicial, GrafoNoDirigido grafoAlQuePertenece) {
        if (nodoInicial == null) return;  // Verifica que el nodo no sea nulo

        pila.add(nodoInicial); // Agregar el nodo a la pila
        nodoInicial.setEstadoVisitado(true); // Marcar como visitado

        // Imprimir el estado actual de la pila
        imprimirEstadoPila();

        // Recorrer los nodos adyacentes (nodos apuntados)
        for (int i = 0; i < nodoInicial.getNumNodosApuntados(); i++) {
            NodoGrafo<String> nodoApuntado = nodoInicial.getNodosApuntados().get(i);

            // Si el nodo no ha sido visitado, se realiza la llamada recursiva
            if (!nodoApuntado.estaVisitado()) {
                imprimirTrazaRecorridoProfundidadGrafoNoDirigido(nodoApuntado, grafoAlQuePertenece);
            }
        }

        // Al terminar de visitar todos los nodos adyacentes, eliminamos el nodo de la pila y lo agregamos a 'salida'
        NodoGrafo<String> nodoEliminado = pila.eliminarDato();
        salida.add(nodoEliminado.getInfo());

        // Imprimir el estado actual de la pila
        imprimirEstadoPila();

        // Verificar si quedan nodos no visitados en el grafo
        if (pila.estaVacia() && !yaRecorriTodosLosNodos(grafoAlQuePertenece)) {
            NodoGrafo<String> siguienteNodoNoVisitado = grafoAlQuePertenece.getNoVisitado();
            if (siguienteNodoNoVisitado != null) {
                imprimirTrazaRecorridoProfundidadGrafoNoDirigido(siguienteNodoNoVisitado, grafoAlQuePertenece);
            }
        }

        // Mostrar la salida solo al final del recorrido completo
        if (yaRecorriTodosLosNodos(grafoAlQuePertenece) && pila.estaVacia()) {
            System.out.println("La salida del recorrido es la siguiente: " + salida);
        }
    }

    private void imprimirEstadoPila() {
        for (int i = 0; i < pila.getNumDeDatos(); i++) {
            System.out.print(" " + pila.getDato(i).getInfo());
        }
        System.out.println(" ");
    }





    private boolean yaRecorriTodosLosNodos(GrafoDirigido grafoAlQuePertenece) {
        // Verifica si todos los nodos del grafo han sido visitados
        for (NodoGrafo<String> nodo : grafoAlQuePertenece.getNodos()) {
            if (nodo != null && !nodo.estaVisitado()) {
                return false; // Si encontramos un nodo no visitado, retornamos false
            }
        }
        return true; // Si todos los nodos han sido visitados, retornamos true
    }
    private boolean yaRecorriTodosLosNodos(GrafoNoDirigido grafoAlQuePertenece) {
        // Verifica si todos los nodos del grafo han sido visitados
        for (NodoGrafo<String> nodo : grafoAlQuePertenece.getNodos()) {
            if (nodo != null && !nodo.estaVisitado()) {
                return false; // Si encontramos un nodo no visitado, retornamos false
            }
        }
        return true; // Si todos los nodos han sido visitados, retornamos true
    }



    public void imprimirTrazaRecorridoAnchuraGrafoDirigido(NodoGrafo<String> nodoInicial, GrafoDirigido grafoAlQuePertenece) {
        if (nodoInicial == null) return;  // Verifica que el nodo no sea nulo

        // Cola para gestionar el recorrido en anchura
        Queue<NodoGrafo<String>> cola = new LinkedList<>();
        cola.add(nodoInicial);
        nodoInicial.setEstadoVisitado(true);  // Marcamos el nodo inicial como visitado

        // Lista para acumular la salida del recorrido
        ArrayList<String> salidaAnchura = new ArrayList<>();

        // Mientras la cola no esté vacía
        while (!cola.isEmpty()) {
            NodoGrafo<String> nodoActual = cola.poll();  // Extraemos el nodo al frente de la cola
            salidaAnchura.add(nodoActual.getInfo());  // Agregamos la información del nodo a la salida

            // Imprimimos el estado actual de la cola
            System.out.print("Cola: ");
            for (NodoGrafo<String> nodo : cola) {
                System.out.print(" " + nodo.getInfo());
            }
            System.out.println();

            // Recorremos los nodos adyacentes (nodos apuntados)
            for (int i = 0; i < nodoActual.getNumNodosApuntados(); i++) {
                NodoGrafo<String> nodoApuntado = nodoActual.getNodosApuntados().get(i);

                // Si el nodo no ha sido visitado, lo marcamos como visitado y lo agregamos a la cola
                if (!nodoApuntado.estaVisitado()) {
                    nodoApuntado.setEstadoVisitado(true);
                    cola.add(nodoApuntado);
                }
            }
        }

        // Mostrar la salida solo al final del recorrido completo
        System.out.println("La salida del recorrido en anchura es la siguiente: " + salidaAnchura);
    }

    public void imprimirTrazaRecorridoAnchuraGrafoNoDirigido(NodoGrafo<String> nodo1, GrafoNoDirigido grafoNoDirigido) {

    }
}
