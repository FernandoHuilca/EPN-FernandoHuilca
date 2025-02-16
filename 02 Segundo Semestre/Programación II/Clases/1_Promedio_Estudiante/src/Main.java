//Author Fernando Huilca
// un proceso para saber si un estudiante pasa una asignatura
// la información del estudiante tenga nombre, nota 1, nota 2, correo
// pensar solamente en el proceso, pero no en el ingreso por teclado
//Declarando objeto = Inicializando objeto

public class Main {

    public static void main(String[] args) {
        //Estudiante dos
        //creo un objeto de la clase Estudiante y lo inicializo
        Estudiante estudiante1 = new Estudiante("Jaimito", "jaimito.com", -2, 90); // estudiante1 ES UN estudiante, estudiante1 ES DE TIPO estudiante
        Estudiante estudiante2 = new Estudiante("Juanito", "juanito.com", 70, 90);

        if (estudiante1.tieneNotasDentroDeRango()) {
            estudiante1.calcularPromedio();
            System.out.println(estudiante1.imprimirResultado());
        } else {
            System.out.println("ERROR: Una de las notas de " + estudiante1.getNombre() + " esta fuera del rango.");
        }

        if (estudiante2.tieneNotasDentroDeRango()) {
            estudiante2.calcularPromedio();
            System.out.println(estudiante2.imprimirResultado());
        } else {
            System.out.println("ERROR: Una de las notas de " + estudiante2.getNombre() + " esta fuera del rango.");
        }

        Estudiante estudiante3 = estudiante1;
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3.getNombre());
    }
}