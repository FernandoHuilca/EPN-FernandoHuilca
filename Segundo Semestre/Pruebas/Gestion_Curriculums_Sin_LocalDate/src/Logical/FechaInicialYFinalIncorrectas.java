package Logical;

public class FechaInicialYFinalIncorrectas extends Exception {
    public FechaInicialYFinalIncorrectas(){
        super("ERROR: al ingresar la fecha");
    }
    public FechaInicialYFinalIncorrectas(String message){
        super(message);
    }

}
