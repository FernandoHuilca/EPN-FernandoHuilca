//Author : Fernando Huilca
//Theme : Algoritmos Genéticos


import Cromosoma.DecodificarCromosoma;
import IAGenerica.IAGenetica;
import agentes.*;
import contenedor.Contenedor;
import funcionesAptitud.EcuacionLogaritmica;
import org.jgap.IChromosome;

public class Main {
    public static void main(String[] args) {

        int numGenes = 8;
        EcuacionLogaritmica eL = new EcuacionLogaritmica(numGenes-1);


        Contenedor contenedor = new Contenedor(null, 1099, "MainContainerFerH");
        contenedor.agregarAgente("Agente1", Agente1.class.getName(),
                new Object[]{contenedor, numGenes, eL}, contenedor.getMainContainer());
        contenedor.iniciarUnAgente(contenedor.getMainContainer(), 0);





    }
}















  /* //Tomar en cuenta que si aumento los números de genes debo asignar los valores correctos de bits en la función
        IAGenetica iaGenetica = new IAGenetica(12, new FuncionEjemplo(5,5));
        iaGenetica.evolucionar(5, 7, 7);


        for (IChromosome magia : iaGenetica.getMejorCromosomaPorGeneracion()){
            DecodificarCromosoma.ParXY valorXY = DecodificarCromosoma.decodificarXY(magia,5,5);
            System.out.println("Mejor valor X : " + valorXY.getX() + ", Y : " + valorXY.getY());
        }
        //


        ______________________ Sobre la ecuacion ___________________________________
        IAGenetica iaGenetica = new IAGenetica(9, new EcuacionLogaritmica(8));
        iaGenetica.evolucionar(5,25,7);
        for (IChromosome magia : iaGenetica.getMejorCromosomaPorGeneracion()){
            int valorX = DecodificarCromosoma.decodificarX(magia,8);
            System.out.println("Mejor valor X : " + valorX);
        }


        ___________ No se puede cambiar la configuracion de poblacion una vez instanciada __________
        IAGenetica iaGenetica = new IAGenetica(9, new EcuacionLogaritmica(8));
        iaGenetica.evolucionar(5,25,7);
        for (IChromosome magia : iaGenetica.getMejorCromosomaPorGeneracion()){
            int valorX = DecodificarCromosoma.decodificarX(magia,8);
            System.out.println("Mejor valor X : " + valorX);
        }
        iaGenetica.evolucionar(4,20,7);

        */