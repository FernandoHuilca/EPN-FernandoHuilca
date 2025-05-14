package IAGenerica;

import Cromosoma.DecodificarCromosoma;
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IAGenetica {
    private Configuration configuracionGenetica;
    private FitnessFunction funcionAptitud;
    private Genotype genotipo;
    private ArrayList<IChromosome> listMejorCromosomaPorGeneracion;

    public IAGenetica(int numGenes, FitnessFunction funcionAptitud) {
        this.listMejorCromosomaPorGeneracion = new ArrayList<>(); // Para guardarme los mejores de cada generación
        Configuration.reset();
        this.configuracionGenetica = new DefaultConfiguration(); //Por defecto, cruce del 0.35%, mutación del 1/12% por gen. Poblacion inicial 50, sin funciónAptitud
        this.funcionAptitud = funcionAptitud;
        try {
            configuracionGenetica.setFitnessFunction(this.funcionAptitud);
            Gene[] cromosoma = new Gene[numGenes]; // Configura cada gen del cromosoma, pero no los "inicializa"
            for (int i = 0; i < numGenes; i++) {
                cromosoma[i] = new IntegerGene(configuracionGenetica, 0, 1); //Enteros en un rango del 0 al 1 (binario)
            }
            Chromosome ejemploChromosome = new Chromosome(configuracionGenetica, cromosoma); //Crea un cromosoma de ejemplo random
            configuracionGenetica.setSampleChromosome(ejemploChromosome); // Todos los cromosomas seguirán esta estructura
        } catch (Exception e) {
            Logger.getLogger(IAGenetica.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public void evolucionar(int numPoblacionInicial, int numGeneraciones, int numEvolucionesXGene) {
        listMejorCromosomaPorGeneracion.clear();
        try {
            configuracionGenetica.setPopulationSize(numPoblacionInicial);
            this.genotipo = Genotype.randomInitialGenotype(configuracionGenetica); //Genera una población inicial aleatoria usando la configuración definida (config).

            for (int i = 0; i < numGeneraciones; i++) {
                genotipo.evolve(numEvolucionesXGene);
                listMejorCromosomaPorGeneracion.add(genotipo.getFittestChromosome());
            }
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<IChromosome> getMejorCromosomaPorGeneracion() {
        return listMejorCromosomaPorGeneracion;
    }

}
