package comportamientos;

import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.ArrayList;

public class EnviarMensajeBehaviour extends OneShotBehaviour {
    private String receptor;
    private String mensaje;
    private int tipoComunicacion;
    private String idConversacion;
    private ArrayList<Integer> listaMensajes;
    private boolean mensajeBoolean;

    public EnviarMensajeBehaviour(Agent agent, String receptor, String mensaje, int tipoComunicacion, String idConversacion) {
        super(agent);
        this.listaMensajes = new ArrayList<>();
        this.mensajeBoolean = false;
        this.receptor = receptor;
        this.tipoComunicacion = tipoComunicacion;
        this.mensaje = mensaje;
        this.idConversacion = idConversacion;
    }
    public EnviarMensajeBehaviour(Agent agent,String receptor, ArrayList<Integer> mensaje, int tipoComunicacion, String idConversacion) {
        super(agent);
        this.listaMensajes = mensaje;
        this.receptor = receptor;
        this.tipoComunicacion = tipoComunicacion;
        this.idConversacion = idConversacion;
    }
    public EnviarMensajeBehaviour(Agent agent,String receptor, boolean mensaje, int tipoComunicacion, String idConversacion) {
        super(agent);
        this.mensajeBoolean = mensaje;
        this.receptor = receptor;
        this.tipoComunicacion = tipoComunicacion;
        this.idConversacion = idConversacion;
    }

    @Override
    public void action() {
        Mensaje.enviarMensaje(getAgent(),receptor,mensaje,tipoComunicacion,idConversacion);
    }

}
