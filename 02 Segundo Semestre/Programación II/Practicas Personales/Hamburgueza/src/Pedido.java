public class Pedido {
    private Cliente cliente;
    private Hamburguesa hamburguesa;

    public Pedido(Cliente cliente, int tipoDeHamburguesa) {
        this.cliente = cliente;
        hamburguesa = new Hamburguesa(tipoDeHamburguesa);

    }
}
