import java.util.Arrays;

public class Vuelo {
    public static final int CAPACIDAD_MAXIMA_DE_ASIENTOS = 3;
    private Ticket[] asientosDeLosTickets;
    private int capacidadDeAsientos;
    private int asientosDisponibles;

    public Vuelo() {
        capacidadDeAsientos = CAPACIDAD_MAXIMA_DE_ASIENTOS;
        asientosDisponibles = capacidadDeAsientos;
        asientosDeLosTickets = new Ticket[capacidadDeAsientos];
    }

    @Override
    public String toString() {
        return "Info del vuelo: " +
                "Asientos disponibles: " + asientosDisponibles + "/" + capacidadDeAsientos + " " +
                Arrays.toString(asientosDeLosTickets);
    }

    public void comprarTicket(Ticket ticket) throws NumeroValidoAsiento {
        if (esUnNuméroVálido(ticket)) {
            throw new NumeroValidoAsiento();
        }
        if (!hayAsientos()) {
            System.out.println("Ya no quedan asientos disponibles");
            return;
        }
        try {
            if (ticket.comprar()) {
                return;
            }
        } catch (BoletoComprado e) {
            System.out.println(e.getMessage());
        }
        asientosDeLosTickets[ticket.mostrarAsiento() - 1] = ticket;
        asientosDisponibles--;
    }

    private boolean hayAsientos() {

        return asientosDisponibles >= 0;
    }

    private boolean esUnNuméroVálido(Ticket ticket) throws NumeroValidoAsiento {
        if (!hayAsientos()) {
            throw new NumeroValidoAsiento();
        }
        return (ticket.mostrarAsiento() <= 0) || ((ticket.mostrarAsiento()) > capacidadDeAsientos);
    }

    public void cancelarTicket(Ticket ticket) {
        if (!hayTicketsPorCancelar()) {
            System.out.println("No existen mas tickets para cancelar");
            return;
        }
        try {
            if (!ticket.cancelar()) {
                return;
            }
        } catch (CancelarVuelo e) {
            System.out.println(e.getMessage());
        }
        asientosDisponibles++;
        asientosDeLosTickets[ticket.mostrarAsiento() - 1] = null;
    }

    private boolean hayTicketsPorCancelar() {

        return asientosDisponibles == 5;
    }

    public void imprimirInformacionDatos(Ticket ticket) {

        System.out.println(ticket);
    }
}
