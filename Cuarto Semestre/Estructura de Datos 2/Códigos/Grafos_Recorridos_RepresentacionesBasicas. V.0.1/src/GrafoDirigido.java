public class GrafoDirigido {
    public static final int TAMAÑO_NODOS_ACEPTADOS = 100;
    private NodoGrafo<String>[] nodosDelGrafo;
    private int contadorDeNodos;
    private boolean[][] matrizDeAdyacencia;

    public GrafoDirigido() {
        this.nodosDelGrafo = new NodoGrafo[TAMAÑO_NODOS_ACEPTADOS];
        this.contadorDeNodos = 0;
        this.matrizDeAdyacencia = new boolean[100][100];
    }

    public boolean agregarNodosDelGrafo(NodoGrafo[] nodos) {
        this.nodosDelGrafo = nodos;
        return true;
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
        return true;
    }

    public NodoGrafo[] getNodos() {
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

    public NodoGrafo<String> getNoVisitado() {
        // Devuelve el primer nodo que no ha sido visitado
        for (NodoGrafo<String> nodo : nodosDelGrafo) {
            if (nodo != null && !nodo.estaVisitado()) {
                return nodo;
            }
        }
        return null; // Si todos los nodos han sido visitados, retorna null
    }

}
