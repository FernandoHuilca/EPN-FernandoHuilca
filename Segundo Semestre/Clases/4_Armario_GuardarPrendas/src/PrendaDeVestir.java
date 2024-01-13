public class PrendaDeVestir {
    public int numMaximoLavadas;
    public int numMaximoArregladas;
    // la camiseta esta y tiene:
    private String color;
    private boolean sucio ;
    private boolean daniada;
    private boolean estadoDeUso;
    private int arreglos;
    private int lavados;
    private boolean danioIrreparable;

    public PrendaDeVestir(String color, int numMaximoLavadas, int numMaximoArregladas) {
        this.color = color;
        this.sucio = false;
        this.daniada = false;
        this.estadoDeUso = false;
        this.arreglos = 0;
        this.lavados = 0;
        this.danioIrreparable = false;
        this. numMaximoLavadas = numMaximoLavadas;
        this.numMaximoArregladas = numMaximoArregladas;
    }

    public void ponerPrenda() {
        if (danioIrreparable){
            System.out.println("ERROR: la prenda esta daniada definitivamente no puede ponerse");
            return;
        }
        if (daniada){
            System.out.println("ERROR: la preda esta daniada, no puede usarse");
            return;
        }
        if (sucio ){
            System.out.println("ERROR: la prenda esta sucia, no se puede usar");
            return;
        }
        estadoDeUso = true;
        System.out.println("Listo, ahora la prenda se esta usando");
    }
    public void sacarPrenda() {
        if (!estadoDeUso) {
            System.out.println("ERROR: no se puede sacar la prenda porque no la esta usando");
            return;
        }
        estadoDeUso = false;
        sucio = true;
        System.out.println("Listo, ahora la prenda no esta en uso pero sí sucia");
    }
    public void imprimirEstadoDeUso() {
        if (estadoDeUso) {
            System.out.println("La prenda SI esta en uso.");
        } else {
            System.out.println("La prenda NO esta en uso.");
        }
    }

    public void lavarPrenda() {
        if (sucio && !estadoDeUso) {
            sucio = false;
            lavados++;
            if (lavados == numMaximoLavadas) {
                daniada = true;
                lavados = 0;
            }
            return;
        }
        System.out.println("ERROR: no se puede lavar la prenda porque la estan ocupando");
    }

    public void arreglarPrenda() {
        if (daniada && !estadoDeUso){
            daniada = false;
            arreglos++;
            if (arreglos == numMaximoArregladas){
                danioIrreparable = true;
            }
            return;
        }
        System.out.println("ERROR: no se puede arreglar la camiseta porque no esta daniada");
    }


    public boolean estaLimpiaYEnBuenEstado() {
        return !sucio && !daniada && !danioIrreparable;
    }

    public boolean estaEnUso() {
        return estadoDeUso;
    }
}
