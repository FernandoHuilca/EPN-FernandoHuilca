package comportamientos;

import comunicacion.Mensaje;
import jade.core.behaviours.OneShotBehaviour;

public class EnviarMensajeBehaviour extends OneShotBehaviour {
    private String emisor;
    private String receptor;
    private String mensaje;
    private int tipoComunicacion;
    private String idConversacion;

    public EnviarMensajeBehaviour(String receptor, String mensaje, int tipoComunicacion, String idConversacion) {
        this.receptor = receptor;
        this.tipoComunicacion = tipoComunicacion;
        this.mensaje = mensaje;
        this.idConversacion = idConversacion;
    }

    @Override
    public void action() {
        Mensaje.enviarMensaje(getAgent(),receptor,mensaje,tipoComunicacion,idConversacion);
    }

}
