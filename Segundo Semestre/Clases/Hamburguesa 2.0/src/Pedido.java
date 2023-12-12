public class Pedido {
    private Hamburguesa tipoDeHamburguesa;
    private Cliente cliente;
    public Pedido(Cliente cliente, Hamburguesa tipoDeHamburguesa) {
    this.cliente = cliente;
    this.tipoDeHamburguesa = tipoDeHamburguesa;
    }

    @Override
    public String toString() {
        return "Pedido" +
                "\n\ttipoDeHamburguesa = " + tipoDeHamburguesa +
                "\n\tcliente = " + cliente +
                "\n\tValor a pagar = " + tipoDeHamburguesa.precio() + "$" ;
    }
}
