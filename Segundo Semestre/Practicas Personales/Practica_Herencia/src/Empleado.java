import java.time.LocalDate;

public class Empleado {


    private String nombre;
    private String correoElectronico;
    private LocalDate fechaDeContratacion;
    private double salario;

    public Empleado(String nombre, String correoElectronico, LocalDate fechaDeContratacion, double salario) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaDeContratacion = fechaDeContratacion;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }
}
