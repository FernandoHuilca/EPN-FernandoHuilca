public class Empresa {
    private int dia_inicio;
    private int mes_incio;
    private int anio_incio;
    private Turno[] turnos;
    private int contadorDeTurnos;

    public Empresa(int dia_inicio, int mes_incio, int anio_incio) {
        this.dia_inicio = dia_inicio;
        this.mes_incio = mes_incio;
        this.anio_incio = anio_incio;
        turnos = new Turno[100];
        contadorDeTurnos = 0;

    }

    public void agendarTurno(Cliente cliente, String tipoDeTurno, int dia, int mes, int anio) {
        if (esLaFechaAnteriorALaActual(dia, mes, anio)) {
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La fecha es anterior a la actual!!");
            return;
        }
        if (tieneClienteYaUnTurno(cliente)){
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " El cliente ya tiene un turno!!");
            return;
        }
        Turno nuevoTurno = new Turno(cliente, tipoDeTurno, dia, mes, anio);
        turnos[contadorDeTurnos++] = nuevoTurno;
    }
    private boolean tieneClienteYaUnTurno(Cliente cliente) {
        for (int i = 0; i < contadorDeTurnos; i++) {
            if (turnos[i].getCliente() == cliente) {
                return true;
            }
        }
        return false;
    }

    private boolean esLaFechaAnteriorALaActual(int dia, int mes, int anio) {
        if (anio < anio_incio) {
            return true;
        } else if (anio == anio_incio && mes < mes_incio) {
            return true;
        } else if (anio == anio_incio && mes == mes_incio && dia < dia_inicio) {
            return true;
        }
        return false;
    }

    public void imprimirTurnoDelDia(int dia, int mes, int anio) {
        System.out.println("Turnos para el día " + dia + "/" + mes + "/" + anio + ":");
        for (int i = 0; i < contadorDeTurnos; i++) {
            Turno turno = turnos[i];
            if (turno.getDia() == dia && turno.getMes() == mes && turno.getAnio() == anio) {
                System.out.println(turnos[i]);
            }
        }
    }


    public void cancelarTurno(Cliente cliente) {
        for (int i = 0; i < contadorDeTurnos; i++) {
            if (turnos[i].getCliente() == cliente) {
                System.out.println("Turno cancelado para el cliente " + cliente.nombre());
                turnos[i] = null;
                break;
            }
        }
    }



}
