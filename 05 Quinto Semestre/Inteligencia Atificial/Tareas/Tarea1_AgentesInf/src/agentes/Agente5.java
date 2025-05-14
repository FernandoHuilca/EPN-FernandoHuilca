package agentes;

import comportamientos.RecibirMensajesBehaviour;
import comportamientos.SuicidarseBehaviour;
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

    private int contadorDeAgentesH;
    private Contenedor contenedor;

    @Override
    protected void setup() {
        System.out.println("AGENTE 5 LIVE");
        contenedor = (Contenedor) getArguments()[0];
        contadorDeAgentesH = (int) getArguments()[1];
        addBehaviour(new RecibirMensajesBehaviour(this,3));
        addBehaviour(new SuicidarseBehaviour(this));

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
