public class ClienteManaba extends Cliente {
    public static double IVA_CLIENTE = 8.;

    public ClienteManaba(String nombre) {
        super(nombre);
    }

    @Override
    double IVADelCliente() {
        return IVA_CLIENTE/100;
    }
}
