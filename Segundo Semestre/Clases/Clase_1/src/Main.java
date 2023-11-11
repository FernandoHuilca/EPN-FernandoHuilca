public class Main {

    public static void main(String[] args) {
// un proceso para saber si un estudiante pasa una asignatura
// la información del estudiante tenga nombre, nota 1, nota 2, correo
// pensar solamente en el proceso pero no en el ingreso por teclado
//Declarando objeto = Inicializando objeto
        Estudiante estudiante1 = new Estudiante(); // estudiante1 ES UN estudiante, estudiante1 ES DE TIPO estudiante
        estudiante1.nombre = "Jaimito";
        estudiante1.correo = "jaimito.com";
        estudiante1.nota1 = -2;
        estudiante1.nota2 = 90;
        Estudiante estudiante2 = new Estudiante();
        estudiante2.nombre = "Juanito";
        estudiante2.correo = "juanito.com";
        estudiante2.nota1 = 70;
        estudiante2.nota2 = 90;
        if (estudiante1.tieneNotasDentroDeRango()) {
            estudiante1.calcularPromedio();
            System.out.println(estudiante1.imprimirResultado());
        } else {
            System.out.println("ERROR: Una de las notas de " + estudiante1.nombre + " esta fuera del rango.");
        }
    }
}