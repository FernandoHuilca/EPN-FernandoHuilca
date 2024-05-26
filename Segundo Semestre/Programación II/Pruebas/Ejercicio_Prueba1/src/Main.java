// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {


        System.out.println("\n\tCaso 1. Crear la empresa y agendar una cita___________________________________________");
        Empresa xyz = new Empresa(1,1,2023); //Voy a recibir una fecha de incio porque la actual no me gusta :)
        xyz.agendarTurno(new Cliente("Fernando Huilca"), "normal", 1,5,2023);
        xyz.imprimirTurnoDelDia(1,5,2023);




        System.out.println("\n\tCaso 2. Agendar una cita en una fecha anterior a la actual____________________________");
        xyz.agendarTurno(new Cliente("Carlos Anchundia"), "normal", 30, 2, 2022);




        System.out.println("\n\tCaso 3. Se puede entregar solamente un turno por cliente.____________________________");
        Cliente gabriel = new Cliente("Gabriel Garcia");
        xyz.agendarTurno(gabriel, "normal", 1, 6, 2023 );
        xyz.agendarTurno(gabriel, "normal", 1, 6, 2023 );


        System.out.println("\n\tCaso 4.Se puede hacer una cancelación de turno para poder tomar otro._________________");
        xyz.cancelarTurno(gabriel);


        //PIPIPIIII NO ACABEEEEE :(



    }
}