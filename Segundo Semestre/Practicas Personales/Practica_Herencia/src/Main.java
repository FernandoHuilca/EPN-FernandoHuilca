//Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        Supermercado comisariato = new Supermercado();


        System.out.println("\n\t\u001B[34m Caso 1. Registrar a un cliente_____________________________________________\u001B[0m");
        comisariato.registrarCliente(new Cliente("Fernando Huilca", "0987654321", "1755534532"));

        comisariato.venderProducto(0,0, 0, 23.50);




    }
}