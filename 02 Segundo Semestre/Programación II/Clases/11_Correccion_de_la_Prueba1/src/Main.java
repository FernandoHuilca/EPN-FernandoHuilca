// Author Fernando Huilca
/* Ejercicio: Diagrame y codifique la solución al siguiente enunciado tomando en consideración cumplir con
casos de prueba. Lea detenidamente t0do el enunciado antes de iniciar el desarrollo de la respuesta.

La empresa XYZ constantemente debe atender solicitudes de sus clientes. Para esto, la empresa requiere atender
a sus clientes a través de turnos que constan de día, mes y año. Finalmente, la empresa requiere imprimir la
lista de turnos (cliente) par un día determinado día. Considere las siguientes reglas para la generación de turnos:

1. Los turnos solo pueden ser entregados a fechas posteriores a la actual
2. Se puede entregar solamente un turno por cliente.
3. Se puede hacer una cancelación de turno para poder tomar otro.
4. Existen turnos normales y urgentes; estos cambian la prioridad, es decir, si un turno urgente se genera al final,
este deberá atenderse primero.
5. Solo se pueden entregar hasta 3 turnos por día.
Nota 1: Para el manejo de días, mes y año, considere que todos los meses tienen 30 días y que no existen años
bisiestos.

Nota 2: Para el punto UNO, puede manejar la fecha actual como constantes para día actual, mes actual y año actual.*/

import java.time.LocalDate; //Importo el paquete de Java.Time y la clase Date TAMBIEN voy a usar equals para comparar objetos :D

public class Main {
    public static void main(String[] args) {


        System.out.println("\n\t\u001B[34m Caso 1. Crear la empresa y agendar un turno_____________________________________________\u001B[0m");
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1); // Le voy a asignar un inicio a la empresa GENERALIZANDO!
        Empresa empresa = new Empresa(fechaDeInicio);

        Cliente fernando = empresa.registrarCliente("Fernando Huilca", "0979835003");
        empresa.agendarTurno(fernando, LocalDate.of(2023,1,1), TipoDeTurno.NORMAL);





        System.out.println("\n\t\u001B[34m Caso 2. Intentar sacar turno sin hacer primero el registro______________________________\u001B[0m");
        Cliente victor = new Cliente("Victor Hugo", "09454562112");
        empresa.agendarTurno(victor, LocalDate.of(2023,1,1), TipoDeTurno.NORMAL);





        System.out.println("\n\t\u001B[34m Caso 3. Agendar una cita en una fecha anterior a la actual______________________________\u001B[0m");
        Cliente carlos = empresa.registrarCliente("Carlos Anchundia", "09454562112");
        empresa.agendarTurno(carlos, LocalDate.of(2022,1,1), TipoDeTurno.NORMAL);




        System.out.println("\n\t\u001B[34m Caso 4. Se puede entregar solamente un turno por cliente._______________________________\u001B[0m");
        Cliente mary = empresa.registrarCliente("Mary Shelley", "0978787878");
        empresa.agendarTurno(mary, LocalDate.of(2023,1,1), TipoDeTurno.URGENTE);
        empresa.agendarTurno(mary, LocalDate.of(2023,1,1), TipoDeTurno.NORMAL);




        System.out.println("\n\t\u001B[34m Caso 5.Se puede hacer una cancelación de turno para poder tomar otro.___________________\u001B[0m");
        empresa.cancelarTurno(mary, LocalDate.of(2023,1,1));
        empresa.agendarTurno(mary, LocalDate.of(2023,1,1), TipoDeTurno.URGENTE);




        System.out.println("\n\t\u001B[34m Caso 6. Imprimir Turnos para un dia determinado.________________________________________\u001B[0m");
        empresa.imprimirTurnoParaElDia(LocalDate.of(2023,1,1));



        System.out.println("\n\t\u001B[34m Caso 7. Solo se pueden entregar hasta 3 turnos por día._________________________________\u001B[0m");
        Cliente edgar = empresa.registrarCliente("Edgar Allan Poe", "0978787878");
        empresa.agendarTurno(edgar, LocalDate.of(2023,2,2), TipoDeTurno.NORMAL);
        Cliente lovecraft = empresa.registrarCliente("Phillips lovecraft", "0978787878");
        empresa.agendarTurno(lovecraft, LocalDate.of(2023,2,2), TipoDeTurno.NORMAL);
        Cliente milan = empresa.registrarCliente("Milan Kundera", "0978787878");
        empresa.agendarTurno(milan, LocalDate.of(2023,2,2), TipoDeTurno.URGENTE);
        Cliente miguel = empresa.registrarCliente("Miguel de Cervantes", "0978787878"); //Aqui se supone que ya no me deja
        empresa.agendarTurno(miguel, LocalDate.of(2023,2,2), TipoDeTurno.URGENTE);




        System.out.println("\n\t\u001B[34m Caso 8. Turno urgente se genera al final, este deberá atenderse primero.________________\u001B[0m");
        empresa.imprimirTurnoParaElDia(LocalDate.of(2023,2,2)); // Usando el Caso de prueba 7 primero se debe imprimir Miguel de Cervantes


        System.out.println("\n\t\u001B[34m Caso 9. Imprimir Turnos de un dia que no tiene turnos.___________________________________\u001B[0m");
        empresa.imprimirTurnoParaElDia(LocalDate.of(2023,3,2));






    }
}