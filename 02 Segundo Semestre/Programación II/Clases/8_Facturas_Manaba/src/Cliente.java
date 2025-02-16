public abstract class Cliente {
    private String nombre;
    private Item[] items;
    private int contadorDeItems;
    public double IVA_DEL_CLIENTE;


    public Cliente(String nombre) {
        this.nombre = nombre;
        items = new Item[1000];
        contadorDeItems = 0;
        IVA_DEL_CLIENTE = IVADelCliente();
    }


    abstract double IVADelCliente();


    public void agregarItem(ProductoDeVenta productoDeVenta, int cantidadDeProducto) {
        Item nuevoItem = new Item(productoDeVenta, cantidadDeProducto);
        items[contadorDeItems++] = nuevoItem;
    }

    public double aplicarIVA(double ivaProducto) { //TODO: esto no estoy seguro de como hacer jeje
        if (ivaProducto == 0){
            return ivaProducto;
        }
        else if (IVA_DEL_CLIENTE != ivaProducto){
            return IVA_DEL_CLIENTE;
        }
        return ivaProducto;
    }



    /************************************ METODOS NO NECESARIOS DE LEER *************************/
    public int getContadorItems() {
        return contadorDeItems;
    }
    public Item[] getItems(){
        return items;
    }


    public String getNombre() {
        return nombre;
    }

    public double getIVAdelCliente() {
        return IVA_DEL_CLIENTE;
    }
}
