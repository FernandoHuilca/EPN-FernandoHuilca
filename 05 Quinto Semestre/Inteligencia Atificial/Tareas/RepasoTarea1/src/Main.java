/*
* Instrucciones:
* idea es que no pueda

// Crear agentes, cuando reciba de 2,3,4, el 5 crea sus hijos

// recibe cualquier mensaje el 5, no importa, una variable global

// el hijo h le va a comunicar al agente 1 y el agente 1 le va a responder al gente h

// matar 2,3,4,5 para quedarnos con el único flujo de los hijos con el 1
*
 */

import Cliente.Cliente;
import agentes.*;
import contenedor.Contenedor;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Contenedor contenedor = new Contenedor(null, 1099, "ContenedorMian");
        contenedor.agregarAgente("MateoAgente", MateoAgente.class.getName(),new Object[]{cliente}, contenedor.getMainContainer());
        contenedor.agregarAgente("FernandoAgente", FernandoAgente.class.getName(),null, contenedor.getMainContainer());
        contenedor.iniciarUnAgente(contenedor.getMainContainer(), 1);
        contenedor.iniciarUnAgente(contenedor.getMainContainer(), 0);

        /*e cliente = new Cliente();
        //Primer paso: Crear el contenerdor para los agentes e iniciar su labor.
        Contenedor contenedor =  new Contenedor(null, 1099, "MainContainer");
        contenedor.agregarContenedorSecundario("FerContainer");
        contenedor.agregarAgente("Agente1", Agente1.class.getName(), null, contenedor.getMainContainer());
        contenedor.agregarAgente("Agent2", Agente2.class.getName(), new Object[]{cliente}, contenedor.getTodosContenedores().get(1));
        contenedor.agregarAgente("Agente3", Agente3.class.getName(), null, contenedor.getMainContainer());
        //Solo inicio dos agentes, el agente2 solo existe, pero no inicia
        contenedor.iniciarUnAgente(contenedor.getMainContainer(),1);
        contenedor.iniciarUnAgente(contenedor.getMainContainer(),0);*/
    }
}


