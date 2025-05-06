package agentes;

import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class Agente2 extends Agent {
    private final int NUMERO_MENSAJES_ESPERADOS = 1;

    @Override
    protected void setup() {
        System.out.println("AGENTE 2 LIVE");
        addBehaviour(new RecibirMensajesCompor(NUMERO_MENSAJES_ESPERADOS));
        addBehaviour(new EnviarMensajeCompor("Agente3", "mensaje del agente 2 al 3", ACLMessage.INFORM, "AG2-AG3"));
        addBehaviour(new EnviarMensajeCompor("Agente4", "mensaje del agente 2 al 4", ACLMessage.INFORM, "AG2-AG4"));
        addBehaviour(new EnviarMensajeCompor("Agente5", "mensaje del agente 2 al 5", ACLMessage.INFORM, "AG2-AG5"));
        addBehaviour(new SuicidarseCompor());
    }

    @Override
    protected void takeDown() {
        System.out.println("AGENTE 2 DEAD");
    }

    private class RecibirMensajesCompor extends Behaviour {
        private boolean finaliza = false;
        private int numMensajesEsperados;
        private int contadorDeMensajes = 0;
        ArrayList<String> mensajes;
        public RecibirMensajesCompor(int numMensajesEsperados) {
            this.numMensajesEsperados = numMensajesEsperados;
            mensajes = new ArrayList<>();
        }

        @Override
        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            mensajes.add(mensajeRecibido.getContent());
            //contadorDeMensajes++;
            System.out.println("SOY AGENTE 2 : Mensaje recibido: " + mensajes.get(contadorDeMensajes++));
            if (contadorDeMensajes == numMensajesEsperados) {
                finaliza = true;
            }

        }

        @Override
        public boolean done() {
            return finaliza;
        }
    }

    private class EnviarMensajeCompor extends OneShotBehaviour {

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

    private class SuicidarseCompor extends OneShotBehaviour {
        @Override
        public void action() {
            doDelete();
        }
    }
}
