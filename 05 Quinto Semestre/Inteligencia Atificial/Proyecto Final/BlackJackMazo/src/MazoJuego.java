import java.util.ArrayList;

public class MazoJuego {

    private int numeroDeMazos;
    ArrayList<Integer> listaDeCartas = new ArrayList<Integer>();


    public MazoJuego(int numeroDeMazos) {
        this.numeroDeMazos = numeroDeMazos;
        cargarCartas(this.numeroDeMazos);
    }

    private void cargarCartas(int numeroDeMazos) {
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
}
