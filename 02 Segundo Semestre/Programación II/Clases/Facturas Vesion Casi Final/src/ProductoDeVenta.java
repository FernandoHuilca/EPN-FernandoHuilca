
public abstract class ProductoDeVenta {
    private String nombre;
    private int cantidadEnStock;
    private double precio;
    private double IVA;

    public ProductoDeVenta(String nombre, int cantidadEnStock, double precio) {
        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precio = precio;
        IVA = IVADelProducto();
    }


    abstract double IVADelProducto();

    public double getIva() {
        return IVA;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}