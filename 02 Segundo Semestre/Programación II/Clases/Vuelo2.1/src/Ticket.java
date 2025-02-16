public class Ticket {
    private String pasajeroPropietario;
    private int posicionDelAsiento;
    private boolean comprado = false;
    private String tipoDeTicket;


    public void comprarPremium(String pasajeroPropietario, int posicionDelAsiento, Vuelo vuelo) {
        comprarTicket(pasajeroPropietario, posicionDelAsiento, vuelo, "Premium");

    }
    public void comprarEconomica(String pasajeroPropietario, int posicionDelAsiento, Vuelo vuelo) {
        comprarTicket(pasajeroPropietario, posicionDelAsiento, vuelo, "Economica");
    }

    private void comprarTicket(String pasajeroPropietario, int posicionDelAsiento, Vuelo vuelo, String claseDeTicket) {
        if (estanVendidosTodosLosAsientos(vuelo, claseDeTicket)) {
            System.out.println("Todos los asientos estan vendidos!!");
            return;
        }
        if (yaEstaVendido()) {
            System.out.println("El voleto ya esta vendido a: " + pasajeroPropietario);
            return;
        }
        if (laPosicionYaEstaOcupada(posicionDelAsiento, vuelo, tipoDeTicket)) {
            this.pasajeroPropietario = pasajeroPropietario;
            this.posicionDelAsiento = posicionDelAsiento;
            this.tipoDeTicket = claseDeTicket;
            comprado = true;
            System.out.println("Compra Exitosa!! Disfrute su vuelo estimad@ " + pasajeroPropietario);
        }else {
            System.out.println("No se puede comprar porque el numero de asiento ya esta ocupado!!");
        }
    }




    /***********Esto no interesa***************************/
    private boolean yaEstaVendido() {
        return comprado;
    }

    private static boolean estanVendidosTodosLosAsientos(Vuelo vuelo, String claseDeTicket) {
        if (claseDeTicket == "Premium") {
            return vuelo.contadorAsientosPremiumOcupados() >= vuelo.capacidadAsientosPremium();
        }
        else
            return vuelo.contadorAsientosEconomicaOcupados() >= vuelo.capacidadAsientosEconomica();

    }

    public String getTipoDeTicket() {
    return tipoDeTicket;
    }

    public int getNumeroDeAsiento() {
        return posicionDelAsiento;
    }

    public void informacion() {
        System.out.println("El propietario de este ticket es: " + pasajeroPropietario);
        //System.out.println("COMPLETAR ESTO XD");
    }

    public boolean getComprado() {
        return comprado;
    }
    private static boolean laPosicionYaEstaOcupada(int posicionDelAsiento, Vuelo vuelo, String tipoDeTicket) {

        if (tipoDeTicket == "Premium") {
            return vuelo.getTicketsPremium()[posicionDelAsiento] == null;
        }
        else
            return vuelo.getTicketsEconomica()[posicionDelAsiento] == null;

    }


}
