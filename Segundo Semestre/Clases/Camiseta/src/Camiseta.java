public class Camiseta {
    private String color;
    private String talla;
    private boolean estadoDeLimpieza;
    private boolean daño;
    private boolean estadoDeUsoActual; //true usar false no usar
    private int arreglos;
    private int lavados;

    public Camiseta(String color, String talla) {
        this.color = color;
        this.talla = talla;
        this.arreglos = 0;
        this.lavados = 0;
        this.estadoDeLimpieza = true;
        this.daño = false; // true significa que esta daniada
    }


    public void ponerse() {
        if (arreglos == 5) {
            return;
        }
        if ((estadoDeLimpieza) && (!daño) ) {
            estadoDeUsoActual = true;
        }
    }


    public void sacarse() {
        estadoDeUsoActual = false;
        estadoDeLimpieza = false;
    }

    public void lavar() {
        if (estadoDeUsoActual) {
            return;
        }
        if (!estadoDeLimpieza) {
            estadoDeLimpieza = true;
            lavados++;
            if (lavados == 3)
            {
                daño = true;
                lavados = 0;
            }
        }
    }

    public void arreglar() {
        if (estadoDeUsoActual){
            return;
        }
        if (daño) {
            daño = false;
            arreglos++;
        }
    }

    public void imprimirEstadoDeUso() {
        if (estadoDeUsoActual) {
            System.out.println("La camiseta SI esta en uso ");
        } else {
            System.out.println("La camiseta NO esta en uso");
        }
    }
}

