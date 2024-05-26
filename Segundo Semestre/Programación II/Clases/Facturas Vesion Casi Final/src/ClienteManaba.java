public class ClienteManaba extends Cliente {
    public static double NUEVO_IVA = 0.08;

    public ClienteManaba(String nombre) {
        super(nombre);
        super.modificarAIVAEspecial(NUEVO_IVA);
    }
}
