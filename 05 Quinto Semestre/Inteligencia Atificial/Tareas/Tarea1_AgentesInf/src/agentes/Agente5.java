package agentes;

import contenedor.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Agente5 extends Agent {

    //TODO: los mensajes deberia guardar el agente no la clase de mensajes

    private final int NUMERO_MENSAJES_ESPERADOS = 3;
    private int contadorDeAgentesH;
    private Contenedor contenedor;

    @Override
    protected void setup() {
        System.out.println("AGENTE 5 LIVE");
        contenedor = (Contenedor) getArguments()[0];
        contadorDeAgentesH = (int) getArguments()[1];
        addBehaviour(new RecibirMensajesCompor(NUMERO_MENSAJES_ESPERADOS));
        addBehaviour(new SuicidarseCompor());

    }

    @Override
    protected void takeDown() {
        System.out.println("AGENTE 5 DEAD");
        try {
            contenedor.agregarAgente("AgenteH"+ contadorDeAgentesH, AgenteH.class.getName(),new Object[]{contenedor, contadorDeAgentesH}, contenedor.getMainContainer()).start();
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }
    }

    private class RecibirMensajesCompor extends Behaviour {
        private boolean finaliza = false;
        private int numMensajesEsperados;
        private int contadorDeMensajes = 0;
        ArrayList<String> mensajes;
        public RecibirMensajesCompor(int numMensajesEsperados) {
            this.numMensajesEsperados = numMensajesEsperados;
            mensajes = new ArrayList<>();
        }

        @Override
        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            mensajes.add(mensajeRecibido.getContent());
            //contadorDeMensajes++;
            System.out.println("SOY AGENTE 5 : Mensaje recibido: " + mensajes.get(contadorDeMensajes++));
            if (contadorDeMensajes == numMensajesEsperados) {
                finaliza = true;
            }

        }

        @Override
        public boolean done() {
            return finaliza;
        }
    }

    private class SuicidarseCompor extends OneShotBehaviour {

        @Override
        public void action() {
         doDelete();
        }
    }

    private class CrearHijo extends OneShotBehaviour {
        private String nombreAgente;
        private String nombreClase;
        private Object[] objetos;
        private AgentContainer contenedorAGuardar;

        public CrearHijo(String nombreAgente, String nombreClase, Object[] objetos, AgentContainer contenedorAGuardar) {
            this.nombreAgente = nombreAgente;
            this.nombreClase = nombreClase;
            this.objetos = objetos;
            this.contenedorAGuardar = contenedorAGuardar;
        }

        @Override
        public void action() {
            contenedor.agregarAgente(nombreAgente, nombreClase, objetos,contenedorAGuardar);
        }
    }
}
