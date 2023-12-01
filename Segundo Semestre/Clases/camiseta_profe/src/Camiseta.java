public class Camiseta {
    private static final int NUMERO_MAX_LAVADAS = 3;
    private static final int NUMERO_MAX_ARREGLOS = 5;
    private boolean sucio;
    private boolean roto;
    private boolean destruido;
    private int numeroLavadas;
    private int numeroArreglos;
    public Camiseta() {
        sucio = false;
        roto = false;
        destruido = false;
        numeroLavadas = 0;
        numeroArreglos = 0;
    }
    public void usar() {
        if(sucio){
            System.out.println("No se puede usar camiseta sucia");
            return;
        }
        if(roto || destruido){
            System.out.println("No se puede usar camiseta en mal estado");
            return;
        }
        sucio = true;
    }
    public void lavar() {
        sucio = false;
        numeroLavadas++;
        if(seHaLavadoMuchasVeces()) {
            roto = true;
            reiniciarLavadas();
        }
    }

    public void arreglar() {
        roto = false;
        numeroArreglos++;
        if(seHaArregladoMuchasVeces())
            destruido = true;
    }
    private void reiniciarLavadas() {
        numeroLavadas = 0;
    }
    private boolean seHaLavadoMuchasVeces() {
        return numeroLavadas >= NUMERO_MAX_LAVADAS;
    }
    private boolean seHaArregladoMuchasVeces() {
        return numeroArreglos >= NUMERO_MAX_ARREGLOS;
    }
    @Override
    public String toString() {
        return "Estado: " +
                (sucio ? "Sucia" : "Limpia") + ", " +
                (destruido ? "Destruido" : (roto ? "Roto" : "Buen estado"));
    }

    public boolean estaLimpiaYEnBuenEstado() {
        return !sucio && !roto && !destruido;
    }
}