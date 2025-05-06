import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MazoJuego {

    private int numeroDeMazos;
    ArrayList<Integer> listaDeCartas = new ArrayList<Integer>();
    Random rand = new Random() ;

    public MazoJuego(int numeroDeMazos) {
        this.numeroDeMazos = numeroDeMazos;
        cargarCartas(this.numeroDeMazos);
    }

    private void cargarCartas(int numeroDeMazos) {
        listaDeCartas.removeAll(listaDeCartas);
        while (numeroDeMazos > 0) {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    if ( i == 11 || i == 12 || i == 13) {
                        listaDeCartas.add(10);
                    }else listaDeCartas.add(i);
                }
            }
            numeroDeMazos--;
        }

    }
    public ArrayList<Integer> getListaDeCartas() {
        return listaDeCartas;
    }

    public void imprimirCartas() {
        for (int i = 0; i < listaDeCartas.size(); i++) {
            System.out.println("Cartas " + listaDeCartas.get(i));
        }
    }

    public int getCartaAleatoria(){
        if (listaDeCartas.isEmpty()) {
            return 0;
        }
        int numAzar = rand.nextInt(listaDeCartas.size());
        return listaDeCartas.remove(numAzar);
        
    }
    public void cargarNuevamenteMazo(){
        cargarCartas(numeroDeMazos);
    }

    public void barajar(ArrayList<Integer> mazo, int numVeces) {
    Random rand = new Random();
    for (int i = 0; i < numVeces; i++) {
        // Algoritmo de Fisher-Yates
        for (int j = mazo.size() - 1; j > 0; j--) {
            int k = rand.nextInt(j + 1);
            Collections.swap(mazo, j, k);
        }
    }
}
}
