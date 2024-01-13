public class Cuenta {

    private String numeroDeCuenta;
    private double saldo;

    public Cuenta(String numeroDeCuenta, double montoInicial) {
        this.numeroDeCuenta = numeroDeCuenta;
        saldo = montoInicial;
    }

    @Override
    public String toString() {
        return "Numero de cuenta: " + numeroDeCuenta + "\nSaldo Actual: " + saldo;
    }

    public void disminuirSaldoActual(double montoATransferir) {
        if (montoATransferir > saldo){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + " El saldo de su cuenta no permite disminuir esa cantidad.");
        }
        saldo -= montoATransferir;
    }

    public void aumentarSaldoActual(double montoATransferir) {
        saldo += montoATransferir;
    }

    public double saldoActual() {
        return saldo;
    }
}
