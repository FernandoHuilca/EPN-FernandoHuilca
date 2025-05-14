package contenedor;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Contenedor {

    private Map<AgentContainer, ArrayList<AgentController>> contenedorYAgentes;
    private Profile perfilMain;
    private jade.core.Runtime runtime;
    private String hostIP;
    private int puertoMain;
    private AgentContainer mainContainer;
    //Vamos a configurar este contenedor y agregar agentes al mismo.

    public Contenedor(String hostIP, int puerto, String nombreMainContainer) {
        this.hostIP = hostIP;
        this.puertoMain = puerto;
        this.contenedorYAgentes = new HashMap<AgentContainer, ArrayList<AgentController>>();
        this.runtime = jade.core.Runtime.instance();        // obtener la Instancia singleton del entorno jade, (nucleo de JADE)
        this.perfilMain = new ProfileImpl(hostIP, puerto, nombreMainContainer);   // Configuramos al contenedor con el host puerto y un nombre
        this.mainContainer = runtime.createMainContainer(perfilMain);
        contenedorYAgentes.put(mainContainer,new ArrayList<>()); // Usamos a runtime que es el nucleo de JADE y le decimos que nos cree un contenedor con el perfil antes creado
    }

    public boolean agregarContenedorSecundario(String nombreContenedor) {
        //Como este nuevo contenedor tienen relación con el actual vamos a crear un perfin con el mismo hostIp y puerto nombre diferente
        Profile perfilSecundario = new ProfileImpl();
        perfilSecundario.setParameter(Profile.MAIN_HOST, hostIP);
        perfilSecundario.setParameter(Profile.MAIN_PORT, String.valueOf(puertoMain));
        perfilSecundario.setParameter(Profile.CONTAINER_NAME, nombreContenedor);

        AgentContainer nuevoContenedor = runtime.createAgentContainer(perfilSecundario);
        contenedorYAgentes.put(nuevoContenedor, new ArrayList<>());
        return true;
    }

    public AgentController agregarAgente(String nombreAgente, String nombreClase,Object[] objetos, AgentContainer contenedorAGuardar) {
        try {
            AgentController nuevoAgente = contenedorAGuardar.createNewAgent(nombreAgente,nombreClase,objetos);
            contenedorYAgentes.get(contenedorAGuardar).add(nuevoAgente);
            return nuevoAgente;
        } catch (StaleProxyException e) {
            return null;
        }
    }

    public boolean iniciarUnAgente(AgentContainer contenedor, int numListAgentes) {
        try {
            contenedorYAgentes.get(contenedor).get(numListAgentes).start();
            return true;
        } catch (StaleProxyException e) {
            return false;
        }
    }

    public boolean iniciarTodosLosAgentesContenedor(AgentContainer contenedor) {
        for (AgentController agente : contenedorYAgentes.get(contenedor)) {
            try {
                agente.start();
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public boolean iniciarTodosLosAgentes() {
        boolean exitoTotal = true;
        for (AgentContainer contenedor : contenedorYAgentes.keySet()) {
            if (!iniciarTodosLosAgentesContenedor(contenedor)) {
                exitoTotal = false;
            }
        }
        return exitoTotal;
    }
    public boolean detenerContenedor(AgentContainer contenedor) {
        if (!contenedorYAgentes.containsKey(contenedor)) {
            return false;
        }
        try {
            contenedor.kill();
            contenedorYAgentes.remove(contenedor);
            return true;
        } catch (StaleProxyException e) {
            return false;
        }
    }
    // Métodos auxiliares
    public AgentContainer getMainContainer() {
        return mainContainer;
    }

    public ArrayList<AgentContainer> getTodosContenedores() {
        return new ArrayList<>(contenedorYAgentes.keySet());
    }

}
