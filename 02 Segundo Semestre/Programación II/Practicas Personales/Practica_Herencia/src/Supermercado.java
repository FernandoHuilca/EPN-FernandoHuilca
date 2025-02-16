import java.time.LocalDate;

public class Supermercado {
    private Cliente[] clientes;
    private int contadorClientes;
    private Venta[] ventas;
    private int contadorVentas;
    private ProductoDeVenta[] productoDeVentas;
    private int contadorProductoDeVentas;
    private Ganacia[] ganacias;
    private int contadorDeGanancias;
    private Empleado[] empleados;
    private int contadorDeEmpleados;


    //CONSTRUCTOR:
    public Supermercado() {
        clientes = new Cliente[1000];
        contadorClientes = 0;
        ventas = new Venta[1000];
        contadorVentas = 0;
        productoDeVentas = new ProductoDeVenta[1000];
        contadorProductoDeVentas = 0;
        ganacias = new Ganacia[1000];
        contadorDeGanancias = 0;
        empleados = new Empleado[100];
        contadorDeEmpleados = 0;
    }


    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: Cliente null");
            return;
        }
        clientes[contadorClientes++] = cliente;
        System.out.println("Cliente: " + cliente.getNombre() + " registrado con exito!!");
    }


    public void venderProducto(int numCliente, int numProducto, double dineroDelCliente) {
        if (dineroDelCliente != productoDeVentas[numProducto].getPrecio()){
            System.out.println("ERROR: el dinero es diferente al precio del produto");
            return;
        }
        Venta nuevaVenta = new Venta(clientes[numCliente], productoDeVentas[numProducto]);
        ventas[contadorVentas++] = nuevaVenta;
        agregarGananciaDeVenta(dineroDelCliente);
        nuevaVenta.imprimirFactura();
    }

    private void agregarGananciaDeVenta(double dineroDelCliente) {
        ganacias[contadorDeGanancias++] = new Ganacia(dineroDelCliente);
    }

    public void registrarProductoDeVenta(ProductoDeVenta producto) {
        productoDeVentas[contadorVentas++] = producto;
        System.out.println("Producto: " + producto.getNombre() + " registrado con éxito!!");
    }

    public void imprimirGananciasTotales() {
        double GananciasTotales = 0;
        for (int i = 0; i < contadorDeGanancias; i++){
            GananciasTotales += ganacias[i].getDinero();
        }
        System.out.println("Las ganancias Totales del Supermercado son: $" + GananciasTotales);
    }

    public void imprimirGananciasDelDia(LocalDate fechaParaImprimir) {
        double GananciasTotales = 0;
        System.out.println("Las ganancias de la fecha: " + fechaParaImprimir + " son:" );
        for (int i = 0; i < contadorDeGanancias; i++){
            if (ganacias[i].getFecha().equals(fechaParaImprimir)){
                System.out.println("\n\t $" + ganacias[i].getDinero());
                GananciasTotales += ganacias[i].getDinero();
            }
        }
        System.out.println("\nTotal = $" + GananciasTotales);
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados[contadorDeEmpleados++] = empleado;
        System.out.println("Empleado: " + empleado.getNombre() + " registrado con éxito!!");
    }

    public void calcularCuantoHayQuePagar(Empleado empleado) {
        System.out.println("YA ME DIO PEREZA, PAGALE NO MAS LO QUE QUIERAS 🥱");
    }
}
