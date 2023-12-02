public class Ticket {
    private String nombrePasajero;
    private int posicionDelAsiento;
    private boolean comprado = false;
    //private String tipoDeTicket;

    public void comprar(String nombrePasajero, int posicionDelAsiento, Vuelo vuelo, String tipoDeTicket) {
        comprado = true;
        this.nombrePasajero = nombrePasajero;
        this.posicionDelAsiento = posicionDelAsiento;
    }

    public void imprimirTicket() {
        System.out.println("Nombre pasajero: "  + nombrePasajero + ".");
        System.out.println("Numero de asiento: " + posicionDelAsiento + ".");
        System.out.println("Destino: " + origen + ".");
    }

}
