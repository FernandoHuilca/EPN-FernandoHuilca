package BusinessLogic.ContenidoMultimedia.ControlDeExcepciones;

public class DineroInsuficiente extends Exception {
    public DineroInsuficiente(){
        super("\u001B[31m" + "ERROR:" + "\u001B[0m" + " el dinero depositado no es el correcto!!");
    }
    public DineroInsuficiente(String message){
        super(message);
    }

}
