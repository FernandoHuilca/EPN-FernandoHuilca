public class TicketVendido extends Throwable {
    public TicketVendido () {
        super("ERROR: No se puede vender el ticket porque ya tiene dueño");
    }
}
