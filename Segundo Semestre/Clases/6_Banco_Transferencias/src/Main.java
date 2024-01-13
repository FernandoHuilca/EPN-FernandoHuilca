// Realizar un programa que permita la gestión de las
// transacciones bancarias de las cuentas de un cliente

public class Main {
    public static void main(String[] args) {


        System.out.println("\n\nCASO 1. Crear cuenta en un Banco e imprimirla_____________________________");
        Banco pichincha = new Banco("Pichincha");
        Cuenta cuenta = pichincha.abrirCuenta(new Cliente("Carlos"), 200);
        System.out.println(cuenta);


        System.out.println("\n\nCaso 2. Crear cuenta sin monto mínimo de $20_____________________________");
        Cuenta otraCuenta1 = pichincha.abrirCuenta(new Cliente("Fernando"), 5);
        System.out.println(otraCuenta1);


        System.out.println("\n\nCaso 3. transferir dinero entre cuentas con saldo_____________________________");
        Cuenta otraCuenta = pichincha.abrirCuenta(new Cliente("Fernando"), 2000);
        System.out.println(pichincha.transferir(cuenta, otraCuenta, 30));


        System.out.println("\n\nCaso 4. transferir dinero desde cuenta sin saldo_____________________________");
        Cuenta cuenta2 = pichincha.abrirCuenta(new Cliente("Miguel De Cervantes"), 20);
        System.out.println(pichincha.transferir(cuenta2, cuenta, 200));


        System.out.println("\n\nCaso 5. transferir con monto negativo_____________________________");
        System.out.println(pichincha.transferir(cuenta, otraCuenta, -30));


        System.out.println("\n\nCaso 6. transferir a cuenta null_____________________________");
        Cuenta cuenta6 = null;
        System.out.println(pichincha.transferir(cuenta, cuenta6, 30));



        System.out.println("\n\nCaso 7. cada transferencia cuesta 0.35 centavos_____________________________");
        System.out.println(pichincha.transferir(cuenta, otraCuenta, 30));
    }
}