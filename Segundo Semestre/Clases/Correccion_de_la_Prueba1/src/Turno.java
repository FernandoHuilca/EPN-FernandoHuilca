import java.time.LocalDate;

public class Turno {
    private Cliente cliente;
    private LocalDate fechaDeTurno;

    public Turno(Cliente cliente, LocalDate fechaDeTurno) {

        this.cliente = cliente;
        this.fechaDeTurno = fechaDeTurno;
    }

    public LocalDate getFecha() {
        return fechaDeTurno;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
