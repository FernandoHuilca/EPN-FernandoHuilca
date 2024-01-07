public class Factura {
    private Cliente cliente;
    private double subTotal;
    private double IVAaPagar;
    private double totalTotal;
    private Item[] items;
    private int contadorDeItems;



    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.subTotal = calcularSubTotal();
        IVAaPagar = calcularIVAaPagar(cliente);
        totalTotal = subTotal + IVAaPagar;
        items = cliente.getItems();
        contadorDeItems = 0;
    }

    private double calcularIVAaPagar(Cliente cliente) {

        double IVA = 0;
        for (Item productoDeVenta : items){
            IVA += productoDeVenta.getIVA() * ;
        }
        return IVA;
    }









    private double calcularSubTotal() {
        return 0;
    }


    public void imprimirFactura() {
        System.out.println("____________________________ FACTURA DE COMPRA _______________________________");
        System.out.println("Cliente: " + cliente.getNombre() + "\n");

        System.out.println("       Nombre                Cantidad            PrecioUnitario       TotalPorElItem");


        System.out.println("________________________________________________________________________________");
        System.out.println("SUBTOTAL A PAGAR:                                                       " + subTotal + "$");
        System.out.println("VALOR POR IVA:                                                          " + IVAaPagar );
        System.out.println("TOTAL TOTAL:                                                            " + totalTotal );
        System.out.println("________________________________________________________________________________");
        System.out.println("                    Gracias por comprar. No vuelva nunca.      ");
        System.out.println("--------------------------------------------------------------------------------");
    }







}
