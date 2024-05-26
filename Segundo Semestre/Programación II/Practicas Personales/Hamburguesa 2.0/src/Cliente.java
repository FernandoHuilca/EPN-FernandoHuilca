public class Cliente {
    private String nombreDelCliente;
    public Cliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String nombre() {
        return nombreDelCliente;
    }

    @Override
    public String toString() {
        return nombreDelCliente ;
    }
}
