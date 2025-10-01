
public class RedSocial {
    private FiltroMensaje filtroMensaje;

    public RedSocial() {
        this.filtroMensaje = new FiltroPalabrasProhibidas();
        FiltroDeLongitud filtroLongitud = new FiltroDeLongitud();
        FiltroEnlace filtroEnlace = new FiltroEnlace();
    
        filtroMensaje.cambiarSiguiente(filtroLongitud);
        filtroLongitud.cambiarSiguiente(filtroEnlace);
    }

    public void enviarMensaje(String mensaje) {
        if(!filtroMensaje.filtrarMensaje(mensaje)){
            System.out.println("ERROR: MENSAJE NO ENVIADO, no paso algun filtro");
        }else
        System.out.println("MENSAJE ENVIADO CORRECTAMENTE.");
    }
}
