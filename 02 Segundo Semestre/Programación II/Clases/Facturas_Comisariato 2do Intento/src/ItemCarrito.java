public class ItemCarrito {
    private ProductoDeVenta producto;
    private int cantidad;
    private double valorAPagarPortodoElItem;
    private double valorAPagarDelIVAPorTodoElItem;

    public ItemCarrito(ProductoDeVenta producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        valorAPagarPortodoElItem = producto.getPrecio() * cantidad;
        valorAPagarDelIVAPorTodoElItem = producto.getIVA() * cantidad;
    }

    public ProductoDeVenta getProducto() {
        return producto;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }


    @Override
    public String toString() {
        return " " + producto.getNombre() +
                "           " + cantidad + "                   " + producto.getPrecio() + "               " + valorAPagarPortodoElItem;
    }

    public double getValorAPagarPortodoElItem() {
    return valorAPagarPortodoElItem;
    }

    public double getValorAPagarDelIVAPorTodoElItem() {
        return valorAPagarDelIVAPorTodoElItem;
    }
}