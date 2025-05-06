package agentes;

import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class Agente1 extends Agent {
    int contadorDeAgentesH = 0;

    @Override
    protected void setup() {
        System.out.println("AGENTE 1 LIVE");
        addBehaviour(new EnviarMensajeCompor("Agente2", "mensaje del agente 1 al 2", ACLMessage.INFORM, "AG1-AG2"));
        addBehaviour(new RecibirMensajesInf());
    }
    private class EnviarMensajeCompor extends OneShotBehaviour {

        private String emisor;
        private String receptor;
        private String mensaje;
        private int tipoComunicacion;
        private String idConversacion;

        public EnviarMensajeCompor(String receptor, String mensaje, int tipoComunicacion, String idConversacion) {
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

    private class RecibirMensajesInf extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            String mensaje = mensajeRecibido.getContent();
            System.out.println("SOY AGENTE 1: Mensaje recibido: " + mensaje);
            Mensaje.enviarMensaje(getAgent(),"AgenteH" + contadorDeAgentesH,"soy agente 1 hola agente H " + contadorDeAgentesH + ", muereee", ACLMessage.REQUEST, "AG1-AG5");
            contadorDeAgentesH++;
            //addBehaviour(new EnviarMensajeCompor("AgenteH","soy agente 1 hola agente H", ACLMessage.REQUEST, "AG1-AG5"));
        }
    }
}
