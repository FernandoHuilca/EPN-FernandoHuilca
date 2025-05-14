package comportamientos;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class RecibirMensajesBehaviour extends Behaviour {
    private boolean finaliza = false;
    private int numMensajesEsperados;
    private int contadorDeMensajes = 0;
    ArrayList<String> mensajes;

    public RecibirMensajesBehaviour(Agent agente, int numMensajesEsperados) {
        super(agente);
        this.numMensajesEsperados = numMensajesEsperados;
        mensajes = new ArrayList<>();
    }

    @Override
    public void action() {
        ACLMessage mensajeRecibido = getAgent().blockingReceive();
        mensajes.add(mensajeRecibido.getContent());
        System.out.println("SOY AGENTE  " + getAgent().getName() +"  : Mensaje recibido: " + mensajes.get(contadorDeMensajes++));
        if (contadorDeMensajes == numMensajesEsperados) {
            finaliza = true;
        }
    }

    @Override
    public boolean done() {
        return finaliza;
    }
}
