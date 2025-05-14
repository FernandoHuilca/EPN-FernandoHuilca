package agentes;

import comportamientos.CrearAgenteBehaviour;
import comunicacion.Mensaje;
import comunicacion.NumerosEvolucion;
import contenedor.Contenedor;
import funcionesAptitud.EcuacionLogaritmica;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.util.concurrent.ThreadLocalRandom;

public class Agente1 extends Agent {

    private Contenedor contenedor;
    private int numGenes;
    private int rangoDeVariacionPoblacion = 10;
    private int rangoDeVariacionGeneraciones = 20;
    private int rangoDeVariacionEvoluciones = 15;

    private EcuacionLogaritmica eL;

    @Override
    protected void setup() {
        System.out.println(" AGENTE 1 LIVE ");
        this.contenedor = (Contenedor) getArguments()[0];
        this.numGenes = (int) getArguments()[1];
        this.eL = (EcuacionLogaritmica) getArguments()[2];
        addBehaviour(new CrearAgenteBehaviour("Agente2", Agente2.class.getName(),new Object[]{contenedor, numGenes, eL},contenedor));
        addBehaviour(new Comportamiento(this));

    }

    @Override
    protected void takeDown() {
        System.out.println(" AGENTE 1 DEAD ");
    }

    private class Comportamiento extends Behaviour {
        private Agent agente;
        boolean bandera = false;

        public Comportamiento(Agent agente) {
            this.agente = agente;
        }

        @Override
        public void action() {
            int poblacion = ThreadLocalRandom.current().nextInt(3, rangoDeVariacionPoblacion);
            int generaciones = ThreadLocalRandom.current().nextInt(3, rangoDeVariacionGeneraciones);
            int evoluciones = ThreadLocalRandom.current().nextInt(3, rangoDeVariacionEvoluciones);
            Mensaje.enviarMensajeObjet(getAgent(),"Agente2",new NumerosEvolucion(poblacion,generaciones,evoluciones), ACLMessage.REQUEST,"Ag1-Ag2");
            ACLMessage mensajeRecibido = blockingReceive();
            try {
                bandera = (boolean) mensajeRecibido.getContentObject();
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
            System.out.println("SOY AGENTE 1: Mensaje boleando recibido: " + bandera);
            if (bandera){
                doDelete();
            }
        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}
