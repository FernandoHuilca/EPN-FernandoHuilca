package agentes;

import Cliente.Cliente;
import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Agente 3: LIVE");
        addBehaviour(new ComportRecibirRequest());
    }

    private class ComportRecibirRequest extends Behaviour {
        @Override
        public void action() {
            ACLMessage request = blockingReceive(); // El agente se detiene aquí hasta recibir algo
            String mensaje = request.getContent();
            System.out.println("El request recibido: " + mensaje);
            Mensaje.enviarMensaje(getAgent(),"Agente1","Mensaje Recibido",ACLMessage.REQUEST, "AG1-AG3");
        }

        @Override
        public boolean done() {
            return false;
        }
    }
}
