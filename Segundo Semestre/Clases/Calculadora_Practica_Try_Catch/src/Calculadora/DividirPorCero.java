package Calculadora;

public class DividirPorCero extends Exception {
    public DividirPorCero(){
        super("ERROR: No seas pendejo, no dividas para cero");
    }
    public DividirPorCero(String message){
        super(message);
    }
}
