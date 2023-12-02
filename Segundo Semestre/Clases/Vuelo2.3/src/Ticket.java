public class Ticket {
    private String duenioDelTicket;
    private boolean vendido = false;

    public Ticket(String duenioDelTicket) {
        this.duenioDelTicket = duenioDelTicket;
    }

    public void vender() {
        if (vendido) {
            System.out.println("ERROR: No se puede vender el ticket porque ya esta vendido. ");
            return;
        }
        vendido = true;
        System.out.println("Ticket vendido con exito, el duenio es: \"" + duenioDelTicket + "\"");
    }
}
