// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {


        System.out.println(".................CASO DE PRUEBA 1................. \n * Crear vuelo y pedir su informacion:");
        Vuelo vuelo1 = new Vuelo("Cathay Pacific", "Quito", "Argentina",
                "30/11/2023", "14:00h", 40, 100);
        vuelo1.informacionGeneral();




        System.out.println(".................CASO DE PRUEBA 2................. \n * Vender dos tickets del vuelo diferente clase:");
        Ticket ticket1 = vuelo1.venderTicketPremium("Fernando Huilca", 0);


        try {
            Ticket ticket3 = vuelo1.venderTicketEconomica("Eliceo Villagomez", 24);
        } catch (AsientoOcupado e) {
            System.out.println(e.getMessage());
        }
        try {
            Ticket ticket2 = vuelo1.venderTicketEconomica("Carlos Anchundia", 24);
        } catch (AsientoOcupado e) {
            System.out.println(e.getMessage());
        }
        vuelo1.informacionGeneral();




        System.out.println(".................CASO DE PRUEBA 3................. \n * Vender un ticket que ya esta vendido y en el mismo asiento:");
        ticket1.vender();
        Ticket ticket3 = vuelo1.venderTicketPremium("Carlos Anchundia", 0);




        System.out.println(".................CASO DE PRUEBA 4................. \n * Presentar informacion de los asientos del vuelo:");
        vuelo1.asientosDisponibles();

    }
}