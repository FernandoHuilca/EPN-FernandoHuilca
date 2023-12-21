import java.time.LocalDate;

public class Turno {
    private Cliente cliente;
    private LocalDate fechaDeTurno;
    private TipoDeTurno tipoDeTurno;

    public Turno(Cliente cliente, LocalDate fechaDeTurno, TipoDeTurno tipoDeTurno) {
        this.cliente = cliente;
        this.fechaDeTurno = fechaDeTurno;
        this.tipoDeTurno = tipoDeTurno;
    }

    public LocalDate getFecha() {
        return fechaDeTurno;
    }

    public Cliente getCliente() {
        return cliente;
    }


    @Override
    public String toString() {
        return
                cliente +
                "\n\tFechaDeTurno = " + fechaDeTurno +
                "\n\tTipoDeTurno = " + tipoDeTurno;
    }
}
