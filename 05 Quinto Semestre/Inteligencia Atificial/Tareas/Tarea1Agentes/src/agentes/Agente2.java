package agentes;

import Cliente.Cliente;
import jade.core.Agent;

public class Agente2 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Agente 2: LIVE");
        Cliente cliente = new Cliente();
        cliente = (Cliente) getArguments()[0];
        System.out.println("Hola soy el agente:  " + this.getClass().getName() + " el cliente es: " + cliente.getNombre());

    }
}
