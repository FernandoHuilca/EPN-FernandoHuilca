package agentesExtras;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class AgentTest extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new enviarMensaje());
    }

    private class enviarMensaje extends Behaviour {
        @Override
        public void action() {
            System.out.println("MENSAJE ENVIADO");
        }

        @Override
        public boolean done() {
            return true;
        }
    }
}
