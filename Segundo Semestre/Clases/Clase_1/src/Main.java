//Author Fernando Huilca
// un proceso para saber si un estudiante pasa una asignatura
// la información del estudiante tenga nombre, nota 1, nota 2, correo
// pensar solamente en el proceso pero no en el ingreso por teclado

//Pasos:
// 1. Crear las variables
// 2. Asignar valor a las variables
// 3. Hacer el cálculo
// 4. Imprimir el resultado

public class Main {

    public static final int PROMEDIO_MINIMO = 70;
    public static final int NOTA_MAXIMA = 100;
    public static final int NOTA_MINIMA = 0;

    public static void main(String[] args) {
        String nombre = "Fernando";
        String correo = "Fernando.huilca@epn.edu.ec";
        double nota1 = 2;
        double nota2 = 90;
        if (notasEstanDentroDelRango(nota1, nota2)) {
            double promedio = calcularPromedio(nota1, nota2);
            System.out.println(imprimirResultado(promedio));
        } else {
            System.out.println("ERROR: Una o las dos notas no estan dentro del rango");
        }


    }

    private static boolean notasEstanDentroDelRango(double nota1, double nota2) {
        return (nota1 >= NOTA_MINIMA && nota1 <= NOTA_MAXIMA) &&
                (nota2 >= NOTA_MINIMA && nota2 <= NOTA_MAXIMA);
    }

    private static String imprimirResultado(double promedio) {
        if (promedio > PROMEDIO_MINIMO) {
            return "El alumno aprueba la asignatura";
        } else {
            return "El alumno Reprueba la asignatura";
        }
    }

    private static double calcularPromedio(double nota1, double nota2) {
        return (nota1 + nota2) / 2;
    }
}