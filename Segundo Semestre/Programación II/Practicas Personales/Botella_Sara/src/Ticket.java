public class Ticket {
    private String nombreDelPasajero;
    private String tipoDeVuelo;
    private String destino;
    private int horario;
    private int numeroDelAsiento;
    private boolean comprado;

    public Ticket(String nombreDelPasajero, String tipoDeVuelo, String destino, int horario, int asiento) {
        if (esUnHorarioErroneo(horario)) {
            System.out.println("No existe ese horario");
            return;
        }
        this.nombreDelPasajero = nombreDelPasajero;
        this.tipoDeVuelo = tipoDeVuelo;
        this.destino = destino;
        this.horario = horario;
        this.numeroDelAsiento = asiento;
        comprado = false;
    }

    private static boolean esUnHorarioErroneo(int horario) {
        return horario < 0 || horario >= 24;
    }

    public boolean cancelar() throws CancelarVuelo {
        if (!estaComprado()) {
            throw new CancelarVuelo();
        }
        comprado = false;
        return true;
    }

    public String toString() {
        return "Info del ticket: " +
                nombreDelPasajero + " - " + tipoDeVuelo + " - " + destino + " - " +
                (comprado ? "comprado" : "cancelado") + " - " + horario + ":00 - " + "#Asiento: " + numeroDelAsiento;
    }

    public int mostrarAsiento() {

        return numeroDelAsiento;
    }

    public boolean estaComprado() {

        return comprado;
    }


    public boolean comprar() throws BoletoComprado {
        if (estaComprado()) {
            throw new BoletoComprado();
        }
        return comprado = true;
    }
}