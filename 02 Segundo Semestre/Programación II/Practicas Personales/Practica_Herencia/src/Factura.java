import java.time.LocalDate;

public class Factura {
    private Cliente cliente;
    private ProductoDeVenta producto;
    private LocalDate fechaVenta;

    public Factura(Cliente cliente, ProductoDeVenta producto, LocalDate fechaVenta) {

        this.cliente = cliente;
        this.producto = producto;
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "+-------------------------------------------------------+\n" +
                "|                    FACTURA DE VENTA                   |\n" +
                "+-------------------------------------------------------+\n" +
                "| Fecha:        "+ fechaVenta + "  Hora: ??:??:??            |\n" +
                "+-------------------------------------------------------+\n" +
                "| Cliente:              "+ cliente.getNombre() + "               |\n" +
                "| Dirección:            ???????????????????             |\n" +
                "| Teléfono:            "+ cliente.getCelular() + "                    |\n" +
                "+-------------------------------------------------------+\n" +
                "| Detalles de la Compra:                                |\n" +
                "|                                                       |\n" +
                "|   Producto         |  Cantidad  |  Precio Unitario   |\n" +
                "|---------------------|------------|--------------------|\n" +
                "|   "+producto.getNombre() +  "         |      1     |      $"+ producto.getPrecio() +"       |\n" +
                "|   _________         |      ?     |        $00.00      |\n" +
                "|   _________         |      ?     |        $00.00      |\n" +
                "+-------------------------------------------------------+\n" +
                "| Subtotal:                     $" +producto.getPrecio() +"                  |\n" +
                "| Impuestos (IVA 12%):          $00.00                 |\n" +
                "| Total:                        $" +producto.getPrecio() + "               |\n" +
                "+-------------------------------------------------------+\n" +
                "|        ¡Gracias por su compra!                        |\n" +
                "+-------------------------------------------------------+\n" ;
    }
}
