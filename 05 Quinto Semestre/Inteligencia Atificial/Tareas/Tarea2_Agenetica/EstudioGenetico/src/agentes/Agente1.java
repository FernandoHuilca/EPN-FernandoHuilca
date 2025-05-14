package agentes;

import comportamientos.CrearAgenteBehaviour;
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

import java.util.concurrent.ThreadLocalRandom;

public class Agente1 extends Agent {

    private Contenedor contenedor;
    private int numGenes;
    private int rangoDeVariacionPoblacion = 10;
    private int rangoDeVariacionGeneraciones = 20;
    private int rangoDeVariacionEvoluciones = 15;


    @Override
    protected void setup() {
        System.out.println(" AGENTE 1 LIVE ");
        //Recibir los argumentos
        this.contenedor = (Contenedor) getArguments()[0];
        this.numGenes = (int) getArguments()[1];
        //Comportamientos
        addBehaviour(new CrearAgenteBehaviour("Agente2", Agente2.class.getName(), new Object[]{contenedor, numGenes}, contenedor));
        addBehaviour(new Comportamiento());
    }

    private class Comportamiento extends Behaviour {
        boolean bandera = false; //pa salir del bucle

        @Override
        public void action() {
            //Obtener valores randoms
            int poblacion = ThreadLocalRandom.current().nextInt(1, rangoDeVariacionPoblacion);
            int generaciones = ThreadLocalRandom.current().nextInt(1, rangoDeVariacionGeneraciones);
            int evoluciones = ThreadLocalRandom.current().nextInt(1, rangoDeVariacionEvoluciones);
            //Enviamos los valores al agente 2 para que los revise
            Mensaje.enviarMensajeObjet(getAgent(),"Agente2",new NumerosEvolucion(poblacion,generaciones,evoluciones), ACLMessage.REQUEST,"Ag1-Ag2");
            //Esperamos una respuesta
            ACLMessage mensajeRecibido = blockingReceive();
            try {
                //Obtenemos un bolean de respuesta
                bandera = (boolean) mensajeRecibido.getContentObject();
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
            System.out.println("SOY AGENTE 1: Mensaje boleando recibido: " + bandera);
            if(bandera) {
                addBehaviour(new SuicidarseBehaviour(getAgent()));
            }
        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}
