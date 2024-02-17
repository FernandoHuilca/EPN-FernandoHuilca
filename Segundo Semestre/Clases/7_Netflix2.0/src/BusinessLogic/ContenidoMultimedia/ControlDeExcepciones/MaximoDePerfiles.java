package BusinessLogic.ContenidoMultimedia.ControlDeExcepciones;

public class MaximoDePerfiles extends Throwable {
    public MaximoDePerfiles(){
        super("ERROR: No se puede crear mas perfiles, conozca sus límites señor Wayne");
    }
}
