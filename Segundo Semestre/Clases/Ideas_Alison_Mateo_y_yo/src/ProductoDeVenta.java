public abstract class ProductoDeVenta {
    private String nombre;
    private int cantidadEnStock;
    private double precio;

    public ProductoDeVenta(String nombre, int cantidadEnStock, double precio) {
        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precio = precio;
    }
}
