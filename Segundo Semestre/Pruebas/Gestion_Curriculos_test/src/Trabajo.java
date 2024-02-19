import java.time.LocalDate;
import java.time.Period;

public class Trabajo {
    private final LocalDate fechaDeIngreso;
    private final LocalDate fechaDeFinalización;
    private final String nombreEmpresa;

    public Trabajo(LocalDate fechaDeIngreso, LocalDate fechaDeFinalización, String nombreEmpresa) {
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeFinalización = fechaDeFinalización;
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "\nFechaDeIngreso: " + fechaDeIngreso +
                "\nFechaDeFinalización: " + fechaDeFinalización +
                "\nNombreEmpresa: " + nombreEmpresa +"\n\n";
    }

    public double getExperiencia() {
        Period period =Period.between(fechaDeIngreso, fechaDeFinalización);
        return period.getYears();
    }
}
