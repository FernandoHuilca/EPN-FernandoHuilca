public class Sudoku4x4Solver {

    private static final int SIZE = 4; // Tamaño del sudoku (4x4)
    private static final int SUBGRID_SIZE = 2; // Tamaño de las subcuadrículas (2x2)

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {2, 0, 0, 3},
                {4, 0, 1, 2}
        };

        System.out.println("Tablero inicial:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("Sudoku resuelto:");
            printBoard(board);
        } else {
            System.out.println("No se encontró solución para este sudoku.");
        }
    }

    // Método para resolver el sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Encontrar una celda vacía
                    for (int num = 1; num <= SIZE; num++) { // Probar números del 1 al 4
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Asignar un número válido
                            if (solveSudoku(board)) { // Recursión
                                return true;
                            }
                            board[row][col] = 0; // Retroceder si no funciona
                        }
                    }
                    return false; // Si no se puede asignar ningún número, retornar false
                }
            }
        }
        return true; // Retornar true si el sudoku está completamente resuelto
    }

    // Validar si un número puede colocarse en una celda
    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Verificar columna
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Verificar subcuadrícula
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Imprimir el tablero
    public static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
