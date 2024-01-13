public class Vuelo {
    private String companiaDelVuelo;
    private String origen;
    private String destino;
    private String fechaDeSalida;
    private String horaDeSalida;
    private int asientosTotales;
    private int contadorAsientosEconomicaOcupados;
    private int contadorAsientosPremiumOcupados;
    private int capacidadAsientosPremium;
    private int capacidadAsientosEconomica;
    private Ticket[] ticketsPremium;
    private Ticket[] ticketsEconomica;


    public Vuelo(String companiaDelVuelo, String origen, String destino, String fechaDeSalida, String horaDeSalida,
                 int capacidadAsientosPremium, int capacidadAsientosEconomica) {

        this.companiaDelVuelo = companiaDelVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaDeSalida = fechaDeSalida;
        this.horaDeSalida = horaDeSalida;
        this.capacidadAsientosPremium = capacidadAsientosPremium;
        contadorAsientosPremiumOcupados = 0;
        this.capacidadAsientosEconomica = capacidadAsientosEconomica;
        contadorAsientosEconomicaOcupados = 0;
        this.asientosTotales = capacidadAsientosEconomica + capacidadAsientosPremium;
        ticketsEconomica = new Ticket[capacidadAsientosEconomica];
        ticketsPremium = new Ticket[capacidadAsientosPremium];
        System.out.println("Vuelo creado con Exito!!");

    }

    public void informacionGeneral() { // TODO: Hacer un metodo para esto??? preguntar al Carlitos
        System.out.println("************* Informacion General *************");
        System.out.println("Compañía del vuelo: \"" + companiaDelVuelo + "\"");
        System.out.println("Origen y Destino del vuelo: \"" + origen + "\" to \"" + destino + "\"");
        System.out.println("Fecha y hora de salida: " + fechaDeSalida + " " + horaDeSalida);
        System.out.println("Capacidad de pasajeros: " + asientosTotales + " pasajeros");
        System.out.println("Asientos ocupados: " + cantidadDeAsientosOcupados() + " asientos");
        System.out.println("************************************************");
    }

    public Ticket venderTicketPremium(String duenioDelTicket, int posicionDelAsiento) {
        if (estaElAsientoPremiumOcupado(posicionDelAsiento)) {
            System.out.println("ERROR: El asiento numero " + posicionDelAsiento + " ya esta ocupado.");
            return null; //TODO: Preguntar a CARLOS GOD si se puede hacer eso
        }
        if (estanVendidosTodosLosTicketsPremium()) {
            System.out.println("ERROR: Todos los asientos están vendidos.");
            return null;
        }
        Ticket ticket = new Ticket(duenioDelTicket);
        ticket.vender();
        ticketsPremium[posicionDelAsiento] = ticket;
        contadorAsientosPremiumOcupados++;
        return ticket;
    }

    public Ticket venderTicketEconomica(String duenioDelTicket, int posicionDelAsiento) {
        if (estaElAsientoEconomicaOcupado(posicionDelAsiento)) {
            System.out.println("ERROR: El asiento numero " + posicionDelAsiento + " ya esta ocupado.");
            return null;
        }
        if (estanVendidosTodosLosTicketsEconomica()) {
            System.out.println("ERROR: Todos los asientos están vendidos.");
            return null;
        }
        Ticket ticket = new Ticket(duenioDelTicket);
        ticket.vender();
        ticketsEconomica[posicionDelAsiento] = ticket;
        contadorAsientosEconomicaOcupados++;
        return ticket;
    }


    public void asientosDisponibles() {
        // Asientos premium
        mostrarAsientosDisponibles("Premium", ticketsPremium, capacidadAsientosPremium);

        // Asientos de clase económica
        mostrarAsientosDisponibles("Economica", ticketsEconomica, capacidadAsientosEconomica);
    }


    /************* Métodos que no importan *********************/
    private int cantidadDeAsientosOcupados() {
        return contadorAsientosPremiumOcupados + contadorAsientosEconomicaOcupados;
    }

    private boolean estanVendidosTodosLosTicketsPremium() {
        return contadorAsientosPremiumOcupados >= capacidadAsientosPremium;
    }

    private boolean estaElAsientoPremiumOcupado(int posicionDelAsiento) {
        return ticketsPremium[posicionDelAsiento] != null;
    }

    private boolean estaElAsientoEconomicaOcupado(int posicionDelAsiento) {
        return ticketsEconomica[posicionDelAsiento] != null;
    }

    private boolean estanVendidosTodosLosTicketsEconomica() {
        return contadorAsientosEconomicaOcupados >= capacidadAsientosEconomica;
    }

    private void mostrarAsientosDisponibles(String clase, Ticket[] tickets, int capacidad) {
        String RESET = "\u001B[0m";
        String ROJO = "\u001B[31m";
        String VERDE = "\u001B[32m";
        System.out.println("Clase " + clase + ". \nAsientos disponibles: " + (capacidad - contarAsientosOcupados(tickets))
                + ". Asientos ocupados: " + contarAsientosOcupados(tickets));
        for (int i = 0; i < capacidad; i++) {
            if (tickets[i] == null) {
                System.out.print(ROJO + " " + i + "Y " + RESET);
            } else {
                System.out.print(VERDE + " " + i + "X " + RESET);
            }
            if (i != 0 && i % 10 == 0) {
                System.out.println(" ");
            }
        }
        System.out.println(" ");
    }

    private int contarAsientosOcupados(Ticket[] tickets) {
        int contador = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                contador++;
            }
        }
        return contador;
    }
}
