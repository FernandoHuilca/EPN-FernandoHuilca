public class Hamburguesa {
    private double precio;
    private String ingredientes;
    private String nombreDelTipoDeHamburguesa;

    public Hamburguesa(String nombreDelTipoDeHamburguesa, String ingredientes, double precio) {
    this.nombreDelTipoDeHamburguesa = nombreDelTipoDeHamburguesa;
    this.ingredientes = ingredientes;
    this.precio = precio;
    }

    public double precio() {
    return precio;
    }
}
