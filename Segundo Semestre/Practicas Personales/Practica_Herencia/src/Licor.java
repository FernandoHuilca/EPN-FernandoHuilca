public class Licor extends Bebida{
    private double porcentajeDeAlcohol;
    public Licor(double precio, String nombre, double volumenEnLitros, double porcentajeDeAlcohol) {
        super(precio, nombre, volumenEnLitros);
        this.porcentajeDeAlcohol = porcentajeDeAlcohol;

    }
}
