public class Cliente {

    private String nombre;
    private CarritoCompras carritoCompras;

    public Cliente(String nombre){
        this.nombre = nombre;
        carritoCompras = new CarritoCompras();
    }

    public void agregarAlCarrito(ProductoDeVenta productoDeVenta, int cantidadDelProducto) {
        carritoCompras.agregarProducto(productoDeVenta, cantidadDelProducto);
    }

    public CarritoCompras devolverCarritoDeCompras() {
    return carritoCompras;
    }

    public String getNombre() {
        return nombre;
    }
}
