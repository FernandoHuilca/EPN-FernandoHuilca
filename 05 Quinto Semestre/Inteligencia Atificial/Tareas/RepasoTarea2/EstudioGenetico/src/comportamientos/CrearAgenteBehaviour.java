package comportamientos;

import agentes.Agente2;
import contenedor.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class CrearAgenteBehaviour extends OneShotBehaviour {

    private String nombreAgente;
    private String nombreClase;
    private Object[] objetos;
    private Contenedor contenedor;

    public CrearAgenteBehaviour(String nombreAgente, String nombreClase,Object[] objetos, Contenedor contenedorAGuardar ) {
        this.contenedor = contenedorAGuardar;
        this.nombreAgente = nombreAgente;
        this.nombreClase = nombreClase;
        this.objetos = objetos;
    }
    @Override
    public void action() {
        try {
            this.contenedor.agregarAgente(nombreAgente, nombreClase,objetos,contenedor.getMainContainer()).start();
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }
    }
}
