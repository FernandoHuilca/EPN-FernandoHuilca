import java.util.Scanner;

public class MenuGrafoApp {

    private static GrafoNoDirigido grafoActual; // Grafo dirigido o no dirigido actual
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarNuevoGrafo();
                    break;
                case 2:
                    imprimirRecorridoEnProfundidadDirigido();
                    break;
                case 3:
                    imprimirRecorridoEnProfundidadNoDirigido();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("----- Menú de Operaciones con Grafos -----");
        System.out.println("1. Agregar un nuevo grafo");
        System.out.println("2. Imprimir recorrido en profundidad (Grafo Dirigido)");
        System.out.println("3. Imprimir recorrido en profundidad (Grafo No Dirigido)");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // Método para inicializar un nuevo grafo
    private static void agregarNuevoGrafo() {
        grafoActual = new GrafoNoDirigido(); // O GrafoDirigido si se requiere
        System.out.println("Nuevo grafo creado.");
    }

    // Método para imprimir el recorrido en profundidad para un grafo dirigido
    private static void imprimirRecorridoEnProfundidadDirigido() {
        if (grafoActual == null) {
            System.out.println("Debes crear un grafo primero (Opción 1).");
            return;
        }

        System.out.print("Ingresa el nodo inicial: ");
        String nodoInicial = scanner.nextLine();
        NodoGrafo<String> nodo = grafoActual.buscarNodo(nodoInicial);

        if (nodo == null) {
            System.out.println("El nodo no existe.");
            return;
        }

        System.out.println("Recorrido en profundidad para Grafo Dirigido desde " + nodoInicial + ":");
        grafoActual.imprimirTrazaRecorridoProfundidadGrafoDirigido(nodo, grafoActual);

        // Mostrar la salida final
        if (yaRecorriTodosLosNodos(grafoActual) && pila.estaVacia()) {
            System.out.println("La salida del recorrido es la siguiente: " + grafoActual.getSalida());
        }
    }

    // Método para imprimir el recorrido en profundidad para un grafo no dirigido
    private static void imprimirRecorridoEnProfundidadNoDirigido() {
        if (grafoActual == null) {
            System.out.println("Debes crear un grafo primero (Opción 1).");
            return;
        }

        System.out.print("Ingresa el nodo inicial: ");
        String nodoInicial = scanner.nextLine();
        NodoGrafo<String> nodo = grafoActual.buscarNodo(nodoInicial);

        if (nodo == null) {
            System.out.println("El nodo no existe.");
            return;
        }

        System.out.println("Recorrido en profundidad para Grafo No Dirigido desde " + nodoInicial + ":");
        grafoActual.imprimirTrazaRecorridoProfundidadGrafoNoDirigido(nodo, grafoActual);

        // Mostrar la salida final
        if (yaRecorriTodosLosNodos(grafoActual) && pila.estaVacia()) {
            System.out.println("La salida del recorrido es la siguiente: " + grafoActual.getSalida());
        }
    }

    // Método auxiliar para verificar si ya se recorrieron todos los nodos
    private static boolean yaRecorriTodosLosNodos(GrafoNoDirigido grafo) {
        // Implementación de este método que verifica si todos los nodos fueron recorridos
        return true; // Cambia esto según la lógica de tu programa
    }
}
