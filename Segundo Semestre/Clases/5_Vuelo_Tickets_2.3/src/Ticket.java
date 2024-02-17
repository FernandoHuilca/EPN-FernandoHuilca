public class Ticket {
    private String duenioDelTicket;
    private boolean vendido = false;

    public Ticket(String duenioDelTicket) {
        this.duenioDelTicket = duenioDelTicket;
    }

    public void vender() {
        if (vendido) {
            try {
                throw new TicketVendido();
            } catch (TicketVendido e) {
                System.out.println(e.getMessage());
            }
        } else {
            vendido = true;
            System.out.println("Ticket vendido con exito, el duenio es: \"" + duenioDelTicket + "\"");
        }
    }
}
