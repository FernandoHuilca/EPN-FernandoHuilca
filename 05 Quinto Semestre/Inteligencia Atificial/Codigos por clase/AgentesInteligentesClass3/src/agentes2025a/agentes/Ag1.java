
package agentes2025a.agentes;

import agentes2025a.Modelo.Cliente;
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
            System.out.println(getName());
            
            Cliente cliente = new Cliente(1, 2,50,25,20, 21.2, 100.5, 55.25);
            
            Mensaje.enviarMensajeObj(getAgent(), "Ag2", cliente, ACLMessage.REQUEST, "AG1-AG2");
            ACLMessage acl = blockingReceive();
            System.out.println(acl);
        }
        
    }
          
}
