public class GrafoNoDirigido {
    public static final int TAMAÑO_NODOS_ACEPTADOS = 100;
    private NodoGrafo<String>[] nodosDelGrafo;
    private int contadorDeNodos;
    private boolean[][] matrizDeAdyacencia;

    // Nota importante: Si bien lo deseable sería que tengamos una cantidad de nodos no definidos, es decir,
    // que podamos agregar nodos sin límites a nuestro grafo, esto no es posible porque luego cuando queramos
    // hacer la matriz de adyacencia tenemos que definir el tamaño de la matriz bidimensional, como solución
    // a este problema he limitado el número de nodos aceptados en la matriz a 100, lo cual para este programa
    // que busca ser mas educativo es suficiente.

    public GrafoNoDirigido() {
        this.nodosDelGrafo = new NodoGrafo[TAMAÑO_NODOS_ACEPTADOS];
        this.contadorDeNodos = 0;
        this.matrizDeAdyacencia = new boolean[100][100];
    }

    public boolean agregarNodo(NodoGrafo nuevoNodo) {
        if (contadorDeNodos == TAMAÑO_NODOS_ACEPTADOS){
            return false;
        }
        nodosDelGrafo[contadorDeNodos++] = nuevoNodo;
        return true;
    }

    public boolean dirigirAristaANodo(int nodoOrigen, int nodoDestino) {
        nodosDelGrafo[nodoOrigen].apuntarANodo(nodosDelGrafo[nodoDestino]);
        nodosDelGrafo[nodoDestino].apuntarANodo(nodosDelGrafo[nodoOrigen]);
        return true;
    }

    public NodoGrafo[] getNodos() {
        return nodosDelGrafo;
    }

    public int getCantidadDeNodos() {
        return contadorDeNodos;
    }

    private void actualizarMatrizDeAdyacencia() {
        // Solo actualizamos hasta donde hay nodos insertados
        for (int i = 0; i < contadorDeNodos; i++) {
            for (int j = 0; j < contadorDeNodos; j++) {
                // Verificamos si existe una arista entre nodo[i] y nodo[j]
                matrizDeAdyacencia[i][j] = nodosDelGrafo[i].getNodosApuntados().contains(nodosDelGrafo[j]);
            }
        }
    }

    public boolean[][] getMatrizDeAdyacencia() {
        actualizarMatrizDeAdyacencia();
        return matrizDeAdyacencia;
    }
}
