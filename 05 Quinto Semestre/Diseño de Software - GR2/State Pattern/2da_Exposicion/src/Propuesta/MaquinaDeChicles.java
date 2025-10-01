package Propuesta;

public class MaquinaDeChicles {

    // Estado actual:
    private Estado estadoActual = new EstadoAgotado(this);
    // Lógica propia del negocio:
    private int contadorChicles = 0;

    //Constructor: ________________________________________________________
    public MaquinaDeChicles(int numeroDeChicles) {

        contadorChicles = numeroDeChicles;

        if (contadorChicles > 0){
            estadoActual = new EstadoNoCuarto(this);
        }
    }

    // Todas las funciones de transición entre estados: _______________________
    public void insertarCuarto() {
        estadoActual.insertarCuarto();
    }

    public void expulsarCuarto() {
        estadoActual.expulsarCuarto();
    }

    public void girarManivela() {
        estadoActual.girarManivela();
        estadoActual.dispensar();
    }
    //No es necesario un metodo para dispensar, ya que el usuario no podría pedir a la quina que dispense
    //__________________________________________________________________________
    //Metodo propio de la máquina de chicles:
    protected void liberarChicle() {
        System.out.println("Un chicle rodando por la ranura...");
        if (contadorChicles != 0){
            contadorChicles--;
        }
    }
    //__________________________________________________________________________
    protected void setEstado(Estado nuevoEstado) {
    this.estadoActual = nuevoEstado;
    }

    protected int getContadorChicles() {
        return contadorChicles;
    }


}
