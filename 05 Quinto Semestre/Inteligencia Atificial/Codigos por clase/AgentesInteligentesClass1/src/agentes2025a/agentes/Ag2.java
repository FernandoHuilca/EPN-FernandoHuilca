
package agentes2025a.agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Ag2 extends Agent {
    
    @Override
    protected void setup(){ // configuracion inicial del agente, metodo abstracto
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action (){ // lo que va a hacer el agente
            
            ACLMessage acl = blockingReceive(); // se detiene hasta decirle que hacer
            System.out.println(acl);
            
            // enviar
        }
    }
}
