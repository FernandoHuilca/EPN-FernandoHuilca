public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Eduardo");

        Restaurante CarlosJr = new Restaurante("CarlosJr");

        CarlosJr.registrarClienteEnCatalogo(cliente1);
        CarlosJr.registrarClienteEnCatalogo(cliente2);
    }
}