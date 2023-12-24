public class Bebida extends ProductoDeVenta {
    private double volumenEnLitros;
    public Bebida(double precio, String nombre, double volumenEnLitros) {
        super(precio, nombre);
        this.volumenEnLitros = volumenEnLitros;
    }
}
