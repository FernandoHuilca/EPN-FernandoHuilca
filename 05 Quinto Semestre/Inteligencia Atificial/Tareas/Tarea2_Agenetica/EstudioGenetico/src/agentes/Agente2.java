package agentes;

import Cromosoma.DecodificarCromosoma;
import IAGenerica.IAGenetica;
import comportamientos.CrearAgenteBehaviour;
import comportamientos.EnviarMensajeBehaviour;
import comportamientos.RecibirMensajesBehaviour;
import comportamientos.SuicidarseBehaviour;
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
    private int respuesta;
    private final int valorRepetidoAceptado = 15;

    @Override
    protected void setup() {
        System.out.println(" AGENTE 2 LIVE ");
        this.contenedor = (Contenedor) getArguments()[0];
        this.numGenes = (int) getArguments()[1];
        addBehaviour(new CrearAgenteBehaviour("Agente3", Agente3.class.getName(),null,contenedor));
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        Mensaje.enviarMensaje(this, "Agente3", "Listo, acabamos. La respuesta a la ecuación es " + respuesta, ACLMessage.INFORM, "AG2-AG3");
    }

    private class Comportamiento extends Behaviour {
        boolean bandera = false; //Para salir del bucle
        @Override
        public void action() {
            //Esperar el mensaje del agente 1
            ACLMessage mensajeRecibido = blockingReceive();
            //Objeto para recibir los valores de poblacion, generaciones y evoluciones
            NumerosEvolucion contenido = null;
            try {
                contenido = (NumerosEvolucion) mensajeRecibido.getContentObject();
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }

            System.out.println("SOY AGENTE 2: Mensaje de números recibido: " + contenido.imprimirNumeros());
            // Creo la iaGenética y le paso la función de Aptitud luego la hago evolucionar
            IAGenetica iaGenetica = new IAGenetica(numGenes, new EcuacionLogaritmica(numGenes - 1));
            iaGenetica.evolucionar(contenido.getNumPoblacionInicial(), contenido.getNumGeneraciones(), contenido.getNumEvolucionesXGene());


            int contadorActual = 0;
            int valorAnterior = DecodificarCromosoma.decodificarX(iaGenetica.getMejorCromosomaPorGeneracion().getFirst(), numGenes-1);
            for (IChromosome magia : iaGenetica.getMejorCromosomaPorGeneracion()){
                int valorActual = DecodificarCromosoma.decodificarX(magia,numGenes-1);
                System.out.println("Mejor valor X : " + valorActual);
                respuesta = valorActual;
                if (valorActual == valorAnterior) {
                    contadorActual++;
                } else {
                    contadorActual = 0; // Nueva secuencia
                }
                valorAnterior = valorActual;
            }
            bandera = (contadorActual >= valorRepetidoAceptado /*&& (valorAnterior == 7 || valorAnterior == 1)*/);
            //bandera = (contadorActual >= valorRepetidoAceptado);
            if(bandera){
                addBehaviour(new SuicidarseBehaviour(getAgent()));
            }
            Mensaje.enviarMensajeObjet(getAgent(), "Agente1",bandera,ACLMessage.INFORM, "AG2-AG1");

        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}



