/*Gestión de Tareas:
Diseña una clase Tarea con atributos como descripción, fecha de vencimiento y estado
(pendiente, completada, en progreso).
Crea una clase ListaTareas que contenga una lista de tareas.
Implementa métodos para agregar nuevas tareas, marcar tareas como
completadas y mostrar la lista de tareas pendientes.
 */
//Author Fernando Huilca

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\nCaso 1. Crear una lista de tareas_______________________");
        ListaTareas universidad = new ListaTareas("Universidad", 20);
        System.out.println(universidad);


        System.out.println("\n\nCaso 2. Agregar una tarea en la lista de tareas_______________________");
        universidad.agregarTarea("Hacer tarea de mates", "10/12/2023", "Pendiente");
        System.out.println(universidad);



        System.out.println("\n\nCaso 3. Mostrar lista de tareas pendientes_______________________");
        universidad.imprimirTareasPendienes();


        System.out.println("\n\nCaso 4. Agregar mas tareas_______________________");
        universidad.agregarTarea("Dibujar Bandera de Quito", "10/12/2023", "Pendiente");
        universidad.imprimirTareasPendienes();
    }
}