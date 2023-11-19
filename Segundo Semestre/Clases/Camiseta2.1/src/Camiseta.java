public class Camiseta {

    private String color;
    private String talla;
    private boolean suciedad;
    private boolean danio;
    private boolean estadoDeUso;
    private int arreglos;
    private int lavados;
    private boolean danioIrreparable;

    public Camiseta(String color, String talla) {
        this.color = color;
        this.talla = talla;
        this.suciedad = false;
        this.danio = false;
        this.estadoDeUso = false;
        this.arreglos = 0;
        this.lavados = 0;
        this.danioIrreparable = false;
    }


    public void poner() {
        if (!suciedad && !danio && !danioIrreparable) {
            estadoDeUso = true;
        }

    }

    public void sacar() {
        if (estadoDeUso) {
            estadoDeUso = false;
            suciedad = true;
        }
    }

    public void imprimirEstadoDeUso() {
        if (estadoDeUso) {
            System.out.println("La camiseta SI esta en uso.");
        } else {
            System.out.println("La camiseta NO esta en uso.");
        }
    }

    public void lavar() {
        if (suciedad && !estadoDeUso) {
            suciedad = false;
            lavados++;
            if (lavados == 3) {
                danio = true;
                lavados = 0;
            }
        }
    }

    public void arreglar() {
        if (danio && !estadoDeUso){
            danio = false;
            arreglos++;
            if (arreglos == 5){
                danioIrreparable = true;
            }
        }
    }
}
