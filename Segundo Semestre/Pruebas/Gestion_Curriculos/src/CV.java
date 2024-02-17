import java.util.ArrayList;

public class CV {
    private ArrayList<Título> títulos;
    private ArrayList<Trabajo> trabajos;
    private ArrayList<Competencia> competencias;

    public CV(ArrayList<Título> títulos, ArrayList<Trabajo> trabajos, ArrayList<Competencia> competencias) {
        this.títulos = títulos;
        this.trabajos = trabajos;
        this.competencias = competencias;
    }

    public double experienciaLaboral() {
        double aux = 0;
        for (Trabajo magia : trabajos) {
            aux += magia.experienciaLaboral();
        }
        return aux;
    }

    public void getCompencias() {
        for (Competencia magia : competencias){
            System.out.println(magia);
        }

    }
}
