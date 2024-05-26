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

    public void guardar(PrendaDeVestir prendaDeVestir) {
        if (cerrado) {
            System.out.println("El armario esta cerrado.");
            return;
        }
        if (!prendaDeVestir.estaLimpiaYEnBuenEstado()) {
            System.out.println("La camiseta no se puede guardar, por sucia o en mal estado");
            return;
        }
        if (prendasGuardadas > capacidadDePrendas) {
            System.out.println("No hay mas espacio en el armario pa tantas camisetas");
            return;
        }
        prendasDeVestir[prendasGuardadas++] = prendaDeVestir;
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
