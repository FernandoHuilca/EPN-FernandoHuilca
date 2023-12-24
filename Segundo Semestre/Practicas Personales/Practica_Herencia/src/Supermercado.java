public class Supermercado {
    private Cliente[] clientes;
    private int contadorClientes;
    private Venta[] ventas;
    private int contadorVentas;


    //CONSTRUCTOR:
    public Supermercado() {
        clientes = new Cliente[1000];
        contadorClientes = 0;
        ventas = new Venta[1000];
        contadorVentas = 0;
    }


    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: Cliente null");
            return;
        }
        clientes[contadorClientes++] = cliente;
        System.out.println("Cliente: " + cliente.getNombre() + " registrado con exito!!");
    }

    public void venderProducto(int numCliente, int numProductoVenta, double subproducto, double dineroDelCliente) {

        Venta nuevaVenta = new Venta(clientes[numCliente], );
        ventas[contadorVentas++] = nuevaVenta;
    }
}
