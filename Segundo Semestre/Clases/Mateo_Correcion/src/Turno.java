public class Turno {

    private int numeroDeTurno;
    private String nombre;
    private Fecha fecha;
    private TipoDeTurno tipoDeTurno;
    private boolean turnoCancelado;

    public Turno(int numeroDeTurno, String nombreDelCliente, TipoDeTurno tipoDeTurno, Fecha fecha) {
        this.numeroDeTurno = numeroDeTurno;
        this.tipoDeTurno = tipoDeTurno;
        this.nombre = nombreDelCliente;
        this.fecha = fecha;
        this.turnoCancelado = false;
    }

    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre; //+
        //" Fecha: " + fecha;
    }

    public boolean esLaMismaFechaImprimir(Fecha fechaComparar) {
        if(!fecha.esLaMismaFecha(fechaComparar)){
            return false;
        }
        return true;
    }

    public void cancelarTurno() {
        turnoCancelado = true;
        return;
    }

    public boolean estaActivoELTurno() {
        if(turnoCancelado){
            return false;
        }
        return true;
    }

    public boolean tieneUnTurno(String nombreDelClienteAComparar) {
        if(nombre == nombreDelClienteAComparar){
            return true;
        }
        return false;
    }

    public boolean estaCancelado() {
        return turnoCancelado;
    }

    public boolean esUrgente() {
        if(tipoDeTurno == TipoDeTurno.URGENTE){
            return true;
        }
        return false;
    }
}