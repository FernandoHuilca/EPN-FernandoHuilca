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

    //Metodo constructor
    public Estudiante(String nombre, String correo, double nota1, double nota2) {
        //Utilizar los metodos setter o inicializar
        this.nombre = nombre;
        this.correo = correo;
        this.nota1 = nota1;
        this.nota2 = nota2;

    }

    // métodos
    public boolean tieneNotasDentroDeRango() {
        return (nota1 >= NOTA_MINIMA && nota1 <= NOTA_MAXIMA) &&
                (nota2 >= NOTA_MINIMA && nota2 <= NOTA_MAXIMA);
    }

    /*public double calcularPromedio() {
        promedio = (nota1 + nota2) / 2;
        return promedio;
    }*/
    public void calcularPromedio() {

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
}