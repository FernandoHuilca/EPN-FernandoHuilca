public class Cliente {
    private static int MAXIMO_CUENTAS_POR_CLIENTE = 2;
    private String nombre;
    private Cuenta[] cuentas;
    private int contadorNumeroCuentas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        cuentas = new Cuenta[MAXIMO_CUENTAS_POR_CLIENTE];
    }

    public void agregarCuenta(Cuenta nuevaCuenta) {
        cuentas[contadorNumeroCuentas++] = nuevaCuenta;
    }
}
