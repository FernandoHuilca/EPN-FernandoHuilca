import java.time.LocalDate;

public class Ganacia {
    private double dinero;
    private LocalDate fecha;

    public Ganacia(double dineroDelCliente) {
        this.dinero = dineroDelCliente;
        fecha = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Ganacia{" +
                "dinero=" + dinero +
                ", fecha=" + fecha +
                '}';
    }

    public double getDinero() {
        return dinero;
    }
}
