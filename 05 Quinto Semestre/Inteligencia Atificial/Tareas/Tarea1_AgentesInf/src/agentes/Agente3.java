package agentes;

import comportamientos.EnviarMensajeBehaviour;
import comportamientos.RecibirMensajesBehaviour;
import comportamientos.SuicidarseBehaviour;
import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class Agente3 extends Agent {

    @Override
    protected void setup() {
        System.out.println("AGENTE 3 LIVE");
        addBehaviour(new RecibirMensajesBehaviour(this , 1));
        addBehaviour(new EnviarMensajeBehaviour("Agente5", "mensaje del agente 3 al 5", ACLMessage.INFORM, "AG3-AG5"));
        addBehaviour(new SuicidarseBehaviour(this));
    }
    @Override
    protected void takeDown() {
        System.out.println("AGENTE 3 DEAD");
    }

}
