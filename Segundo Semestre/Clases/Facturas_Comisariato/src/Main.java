// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();

        Cliente carlos = new Cliente("Carlos E. Anchundia");
        Cliente fernando = new Cliente("Fernando E. Huilca");
        carlos.agregarAlCarrito(supermercado.productoDeVenta(1),2);
        fernando.agregarAlCarrito(supermercado.productoDeVenta(2), 2);

        supermercado.venderProductos(carlos); // Generar la factura de venta
        supermercado.venderProductos(fernando);

    }
}