package agentes;

import comportamientos.EnviarMensajeBehaviour;
import comportamientos.RecibirMensajesBehaviour;
import comportamientos.SuicidarseBehaviour;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class Agente4 extends Agent {

    @Override
    protected void setup() {
        System.out.println("AGENTE 4 LIVE");
        addBehaviour(new RecibirMensajesBehaviour(this ,1));
        addBehaviour(new EnviarMensajeBehaviour("Agente5", "mensaje del agente 4 al 5", ACLMessage.INFORM, "AG4-AG5"));
        addBehaviour(new SuicidarseBehaviour(this));
    }

    @Override
    protected void takeDown() {
        System.out.println("AGENTE 4 DEAD");
    }

}






