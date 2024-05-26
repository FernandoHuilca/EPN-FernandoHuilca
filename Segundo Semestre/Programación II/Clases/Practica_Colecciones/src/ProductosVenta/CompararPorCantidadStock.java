package ProductosVenta;
import java.util.Comparator;

public class CompararPorCantidadStock implements Comparator<ProductoDeVenta> {

    @Override
    public int compare(ProductoDeVenta o1, ProductoDeVenta o2) {
        return o1.cantidadStock - o2.cantidadStock;
    }
}
