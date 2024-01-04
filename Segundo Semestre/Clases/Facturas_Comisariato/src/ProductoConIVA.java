public class ProductoConIVA extends ProductoDeVenta {

    public static double IVA = 0.12;

    public ProductoConIVA(String nombre, int cantidadEnStock, double precio) {
        super(nombre, cantidadEnStock, aplicarIVA(precio));
    }

    private static double aplicarIVA(double precio) {
        return precio + (precio * IVA);
    }
}
