public class Restaurante {
    private String nombreDelRestaurante;
    private Hamburguesa[] menuDeHamburguesas;
    private Cliente[] clientes;
    private Pedido[] pedidos;
    private int contadorDeClientes;
    private int contadorDePedidos;


    public Restaurante(String nombreDelRestaurante) {
        this.nombreDelRestaurante = nombreDelRestaurante;
        menuDeHamburguesas = new Hamburguesa[3];
        menuDeHamburguesas[0] = new HamburguesaSimple();
        menuDeHamburguesas[1] = new HamburguesaExplosiva();
        menuDeHamburguesas[2] = new HamburguesaInfarto();
        pedidos = new Pedido[100];
        clientes = new Cliente[100];
        contadorDeClientes = 0;
        contadorDePedidos = 0;
    }

    public void crearPedido(Cliente cliente, int numeroTipoDeHamburguesa) {
        if (cliente.nombre() == "Bad Bunny" && numeroTipoDeHamburguesa == 69){
            System.out.println("\u001B[36m"+"En McDonald's no venden Donas!! :D " + "\u001B[0m");
            return;
        }
        registroCliente(cliente);
        pedidos[contadorDePedidos] = new Pedido(cliente, menuDeHamburguesas[numeroTipoDeHamburguesa]);
        //System.out.println("Pedido: Cliente: " + cliente.nombre()+ "Tipo de Hamburguesa: " + menuDeHamburguesas[numeroTipoDeHamburguesa]);
        System.out.println(pedidos[contadorDePedidos++]);
    }

    private void registroCliente(Cliente cliente) {
        clientes[contadorDeClientes++] = cliente;

    }
}
