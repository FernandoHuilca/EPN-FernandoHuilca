public class Ticket {
    private String pasajeroPropietario;
    private int posicionDelAsiento;
    private boolean comprado = false;
    private String origen;
    private String tipoDeTicket;


    public void comprarPremium(String pasajeroPropietario, int posicionDelAsiento, Vuelo vuelo) {
        if (estanVendidosTodosLosAsientos(vuelo)) {
            System.out.println("Todos los asientos estan vendidos!!");
            return;
        }
        if (yaEstaVendido()) {
            System.out.println("El voleto ya esta vendido a: " + pasajeroPropietario);
            return;
        }
        if (vuelo.getTicketsPremium()[posicionDelAsiento] == null) {
            this.pasajeroPropietario = pasajeroPropietario;
            this.posicionDelAsiento = posicionDelAsiento;
            tipoDeTicket = "Premium";
            comprado = true;
        }else {
            System.out.println("No se puede comprar porque el numero de asiento ya esta ocupado!!");
        }

    }


    /***********Esto no interesa***************************/
    private boolean yaEstaVendido() {
        return comprado;
    }

    private static boolean estanVendidosTodosLosAsientos(Vuelo vuelo) {
        return vuelo.contadorAsientosPremiumOcupados() >= vuelo.capacidadAsientosPremium();
    }

    public String getTipoDeTicket() {
    return tipoDeTicket;
    }

    public int getNumeroDeAsiento() {
        return posicionDelAsiento;
    }

    public void informacion() {
        System.out.println("El propietario de este ticket es: " + pasajeroPropietario);
        System.out.println("XD");
    }

    public boolean getComprado() {
        return comprado;
    }
}
