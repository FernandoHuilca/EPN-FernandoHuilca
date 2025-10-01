public class UsuarioImpl implements Usuario {
    private final String id;
    private final String nombre;
    private double balance;

    public UsuarioImpl(String id, String nombre, double balance) {
        this.id = id;
        this.nombre = nombre;
        this.balance = balance;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getBalance() { return balance; }

    @Override
    public void actualizarBalance(double monto) {
        this.balance += monto;
    }
}