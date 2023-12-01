public class Vuelo {
    private String origen;
    private String destino;
    private String fecha;
    private boolean vendido;
    private int cantidadDeAsientosPremium;
    private int cantidadDeAsientosEconomicos;
    private Ticket[] ticketsPremium;
    private Ticket[] ticketsEconomico;
    

    public Vuelo(String origen, String destino, String fecha, int premium, int economica) {
    this.origen = origen; 
    this.destino = destino;
    this.fecha = fecha;
    this.cantidadDeAsientosEconomicos = economica;
    this.cantidadDeAsientosPremium = premium; 
    
    }


    public void comprarTicket() {
        vendido = true;
    }
}
