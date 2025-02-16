
public class Botella extends Recipiente {

    private boolean tapado;

    public Botella(String color, double capacidadMáximaLitros, String material, double pesoOnzas) {
        super(color, capacidadMáximaLitros, material, pesoOnzas);
        tapado = true;
    }

    public void llenarCiertaCantidad(double cantidadALlenar) {
        if (estaTapado()) {
            System.out.println("No se puede llenar porque la botella esta tapada");
            return;
        }
        try {
            super.llenarCiertaCantidad(cantidadALlenar);
        } catch (CantidadNegativa e) {
            System.out.println(e.getMessage());
        }
    }

    public void llenarConOtraBotella(Botella otraBotella)  {
        if (estaTapado() || otraBotella.estaTapado()) {
            System.out.println("ERROR: La botella esta tapada no se puede llenar con el otro recipiente");
            return;
        }
        try {
            super.llenarConOtroRecipiente(otraBotella);
        } catch (CantidadNegativa e) {
            System.out.println(e.getMessage());
        }
    }


    public void vaciarPorCompleto() {
        if (estaTapado()) {
            return;
        }
        super.vaciarPorCompleto();
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


}