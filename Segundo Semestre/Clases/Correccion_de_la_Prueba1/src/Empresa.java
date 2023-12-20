import java.time.LocalDate;

public class Empresa {

    private LocalDate fechaDeInicio;
    private Cliente[] clientes;
    private int contadorClientes;
    private Turno[] turnos;
    private int contadorTurnos;

    public Empresa(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
        clientes = new Cliente[1000];
        contadorClientes = 0;
        turnos = new Turno[1000];
        contadorTurnos = 0;
    }

    public Cliente registrarCliente(String nombreCliente, String celularCliente) {
        Cliente nuevoCliente = new Cliente(nombreCliente,celularCliente);
        clientes[contadorClientes++] = nuevoCliente;
        System.out.println("Cliente " + nombreCliente + " registrado con éxito!!");
        return nuevoCliente;
    }

    public void agendarTurno(Cliente cliente, LocalDate fechaDeTurno) {
        if (!(estaClienteEnElRegistro(cliente))){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "el cliente no esta registrado." );
            return;
        }
        if (fechaDeTurno.isBefore(fechaDeInicio)){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "la fecha ingresada es anterior a la del incio" );
            return;
        }
        if (tieneClienteYaUnaCitaEsaFecha(cliente, fechaDeTurno)){
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + "el cliente ya tiene una cita en esa fecha solo puede una" );
            return;
        }
        Turno nuevoTurno = new Turno(cliente, fechaDeTurno);
        turnos[contadorTurnos++] = nuevoTurno;
        System.out.println("Turno agendado con éxito para el cliente: " + cliente + "\n\tFecha del turno = " + fechaDeTurno);
    }

    private boolean tieneClienteYaUnaCitaEsaFecha(Cliente cliente, LocalDate fechaDeTurno) {
        for (int i = 0; i < contadorTurnos; i++){
            if (turnos[i].getCliente().equals(cliente) && turnos[i].getFecha().equals(fechaDeTurno)){
                return true;
            }
        }
        return false;
    }


    private boolean estaClienteEnElRegistro(Cliente cliente) {
        for (Cliente magia : clientes) {
            if (magia != null && magia.equals(cliente)) {
                return true; // El cliente está en el registro
            }
        }
        return false; // El cliente no está en el registro
    }
}
