public class Recipiente {
    private String color;
    private double capacidadMáximaLitros;
    private double capacidadActualLitros;
    private String material;
    private double pesoOnzas;

    public Recipiente(String color, double capacidadMáximaLitros, String material, double pesoOnzas) {
        this.color = color;
        this.capacidadMáximaLitros = capacidadMáximaLitros;
        this.material = material;
        this.pesoOnzas = pesoOnzas;
        capacidadActualLitros = 0;
    }

    public void llenar() throws RecipienteTapado {
        llenar(capacidadMáximaLitros);
    }

    public void llenar(Recipiente otroRecipiente) throws RecipienteTapado, CantidadNegativa {
        double cantidadATransferir = obtenerCapacidadResidual();
        if(cantidadATransferir > otroRecipiente.capacidadActualLitros)
            cantidadATransferir = otroRecipiente.capacidadActualLitros;
        llenar(cantidadATransferir);
        otroRecipiente.vaciar(cantidadATransferir);
    }

    public void llenar(double cantidadALlenar) throws RecipienteTapado {
        if(cantidadALlenar < 0) {
            return;
        }
        capacidadActualLitros =
                seRebasaLaCapacidad(cantidadALlenar) ?
                        capacidadMáximaLitros:
                        cantidadALlenar + capacidadActualLitros;
    }

    public void vaciar() throws CantidadNegativa {
        vaciar(capacidadMáximaLitros);
    }

    public void vaciar(double cantidadAVaciar) throws CantidadNegativa {
        if(cantidadAVaciar < 0) {
            return;
        }
        capacidadActualLitros=(capacidadActualLitros - cantidadAVaciar<0)?0:capacidadActualLitros - cantidadAVaciar;
    }

    private double obtenerCapacidadResidual() {
        return capacidadMáximaLitros - capacidadActualLitros;
    }

    private boolean seRebasaLaCapacidad(double cantidadALlenar) {
        return cantidadALlenar + capacidadActualLitros > capacidadMáximaLitros;
    }
    public void imprimirCapacidadActual() {
        System.out.println(color + ": " + capacidadActualLitros + "L.");
    }
}
