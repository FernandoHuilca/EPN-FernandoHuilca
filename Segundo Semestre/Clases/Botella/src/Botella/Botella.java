package Botella;

public class Botella {
    private String color;
    private double capacidadMáximaLitros;
    private double capacidadActualLitros;
    private String material;
    private double pesoOnzas;
    private boolean tapado;

    public Botella(String color, double capacidadMáximaLitros, String material, double pesoOnzas) {
        this.color = color;
        this.capacidadMáximaLitros = capacidadMáximaLitros;
        this.material = material;
        this.pesoOnzas = pesoOnzas;
        tapado = true;
        capacidadActualLitros = 0;
    }

    public void llenarCiertaCantidad(double cantidadALlenar) {
        if (estaTapado()) {
            return;
        }
        if (cantidadALlenar < 0) {
            return;
        }
        capacidadActualLitros =
                seRebasaLaCapacidad(cantidadALlenar) ?
                        capacidadMáximaLitros :
                        cantidadALlenar + capacidadActualLitros;
    }

    public void llenarPorCompleto() {
        llenarCiertaCantidad(capacidadMáximaLitros);
    }

    /*public void llenarConOtraBotella(Botella otraBotella) {
        if (otraBotella.estaTapado() || this.estaTapado()) {
            return;
        }
        this.llenarCiertaCantidad(otraBotella.capacidadActualLitros);
        otraBotella.vaciarPorCompleto(); // solo sale bien porque la otra botella es más grande
    }*/
    public void llenarConOtraBotella(Botella otraBotella) {
        if (estaTapado() || otraBotella.estaTapado()) {
            return;
        }
        if (DarMasDeLoQueRecibe(otraBotella)) {
            otraBotella.vaciarCiertaCantidad(capacidadMáximaLitros);
            this.llenarPorCompleto();
        } else {
            this.llenarCiertaCantidad(otraBotella.capacidadActualLitros);
            otraBotella.vaciarPorCompleto();
        }
    }

    private boolean DarMasDeLoQueRecibe(Botella otraBotella) {
        return otraBotella.capacidadActualLitros + this.capacidadActualLitros > this.capacidadMáximaLitros;
    }

    public void vaciarCiertaCantidad(double cantidadAVaciar) {
        if (estaTapado() || cantidadAVaciar < 0) {
            return;
        }
        if (capacidadActualLitros - cantidadAVaciar < 0) {
            vaciarPorCompleto();
        } else {
            capacidadActualLitros -= cantidadAVaciar;
        }
    }


    private boolean seRebasaLaCapacidad(double cantidadALlenar) {
        return cantidadALlenar + capacidadActualLitros > capacidadMáximaLitros;
    }

    public void vaciarPorCompleto() {
        if (estaTapado()) {
            return;
        }
        capacidadActualLitros = 0;
    }

    private boolean estaTapado() {
        return tapado;
    }

    public void destapar() {
        tapado = false;
    }


    public void tapar() {
        tapado = true;
    }

    public void imprimirCapacidadActual() {
        System.out.println(color + ": " + capacidadActualLitros + " litros");
    }
}