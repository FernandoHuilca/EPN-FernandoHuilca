// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {
        /* *
         *  1) El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.
         *  2) El resultado será una nueva matriz con un número de filas igual al número de filas de la primera
         * matriz y un número de columnas igual al número de columnas de la segunda matriz.
         */

        // Matrices de ejemplo
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrizB = {{7, 8}, {9, 10}, {11, 12}};
        System.out.println("Matriz A: ");
        imprimirMatriz(matrizA);
        System.out.println("Matriz B: ");
        imprimirMatriz(matrizB);
        // Multiplicar las matrices
        int[][] resultado = multiplicarMatrices(matrizA, matrizB);

        // Imprimir el resultado
        System.out.println("Matriz resultante:");
        imprimirMatriz(resultado);
    }

    private static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;

        int[][] resultado = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}