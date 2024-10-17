import java.util.ArrayList;

public class App {
    ArrayList<GrafoDirigido> grafosDirigidos;

    public App() {
        this.grafosDirigidos = new ArrayList<>();
    }
    public void agregarGrafoDirigido(GrafoDirigido nuevoGrafoDirigido) {
        grafosDirigidos.add(nuevoGrafoDirigido);
    }

    public void imprimirGrafoDirigido(int numeroGrafoDirigido) {
        System.out.println("_______________________ GRAFO DIRIGIDO N# " + numeroGrafoDirigido + "  _______________________");
    }
}
