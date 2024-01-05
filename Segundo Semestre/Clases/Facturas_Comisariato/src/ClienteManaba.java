public class ClienteManaba extends Cliente {
    public static double SU_PROPIO_IVA = 0.8;
    private double suPropioIva;
    public ClienteManaba(String nombre) {
        super(nombre);
        suPropioIva = SU_PROPIO_IVA;
    }
    public double getsuPropioIva(){
        return suPropioIva;
    }
}
