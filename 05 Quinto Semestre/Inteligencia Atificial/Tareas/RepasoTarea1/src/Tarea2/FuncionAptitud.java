
package Tarea2;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author P3E002-B
 */
public class FuncionAptitud extends FitnessFunction{

    @Override
    protected double evaluate(IChromosome ic) {
        //crear la funcion
        return individuo(ic);
    }
    private double individuo(IChromosome ic){
        int signoX = (int)ic.getGene(0).getAllele();
        int x1 = (int)ic.getGene(1).getAllele();
        int x2 = (int)ic.getGene(2).getAllele();
        int x3 = (int)ic.getGene(3).getAllele();
        int x4 = (int)ic.getGene(4).getAllele();
        
        int signoY = (int)ic.getGene(5).getAllele();
        int y1 = (int)ic.getGene(6).getAllele();
        int y2 = (int)ic.getGene(7).getAllele();
        int y3 = (int)ic.getGene(8).getAllele();
        int y4 = (int)ic.getGene(9).getAllele();
        
        int x_valor = Integer.parseInt(x1+""+x2+""+x3+""+x4, 2);
        int y_valor = Integer.parseInt(y1+""+y2+""+y3+""+y4, 2);
        if (signoX==0){
            x_valor = -x_valor;
        }
        if (signoY==0){
            y_valor = -y_valor;
        }
        double score = 450-(x_valor*x_valor + y_valor*y_valor);
        return score;
    }
}
