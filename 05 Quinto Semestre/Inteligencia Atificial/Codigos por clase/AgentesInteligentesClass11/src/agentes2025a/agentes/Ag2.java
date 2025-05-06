
package agentes2025a.agentes;

import agentes2025a.Modelo.Cliente;
import agentes2025a.mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


public class Ag2 extends Agent {
    
    @Override
    protected void setup(){ // configuracion inicial del agente, metodo abstracto
        addBehaviour(new Comportamiento());
    }
    @Override
    protected void takeDown(){
        System.out.println(" Noooooooooooooooooooooooooooooooooo ");
    }
    /*
    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action (){ // lo que va a hacer el agente
            
            ACLMessage acl = blockingReceive(); // se detiene hasta decirle que hacer

            
        
            try {
            
                Cliente c1 = (Cliente)acl.getContentObject();
                System.out.println(c1.getTotalFacturasUltimoMes());

           
            } catch (UnreadableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
            //if (acl.getConversationId().equalsIgnoreCase("AG1-AG2")){
            //    Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(), "Hola, soy"+ getName(), ACLMessage.REQUEST, "AG2-AG1");
            //}
            // enviar
        }*/


            class Comportamiento extends Behaviour {
                private boolean done = false;
            @Override
            public void action (){ // lo que va a hacer el agente
                
                ACLMessage acl = blockingReceive(); // se detiene hasta decirle que hacer
    
            
                try {
                
                    Cliente c1 = (Cliente)acl.getContentObject();
                    System.out.println(c1.getTotalFacturasUltimoMes());
                    done = true;
                    doDelete();
               
                } catch (UnreadableException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                
                //if (acl.getConversationId().equalsIgnoreCase("AG1-AG2")){
                //    Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(), "Hola, soy"+ getName(), ACLMessage.REQUEST, "AG2-AG1");
                //}
                // enviar
            }
            
            @Override
            public boolean done(){
                return done;
            }

    }
}
