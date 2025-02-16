// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {

        Empresa supermercado = new Empresa();

        Cliente carlos = new ClienteManaba("Carlos E. Anchundia");
        Cliente fernando = new Cliente("Fernando E. Huilca");

        carlos.agregarAlCarrito(supermercado.productoDeVenta(1),2);
        fernando.agregarAlCarrito(supermercado.productoDeVenta(2), 2);
        fernando.agregarAlCarrito(supermercado.productoDeVenta(1), 2);

        supermercado.venderProductos(carlos); // Generar la factura de venta
        System.out.println("\n\n\n");
        supermercado.venderProductos(fernando);


    }
}