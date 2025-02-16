public class ProductoDeVenta {
    private double precio;
    private String nombre;
    private int codigoDeBarras; //TODO: Hacer una clase CódigoDeBarra y estudiar como funciona eso jeje (Sé que es única)

    public ProductoDeVenta(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
    return nombre;
    }
}
