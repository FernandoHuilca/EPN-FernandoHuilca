public class CantidadNegativa extends Exception {
    public CantidadNegativa(){
        super("ERROR: Se ha ingresado cantidades negativas");
    }
    public CantidadNegativa(String message){
        super(message);
    }
}
