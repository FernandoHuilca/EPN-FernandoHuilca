public class RoleFactory {
    public static JugadorBlackJack comoJugadorBlackJack(Usuario usuario) {
        return new JugadorBlackJackImpl(usuario);
    }

    public static JugadorPoker comoJugadorPoker(Usuario usuario) {
        return new JugadorPokerImpl(usuario);
    }
}