package agentes;

import IAGenerica.IAGenetica;
import comportamientos.CrearAgenteBehaviour;
import comportamientos.RecibirMensajesBehaviour;
import contenedor.Contenedor;
import jade.core.Agent;

public class Agente3 extends Agent {
    @Override
    protected void setup() {
        System.out.println(" AGENTE 3 LIVE ");
        addBehaviour(new RecibirMensajesBehaviour(this, 1));
    }
}
