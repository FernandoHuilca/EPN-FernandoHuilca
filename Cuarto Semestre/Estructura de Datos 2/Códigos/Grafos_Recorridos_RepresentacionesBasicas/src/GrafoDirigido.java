public class GrafoDirigido {
    public static final int TAMAÑO_NODOS_ACEPTADOS = 100;
    private Nodo[] nodosDelGrafo;
    private int contadorDeNodos;
    private boolean[][] matrizDeAdyacencia;

    public GrafoDirigido() {
        this.nodosDelGrafo = new Nodo[TAMAÑO_NODOS_ACEPTADOS];
        this.contadorDeNodos = 0;
        this.matrizDeAdyacencia = new boolean[100][100];
    }

    public boolean agregarNodosDelGrafo(Nodo[] nodos) {
        this.nodosDelGrafo = nodos;
        return true;
    }

    public boolean agregarNodo(Nodo nuevoNodo) {
        if (contadorDeNodos == TAMAÑO_NODOS_ACEPTADOS){
            return false;
        }
        nodosDelGrafo[contadorDeNodos++] = nuevoNodo;
        return true;
    }

    public boolean dirigirAristaANodo(int nodoOrigen, int nodoDestino) {
        nodosDelGrafo[nodoOrigen].apuntarANodo(nodosDelGrafo[nodoDestino]);
        return true;
    }

    public Nodo[] getNodos() {
    return nodosDelGrafo;
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

    public int getCantidadDeNodos() {
        return contadorDeNodos;
    }
}
