package ProductosVenta;

public class ProductoDeVenta implements Comparable<ProductoDeVenta>{
    private String nombrePorducto;
    protected int cantidadStock ;

    public ProductoDeVenta(String nombreProducto, int cantidadStock) {
        this.nombrePorducto = nombreProducto;
        this.cantidadStock = cantidadStock;
    }


    @Override
    public String toString() {
        return "\nProductosVenta.ProductoDeVenta: " +
                "\n\tNombrePorducto: " + nombrePorducto +
                "\n\tCantidadStock: " + cantidadStock;
    }

    @Override
    public int compareTo(ProductoDeVenta producto) {
        return this.nombrePorducto.compareTo(producto.nombrePorducto);
    }
}
