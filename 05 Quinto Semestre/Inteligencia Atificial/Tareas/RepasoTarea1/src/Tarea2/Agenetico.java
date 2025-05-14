/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author P3E002-B
 */
public class Agenetico {

    public void configurar(int genes, int poblacionInicial, int iteracionGeneracion, int evolucion) {
        try {
            Configuration config = new DefaultConfiguration();

            FuncionAptitud fa = new FuncionAptitud();
            config.setFitnessFunction(fa);

            Gene[] sampleGene = new Gene[genes];
            for (int i = 0; i < genes; i++) {
                sampleGene[i] = new IntegerGene(config, 0, 1);
            }
            Chromosome ic = new Chromosome(config, sampleGene);
            config.setSampleChromosome(ic);
            conf_poblacion(config, poblacionInicial, iteracionGeneracion, evolucion);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(Agenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void conf_poblacion(Configuration config, int poblacionInicial, int iteracionGeneracion, int evolucion) {
        try {
            config.setPopulationSize(poblacionInicial);
            Genotype poblacion = Genotype.randomInitialGenotype(config);
            evalucionar(poblacion, iteracionGeneracion, evolucion);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(Agenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void evalucionar(Genotype poblacion, int iteracionGeneracion, int evolucion) {
        
        for (int i = 0; i < iteracionGeneracion; i++) {
            ver_poblacion(poblacion.getChromosomes());
            poblacion.evolve(evolucion);
            ver_individuo(poblacion.getFittestChromosome());
        }
        System.out.println("Optimo: ");
        ver_individuo(poblacion.getFittestChromosome());

    }
    
    private void ver_poblacion(IChromosome[] ic){
        System.out.println("------Poblacion:--------");
        for (IChromosome iChromosome : ic) {
            ver_individuo(iChromosome);
        }
        System.out.println("------------------------");
    }
    
    private void ver_individuo(IChromosome ic) {
        System.out.println("****Individuo:****");
        int signoX = (int) ic.getGene(0).getAllele();
        int x1 = (int) ic.getGene(1).getAllele();
        int x2 = (int) ic.getGene(2).getAllele();
        int x3 = (int) ic.getGene(3).getAllele();
        int x4 = (int) ic.getGene(4).getAllele();

        int signoY = (int) ic.getGene(5).getAllele();
        int y1 = (int) ic.getGene(6).getAllele();
        int y2 = (int) ic.getGene(7).getAllele();
        int y3 = (int) ic.getGene(8).getAllele();
        int y4 = (int) ic.getGene(9).getAllele();

        int x_valor = Integer.parseInt(x1 + "" + x2 + "" + x3 + "" + x4, 2);
        int y_valor = Integer.parseInt(y1 + "" + y2 + "" + y3 + "" + y4, 2);
        if (signoX == 0) {
            x_valor = -x_valor;
        }
        if (signoY == 0) {
            y_valor = -y_valor;
        }
        System.out.println("x: "+x_valor+" y: "+y_valor);
        System.out.println("**************");
    }
}
