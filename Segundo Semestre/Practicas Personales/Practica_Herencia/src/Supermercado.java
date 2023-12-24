public class Supermercado {
    private Cliente[] clientes;
    private int contadorClientes;
    private ProductoDeVenta[] productoDeVentas;


    //CONSTRUCTOR:
    public Supermercado(){
        clientes = new Cliente[1000];
        contadorClientes = 0;
        this.productoDeVentas = new ProductoDeVenta[4];
        productoDeVentas[0] = new Electrodomestico();
        productoDeVentas[1] = new Bebida();
        productoDeVentas[2] = new Alimento();
        productoDeVentas[3] = new Ropa();
    }


    public void registrarCliente(Cliente cliente) {
        if (cliente == null){
            System.out.println("Error: Cliente null");
            return;
        }
        clientes[contadorClientes++] = cliente;
        System.out.println("Cliente: " + cliente.getNombre() + " registrado con exito!!");
    }

    public void venderProducto(int numCliente, int numProductoVenta, double dineroDelCliente) {
    }
}
