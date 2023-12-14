public class Netflix {
    private CuentaNetflix[] cuentas;
    private int numeroDeCuentas;
    private Pelicula[]

    public Netflix() {
        numeroDeCuentas = 0;
        cuentas = new CuentaNetflix[100];
    }

    public CuentaNetflix registrar(String mail, Suscripcion tipoDeSuscripcion, double valorDelDeposito) {
        if (!(valorDelDeposito == tipoDeSuscripcion.getprecio())) {
            System.out.println("El valor cancelado no corresponde con el pedido");
            return null;
        }
        CuentaNetflix nuevaCuenta = new CuentaNetflix(mail, tipoDeSuscripcion);
        registrarCuenta(nuevaCuenta);
        System.out.println("** Felicidades ** por adquirir nuestro servicio :)");
        return nuevaCuenta;
    }

    private void registrarCuenta(CuentaNetflix nuevaCuenta) {
        cuentas[numeroDeCuentas++] = nuevaCuenta;

    }

    public void reproducirPelicula(int posicionDeLaCuenta, int posicionDeLaPelicula) {
        System.out.println("Esta viendo la movie");
    }
}