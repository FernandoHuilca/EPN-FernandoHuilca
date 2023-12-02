
public class Main {
    public static void main(String[] args) {

        //Primero, vamos a crear un vuelo
        Vuelo vuelo1 = new Vuelo("Cathay Pacific", "Quito", "Argentina",
                "30/11/2023", "14:00h", 50, 100);


        Vuelo vuelo2 = null;
        System.out.println("*********************** CASO DE PRUEBA 1. Comprar ticket  *************************");
        //Crear un ticket de vuelo
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        ticket1.comprar("Fernando Huilca", 0, vuelo2);
        ticket1.imprimirTicket();
        ticket2.comprarEconomica();

        Ticket ticket3 = vuelo1.comprarTicket("Fernando Huilca", 0); //Este metodo devulve un ticket comprado
        vuelo1.informacionGeneral();
    }
}