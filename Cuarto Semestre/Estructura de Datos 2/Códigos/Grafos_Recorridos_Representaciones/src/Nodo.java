import java.util.ArrayList;

public class Nodo {
    private String infoNodo;
    private ArrayList<Nodo> nodosAlosQueApunta;

    public Nodo(String infoNodo) {
        this.infoNodo = infoNodo;
    }

    public boolean apuntarANodo(Nodo nodoDestino) {
        nodosAlosQueApunta.add(nodoDestino);
    }
}
