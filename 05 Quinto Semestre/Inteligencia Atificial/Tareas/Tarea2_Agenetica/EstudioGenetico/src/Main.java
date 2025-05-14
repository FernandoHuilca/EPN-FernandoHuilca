//Author : Fernando Huilca
//Theme : Algoritmos Genéticos


import agentes.*;
import contenedor.Contenedor;

public class Main {
    public static void main(String[] args) {

        int numGenes = 10;

        Contenedor contenedor = new Contenedor(null, 1099, "MF");
        contenedor.agregarAgente("Agente1", Agente1.class.getName(),new Object[]{contenedor, numGenes}, contenedor.getMainContainer());
        contenedor.iniciarUnAgente(contenedor.getMainContainer(), 0);


    }
}