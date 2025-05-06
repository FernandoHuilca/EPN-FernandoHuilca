
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
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;



public class Agh extends Agent {
    
    @Override
    protected void setup(){ // configuracion inicial del agente, metodo abstracto
        addBehaviour(new Comportamiento());
    }
    @Override
    protected void takeDown() {
        System.out.println(" He muertooooooooooooooooooooooooooooo ");
         AgentContainer contenedorAgentes = (AgentContainer)getArguments()[0];
        int i = (int) getArguments()[1];
        i += 1; 
         
         try {
            
            contenedorAgentes.createNewAgent("Agh_" + i, Agh.class.getName(), new Object[]{contenedorAgentes, i}).start(); // arrancarlo pq es un hilo
            
        } catch (StaleProxyException ex) { // si no es un agente, se ocupa el try catch
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    class Comportamiento extends Behaviour{
        
        @Override
        public void action (){ // lo que va a hacer el agente
            System.out.println(" Agente Nuevo" + getName());
            doDelete();
        }
        @Override
        public boolean done() {
            // TODO Auto-generated method stub
            return true;
        }
        
    }
          
}
