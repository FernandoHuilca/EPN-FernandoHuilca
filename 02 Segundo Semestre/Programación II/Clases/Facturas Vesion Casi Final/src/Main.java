public class Main {
    public static void main(String[] args) {

        Empresa supermercado = new Empresa();

        Cliente carlos = new ClienteManaba("Carlos E. Anchundia");
        Cliente marco = new ClienteQuiteño("Marco E. Molina");
        Cliente fernando = new Cliente("Fernando E. Huilca");


        marco.agregarItem(supermercado.retornarProductoDeVenta(1),1);
        marco.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        marco.agregarItem(supermercado.retornarProductoDeVenta(3),1);



        carlos.agregarItem(supermercado.retornarProductoDeVenta(1),1);
        carlos.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        carlos.agregarItem(supermercado.retornarProductoDeVenta(3),1);

        fernando.agregarItem(supermercado.retornarProductoDeVenta(1),1);
        fernando.agregarItem(supermercado.retornarProductoDeVenta(2), 5);
        fernando.agregarItem(supermercado.retornarProductoDeVenta(3),1);




        supermercado.venderProductos(carlos); // Generar la factura de venta
        System.out.println("\n\n\n");
        supermercado.venderProductos(fernando);
        System.out.println("\n\n\n");
        supermercado.venderProductos(marco);



    }
}