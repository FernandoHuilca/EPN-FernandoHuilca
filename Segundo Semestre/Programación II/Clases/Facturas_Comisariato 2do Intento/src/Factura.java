public class Factura {
    private Cliente cliente;
    private double subTotal;
    private double IVAaPagar;



    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.subTotal = calcularSubTotal();
        IVAaPagar = calcularIVAaPagar();
    }



    private double calcularIVAaPagar() {
        double aux = 0;
        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {

            aux += cliente.devolverCarritoDeCompras().itemEnCarrito()[i].getValorAPagarDelIVAPorTodoElItem();
        }
        return aux;
    }

    private double calcularSubTotal() {
        double aux = 0 ;
        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {

            aux += cliente.devolverCarritoDeCompras().itemEnCarrito()[i].getValorAPagarPortodoElItem();
        }
        return aux;
    }

    public void imprimirFactura() {
        System.out.println("____________________________ FACTURA DE COMPRA _______________________________");
        System.out.println("Cliente: " + cliente.getNombre() + "\n");

        System.out.println("       Nombre                Cantidad            PrecioUnitario       TotalPorElItem");

        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {
            System.out.println(cliente.devolverCarritoDeCompras().itemEnCarrito()[i]);
        }
        System.out.println("________________________________________________________________________________");
        System.out.println("SUBTOTAL A PAGAR:                                                       " + subTotal + "$");
        System.out.println("VALOR POR IVA:                                                          " + IVAaPagar );
        System.out.println("TOTAL TOTAL:                                                            " + (IVAaPagar+subTotal) );
        System.out.println("________________________________________________________________________________");
        System.out.println("                    Gracias por comprar. No vuelva nunca.      ");
        System.out.println("--------------------------------------------------------------------------------");
    }

}
