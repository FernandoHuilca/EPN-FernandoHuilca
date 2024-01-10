public class Cliente {
    private String nombre;
    private Item[] items;
    private int contadorDeItems;


    public Cliente(String nombre) {
        this.nombre = nombre;
        items = new Item[1000];
        contadorDeItems = 0;
    }

    public void agregarItem(ProductoDeVenta productoDeVenta, int cantidadDeProducto) {
        Item nuevoItem = new Item(productoDeVenta, cantidadDeProducto);
        items[contadorDeItems++] = nuevoItem;

    }

    public Item[] getItems(){
        return items;
    }


    public String getNombre() {
        return nombre;
    }



}
