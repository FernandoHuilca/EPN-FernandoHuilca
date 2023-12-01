public class Vuelo {
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    private String companiaDelVuelo;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private int asientosTotal;
    private int capacidadAsientosEconomica;
    private int contadorAsientosEconomicaOcupados;
    private int contadorAsientosPremiumOcupados;
    private int capacidadAsientosPremium;
    private Ticket[] ticketsPremium;
    private Ticket[] ticketsEconomica;

    public Vuelo(String companiaDelVuelo, String origen, String destino, String fecha, String hora,
                 int capacidadAsientosPremium, int capacidadAsientosEconomica) {

        this.companiaDelVuelo = companiaDelVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidadAsientosPremium = capacidadAsientosPremium;
        contadorAsientosPremiumOcupados = 0;
        this.capacidadAsientosEconomica = capacidadAsientosEconomica;
        contadorAsientosEconomicaOcupados = 0;
        this.asientosTotal = capacidadAsientosEconomica + capacidadAsientosPremium;
        ticketsEconomica = new Ticket[capacidadAsientosEconomica];
        ticketsPremium = new Ticket[capacidadAsientosPremium];

    }

    public void asientosDisponibles() {
        System.out.println("Los asientos disponibles totales son: " + (asientosTotal - (contadorAsientosEconomicaOcupados + contadorAsientosPremiumOcupados)));
        System.out.println("Los asientos Premium disponibles totales son: "+ (capacidadAsientosPremium - contadorAsientosPremiumOcupados));
        for (int i = 0; i < capacidadAsientosPremium; i++){
            if (ticketsPremium[i] == null){
                System.out.print( ROJO + " " + i + "Y " + RESET);
            }
            else {
                System.out.print( VERDE + " " + i + "X " + RESET);
            }
            if (i!=0 && i % 10 == 0){
                System.out.println(" ");
            }
        }
        System.out.println(" ");
        System.out.println("Los asientos clase Economica disponibles totales son: " + (capacidadAsientosEconomica - contadorAsientosEconomicaOcupados));
        for (int i = 0; i < capacidadAsientosEconomica; i++){
            if (ticketsEconomica[i] == null){
                System.out.print( ROJO + " " + i + "Y " + RESET);
            }
            else {
                System.out.print( VERDE + " " + i + "X " + RESET);
            }
            if (i!=0 && i % 10 == 0){
                System.out.println(" ");
            }
        }
        System.out.println(" ");
    }

    public void informacion() {
        System.out.println("Vuelo de la compania: " + companiaDelVuelo + ".");
        System.out.println("El vuelo sale desde: " + origen + " hacia: " + destino + ". Con una capacidad de: " + asientosTotal + " pasajeros" );
        System.out.println("El vuelo sale en el horario: " + fecha + " a las: " + hora + ".");

    }

    public String imprimirOrigen() {
        return origen;
    }

    public int contadorAsientosPremiumOcupados() {
        return contadorAsientosPremiumOcupados;
    }

    public int capacidadAsientosPremium() {
        return capacidadAsientosPremium;
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

    public Ticket[] getTicketsPremium() {
        return ticketsPremium;
    }
}
