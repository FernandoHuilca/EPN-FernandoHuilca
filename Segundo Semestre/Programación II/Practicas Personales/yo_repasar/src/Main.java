// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Crear un banco
        Banco pichincha = new Banco("Pichincha");

        //crear una cuenta a un cliente
        pichincha.crearUnaCuenta();

        //realizr una transaccion
        pichincha.transaccion(cuenta1, cuenta2, valorTransaccion);

    }
}