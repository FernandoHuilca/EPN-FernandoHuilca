import java.util.ArrayList;

public class Empresa {
    private static ArrayList<Candidato> candidatos;

    public Empresa() {
        candidatos = new ArrayList<>();
    }

    public static void agregarCandidato(Candidato fernandoH) {
        candidatos.add(fernandoH);
    }

    public void mostrarCandidatosPorTiempoDeExperiencia() {
        for (Candidato candidato : candidatos) {
            System.out.println(candidato.getExperienciaLaboral());
        }
    }
}
