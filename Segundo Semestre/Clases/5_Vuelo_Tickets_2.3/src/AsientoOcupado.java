public class AsientoOcupado extends Exception {
    public AsientoOcupado() {
        super("Error: No se puede asignar el asiento porque ya está ocupado");
    }
}
