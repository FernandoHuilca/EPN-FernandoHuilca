import java.time.LocalDateTime;

public class Transferencia {

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double montoATransferir;
    private LocalDateTime fecha;


    public Transferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double montoATransferir) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.montoATransferir = montoATransferir;
        fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "\u001B[32m"+"Transferencia Exitosa!!" + "\u001B[0m" +
                "\n\tCuentaOrigen: \n" + cuentaOrigen +
                ", \n\tCuentaDestino: \n" + cuentaDestino +
                ", \n\tMontoDeTransferencia: " + montoATransferir +
                ", \n\tFecha: " + fecha;
    }
}
