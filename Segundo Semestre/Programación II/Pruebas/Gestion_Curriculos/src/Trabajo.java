import java.time.LocalDate;

public class Trabajo {
    private LocalDate fechaInicio;
    private LocalDate fechaFinalización;
    private String nombreDeLaEmpresa;


    public Trabajo(LocalDate fechaInicio, LocalDate fechaFinalización, String nombreDeLaEmpresa) {
        this.fechaInicio = fechaInicio;
        this.fechaFinalización = fechaFinalización;
        this.nombreDeLaEmpresa = nombreDeLaEmpresa;
    }

    public double experienciaLaboral() {
        return fechaFinalización.compareTo(fechaInicio);
    }
}
