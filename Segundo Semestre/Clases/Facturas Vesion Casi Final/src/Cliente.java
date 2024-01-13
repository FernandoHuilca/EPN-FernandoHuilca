public class Cliente {
    private String nombre;
    private Item[] items;
    private int contadorDeItems;
    private double IVA;


    public Cliente(String nombre) {
        this.nombre = nombre;
        items = new Item[1000];
        contadorDeItems = 0;
        IVA = 0;
    }

    public void agregarItem(ProductoDeVenta productoDeVenta, int cantidadDeProducto) {
        Item nuevoItem = new Item(productoDeVenta, cantidadDeProducto);
        items[contadorDeItems] = nuevoItem;
        contadorDeItems +=1;
    }

    public Item[] getItems(){
        return items;
    }


    public String getNombre() {
        return nombre;
    }

    public double getIVA() {
        return IVA;
    }

    public void modificarAIVAEspecial(double nuevoIVA) {
        IVA = nuevoIVA;
    }


    public double aplicarIVA(double ivaProducto) {
        if (IVA != 0){
            return IVA;
        }
        return ivaProducto;
    }


    public int getContadorItems() {
        return contadorDeItems;
    }

    public Item devolverUnItem(int numItem) {
        return items[numItem];
    }
}
