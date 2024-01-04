public class ItemCarrito {
    private ProductoDeVenta producto;
    private int cantidad;
    private double valorAPagar;

    public ItemCarrito(ProductoDeVenta producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        valorAPagar = producto.precioDeVenta() * cantidad;
    }

    public ProductoDeVenta getProducto() {
        return producto;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }


    @Override
    public String toString() {
        return "producto = " + producto.getNombre() +
                ", cantidad = " + cantidad;
    }

    public double getValorAPagar() {
    return valorAPagar;
    }
}