public class Main {
    public static void main(String[] args) {
        //Crear la empresa
        Empresa empresaXYZ = new Empresa();
        String colorRojo = new String("\033[31m");

        //emitir Turno
        System.out.println("\033[31m" + "Emitir Turno" + "\033[0m");
        empresaXYZ.emitirTurno("Mateo", TipoDeTurno.NORMAL, 17, Mes.DICIEMBRE, 2023);

        //Imprimir Turno para dia determinado
        System.out.println("\033[31m" + "Imprirmir Turno" + "\033[0m");
        empresaXYZ.imprimirListaDeTurnos(17, Mes.DICIEMBRE, 2023);
        //Imprimir para un dia que no hay turnos
        empresaXYZ.imprimirListaDeTurnos(19, Mes.DICIEMBRE, 2023);

        //solo se puede emitir a fechas posteriores a la actual
        System.out.println("\033[31m" + "No fechas anteriores" + "\033[0m");
        empresaXYZ.emitirTurno("Juan", TipoDeTurno.NORMAL, 10, Mes.DICIEMBRE, 2023); //TODO: no es permitido

        //empresaXYZ.emitirTurno("Santiago", TipoDeTurno.NORMAL, 10, Mes.NOVIEMBRE, 2023); //TODO: No es permitido


        //solo un turno por cliente, ERROR DEBE DAR ESTO
        System.out.println("\033[31m" + "Un turno Por cliente" + "\033[0m");
        empresaXYZ.emitirTurno("Mateo", TipoDeTurno.NORMAL, 18, Mes.DICIEMBRE, 2023);

        //cancelar turno
        System.out.println("\033[31m" + "Cancelar el turno" + "\033[0m");
        empresaXYZ.cancelarTurno(1);
        empresaXYZ.cancelarTurno(2);
        empresaXYZ.cancelarTurno(0);

        System.out.println("\033[31m" + "Revision de la Lista De Turnos" + "\033[0m");
        empresaXYZ.imprimirListaDeTurnos(17, Mes.DICIEMBRE, 2023);


        //ahora si puedo tomar un turno
        System.out.println("\033[31m" + "Permitir el turno" + "\033[0m");
        empresaXYZ.emitirTurno("Mateo", TipoDeTurno.NORMAL, 18, Mes.DICIEMBRE, 2023);

        //al momento de imprimir turnos, tiene prioridad urgente
        System.out.println("\033[31m" + "Imprimir urgente y primero" + "\033[0m");
        empresaXYZ.emitirTurno("Pablo", TipoDeTurno.URGENTE, 18, Mes.DICIEMBRE, 2023);
        empresaXYZ.imprimirListaDeTurnos(18, Mes.DICIEMBRE, 2023);

        //si excedo el diario de turnos ya no puedo tomar mas turnos
        System.out.println("\033[31m" + "No Permitir Tomar mas turnos" + "\033[0m");
        empresaXYZ.emitirTurno("Sol", TipoDeTurno.NORMAL, 18, Mes.DICIEMBRE, 2023);
        empresaXYZ.emitirTurno("Irene", TipoDeTurno.NORMAL, 18, Mes.DICIEMBRE, 2023);//Este ya no debe permitir


        //
    }
}