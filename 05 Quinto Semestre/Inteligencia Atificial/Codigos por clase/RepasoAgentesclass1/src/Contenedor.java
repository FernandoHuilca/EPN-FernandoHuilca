import java.lang.System.Logger.Level;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.Logger;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;


public class Contenedor {

    public void contenedor(){

        // Runtime runtime = Runtime.instance();
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile p = new ProfileImpl(null, 1099, null);
        AgentContainer agenteContenedor = runtime.createMainContainer(p);
        agregarAgentes(agenteContenedor);
    }


    private void agregarAgentes(AgentContainer agenteContenedor){
        try{
            agenteContenedor.createNewAgent("Agent2", Ag2.class.getName(), null).start();
        }catch(StaleProxyException ex){
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
