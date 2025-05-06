package agentes;

import comunicacion.Mensaje;
import contenedor.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;

public class AgenteH extends Agent {
    private final int NUMERO_MENSAJES_ESPERADOS = 1;
    private int contadorDeAgentesH;
    private Contenedor contenedor;
    @Override
    protected void setup() {
        contenedor = (Contenedor) getArguments()[0];
        contadorDeAgentesH = (int) getArguments()[1];
        addBehaviour(new EnviarMensajeCompor("Agente1", "Hola soy el agente H" + contadorDeAgentesH + " si me respondes muero xd", ACLMessage.REQUEST, "AGH-AG1"));
        addBehaviour(new RecibirMensajesCompor(NUMERO_MENSAJES_ESPERADOS));
        addBehaviour(new SuicidarseCompor());
    }

    @Override
    protected void takeDown() {
        System.out.println("AGENTE H" + contadorDeAgentesH + " DEAD");
        contadorDeAgentesH++;
        try {
            contenedor.agregarAgente("AgenteH" + contadorDeAgentesH, AgenteH.class.getName(),new Object[]{contenedor, contadorDeAgentesH}, contenedor.getMainContainer()).start();
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }
    }

    private class EnviarMensajeCompor extends OneShotBehaviour {

        private String receptor;
        private String mensaje;
        private int tipoComunicacion;
        private String idConversacion;

        public EnviarMensajeCompor(String receptor, String mensaje, int tipoComunicacion, String idConversacion) {
            this.receptor = receptor;
            this.tipoComunicacion = tipoComunicacion;
            this.mensaje = mensaje;
            this.idConversacion = idConversacion;
        }

        @Override
        public void action() {
            Mensaje.enviarMensaje(getAgent(),receptor,mensaje,tipoComunicacion,idConversacion);
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
            System.out.println("SOY AGENTE H" + contadorDeAgentesH + " : Mensaje recibido: " + mensajes.get(contadorDeMensajes++));
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
}
