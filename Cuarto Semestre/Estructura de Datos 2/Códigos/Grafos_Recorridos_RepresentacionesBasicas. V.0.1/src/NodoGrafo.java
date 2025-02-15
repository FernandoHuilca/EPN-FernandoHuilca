import java.util.ArrayList;

public class NodoGrafo<T> {
    private String infoNodo;
    private ArrayList<NodoGrafo<T>> nodosAlosQueApunta;
    private boolean visitado ;

    public NodoGrafo() {
        this.infoNodo = "null";
        nodosAlosQueApunta = new ArrayList<>();
        visitado = false;
    }

    public NodoGrafo(String infoNodo) {
        this.infoNodo = infoNodo;
        nodosAlosQueApunta = new ArrayList<>();
    }

    public boolean apuntarANodo(NodoGrafo nodoDestino) {
        if (!nodosAlosQueApunta.contains(nodoDestino)) {
            nodosAlosQueApunta.add(nodoDestino);
            return true;
        }
        return false;
    }


    public String getInfo() {
        return infoNodo;
    }


    public ArrayList<NodoGrafo<T>> getNodosApuntados() {
        return nodosAlosQueApunta;
    }

    public void setEstadoVisitado(boolean valorBooleano) {
        visitado = valorBooleano;
    }

    public boolean estaVisitado() {
        return visitado;
    }

    public int getNumNodosApuntados() {
        return nodosAlosQueApunta.size();
    }
}
