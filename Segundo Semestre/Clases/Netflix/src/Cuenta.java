public class Cuenta {
    private String nombreDelDuenioDeLaCuenta;
    private double valorDeSuscripcion;
    private Suscripcion suscripcion;
    public Cuenta(String nombreDelDuenioDeLaCuenta) {
        this.nombreDelDuenioDeLaCuenta = nombreDelDuenioDeLaCuenta;
        valorDeSuscripcion = 10.99;
        suscripcion = null;
    }

    public void suscribirse(double dineroDelCliente) {
        if (dineroDelCliente == valorDeSuscripcion){
            suscripcion = new Suscripcion();
            System.out.println("\u001B[32m" + "Felicidades!!! Su cuenta tiene suscripcion"+"\u001B[0m");
        }
    }

    @Override
    public String toString() {
        return "Cuenta \n" +
                "nombreDelDuenioDeLaCuenta = " + nombreDelDuenioDeLaCuenta +
                "\nsuscripcion = " + suscripcion;
    }

    public Suscripcion suscripcion() {
        return suscripcion;
    }
}
