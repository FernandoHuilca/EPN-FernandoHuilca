package BusinessLogic.ContenidoMultimedia.ControlDeExcepciones;

public class VerContenidoCuentaSinPagar extends Throwable {
    public VerContenidoCuentaSinPagar(String message) {
        super(message);
    }
    public VerContenidoCuentaSinPagar(){
        super("\u001B[31m" + "ERROR: " + "\u001B[0m" + " Su cuenta no tiene una suscripción valida para ver pelis o series!!");
    }
}
