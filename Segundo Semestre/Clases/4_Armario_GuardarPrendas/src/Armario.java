public class Armario {
    private int capacidadDePrendas;
    private PrendaDeVestir[] prendasDeVestir;
    private boolean cerrado;
    int prendasGuardadas;

    public Armario(int capacidadDePrendas) {
        this.capacidadDePrendas = capacidadDePrendas;
        prendasDeVestir = new PrendaDeVestir[capacidadDePrendas];
        cerrado = false;
        prendasGuardadas = 0;
    }

    public void guardar(PrendaDeVestir prendaAGuardar) {
        if (cerrado) {
            System.out.println("ERROR: El armario esta cerrado.");
            return;
        }
        if (!prendaAGuardar.estaLimpiaYEnBuenEstado()) {
            System.out.println("La camiseta no se puede guardar, por sucia o en mal estado");
            return;
        }
        if (prendaAGuardar.estaEnUso()){
            System.out.println("ERROR: la prenda esta en uso, no se puede guardar");
            return;
        }
        if (prendasGuardadas > capacidadDePrendas) {
            System.out.println("No hay mas espacio en el armario pa tantas camisetas");
            return;
        }
        prendasDeVestir[prendasGuardadas++] = prendaAGuardar;
        System.out.println("Prenda guardada con exito en el armario");
    }

    public void abrir() {

        cerrado = false;
    }

    public void cerar() {

        cerrado = true;
    }

    public PrendaDeVestir sacar(int posicionDePrendaVestir) {
        //Verificar que la posicion sea valida
        PrendaDeVestir prendaASacar = prendasDeVestir[posicionDePrendaVestir];
        return prendaASacar;
    }
}
