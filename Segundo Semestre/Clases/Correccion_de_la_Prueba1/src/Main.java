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


        System.out.println("\n\tCaso 1. Crear la empresa y agendar un turno__________________________________________");
        LocalDate fechaDeInicio = LocalDate.of(2023, 1, 1); // Le voy a asignar un inicio a la empresa GENERALIZANDO!
        Empresa empresa = new Empresa(fechaDeInicio);

        Cliente fernando = empresa.registrarCliente("Fernando Huilca", "0979835003");
        empresa.agendarTurno(fernando, LocalDate.of(2023,1,1));  //TODO: Preguntar si es mejor al agendar una cita registrar el cliente

        System.out.println("\n\tCaso 2. Intentar sacar turno sin hacer primero el registro____________________________");
        Cliente alison = new Cliente("Alison Betancour", "09454562112");
        empresa.agendarTurno(alison, LocalDate.of(2023,1,1));

        System.out.println("\n\tCaso 3. Agendar una cita en una fecha anterior a la actual____________________________");
        Cliente carlos = empresa.registrarCliente("Carlos Anchundia", "09454562112");
        empresa.agendarTurno(carlos, LocalDate.of(2022,1,1));


        System.out.println("\n\tCaso 4. Se puede entregar solamente un turno por cliente._____________________________"); //TODO: preguntar si es por dia o por siempre
        Cliente gabriel = empresa.registrarCliente("Gabriel Garcia", "0978787878");
        empresa.agendarTurno(gabriel, LocalDate.of(2023,1,1));
        empresa.agendarTurno(gabriel, LocalDate.of(2023,1,1));


    }
}