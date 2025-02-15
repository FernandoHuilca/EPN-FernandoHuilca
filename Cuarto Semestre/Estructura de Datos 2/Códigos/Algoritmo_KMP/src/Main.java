import java.util.ArrayList;
import java.util.List;

public class Main {

    // Función para realizar la búsqueda del patrón en el texto usando la tabla siguiente
    public static void KMPSearch(String text, String pattern, int[] next) {
        int n = text.length();
        int m = pattern.length();

        // Variables para estadísticas
        int comparaciones = 0;
        int desplazamientos = 0;
        int coincidencias = 0;
        int fallos = 0;
        List<Integer> posiciones = new ArrayList<>();

        int i = 0; // Índice para el texto
        int j = 0; // Índice para el patrón

        while (i < n) {
            comparaciones++; // Contar cada comparación

            if (pattern.charAt(j) == text.charAt(i)) {
                coincidencias++; // Contar coincidencias de caracteres
                i++;
                j++;

                // Si encontramos una coincidencia completa
                if (j == m) {
                    posiciones.add(i - j); // Guardar la posición donde inicia el patrón
                    desplazamientos++; // Contar desplazamiento del patrón
                    j = next[j]; // Moverse en el patrón usando la tabla siguiente
                }
            } else { // En caso de desajuste
                fallos++; // Contar fallos
                if (next[j] != -1) {
                    j = next[j]; // Retroceder en el patrón según la tabla siguiente
                    desplazamientos++; // Contar desplazamiento
                } else {
                    i++;
                    j = 0; // Reiniciar el patrón
                }
            }
        }

        // Imprimir estadísticas
        System.out.println("Estadísticas del algoritmo KMP:");
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Coincidencias: " + coincidencias);
        System.out.println("Fallos: " + fallos);
        System.out.println("Desplazamientos: " + desplazamientos);
        System.out.println("Posiciones del patrón: " + posiciones);
    }

    public static void main(String[] args) {
        // Texto y patrón de ejemplo
        String text = "babcbabcabcaabcabcabcacabc";
        String pattern = "abcabcacab";

        // Tabla siguiente proporcionada
        int[] next = {-1, 0, 0, -1, 0, 0, -1, 4, -1, 0};

        // Ejecutar la búsqueda
        KMPSearch(text, pattern, next);
    }
}
