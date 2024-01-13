public class Main {
    public static void main(String[] args) {

        Empresa supermercado = new Empresa();


        System.out.println("\n\t\u001B[34m Caso 1. Agregar productos al carrito del cliente y vender _____________________________________________\u001B[0m");
        Cliente carlos = new ClienteManaba("Carlos E. Anchundia");
        Cliente marco = new ClienteQuiteño("Marco E. Molina");
        Cliente fernando = new ClienteNormal("Fernando E. Huilca");

        marco.agregarItem(supermercado.retornarProductoDeVenta(1),1);
        marco.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        marco.agregarItem(supermercado.retornarProductoDeVenta(3),1);

        carlos.agregarItem(supermercado.retornarProductoDeVenta(1), 5);
        carlos.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        carlos.agregarItem(supermercado.retornarProductoDeVenta(3),1);


        fernando.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        fernando.agregarItem(supermercado.retornarProductoDeVenta(3),1);

        System.out.println("\n\t\u001B[34m Caso 1. Vender estos productos al cliente _____________________________________________\u001B[0m");
        supermercado.venderProductos(carlos); // Generar la factura de venta
        System.out.println("\n\n\n");
        supermercado.venderProductos(fernando);
        System.out.println("\n\n\n");
        supermercado.venderProductos(marco);



    }
}