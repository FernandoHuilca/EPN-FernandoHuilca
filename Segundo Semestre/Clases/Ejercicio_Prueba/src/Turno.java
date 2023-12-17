public class Turno {
    private Cliente cliente;
    private String tipoDeTurno;
    private int dia;
    private int mes;
    private int anio;

    public Turno(Cliente cliente, String tipoDeTurno, int dia, int mes, int anio) {
        this.cliente = cliente;
        this.tipoDeTurno = tipoDeTurno;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return
                "\n\tNombre: " + cliente.nombre()
                        + "\n\tTipo de turno: " + tipoDeTurno;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
