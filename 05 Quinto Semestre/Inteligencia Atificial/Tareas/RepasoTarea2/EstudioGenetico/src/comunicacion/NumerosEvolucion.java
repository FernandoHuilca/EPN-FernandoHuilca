package comunicacion;

import java.io.Serializable;

public class NumerosEvolucion implements Serializable {

    private int numPoblacionInicial;
    private int numGeneraciones;
    private int numEvolucionesXGene;

    public NumerosEvolucion(int numPoblacionInicial, int numGeneraciones, int numEvolucionesXGene) {
        this.numPoblacionInicial = numPoblacionInicial;
        this.numGeneraciones = numGeneraciones;
        this.numEvolucionesXGene = numEvolucionesXGene;
    }

    public int getNumPoblacionInicial() {
        return numPoblacionInicial;
    }
    public int getNumGeneraciones() {
        return numGeneraciones;
    }
    public int getNumEvolucionesXGene() {
        return numEvolucionesXGene;
    }
}
