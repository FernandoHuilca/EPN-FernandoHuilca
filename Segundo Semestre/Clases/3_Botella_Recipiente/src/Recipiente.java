public class Recipiente {

    private String color;
    private double capacidadMáximaLitros;
    private double capacidadActualLitros;
    private String material;
    private double pesoOnzas;

    public Recipiente(String color, double capacidadMáximaLitros, String material, double pesoOnzas){
        this.color = color;
        this.capacidadMáximaLitros = capacidadMáximaLitros;
        this.material = material;
        this.pesoOnzas = pesoOnzas;
        capacidadActualLitros = 0;
    }

    public void llenarCiertaCantidad(double cantidadALlenar) throws CantidadNegativa{
        if (cantidadALlenar < 0) {
            throw new CantidadNegativa();
        }
        capacidadActualLitros =
                seRebasaLaCapacidad(cantidadALlenar) ?
                        capacidadMáximaLitros :
                        cantidadALlenar + capacidadActualLitros;
    }
    private boolean seRebasaLaCapacidad(double cantidadALlenar) {
        return cantidadALlenar + capacidadActualLitros > capacidadMáximaLitros;
    }
    public void llenarPorCompleto(){
        try {
            llenarCiertaCantidad(capacidadMáximaLitros);
        } catch (CantidadNegativa e) {
            System.out.println(e.getMessage());
        }
    }

    public void llenarConOtroRecipiente(Recipiente otroRecipiente) throws CantidadNegativa {
        if (DarMasDeLoQueRecibe(otroRecipiente)) {
            otroRecipiente.vaciarCiertaCantidad(this.espacioLibreEnRecipiente());
            this.llenarPorCompleto();
        } else {
            this.llenarCiertaCantidad(otroRecipiente.capacidadActualLitros);
            otroRecipiente.vaciarPorCompleto();
        }
    }
    private boolean DarMasDeLoQueRecibe(Recipiente otroRecipiente) {
        return otroRecipiente.capacidadActualLitros + this.capacidadActualLitros > this.capacidadMáximaLitros;
    }
    public void vaciarCiertaCantidad(double cantidadAVaciar) {
        if (capacidadActualLitros - cantidadAVaciar < 0) {
            vaciarPorCompleto();
        } else {
            capacidadActualLitros -= cantidadAVaciar;
        }
    }

    private double espacioLibreEnRecipiente() {
        return capacidadMáximaLitros - capacidadActualLitros;
    }
    public void vaciarPorCompleto() {
        capacidadActualLitros = 0;
    }
    public void imprimirCapacidadActual() {

        System.out.println(color + ": " + capacidadActualLitros + " litros");
    }

}
