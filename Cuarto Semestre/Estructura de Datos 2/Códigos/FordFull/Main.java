// Author: Fernando Huilca
public static void main(String[] args) {
    int[][] graph = {
        {0, 16, 13, 0, 0, 0},
        {0, 0, 10, 12, 0, 0},
        {0, 4, 0, 0, 14, 0},
        {0, 0, 9, 0, 0, 20},
        {0, 0, 0, 7, 0, 4},
        {0, 0, 0, 0, 0, 0}
    };
    FordFulkerson maxFlow = new FordFulkerson();
    System.out.println("El flujo máximo es: " +
            maxFlow.fordFulkerson(graph, 0, 5));
}
