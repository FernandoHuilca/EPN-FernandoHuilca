public class JugadorPokerImpl implements JugadorPoker {
    private final Usuario usuario;

    public JugadorPokerImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void unirseAMesa(int mesaId) {
        System.out.println(usuario.getNombre() + " se unió a la mesa de Poker #" + mesaId);
    }

    @Override
    public void pagarCiega(double monto) {
        usuario.actualizarBalance(-monto);
        System.out.println(usuario.getNombre() + " paga ciega de $" + monto);
    }

    @Override
    public void retirarse() {
        System.out.println(usuario.getNombre() + " se retira del Poker");
    }
}