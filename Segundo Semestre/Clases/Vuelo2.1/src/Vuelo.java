public class Vuelo {
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";

    private String companiaDelVuelo;
    private String origen;
    private String destino;
    private String fechaDeSalida;
    private String horaDeSalida;
    private int asientosTotales;
    private int capacidadAsientosEconomica;
    private int contadorAsientosEconomicaOcupados;
    private int contadorAsientosPremiumOcupados;
    private int capacidadAsientosPremium;
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

    }

    public void asientosDisponibles() {
        // Asientos premium
        mostrarAsientosDisponibles("Premium", ticketsPremium, capacidadAsientosPremium);

        // Asientos de clase económica
        mostrarAsientosDisponibles("Economica", ticketsEconomica, capacidadAsientosEconomica);
    }

    public void informacionGeneral() {
        System.out.println("Vuelo de la compania: " + companiaDelVuelo + ".");
        System.out.println("El vuelo sale desde: " + origen + " hacia: " + destino + ". Con una capacidad de: " + asientosTotales + " pasajeros" );
        System.out.println("El vuelo sale en el horario: " + fechaDeSalida + " a las: " + horaDeSalida + ".");

    }



    public void guardar(Ticket ticket) {
        if (ticket.getTipoDeTicket() == "Premium") {
            ticketsPremium[ticket.getNumeroDeAsiento()] = ticket;
            contadorAsientosPremiumOcupados++;
        }
        if (ticket.getTipoDeTicket() == "Economica") {
            ticketsEconomica[ticket.getNumeroDeAsiento()] = ticket;
            contadorAsientosEconomicaOcupados++;
        }

    }


/*********************No interesa***********************************/
    private void mostrarAsientosDisponibles(String clase, Ticket[] tickets, int capacidad) {
        System.out.println("Los asientos disponibles de clase " + clase + " son: " + (capacidad - contarAsientosOcupados(tickets)));
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

    public Ticket[] getTicketsPremium() {
        return ticketsPremium;
    }
    public int contadorAsientosPremiumOcupados() {
        return contadorAsientosPremiumOcupados;
    }

    public int capacidadAsientosPremium() {
        return capacidadAsientosPremium;
    }

    public int contadorAsientosEconomicaOcupados() {
        return contadorAsientosEconomicaOcupados;
    }

    public int capacidadAsientosEconomica() {
        return capacidadAsientosEconomica;
    }

    public Ticket[] getTicketsEconomica() {
        return ticketsEconomica;
    }
}
