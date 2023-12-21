import java.time.LocalDate;

public class Empresa {

    private LocalDate fechaDeInicio;
    private Cliente[] clientes;
    private int contadorClientes;
    private Turno[] turnosGenerales;
    private int contadorTurnosGenerales;
    private Turno[] turnosUrgentes;
    private int contadorTurnosUrgentes;

    public Empresa(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
        clientes = new Cliente[1000];
        contadorClientes = 0;
        turnosGenerales = new Turno[1000];
        contadorTurnosGenerales = 0;
        turnosUrgentes = new Turno[1000];
        contadorTurnosUrgentes = 0;

    }

    public Cliente registrarCliente(String nombreCliente, String celularCliente) {
        Cliente nuevoCliente = new Cliente(nombreCliente, celularCliente);
        clientes[contadorClientes++] = nuevoCliente;
        System.out.println("Cliente " + nombreCliente + " registrado con éxito!!");
        return nuevoCliente;
    }


    //AQUí VIENE LO POTENTE!!
    public void agendarTurno(Cliente cliente, LocalDate fechaDeTurno, TipoDeTurno tipoDeTurno) {
        if (!(estaClienteEnElRegistro(cliente))) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "el cliente no esta registrado.");
            return;
        }
        if (fechaDeTurno.isBefore(fechaDeInicio)) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "la fecha ingresada es anterior a la del inicio");
            return;
        }
        if (tieneClienteYaUnaCitaEsaFecha(cliente, fechaDeTurno)) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "el cliente ya tiene una cita en esa fecha solo puede una");
            return;
        }
        if (elDiaYaTieneTresCitas(fechaDeTurno)){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "dia ya tiene tres citas, no podemos trabajar mas jeje");
            return;
        }
        Turno nuevoTurno = new Turno(cliente, fechaDeTurno, tipoDeTurno);
        if (tipoDeTurno == TipoDeTurno.URGENTE) {
            turnosUrgentes[contadorTurnosUrgentes++] = nuevoTurno;
        } else {
            turnosGenerales[contadorTurnosGenerales++] = nuevoTurno;
        }
        System.out.println("Turno agendado con éxito para el cliente: " + cliente + "\n\tFecha del turno = " + fechaDeTurno);
    }



    public void cancelarTurno(Cliente cliente, LocalDate fechaDelTurno) {
        if (sePuedeCancelarTurnoEnArray(contadorTurnosGenerales, turnosGenerales, cliente, fechaDelTurno)) {
            contadorTurnosGenerales--;
            System.out.println("Turno cancelado con éxito!!");
            return;
        }
        if (sePuedeCancelarTurnoEnArray(contadorTurnosUrgentes, turnosUrgentes, cliente, fechaDelTurno)) {
            contadorTurnosUrgentes--;
            System.out.println("Turno cancelado con éxito!!");
            return;
        }
        System.out.println("El cliente no tiene un turno designado en esa fecha.");
    }


    public void imprimirTurnoParaElDia(LocalDate diaParaImprimir) {
        imprimirTurnos(turnosUrgentes, contadorTurnosUrgentes, diaParaImprimir);
        imprimirTurnos(turnosGenerales, contadorTurnosGenerales, diaParaImprimir);
    }





    /***************** METODOS QUE NO ES INTERESA LEER PORQUE ESTAMOS EN PROGRA DOS Y BLA BLA BLA... 🙄 ****************************************/
    private boolean estaClienteEnElRegistro(Cliente cliente) {
        for (Cliente magia : clientes) {
            if (magia != null && magia.equals(cliente)) {
                return true; // El cliente está en el registro
            }
        }
        return false;
    }
    private boolean tieneClienteYaUnaCitaEsaFecha(Cliente cliente, LocalDate fechaDeTurno) {
        if (coincideClienteYFecha(contadorTurnosGenerales, turnosGenerales, cliente, fechaDeTurno)) {
            return true;
        }
        if (coincideClienteYFecha(contadorTurnosUrgentes, turnosUrgentes, cliente, fechaDeTurno)) {
            return true;
        }
        return false;
    }
    private boolean elDiaYaTieneTresCitas(LocalDate fechaDeTurno) {
        int contadorCitasPorDia = 0;
        for (int i = 0; i < contadorTurnosGenerales; i++){
            if (turnosGenerales[i].getFecha().equals(fechaDeTurno)){
                contadorCitasPorDia++;
            }
        }
        for (int i = 0; i < contadorTurnosUrgentes; i++){
            if (turnosUrgentes[i].getFecha().equals(fechaDeTurno)){
                contadorCitasPorDia++;
            }
        }
        return contadorCitasPorDia == 3;
    }
    private boolean coincideClienteYFecha(int contadorTurnos, Turno[] turnos, Cliente cliente, LocalDate fechaDeTurno) {
        for (int i = 0; i < contadorTurnos; i++) {
            if (turnos[i].getCliente().equals(cliente) && turnos[i].getFecha().equals(fechaDeTurno)) {
                return true;
            }
        }
        return false;
    }
    private boolean sePuedeCancelarTurnoEnArray(int contadorTurnos, Turno[] turnos, Cliente cliente, LocalDate fechaDelTurno) {
        for (int i = 0; i < contadorTurnos; i++) {
            if (turnos[i].getCliente().equals(cliente) && turnos[i].getFecha().equals(fechaDelTurno)) {
                turnos[i] = turnos[contadorTurnos - 1];
                turnos[contadorTurnos - 1] = null;
                return true;
            }
        }
        return false;
    }
    private void imprimirTurnos(Turno[] turnos, int contadorTurnos, LocalDate diaParaImprimir) {
        int contador = 1;
        for (int i = 0; i < contadorTurnos; i++) {
            if (turnos[i].getFecha().equals(diaParaImprimir)) {
                System.out.println(String.valueOf(contador) + turnos[i]);
                contador++;
            }
        }
        if (contador == 1) {
            System.out.println("No hay citas para esa fecha: " + diaParaImprimir);
        }
    }

}
