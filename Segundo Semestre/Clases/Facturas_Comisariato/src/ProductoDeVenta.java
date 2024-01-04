public abstract class ProductoDeVenta {

    private String nombre;
    private int cantidadEnStock;
    private double precioDeVenta;

    public ProductoDeVenta(String nombre, int cantidadEnStock, double precio) {

        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precioDeVenta = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double precioDeVenta() {
        return precioDeVenta;
    }
}
