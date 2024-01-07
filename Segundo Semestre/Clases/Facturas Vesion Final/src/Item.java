public class Item {
    private ProductoDeVenta productoDeVenta;
    private int cantidad;
    private double valorAPagarPorTodoElItem;

    public Item(ProductoDeVenta productoDeVenta, int cantidadDeProducto) {
        this.productoDeVenta = productoDeVenta;
        this.cantidad = cantidadDeProducto;
        valorAPagarPorTodoElItem = (productoDeVenta.getPrecio() * cantidadDeProducto);
    }

    public double getIvaProducto() {
        return productoDeVenta.getIva();
    }

    public int  getCantidadProducto() {
        return cantidad;
    }

    public double getPrecio() {
        return productoDeVenta.getPrecio();
    }


    @Override
    public String toString() {
        return " " + productoDeVenta.getNombre() +
                "           " + cantidad + "                   " + productoDeVenta.getPrecio() + "               " + valorAPagarPorTodoElItem;
    }
}
