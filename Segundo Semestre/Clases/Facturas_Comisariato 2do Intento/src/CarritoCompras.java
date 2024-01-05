
public class CarritoCompras {
    private ItemCarrito[] productosEnCarrito;
    private int contadorItems;

    public CarritoCompras() {
        productosEnCarrito = new ItemCarrito[1000];
        contadorItems = 0;
    }

    public void agregarProducto(ProductoDeVenta productoDeVenta, int cantidadDelProducto) {
        /*for (ItemCarrito item : productosEnCarrito) {
            if (item.getProducto().equals(productoDeVenta)) {
                item.aumentarCantidad(cantidadDelProducto);
                return;
            }
        }*/
        productosEnCarrito[contadorItems++] = new ItemCarrito(productoDeVenta, cantidadDelProducto);
    }

    public ItemCarrito[] itemEnCarrito() {
        return productosEnCarrito;
    }

    public int getContadorItems() {
        return contadorItems;
    }
}
