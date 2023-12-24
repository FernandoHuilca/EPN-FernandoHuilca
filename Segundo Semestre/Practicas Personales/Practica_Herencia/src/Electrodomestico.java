public class Electrodomestico extends ProductoDeVenta {
    private String marca;

    public Electrodomestico(double precio, String marca){
        super(precio);
        this.marca = marca;
    }
}
