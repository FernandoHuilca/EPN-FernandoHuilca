public class JugadorBlackJackImpl implements JugadorBlackJack {
    private final Usuario usuario;

    public JugadorBlackJackImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void iniciarMano() {
        System.out.println(usuario.getNombre() + " inicia mano en BlackJack");
    }

    @Override
    public void pedirCarta() {
        System.out.println(usuario.getNombre() + " pide carta");
    }

    @Override
    public void plantarse() {
        System.out.println(usuario.getNombre() + " se planta");
    }

    @Override
    public double apostar(double monto) {
        usuario.actualizarBalance(-monto);
        return monto;
    }
}