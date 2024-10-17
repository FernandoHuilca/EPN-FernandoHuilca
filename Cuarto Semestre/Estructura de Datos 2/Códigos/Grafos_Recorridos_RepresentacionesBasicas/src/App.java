import java.util.ArrayList;

public class App {
    private static App app;

    ArrayList<GrafoDirigido> grafosDirigidos;
    ArrayList<GrafoNoDirigido> grafosNoDirigidos;
    private App() {
        this.grafosDirigidos = new ArrayList<>();
        this.grafosNoDirigidos = new ArrayList<>();
    }

    public static App getInstance(){
        if(app == null){
            app = new App();
        }
        return app;
    }
    public boolean agregarGrafoDirigido(GrafoDirigido nuevoGrafoDirigido) {
        grafosDirigidos.add(nuevoGrafoDirigido);
        return true;
    }

    public Nodo[] getNodosGrafosDirigidos(int numeroGrafoDirigido) {
    return grafosDirigidos.get(numeroGrafoDirigido).getNodos();
    }

    public GrafoDirigido getGrafoDirigido(int numeroGrafoDirigido) {
        return grafosDirigidos.get(numeroGrafoDirigido);
    }

    public boolean agregarGrafoNoDirigido(GrafoNoDirigido NuevoGrafoNoDirigido) {
    grafosNoDirigidos.add(NuevoGrafoNoDirigido);
    return true;
    }

    public Nodo[] getNodosGrafosNoDirigidos(int numeroGrafoNoDirigido) {
        return grafosNoDirigidos.get(numeroGrafoNoDirigido).getNodos();
    }


    public GrafoNoDirigido getGrafoNoDirigido(int numeroGrafoNoDirigido) {
        return grafosNoDirigidos.get(numeroGrafoNoDirigido);
    }
}
