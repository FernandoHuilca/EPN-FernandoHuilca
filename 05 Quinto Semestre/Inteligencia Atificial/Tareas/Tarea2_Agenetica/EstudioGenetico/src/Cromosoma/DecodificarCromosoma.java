package Cromosoma;

import org.jgap.IChromosome;

public class DecodificarCromosoma {

    public static ParXY decodificarXY(IChromosome cromosoma, int numBitsX, int numBitsY) {
        int contador = 0;

        // Decodificar X
        int signoX = (int) cromosoma.getGene(contador++).getAllele();
        String binarioX = obtenerBinario(cromosoma, contador, numBitsX);
        contador += numBitsX;
        int x = convertirBinarioADecimal(binarioX, signoX);

        // Decodificar Y
        int signoY = (int) cromosoma.getGene(contador++).getAllele();
        String binarioY = obtenerBinario(cromosoma, contador, numBitsY);
        int y = convertirBinarioADecimal(binarioY, signoY);

        return new ParXY(x, y);
    }

    private static String obtenerBinario(IChromosome cromosoma, int inicio, int longitud) {
        StringBuilder binario = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            binario.append(cromosoma.getGene(inicio + i).getAllele());
        }
        return binario.toString();
    }

    public static int convertirBinarioADecimal(String binario, int signo) {
        int valor = Integer.parseInt(binario, 2);
        return (signo == 0) ? -valor : valor;
    }

    public static int decodificarX(IChromosome iChromosome, int numBitsX) {
        int signoX = (int) iChromosome.getGene(0).getAllele();
        String resultado = obtenerBinario(iChromosome,1, numBitsX);
        return convertirBinarioADecimal(resultado, signoX);

    }

    // Clase interna para almacenar x e y
    public static class ParXY {
        private int x;
        private int y;

        public ParXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
