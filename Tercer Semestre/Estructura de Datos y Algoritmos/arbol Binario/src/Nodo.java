public class Nodo {
    // Campos del nodo
    private int INFO; // Información contenida en el nodo (valor entero)
    private Nodo IZQ; // Referencia al subárbol izquierdo
    private Nodo DER; // Referencia al subárbol derecho

    // Constructor de los nodos de un arbol binario
    public Nodo(int INFO, Nodo IZQ, Nodo DER) {
        this.INFO = INFO;
        this.IZQ = IZQ;
        this.DER = DER;
    }

    // Constructor de la raíz del nodo
    public Nodo(int INFO) {
        this.INFO = INFO;
        this.IZQ = null;
        this.DER = null;
    }

    // Constructor por defecto del nodo
    public Nodo() {
        super();
        this.INFO = 0;
        this.IZQ = null;
        this.DER = null;
    }

    // Método para obtener informacion o hijos de un nodo
    public int getINFO() {
        return INFO;
    }
    // Método para asignar la información a un nodo
    public void setINFO(int iNFO) {
        INFO = iNFO;
    }

    // Método para obtener la dirección del subárbol izquierdo del nodo actual
    public Nodo getIZQ() {
        return IZQ;
    }

    // Método para asignar la dirección del subárbol izquierdo del nodo actual
    public void setIZQ(Nodo iZQ) {
        IZQ = iZQ;
    }

    // Método para obtener la dirección del subárbol derecho del nodo actual
    public Nodo getDER() {
        return DER;
    }

    // Método para asignar la dirección del subárbol derecho del nodo actual
    public void setDER(Nodo dER) {
        DER = dER;
    }
}