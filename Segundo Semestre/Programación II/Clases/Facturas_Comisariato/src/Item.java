public class Item {
    private ProductoDeVenta producto;
    private int cantidad;
    private double precioPorTodoElItem;
    private double ivaPorTodoElItem;

    public Item(ProductoDeVenta producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        precioPorTodoElItem = producto.getPrecio() * cantidad;
        ivaPorTodoElItem = producto.getIVA() * cantidad;
    }



    @Override
    public String toString() {
        return " " + producto.getNombre() +
                "           " + cantidad + "                   " + producto.getPrecio() + "               " + precioPorTodoElItem;
    }

    public double getPrecioPorTodoElItem() {
    return precioPorTodoElItem;
    }

    public double getIvaPorTodoElItem() {
        return ivaPorTodoElItem;
    }
}