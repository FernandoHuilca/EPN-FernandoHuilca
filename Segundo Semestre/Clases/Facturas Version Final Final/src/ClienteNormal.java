public class ClienteNormal extends Cliente {
    public static double IVA_CLIENTE = 12.;

    public ClienteNormal(String nombre) {
        super(nombre);
    }
    double IVADelCliente() {
        return IVA_CLIENTE/100;
    }
}
