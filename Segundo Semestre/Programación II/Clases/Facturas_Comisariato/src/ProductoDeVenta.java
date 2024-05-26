public abstract class ProductoDeVenta {

    private String nombre;
    private int cantidadEnStock;
    private double precio;
    private double precioIVA;

    public ProductoDeVenta(String nombre, int cantidadEnStock, double precio) {

        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precio = precio;
        this.precioIVA = calcularIVA(precio);
    }


    abstract double calcularIVA(double precio);

    public String getNombre() {
        return nombre;
    }


    public double getPrecio() {
        return precio;
    }

    public double getIVA() {
        return precioIVA;
    }
}
