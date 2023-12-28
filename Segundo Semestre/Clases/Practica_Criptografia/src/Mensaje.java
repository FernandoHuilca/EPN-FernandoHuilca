import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mensaje {

    private String mensaje;
    private LocalDateTime fechaDeEnvio;

    public Mensaje(String mensaje, LocalDateTime fechaDeEnvio) {
        this.mensaje = mensaje;
        this.fechaDeEnvio = fechaDeEnvio;
    }

    @Override
    public String toString() {
        return "Mensaje" +
                "\n\tmensaje = " + mensaje +
                "\n\tfechaDeEnvio = " + fechaDeEnvio;
    }
}
