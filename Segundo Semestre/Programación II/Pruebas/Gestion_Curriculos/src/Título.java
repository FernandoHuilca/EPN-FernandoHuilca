import java.time.LocalDate;

public class Título {
    private LocalDate fechaDeGraduación;
    private String Universidad;
    private int nivelDeTítulo;

    public Título(LocalDate fechaDeGraduación, String universidad, int nivelDeTítulo) {
        this.fechaDeGraduación = fechaDeGraduación;
        Universidad = universidad;
        this.nivelDeTítulo = nivelDeTítulo;
    }
}
