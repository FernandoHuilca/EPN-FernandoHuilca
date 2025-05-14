package funcionesAptitud;

import Cromosoma.DecodificarCromosoma;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionEjemplo extends FitnessFunction {
    private int numBitsX; // número de bits para x , sin incluir el signo
    private int numBitsY; // Número de bits para y , sin incluir el signo
    private int numeroNegativoMinimo;

    public FuncionEjemplo(int numBitsX, int numBitsY) {
        this.numBitsX = numBitsX;
        this.numBitsY = numBitsY;
        String binarioMaximoX = "";
        for (int i = 0; i < numBitsX; i++) {
            binarioMaximoX += "1";
        }
        String binarioMaximoY = "";
        for (int i = 0; i < numBitsY; i++) {
            binarioMaximoY += "1";
        }
        this.numeroNegativoMinimo = DecodificarCromosoma.convertirBinarioADecimal(binarioMaximoX, 1) + DecodificarCromosoma.convertirBinarioADecimal(binarioMaximoY, 1);

    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        DecodificarCromosoma.ParXY decodificarCXY = DecodificarCromosoma.decodificarXY(cromosoma, numBitsX, numBitsY);
        return ((decodificarCXY.getX() - decodificarCXY.getY()) + numeroNegativoMinimo);
    }
}
