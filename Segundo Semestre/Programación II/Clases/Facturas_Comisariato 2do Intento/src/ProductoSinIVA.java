public class ProductoSinIVA extends ProductoDeVenta {
    public ProductoSinIVA(String nombre, int cantidadEnStock, double precio) {

        super(nombre, cantidadEnStock, precio);
    }
    double calcularIVA(double precio){
        return precio;
    }
}
