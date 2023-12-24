import javax.xml.stream.FactoryConfigurationError;
import java.time.LocalDate;

public class Venta {

    private Cliente cliente;
    private ProductoDeVenta producto;
    private LocalDate fechaVenta;
    private Factura factura;

    public Venta(Cliente cliente, ProductoDeVenta producto) {
        this.cliente = cliente;
        this.producto = producto;
        fechaVenta = LocalDate.now();
        factura = new Factura(cliente,producto, fechaVenta);
    }

    public void imprimirFactura() {
         System.out.println(factura);
    }
}
