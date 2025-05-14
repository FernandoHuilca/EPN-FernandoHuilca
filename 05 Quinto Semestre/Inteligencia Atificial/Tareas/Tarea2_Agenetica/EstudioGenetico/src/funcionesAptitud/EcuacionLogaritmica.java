package funcionesAptitud;

import Cromosoma.DecodificarCromosoma;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class EcuacionLogaritmica extends FitnessFunction {
    private int numBitsX;

    public EcuacionLogaritmica(int numBitsX) {
        this.numBitsX = numBitsX;
    }
    @Override
    protected double evaluate(IChromosome cromosoma) {
        //TODO: Preguntar a Henry cuantas veces entro aquí y de que depende
        int valorX = DecodificarCromosoma.decodificarX(cromosoma,numBitsX);
        double resultado = evaluarEcuacion(valorX);
        return (resultado < 0 ) ? 1/ (1+(-resultado)) : 1 / (1+(+resultado));
    }

    private double evaluarEcuacion(int x){
        //ESTO LO HIZO DEEPZEEK YO NO SABIA OCUPAR LOGARITMOS XD
        // Validar que x no sea negativo
        if (x < 0) {
            return 100000000;//Por propiedades de logaritmos no admite negativos así que lo que haré sera descartar
            // esos negativos dándole un numero muy enorme para la evaluate que se encargara de hacelo mínimo xd
        }

        // Calcular cada término
        double term1 = 2 * Math.log(x + 3);   // 2 * ln(x+3)
        double term2 = Math.log(2);           // ln(2)
        double term3 = Math.log(7 * x + 1);   // ln(7x + 1)

        // Combinar los términos
        return (term1 - term2) - term3;
    }
}
