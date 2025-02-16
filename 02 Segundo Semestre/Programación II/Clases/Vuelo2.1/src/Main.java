// Author Fernando Huilca
public class Main {

    public static void main(String[] args) {

        //Primero, vamos a crear un vuelo
        Vuelo vuelo1 = new Vuelo("Cathay Pacific", "Quito", "Argentina",
                "30/11/2023", "14:00h", 50, 100);
        //Ahora, vamos a preguntar cuantos asientos tiene disponibles, y preguntar sobre informacion general
        //vuelo1.asientosDisponibles();
        vuelo1.informacionGeneral();


        System.out.println("*********************** CASO DE PRUEBA 1. Comprar ticket  *************************");
        //Crear un ticket de vuelo
        Ticket ticket1 = new Ticket();
        //Luego, vamos a intentar comprar un ticket premium para el vuelo1
        ticket1.comprarPremium("Fernando Huilca", 0, vuelo1);
        ticket1.informacion();
        vuelo1.guardar(ticket1);
        vuelo1.asientosDisponibles();




        System.out.println("*********************** CASO DE PRUEBA 2. Comprar asiento que ya esta comprado  *************************");
        //Creemos otro ticket
        Ticket ticket2 = new Ticket();
        ticket2.comprarPremium("Maria Juana", 0, vuelo1);
        ticket2.informacion();
        vuelo1.guardar(ticket2);
        vuelo1.asientosDisponibles();



        System.out.println("*********************** CASO DE PRUEBA 3. Comprar asiento Economica  *************************");
        //Creemos otro ticket
        Ticket ticket3 = new Ticket();
        ticket3.comprarEconomica("Maria Juana", 0, vuelo1);
        ticket3.informacion();
        vuelo1.guardar(ticket3);
        vuelo1.asientosDisponibles();



        Ticket ticket4 = new Ticket();
        ticket4.comprarEconomica("Maria Juana", 14, vuelo1);
        ticket4.informacion();
        vuelo1.guardar(ticket4);
        vuelo1.asientosDisponibles();


    }
}