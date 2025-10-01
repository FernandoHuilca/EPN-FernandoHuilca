//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Crear usuario base
        Usuario usuario = new UsuarioImpl("u-123", "Ana López", 1000.0);

        // Usuario juega BlackJack (adquiere rol)
        JugadorBlackJack jugadorBJ = RoleFactory.comoJugadorBlackJack(usuario);
        jugadorBJ.iniciarMano();
        jugadorBJ.apostar(50.0);
        jugadorBJ.pedirCarta();
        jugadorBJ.plantarse();

        System.out.println("Balance actual: $" + usuario.getBalance());

        // El mismo usuario juega Poker (adquiere otro rol)
        JugadorPoker jugadorPoker = RoleFactory.comoJugadorPoker(usuario);
        jugadorPoker.unirseAMesa(5);
        jugadorPoker.pagarCiega(100.0);

        System.out.println("Balance final: $" + usuario.getBalance());


    }
}