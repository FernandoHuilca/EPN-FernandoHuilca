public class Cliente {
    private String nombreCliente;
    private String celular;
    private String cedula;

    public Cliente(String nombreCliente, String celular, String cedula) {
        this.nombreCliente = nombreCliente;
        this.celular = celular;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombreCliente;
    }

    public String getCelular() {
    return celular;
    }
}
