public class Factura {
    private Cliente cliente;
    private double subTotal;
    private double IVAaPagar;
    private double totalTotal;



    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.subTotal = calcularSubTotal();
        IVAaPagar = calcularIVAaPagar();
        totalTotal = subTotal + IVAaPagar;
    }



    public void imprimirFactura() {
        System.out.println("____________________________ FACTURA DE COMPRA _______________________________");
        System.out.println("Cliente: " + cliente.getNombre() + "\n");

        System.out.println("       Nombre                Cantidad            PrecioUnitario       TotalPorElItem");

        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {
            System.out.println(cliente.devolverCarritoDeCompras().getItems()[i]);
        }
        System.out.println("________________________________________________________________________________");
        System.out.println("SUBTOTAL A PAGAR:                                                       " + subTotal + "$");
        System.out.println("VALOR POR IVA:                                                          " + IVAaPagar );
        System.out.println("TOTAL TOTAL:                                                            " + totalTotal );
        System.out.println("________________________________________________________________________________");
        System.out.println("                    Gracias por comprar. No vuelva nunca.      ");
        System.out.println("--------------------------------------------------------------------------------");
    }



    private double calcularIVAaPagar() {
        double IVA = 0;
        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {

            IVA += cliente.devolverCarritoDeCompras().getItems()[i].getIvaPorTodoElItem();
        }
        return IVA;
    }

    private double calcularSubTotal() {
        double subTotal = 0 ;
        for (int i = 0; i < cliente.devolverCarritoDeCompras().getContadorItems(); i++) {

            subTotal += cliente.devolverCarritoDeCompras().getItems()[i].getPrecioPorTodoElItem();
        }
        return subTotal;
    }




}
