// Author: Fernando E. Huilca
// Date: 30/04/2024
public class Main {
    public static void main(String[] args) {
        int A = 8000;
        int contador = 1;

        // Imprimir encabezado de la tabla
        System.out.println(" _____________________________________________________________________________________");
        System.out.println("|                                  Prueba de Escritorio                               |");
        System.out.println(" _____________________________________________________________________________________");
        System.out.println("| Número de Repeticiones   |  Valor de la variable A = A/2   |  Valor de Verdad A > 1 |");
        System.out.println(" _____________________________________________________________________________________");

        // Ciclo para mostrar los valores de A y su verdad
        while (A > 1) {
            System.out.printf("| %-26d | %-30d | %-22s |\n", contador, A, "True");
            A = A / 2;
            contador++;
        }

        // Última fila de la tabla
        System.out.printf("| %-26d | %-30d | \033[31m%-22s\033[0m |\n", contador, A, "False");
        System.out.println(" _____________________________________________________________________________________");
    }
}





