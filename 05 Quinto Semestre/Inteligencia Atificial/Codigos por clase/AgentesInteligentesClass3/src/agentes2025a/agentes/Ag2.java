
package agentes2025a.agentes;

import java.util.logging.Level;
import java.util.logging.Logger;

import agentes2025a.Contenedor;
import agentes2025a.Modelo.Cliente;
import agentes2025a.mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;


public class Ag2 extends Agent {
    
    @Override
    protected void setup(){ // configuracion inicial del agente, metodo abstracto
        addBehaviour(new Comportamiento());
    }

    
    @Override
    protected void takeDown(){
        AgentContainer contenedorAgentes = (AgentContainer)getArguments()[0];
        int i = (int) getArguments()[1];
        i += 1; 
         
         try {
            
            contenedorAgentes.createNewAgent("Agh_" + i, Agh.class.getName(), new Object[]{contenedorAgentes, i}).start(); // arrancarlo pq es un hilo
            
        } catch (StaleProxyException ex) { // si no es un agente, se ocupa el try catch
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
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

