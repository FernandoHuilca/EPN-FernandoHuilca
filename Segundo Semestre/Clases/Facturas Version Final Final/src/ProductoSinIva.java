public class ProductoSinIva extends ProductoDeVenta {
    public static double IVA = 0.0;
    public ProductoSinIva(String nombre, int cantidadEnStock, double precio) {
        super(nombre, cantidadEnStock, precio);
    }

    @Override
    double IVADelProducto() {
        return IVA;
    }
}
