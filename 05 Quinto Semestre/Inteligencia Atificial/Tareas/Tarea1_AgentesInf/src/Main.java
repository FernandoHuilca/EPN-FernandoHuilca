import agentes.*;
import agentesExtras.AgentTest;
import contenedor.Contenedor;

//Author: Fernando Huilca

   public class Main {
    public static void main(String[] args) {

        int contadorDeAgentesH = 0;

        Contenedor contenedor = new Contenedor(null, 1099, "ContenedorFerMain");
        contenedor.agregarAgente("Agente5", Agente5.class.getName(), new Object[]{contenedor, contadorDeAgentesH}, contenedor.getMainContainer());
        contenedor.agregarAgente("Agente4", Agente4.class.getName(), null, contenedor.getMainContainer());
        contenedor.agregarAgente("Agente3", Agente3.class.getName(), null, contenedor.getMainContainer());
        contenedor.agregarAgente("Agente2", Agente2.class.getName(), null, contenedor.getMainContainer());
        contenedor.agregarAgente("Agente1", Agente1.class.getName(), null, contenedor.getMainContainer());
        contenedor.iniciarTodosLosAgentes();
       /* if(contenedor.agregarContenedorSecundario("ContenedorSecundario0")){
            System.out.println("Se agregó un contenedor secundario correctamente");
        };
        contenedor.agregarAgente("AgentTest", AgentTest.class.getName(), null, contenedor.getTodosContenedores().get(1));
        contenedor.iniciarUnAgente(contenedor.getTodosContenedores().get(1), 0); */

    }
}