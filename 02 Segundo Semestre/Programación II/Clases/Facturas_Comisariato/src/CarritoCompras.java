
public class CarritoCompras {
    private Item[] items;
    private int contadorItems;

    public CarritoCompras() {
        items = new Item[1000];
        contadorItems = 0;
    }

    public void agregarProducto(ProductoDeVenta productoDeVenta, int cantidadDelProducto) {
        /*for (ItemCarrito item : productosEnCarrito) {
            if (item.getProducto().equals(productoDeVenta)) {
                item.aumentarCantidad(cantidadDelProducto);
                return;
            }
        }*/ //TODO: Hacer que esto funcione

        items[contadorItems++] = new Item(productoDeVenta, cantidadDelProducto);
    }

    public Item[] getItems() {
        return items;
    }

    public int getContadorItems() {
        return contadorItems;
    }
}
