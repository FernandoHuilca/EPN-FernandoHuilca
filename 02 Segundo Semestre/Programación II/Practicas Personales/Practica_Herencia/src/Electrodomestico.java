public class Electrodomestico extends ProductoDeVenta {
    private String marca;

    public Electrodomestico(double precio, String marca, String nombre){
        super(precio, nombre);
        this.marca = marca;
    }
}
