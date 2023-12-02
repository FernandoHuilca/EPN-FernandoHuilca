public class Vuelo {
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

    public int capacidadAsientosPremium() {
    return capacidadAsientosPremium;
    }

    public int contadorAsientosPremiumOcupados() {
        return contadorAsientosPremiumOcupados;
    }
}
