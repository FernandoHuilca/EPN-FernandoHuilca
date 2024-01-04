public class Supermercado {
    private Factura[] facturas;
    private ProductoDeVenta[] productoDeVentas;
    private int contadorDeFacturas;

    public Supermercado() {
        facturas = new Factura[1000];
        productoDeVentas = new ProductoDeVenta[1000];
        contadorDeFacturas = 0;

        //Inicializo algunos productos, pero esto lo puedo hacer mejor desde un archivo de texto ir leyéndolo
        productoDeVentas[1] = new ProductoConIVA("Televisión 4k Amazon", 5, 168.99);
        productoDeVentas[2] = new ProductoSinIVA(" 30 tabletas Paracetamol 500 mg", 50, 1.09);
    }

    public ProductoDeVenta productoDeVenta(int numProductoDeVenta) {
        return productoDeVentas[numProductoDeVenta];
    }

    public void venderProductos(Cliente cliente) {
        //hacer que se disminuya los productos en el supermercado
        Factura nuevaFactura = new Factura(cliente);
        nuevaFactura.imprimirFactura();
        facturas[contadorDeFacturas++] = nuevaFactura;
    }
}
