import java.util.ArrayList;
import java.util.Collections;

public class CV {
    private String nombreCandidato;
    private ArrayList<Título> títulos;
    private ArrayList<Trabajo> trabajos;
    private ArrayList<Competencia> competencias;

    public CV(String nombreCandidato, ArrayList<Título> títulos, ArrayList<Trabajo> trabajos, ArrayList<Competencia> competencias) {
        this.nombreCandidato = nombreCandidato;
        this.títulos = títulos;
        this.trabajos = trabajos;
        this.competencias = competencias;
    }

    @Override
    public String toString() {
        return "Currículo de : " + nombreCandidato + "\n" +
                "Títulos: \n" + títulos +
                "\nTrabajos: \n" + trabajos +
                "\nCompetencias: \n" + competencias + "\n\n";
    }

    public int getCantidadDeCompetencias() {
        return competencias.size();
    }

    public int getNivelDelTitulo() {
        return títulos.get(0).nivelTitulo();
    }

    public int getExperienciaLaboral() {
        int aux = 0;
        for (Trabajo magia : trabajos){
            aux += magia.getExperiencia();
        }
        return aux;
    }
}
