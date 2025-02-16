// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nCASO 1. Crear Netflix y dos cuenta_____________________________");
        Netflix netflix = new Netflix();
        Cuenta cuenta1 = new Cuenta("Fernando Huilca");
        Cuenta cuenta2 = new Cuenta("Mateo Quisilema");
        System.out.println(cuenta1);
        System.out.println("\n\nCASO 2. Suscribir una cuenta___________________________________");
        netflix.registrarCuenta(cuenta1);
        cuenta1.suscribirse(10.99);
        System.out.println("\n\nCASO 3. Ver pelicula en una cuenta que no esta suscrita________");
        netflix.registrarCuenta(cuenta2);
        netflix.verPelicula(1, 0);

    }
}