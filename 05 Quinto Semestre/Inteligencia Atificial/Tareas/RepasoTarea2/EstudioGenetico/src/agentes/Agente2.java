package agentes;

import Cromosoma.DecodificarCromosoma;
import IAGenerica.IAGenetica;
import comportamientos.CrearAgenteBehaviour;
import comportamientos.EnviarMensajeBehaviour;
import comportamientos.RecibirMensajesBehaviour;
import comunicacion.Mensaje;
import comunicacion.NumerosEvolucion;
import contenedor.Contenedor;
import funcionesAptitud.EcuacionLogaritmica;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.jgap.IChromosome;

import java.util.ArrayList;

public class Agente2 extends Agent {

    private Contenedor contenedor;
    private int numGenes;
    private EcuacionLogaritmica eL;
    private int respuesta;

    @Override
    protected void setup() {
        System.out.println(" AGENTE 2 LIVE ");
        this.contenedor = (Contenedor) getArguments()[0];
        this.numGenes = (int) getArguments()[1];
        this.eL = (EcuacionLogaritmica) getArguments()[2];
        addBehaviour(new CrearAgenteBehaviour("Agente3", Agente3.class.getName(),null,contenedor));
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println(" AGENTE 2 DEAD ");
        Mensaje.enviarMensaje(this, "Agente3", "Listo acabamos la respuesta a la ecuacion es " + respuesta, ACLMessage.INFORM, "AG2-AG3");
    }

    private class Comportamiento extends Behaviour {
        boolean bandera = false;
        @Override
        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            NumerosEvolucion contenido = null;
            try {
                contenido = (NumerosEvolucion) mensajeRecibido.getContentObject();
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
            System.out.println("SOY AGENTE 2: Mensaje de números recibido: " + contenido.getNumPoblacionInicial() +
                    " " + contenido.getNumGeneraciones() + " " +  contenido.getNumEvolucionesXGene());
            IAGenetica iaGenetica = new IAGenetica(numGenes,eL);
            iaGenetica.evolucionar(contenido.getNumPoblacionInicial(), contenido.getNumGeneraciones(), contenido.getNumEvolucionesXGene());
            int valorXanterior = DecodificarCromosoma.decodificarX(iaGenetica.getMejorCromosomaPorGeneracion().getFirst(), numGenes-1) ;
            int contador = 0;
            for (IChromosome magia : iaGenetica.getMejorCromosomaPorGeneracion()){
                int valorXsiguiente = DecodificarCromosoma.decodificarX(magia,numGenes-1);
                System.out.println("Mejor valor X : " + valorXsiguiente);
                respuesta = valorXsiguiente;
                if (valorXanterior == valorXsiguiente){
                    contador++;
                }else contador = 0;
                valorXanterior = valorXsiguiente;
            }
            bandera = (contador >= 6) ? true : false;
            if (bandera){
                doDelete();
            }
            Mensaje.enviarMensajeObjet(getAgent(), "Agente1",bandera,ACLMessage.INFORM, "AG2-AG1");

        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}
