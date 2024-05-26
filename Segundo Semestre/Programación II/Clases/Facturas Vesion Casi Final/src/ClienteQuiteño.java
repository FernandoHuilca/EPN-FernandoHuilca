public class ClienteQuiteño extends Cliente {
    public static double NUEVO_IVA = 0.50;
    public ClienteQuiteño(String nombre) {
        super(nombre);
        super.modificarAIVAEspecial(NUEVO_IVA);
    }
}


