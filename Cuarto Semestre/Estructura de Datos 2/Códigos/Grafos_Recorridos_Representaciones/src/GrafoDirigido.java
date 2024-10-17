public class GrafoDirigido {
    public static final int TAMAÑO_NODOS_ACEPTADOS = 100;
    private Nodo[] nodosDelGrafo;
    private int contadorDeNodos;

    public GrafoDirigido() {
        this.nodosDelGrafo = new Nodo[TAMAÑO_NODOS_ACEPTADOS];
        this.contadorDeNodos = 0;
    }

    public boolean agregarNodosDelGrafo(Nodo[] nodos) {
        this.nodosDelGrafo = nodos;
        return true;
    }

    public boolean agregarNodo(Nodo nuevoNodo) {
        if (contadorDeNodos == TAMAÑO_NODOS_ACEPTADOS){
            return false;
        }
        nodosDelGrafo[contadorDeNodos] = nuevoNodo;
        return true;
    }

    public boolean dirigirAristaANodo(int nodoOrigen, int nodoDestino) {
        nodosDelGrafo[nodoOrigen].apuntarANodo(nodosDelGrafo[nodoDestino]);
        return true;
    }
}
