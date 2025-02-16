public class Factura {
    private Cliente cliente;
    private double subTotalAPagar;
    private double IVAaPagar;
    private double totalTotal;
    private Item[] items;
    private int contadorDeItems;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = cliente.getItems();
        contadorDeItems = cliente.getContadorItems();
        this.subTotalAPagar = calcularSubTotal();
        IVAaPagar = calcularIVAaPagar();
        totalTotal = subTotalAPagar + IVAaPagar;

    }

    private double calcularIVAaPagar() {
        double IVA = 0;
        for (int i = 0; i < contadorDeItems; i++) {
            IVA += items[i].getPrecio() * cliente.aplicarIVA(items[i].getIvaProducto()) * items[i].getCantidadProducto();
        }
        return IVA;
    }


    private double calcularSubTotal() {
        double subTotal = 0;
        for (int i = 0; i < contadorDeItems; i++){
            subTotal = subTotal +  (items[i].getPrecio()) * items[i].getCantidadProducto();
        }
        return subTotal;
    }


    public void imprimirFactura() {


        System.out.println("\n\t\u001B[35m____________________________ FACTURA DE COMPRA _______________________________\n\t\u001B[0m");
        System.out.println("Cliente: " + cliente.getNombre() + "\n");

        System.out.println("       Nombre                Cantidad            PrecioUnitario       TotalPorElItem ");


        for (int i = 0; i < contadorDeItems; i++) {
            System.out.println(items[i]);
        }


        System.out.println("________________________________________________________________________________");
        System.out.println("SUBTOTAL A PAGAR:                                                       " + String.format("%.2f",subTotalAPagar) + "$");
        System.out.println("VALOR IVA " + String.format("%.2f", (cliente.getIVAdelCliente()*100))
                + "% :                                                      " + String.format("%.2f", IVAaPagar) + "$" );
        System.out.println("TOTAL TOTAL:                                                            " + String.format("%.2f",totalTotal) + "$");
        System.out.println("________________________________________________________________________________");
        System.out.println("                         TE FE-LI-CI-TO QUE BIEN FACTURAS.                           ");
        System.out.println("--------------------------------------------------------------------------------");
    }




}
