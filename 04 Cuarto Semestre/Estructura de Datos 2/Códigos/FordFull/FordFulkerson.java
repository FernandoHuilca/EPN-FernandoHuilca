import java.util.LinkedList;

public class FordFulkerson {

    static final int V = 6; // Número de vértices en el grafo

    // Método para realizar una búsqueda en profundidad y encontrar el camino aumentante
    boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    // Método para calcular el flujo máximo de source a sink en el grafo
    int fordFulkerson(int[][] graph, int source, int sink) {
        int u, v;
        int[][] residualGraph = new int[V][V];

        // Inicializamos el grafo residual con las capacidades del grafo original
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                residualGraph[u][v] = graph[u][v];

        int[] parent = new int[V];
        int maxFlow = 0;

        // Aumentar el flujo mientras haya un camino aumentante
        while (bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Actualizamos las capacidades residuales de las aristas y el flujo inverso
            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }