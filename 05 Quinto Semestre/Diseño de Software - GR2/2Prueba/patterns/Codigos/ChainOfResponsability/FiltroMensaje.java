
public abstract class FiltroMensaje {
    protected FiltroMensaje siguiente;

    public void cambiarSiguiente(FiltroMensaje siguiente) {
        this.siguiente = siguiente;
    }

    public boolean filtrarMensaje(String mensaje){
        if(!filtrar(mensaje)){
            return false;
        }
        if (siguiente != null) {
            return siguiente.filtrarMensaje(mensaje);
        }
        return true;
    }

    protected abstract boolean filtrar(String mensaje);

}