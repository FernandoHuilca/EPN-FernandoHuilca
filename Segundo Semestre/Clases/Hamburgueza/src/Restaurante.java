public class Restaurante {
    private String nombreDelRestaurante;
    private Cliente[] clientes;
    private Pedido[] pedidos;
    private Hamburguesa[] menuDeHamburguesas;
    private int contadorDeClientes;
    private int contadorDePedidos;

    public Restaurante(String nombreDelRestaurante) {
        this.nombreDelRestaurante = nombreDelRestaurante;
        clientes = new Cliente[100];
        contadorDeClientes = 0;
        pedidos = new Pedido[100];
        contadorDePedidos = 0;
        menuDeHamburguesas[3] = new Hamburguesa();
        menuDeHamburguesas[0] = new HamburguesaSimple();
        menuDeHamburguesas[1] = new HamburguesaExplisiva();
        menuDeHamburguesas[2] = new HamburguesaInfarto();
    }


    public void crearPedido(Cliente nuevoCliente, int tipoDeHamburguesa) {
        registroCliente(nuevoCliente);
        pedidos[contadorDePedidos++] = new Pedido(nuevoCliente, menuDeHamburguesas[tipoDeHamburguesa]);

    }

    private void registroCliente(Cliente nuevoCliente) {
        clientes[contadorDeClientes++] = nuevoCliente;
    }
}
