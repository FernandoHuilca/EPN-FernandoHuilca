public class Nodo {
    private int info;
    private Nodo nodoDerecho;
    private Nodo nodoIzquierdo;

    //Aquí tenemos un constructor que no recibe parámetros, por lo que los atributos se instance con null
    public Nodo() {
        nodoDerecho = null;
        nodoIzquierdo = null;
        info = 0;
    }
    // Otro constructor que incluye la información que guarda el nodo
    public Nodo(int infoNuevoNodo) {
        nodoDerecho = null;
        nodoIzquierdo = null;
        info = infoNuevoNodo;
    }

    // Getters and Setters
    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }
    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }


    //Para imprimir cada nodo
    @Override
    public String toString() {
        return "\nInfo " + info +
                "\nNodoDerecho " + (nodoDerecho != null ? nodoDerecho.getInfo() : "null") +
                "\nNodoIzquierdo " + (nodoIzquierdo != null ? nodoIzquierdo.getInfo() : "null");
    }
}
