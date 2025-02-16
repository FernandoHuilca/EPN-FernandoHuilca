public class ClienteQuiteño extends Cliente {
    public static double IVA_CLIENTE = 14.;
    public ClienteQuiteño(String nombre) {
        super(nombre);
    }
    double IVADelCliente() {
        return IVA_CLIENTE/100;
    }
}


