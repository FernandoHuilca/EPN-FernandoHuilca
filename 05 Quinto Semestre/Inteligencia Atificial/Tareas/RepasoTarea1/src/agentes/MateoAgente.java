package agentes;

import Cliente.Cliente;
import comunicacion.Mensaje;
import contenedor.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class MateoAgente extends Agent {
    private Cliente nuevoCliente;

    @Override
    protected void setup() {
        nuevoCliente = (Cliente) getArguments()[0];
        System.out.println("Agente Mateo" + nuevoCliente.getNombre());
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("MORIRÉ DE PENA");
        //No se puede porque al parecer solo puede haber un contenedor por maquina
        //Contenedor contenedor = new Contenedor("192.168.1.10", 1099, null);
        //contenedor.agregarAgente("Agente1", Agente1.class.getName(), null, contenedor.getMainContainer());
        //contenedor.iniciarTodosLosAgentes();
    }

    private class Comportamiento extends OneShotBehaviour {
        @Override
        public void action() {
            Mensaje.enviarMensaje(getAgent(),"FernandoAgente", "Hola Fer, casate conmigo?", ACLMessage.REQUEST, "AGMA-AGFER");
            ACLMessage mensaje = blockingReceive();
            String mensajeRecibido = mensaje.getContent();
            System.out.println("mensajeRecibido: " + mensajeRecibido);
            doDelete();
        }


    }
}
