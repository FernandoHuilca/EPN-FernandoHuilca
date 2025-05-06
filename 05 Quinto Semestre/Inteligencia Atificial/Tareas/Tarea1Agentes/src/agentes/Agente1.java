package agentes;

import comunicacion.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent {
    @Override
    protected void setup() {
        //Un agente puede tener más de un comportamiento Behaviour
        System.out.println("Agente 1: LIVE");
        //addBehaviour(new ComportEnviarMensajeRequest());
    }


    private class ComportEnviarMensajeRequest extends Behaviour {
        @Override
        public void action() {
            Mensaje.enviarMensaje(getAgent(),"Agente3", "Este es un mensaje del agente 1 al 3", ACLMessage.REQUEST, "AG1-AG3");
            ACLMessage confirmacion = blockingReceive();
            String confirmacionMensaje = confirmacion.getContent();
            System.out.println("La confirmación es: " + confirmacionMensaje);
        }

        @Override
        public boolean done() {
            return false;
        }
    }



    private class ComportamientoUnaVez extends OneShotBehaviour {
        @Override
        public void action() {
            Mensaje.enviarMensaje(getAgent(), "Agente2", "Hola agente2, soy tu vecino agente1", ACLMessage.REQUEST,"AG1 - AG2");
        }
    }


    private class ComportamientoCiclico extends Behaviour {
        private int contadorEjecuciones = 0; // Variable para controlar la finalización

        @Override
        public void action() {
            System.out.println("Ejecutando tarea cíclica. Iteración: " + contadorEjecuciones);
            contadorEjecuciones++;
        }

        // ¡Este es el metodo clave!
        @Override
        public boolean done() {
            // Termina después de 5 ejecuciones
            return contadorEjecuciones >= 5;
        }
    }

}
