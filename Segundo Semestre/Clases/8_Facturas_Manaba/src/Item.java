public class Item {
    private ProductoDeVenta productoDeVenta;
    private int cantidad;
    private double valorAPagarPorTodoElItem;

    public Item(ProductoDeVenta productoDeVenta, int cantidadDeProducto) {
        this.productoDeVenta = productoDeVenta;
        this.cantidad = cantidadDeProducto;
        valorAPagarPorTodoElItem = (productoDeVenta.getPrecio() * cantidadDeProducto);
    }


    @Override
    public String toString() {
        String formatoCadena = "%-30s %-20s %-20s %-20s";
        String nombreProducto = productoDeVenta.getNombre();
        String cantidad = String.valueOf(this.cantidad);
        String precioUnitario = String.valueOf(productoDeVenta.getPrecio());
        String valorTotalItem = String.valueOf(valorAPagarPorTodoElItem);

        return String.format(formatoCadena, nombreProducto, cantidad, precioUnitario, valorTotalItem);
    }




    /************************** METODOS GET ******************************************/
    public double getIvaProducto() {
        return productoDeVenta.getIva();
    }

    public int  getCantidadProducto() {
        return cantidad;
    }

    public double getPrecio() {
        return productoDeVenta.getPrecio();
    }




}
