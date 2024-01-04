public class Factura {
    private Cliente cliente;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        calcularTotal();
    }

    private void calcularTotal() {
        for (int i = 0; i < cliente.carritoDeCompras().getContadorItems(); i++) {
            total += cliente.carritoDeCompras().productosEnCarrito()[i].getValorAPagar();
        }
    }

    public void imprimirFactura() {
        System.out.println("______________ Factura de compra _________________");
        System.out.println("Cliente: " + cliente.getNombre());

        for (int i = 0; i < cliente.carritoDeCompras().getContadorItems(); i++) {
            System.out.println(cliente.carritoDeCompras().productosEnCarrito()[i]);
        }

        System.out.println("TOTAL A PAGAR: " + total);
        System.out.println("___________________________________________________");
    }
}
