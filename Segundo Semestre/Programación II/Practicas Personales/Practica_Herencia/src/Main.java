//Author: Fernando Huilca
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        Supermercado comisariato = new Supermercado();


        System.out.println("\n\t\u001B[34m Caso 1. Registrar a un par de clientes_____________________________________________\u001B[0m");
        comisariato.registrarCliente(new Cliente("Fernando Huilca", "0987654321", "1755534532"));
        Cliente cliente1 = new Cliente("Carlos Anchundia", "0987654321", "1789456123");
        comisariato.registrarCliente(cliente1);


        System.out.println("\n\t\u001B[34m Caso 2. Registrar un producto a la lista de productos para vender__________________\u001B[0m");
        Lampara lampara = new Lampara("5LCF05B",19.99, "West Point Home", "Lámpara Led");
        comisariato.registrarProductoDeVenta(lampara);
        Licor azteca = new Licor(21.50,"Azteca", 0.75, 35);
        comisariato.registrarProductoDeVenta(azteca);



        System.out.println("\n\t\u001B[34m Caso 3. Vender un producto a un cliente e imprimir Factura__________________________\u001B[0m");
        comisariato.venderProducto(0,0, 19.99);
        comisariato.venderProducto(1,0, 19.99);
        comisariato.venderProducto(1,1,21.50);


        System.out.println("\n\t\u001B[34m Caso 4. Imprimir Ganancias Totales del Supermercado y por dia__________________________\u001B[0m");
        comisariato.imprimirGananciasTotales();
        comisariato.imprimirGananciasDelDia(LocalDate.now());

        System.out.println("\n\t\u001B[34m Caso 5. Registrar un empleado y calcular cuanto hay que pagarle__________________________\u001B[0m");
        Empleado franz = new Guardia("Franz Kafka", "franzkafka@gmail.com", LocalDate.now(), 550.00, "Linterna, pistola, radio");
        comisariato.registrarEmpleado(franz);
        comisariato.calcularCuantoHayQuePagar(franz);

    }
}