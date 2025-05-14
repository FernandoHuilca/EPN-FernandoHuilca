package comportamientos;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SuicidarseBehaviour extends OneShotBehaviour {

    public SuicidarseBehaviour(Agent agente) {
        super(agente);
    }

    @Override
    public void action() {
        System.out.println("Agente " + getAgent().getName() + " DEAD");
    getAgent().doDelete();
    }
}
