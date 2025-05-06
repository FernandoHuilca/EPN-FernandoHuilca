
package agentes2025a;

import agentes2025a.agentes.Ag1;
import agentes2025a.agentes.Ag2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenedor {
    
    
    // necesito agregar agentes a ese contenedor
    
    public void contenedor(){
        

        jade.core.Runtime runtime = jade.core.Runtime.instance(); // proceso
        Profile p = new ProfileImpl(null, 1099, null); // instanciar objeto ip (host), puerto, nombre del contenedor principal vacío
        AgentContainer agenteContenedor = runtime.createMainContainer(p);
        agregarAgentes(agenteContenedor);


        
    }
    
    private void agregarAgentes (AgentContainer agenteContenedor){
        
        try {
            
            agenteContenedor.createNewAgent("Ag2", Ag2.class.getName(), new Object[]{agenteContenedor,0}).start(); // arrancarlo pq es un hilo
            agenteContenedor.createNewAgent("Ag1", Ag1.class.getName(),  new Object[]{" hola "}).start(); // arrancarlo pq es un hilo
            
        } catch (StaleProxyException ex) { // si no es un agente, se ocupa el try catch
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
