public class Estudiante {
    //Constantes
    public static final int PROMEDIO_MINIMO = 70;
    public static final int NOTA_MINIMA = 0;
    public static final int NOTA_MAXIMA = 100;
    public String nombre;
    public String correo;
    public double nota1;
    public double nota2;
    public double promedio;

    // los comportamientos que puede tener una clase
// métodos
    public boolean tieneNotasDentroDeRango() {
        return (nota1 >= NOTA_MINIMA && nota1 <= NOTA_MAXIMA) &&
                (nota2 >= NOTA_MINIMA && nota2 <= NOTA_MAXIMA);
    }

    public double calcularPromedio() {
        promedio = (nota1 + nota2) / 2;
        return promedio;
    }

    public String imprimirResultado() {
        if (promedio > PROMEDIO_MINIMO) {
            return "El estudiante " + nombre + " aprueba la asignatura";
        } else {
            return "El estudiante " + nombre + " alumno reprueba la asignatura";
        }
    }
//public Tutor tutor;
}