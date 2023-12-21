public class Empresa {
    private int cantidadDeTurno;
    private int cantidadDeTurnosUrgentes;
    private Turno[] turnos;
    private Turno[] turnosUrgentes;
    private Fecha fechaDeInicio;
    private int cantidadDeTurnoDiarios;

    public Empresa() {
        cantidadDeTurno = 0;
        cantidadDeTurnosUrgentes =0;
        turnos = new Turno[100];
        turnosUrgentes = new Turno[100];
        fechaDeInicio = new Fecha(16, Mes.DICIEMBRE, 2023);
    }

    public void emitirTurno(String nombreDelCliente, TipoDeTurno tipoDeTurno, int diaTurno, Mes mesTurno,
                            int añoTurno) {
        Fecha nuevaFecha = new Fecha(diaTurno, mesTurno, añoTurno );
        for (int j =0; j < cantidadDeTurno; j++){
            if (turnos[j].tieneUnTurno(nombreDelCliente) && !(turnos[j].estaCancelado())){
                System.out.println("Solo Puede adquirir un turno por Cliente");
                return;
            }
        }
        if(!esPosteriorALaFechaDeIncio(nuevaFecha)){
            System.out.println("La Fecha Ingresada es Anterior a la fecha actual");
            return;
        }

        if(esMayorALosTurnosDiarios(nuevaFecha)){
            System.out.println("No es permitido mas TURNOS EL DIA DE HOY, agende para un nuevo dia");
            return;
        }

        int numeroDeTurno = cantidadDeTurno + cantidadDeTurnosUrgentes + 1;

        Turno nuevoTurno = new Turno(numeroDeTurno, nombreDelCliente, tipoDeTurno, nuevaFecha);
        //if(!esDespuesdeFechaActual(nuevaFecha))

        if(nuevoTurno.esUrgente()){
            turnosUrgentes[cantidadDeTurnosUrgentes] = nuevoTurno;
            cantidadDeTurnosUrgentes++;
            System.out.println("Ha obtenido el turno " + numeroDeTurno);
            return;
        }
        turnos[cantidadDeTurno] = nuevoTurno;
        cantidadDeTurno++;
        System.out.println("Ha obtenido el turno " + numeroDeTurno);
    }

    private boolean esMayorALosTurnosDiarios(Fecha nuevaFecha) {
        cantidadDeTurnoDiarios =0;
        for (int k = 0; k < cantidadDeTurnosUrgentes; k++) {
            if (turnosUrgentes[k].esLaMismaFechaImprimir(nuevaFecha)&&turnosUrgentes[k].estaActivoELTurno()) {
                cantidadDeTurnoDiarios++;
            }
        }
        if (cantidadDeTurnoDiarios>= 3){
            return true;
        }
        for (int k = 0; k < cantidadDeTurno; k++) {
            if (turnos[k].esLaMismaFechaImprimir(nuevaFecha)&&turnos[k].estaActivoELTurno()) {
                cantidadDeTurnoDiarios++;
            }
        }
        if (cantidadDeTurnoDiarios>= 3){
            return true;
        }
        return false;
    }

    private boolean esPosteriorALaFechaDeIncio(Fecha nuevaFecha) {
        if(!fechaDeInicio.esPosteriorALaFechaConstante(nuevaFecha)){
            return false;
        }
        return true;
    }

    public void imprimirListaDeTurnos(int diaDeTurnos, Mes mesDelosTurnos, int añoDeLosTurnos) {
        Fecha fechaComparar = new Fecha(diaDeTurnos, mesDelosTurnos, añoDeLosTurnos);
        System.out.println("\t" + fechaComparar);
        //System.out.println(turnos[0].getFecha());

        imprimirTurnosUrgentes(fechaComparar);

        imprimirTurnosNormales(fechaComparar);
    }

    private void imprimirTurnosNormales(Fecha fechaComparar) {
        for (int i = 0; i < cantidadDeTurno; i++) {
            if (turnos[i].esLaMismaFechaImprimir(fechaComparar)&&turnos[i].estaActivoELTurno()) {
                System.out.println(turnos[i]);
            }

        }
    }

    private void imprimirTurnosUrgentes(Fecha fechaComparar) {
        for (int k = 0; k < cantidadDeTurnosUrgentes; k++) {
            if (turnosUrgentes[k].esLaMismaFechaImprimir(fechaComparar)&&turnosUrgentes[k].estaActivoELTurno()) {
                System.out.println(turnosUrgentes[k] + "\033[32m" + " TURNO URGENTE" + "\033[0m");
            }

        }
    }

    public void cancelarTurno(int numeroDeTurno) {
        if (numeroDeTurno > cantidadDeTurno){
            System.out.println("NO es posible cancelar un turno INEXISTENTE");
            return;
        }
        if (numeroDeTurno<1){
            System.out.println("EL TURNO INGRESADO NO ES CORRECT");
            return;
        }
        turnos[numeroDeTurno-1].cancelarTurno();
        System.out.println("Su Turno: " + numeroDeTurno+ " ha sido cancelado");
        return;
    }
}