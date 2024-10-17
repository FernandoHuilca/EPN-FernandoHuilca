import java.util.ArrayList;

public class Nodo {
    private String infoNodo;
    private ArrayList<Nodo> nodosAlosQueApunta;

    public Nodo() {
        this.infoNodo = "null";
        nodosAlosQueApunta = new ArrayList<>();
    }

    public Nodo(String infoNodo) {
        this.infoNodo = infoNodo;
        nodosAlosQueApunta = new ArrayList<>();
    }

    public boolean apuntarANodo(Nodo nodoDestino) {
        if (!nodosAlosQueApunta.contains(nodoDestino)) {
            nodosAlosQueApunta.add(nodoDestino);
            return true;
        }
        return false;
    }


    public String getInfo() {
        return infoNodo;
    }


    public ArrayList<Nodo> getNodosApuntados() {
        return nodosAlosQueApunta;
    }
}
