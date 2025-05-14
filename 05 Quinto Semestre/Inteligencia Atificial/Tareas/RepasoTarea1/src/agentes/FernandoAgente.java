package agentes;

import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class FernandoAgente extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new RecibirMensajeComport());

    }

    private class RecibirMensajeComport extends Behaviour {

        @Override
        public void action() {
            ACLMessage mensaje = blockingReceive();
            String mensajeRecibido = mensaje.getContent();
            System.out.println("mensajeRecibido: " + mensajeRecibido);
            Mensaje.enviarMensaje(getAgent(), "MateoAgente", "NOOO, COCHINO INFIEL", ACLMessage.INFORM, "AGMA-AGFER");
        }

        @Override
        public boolean done() {
            return false;
        }
    }
}
