// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Spotify spotify = new Spotify();
        Cuenta cuentaFernando = spotify.crearCuenta("Fernando Huilca", "1234", Suscripcion.FAMILIAR, 6.50);
        Cuenta cuentaFer = spotify.crearCuenta(new Cuenta, "1234", Suscripcion.FAMILIAR, 6.50); //TODO: Preguntar si esto es mejor que lo anterior

        Cuenta cuentaFern = spotify.crearCuenta("Fernado")

    }
}