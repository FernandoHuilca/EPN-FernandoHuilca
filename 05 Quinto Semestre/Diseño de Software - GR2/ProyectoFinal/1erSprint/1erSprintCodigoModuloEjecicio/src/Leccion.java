import java.util.ArrayList;

public class Leccion {
    ArrayList<Ejercicio> listEjercicios;

    public Leccion() {
        listEjercicios = new ArrayList<>();
    }

    public ArrayList<Ejercicio> getListEjercicios() {
        return listEjercicios;
    }

    public boolean agregarEjercicio(Ejercicio ejercicio) {
    return listEjercicios.add(ejercicio);
    }

    public Ejercicio getEjercicio(int numEjercicio) {
    return listEjercicios.get(numEjercicio);
    }
}
