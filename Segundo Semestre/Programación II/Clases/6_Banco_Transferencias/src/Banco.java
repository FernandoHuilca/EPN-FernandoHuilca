public class Banco {

    public static int MONTO_INICIAL = 20;
    public static double COSTO_POR_TRANSFERENCIA = 0.35;
    public static int NUMERO_MAXIMO_DE_CLIENTES = 100;
    private String nombreDelBanco;
    private Cliente[] clientes;
    private int contadorClientes;

    public Banco(String nombreDelBanco) {

        this.nombreDelBanco = nombreDelBanco;
        clientes = new Cliente[NUMERO_MAXIMO_DE_CLIENTES];
        contadorClientes = 0;
    }

    public Cuenta abrirCuenta(Cliente potencialCliente, double montoInicial) {
        if (!cumpleConElMontoInicial(montoInicial)) {
            String ROJO = "\u001B[31m";
            System.out.println(ROJO + "ERROR:" + "\u001B[0m" + " Este banco no acepta pobres.");
            return null;
        }
        clientes[contadorClientes++] = potencialCliente; //Este es como el registro que el profe hizo
        Cuenta nuevaCuenta = new Cuenta("ABC123", montoInicial);
        //Cuenta cuenta = cliente.agregarCuenta(montoInicial); //Por que el cliente crearia la cuenta??
        potencialCliente.agregarCuenta(nuevaCuenta);
        return nuevaCuenta;
    }

    private static boolean cumpleConElMontoInicial(double montoInicial) {
        return montoInicial >= MONTO_INICIAL;
    }

    public Transferencia transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double montoATransferir) {
        if ((cuentaOrigen == null) || (cuentaDestino == null)) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + " Cuenta inexistente.");
            return null;
        }
        if (tieneDineroParaLaTransferencia(cuentaOrigen, montoATransferir)) {
            System.out.println("\u001B[31m ERROR: " + "\u001B[0m No tiene suficiente saldo para la transferencia.");
            return null;
        }
        if (montoNegativo(montoATransferir)){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + " No se puede transferir dinero negativo xd.");
            return null;
        }
        cuentaOrigen.disminuirSaldoActual(COSTO_POR_TRANSFERENCIA);
        cuentaOrigen.disminuirSaldoActual(montoATransferir);
        cuentaDestino.aumentarSaldoActual(montoATransferir);
        return new Transferencia(cuentaOrigen, cuentaDestino, montoATransferir);
    }

    private static boolean tieneDineroParaLaTransferencia(Cuenta cuentaOrigen, double montoATransferir) {
        return montoATransferir + COSTO_POR_TRANSFERENCIA >= cuentaOrigen.saldoActual();
    }

    private static boolean montoNegativo(double montoATransferir) {
        return montoATransferir <= 0;
    }

}
