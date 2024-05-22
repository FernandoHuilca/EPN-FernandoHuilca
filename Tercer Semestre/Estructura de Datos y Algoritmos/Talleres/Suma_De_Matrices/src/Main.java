// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
        /* *
         *  Si se desea sumar matrices, hay que tomar en cuenta que:
         *  1) las matrices tengan la misma dimension (mismo número de filas y de columnas)
         *  Para la suma de matrices se tiene que ir sumando componente por componente en la misma posición
         */

        //Ejemplo de aplicación:

        // Dado las matrices:
        int[][] matrizA= {{3, 3, 3}, {4, 4, 4}, {5, 5, 5}};
        int[][] matrizB = {{6, 6, 6}, {7, 7, 7}, {8, 8, 8}};

        sumaDosMatrices(matrizA,matrizB);

    }

    private static void sumaDosMatrices(int[][] matrizA, int[][] matrizB) {
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length){
            int[][] suma = new int[matrizA.length][matrizA[0].length];
            for (int i = 0 ; i < matrizA.length; i++){
                for (int j = 0 ; j < matrizA[0].length; j++){
                    suma[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }
            System.out.println("La suma de las matrices: \n" ); imprimirMatriz(suma);
        }
        else {
            System.out.println("ERROR: las matrices no tienen igual dimension por lo que no se pueden sumar");
        }

    }

    private static void imprimirMatriz(int[][] suma) {
        for (int i = 0; i < suma.length; i++) {
            for (int j = 0; j < suma[i].length; j++) {
                System.out.print(suma[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}