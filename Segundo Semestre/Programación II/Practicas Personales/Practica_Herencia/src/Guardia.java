import java.time.LocalDate;

public class Guardia extends Empleado {
    private String herramientasDeSeguridad;

    public Guardia(String nombre, String correoElectronico, LocalDate fechaDeContratacion, double salario, String herramientasDeSeguridad) {
        super(nombre,correoElectronico, fechaDeContratacion, salario);
        this.herramientasDeSeguridad = herramientasDeSeguridad;
    }
}
