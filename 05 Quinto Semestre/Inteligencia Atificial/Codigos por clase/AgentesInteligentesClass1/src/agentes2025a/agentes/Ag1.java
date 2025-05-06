
package agentes2025a.agentes;

import agentes2025a.mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;



public class Ag1 extends Agent {
    
    @Override
    protected void setup(){ // configuracion inicial del agente, metodo abstracto
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{
        
        @Override
        public void action (){ // lo que va a hacer el agente

            System.out.println("Fer");
            /*System.out.println(getName());
            Mensaje.enviarMensaje(getAgent(), "Ag2", "Hola", ACLMessage.INFORM, "AG1-AG2");
            */
            blockingReceive();
        }
        
    }
          
}
