import java.time.LocalDate;

public class Título {
    private LocalDate fechaDeGraduación;
    private String universidad;
    private int nivelDeEstudio;

    public Título(LocalDate fechaDeGraduación, String universidad, int nivelDeEstudio) {
        this.fechaDeGraduación = fechaDeGraduación;
        this.universidad = universidad;
        this.nivelDeEstudio = nivelDeEstudio;
    }

    @Override
    public String toString() {
        return "\nfechaDeGraduación:" + fechaDeGraduación +
                "\nUniversidad: " + universidad +
                "\nNivelDeEstudio=" + nivelDeEstudio + "\n\n";
    }

    public int nivelTitulo() {
        return nivelDeEstudio;
    }
}
