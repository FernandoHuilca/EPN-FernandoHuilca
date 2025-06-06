public class Estudiante {
    //Constantes
    public static final int PROMEDIO_MINIMO = 70;
    public static final int NOTA_MINIMA = 0;
    public static final int NOTA_MAXIMA = 100;

    //atributos
    private String nombre;
    private String correo;
    private double nota1;
    private double nota2;
    private double promedio;

    // métodos
    public boolean tieneNotasDentroDeRango() {
        return (nota1 >= NOTA_MINIMA && nota1 <= NOTA_MAXIMA) &&
                (nota2 >= NOTA_MINIMA && nota2 <= NOTA_MAXIMA);
    }

    /*public double calcularPromedio() {
        promedio = (nota1 + nota2) / 2;
        return promedio;
    }*/
    public void calcularPromedio()
    {
        promedio = (nota1 + nota2) / 2;
    }

    public String imprimirResultado() {
        if (promedio > PROMEDIO_MINIMO) {
            return "El estudiante " + nombre + " aprueba la asignatura";
        } else {
            return "El estudiante " + nombre + " alumno reprueba la asignatura";
        }
    }
    //Metodo sett
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Metodo gett

    public String getNombre() {
        return nombre;
    }
    //Metodo sett
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
}