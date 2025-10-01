public interface Usuario {
    String getId();
    String getNombre();
    double getBalance();
    void actualizarBalance(double monto);
}