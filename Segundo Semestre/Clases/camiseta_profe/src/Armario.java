public class Armario {
    private int capacidadDeCamisetas;
    private Camiseta[] camisetas;
    private boolean cerrado;
    int camisetasGuardadas;

    public Armario(int capacidadDeCamisetas) {
        this.capacidadDeCamisetas = capacidadDeCamisetas;
        camisetas = new Camiseta[capacidadDeCamisetas];
        cerrado = false;
        camisetasGuardadas = 0;
    }

    public void guardar(Camiseta camiseta) {
        if (cerrado) {
            System.out.println("El armario esta cerrado.");
            return;
        }
        if (!camiseta.estaLimpiaYEnBuenEstado()) {
            System.out.println("La camiseta no se puede guardar, por sucia o en mal estado");
            return;
        }
        if (camisetasGuardadas > capacidadDeCamisetas) {
            System.out.println("No hay mas espacio en el armario pa tantas camisetas");
            return;
        }
        camisetas[camisetasGuardadas++] = camiseta;
    }

    public void abrir() {
        cerrado = false;
    }

    public void cerar() {

        cerrado = true;
    }

    public Camiseta sacar(int posicionDeCamisetas) {
        //Verificar que la posicion sea valida
        Camiseta camisetaASacar = camisetas[posicionDeCamisetas];
        return camisetaASacar;
    }
}
