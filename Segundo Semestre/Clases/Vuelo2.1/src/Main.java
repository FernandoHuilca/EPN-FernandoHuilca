// Author Fernando Huilca
public class Main {

    public static void main(String[] args) {

        //Primero, vamos a crear un vuelo
        Vuelo vuelo1 = new Vuelo("Cathay Pacific", "Quito", "Argentina",
                "30/11/2023", "14:00h", 50, 100);
        //Crear un ticket de vuelo
        Ticket ticket1 = new Ticket();




        //Ahora, vamos a preguntar cuantos asientos tiene disponibles, y preguntar sobre informacion general
        vuelo1.asientosDisponibles();
        vuelo1.informacion();




        //Luego, vamos a intentar comprar un ticket premium para el vuelo1
        ticket1.comprarPremium("Fernando Huilca", 0, vuelo1);
        ticket1.informacion();
        vuelo1.guardar(ticket1);
        vuelo1.asientosDisponibles();

        System.out.println("CASO DE PRUEBA 3");
        //Creemos otro ticket
        Ticket ticket2 = new Ticket();
        ticket2.comprarPremium("Maria Juana", 2, vuelo1);
        ticket2.informacion();
        vuelo1.guardar(ticket2);
        vuelo1.asientosDisponibles();



    }
}