package SegundoEjercicio;

public class MaquinaDeChicles {

    // Los estados posibles: ______________________________________________
    private EstadoTieneCuarto estadoTieneCuarto;
    private EstadoNoCuarto estadoNoCuarto;
    private EstadoVendido estadoVendido;
    private EstadoAgotado estadoAgotado;
    private EstadoGanador estadoGanador;
    //_____________________________________________________________________

    // Estado actual:
    private Estado estadoActual = new EstadoAgotado(this);
    // Lógica propia del negocio:
    private int contadorChicles = 0;

    //Constructor: ________________________________________________________
    public MaquinaDeChicles(int numeroDeChicles) {
        // Instanciar todos los estados:
        estadoAgotado = new EstadoAgotado(this);
        estadoTieneCuarto = new EstadoTieneCuarto(this);
        estadoNoCuarto = new EstadoNoCuarto(this);
        estadoVendido = new EstadoVendido(this);
        estadoGanador = new EstadoGanador(this);

        contadorChicles = numeroDeChicles;

        if (contadorChicles > 0){
            estadoActual = estadoNoCuarto;
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

    protected Estado getEstadoTieneCuarto() {
        return estadoTieneCuarto;
    }
    protected Estado getEstadoNoCuarto() {
        return estadoNoCuarto;
    }
    protected Estado getEstadoVendido() {
        return estadoVendido;
    }
    protected Estado getEstadoAgotado() {
        return estadoAgotado;
    }
    protected Estado getEstadoGanador() {
        return estadoGanador;
    }

    protected int getContadorChicles() {
        return contadorChicles;
    }


}
