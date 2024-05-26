public class Cliente {
    private String nombreCliente;
    private String celularCliente;

    public Cliente(String nombreCliente, String celularCliente) {
        this.nombreCliente = nombreCliente;
        this.celularCliente = celularCliente;
    }

    @Override
    public String toString() {
        return
                "\n\tNombre = " + nombreCliente +
                "\n\tCelular = " + celularCliente;
    }
}
