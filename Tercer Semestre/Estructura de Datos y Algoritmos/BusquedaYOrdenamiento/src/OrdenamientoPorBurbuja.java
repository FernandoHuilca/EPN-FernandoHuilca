import javax.swing.*;

public class OrdenamientoPorBurbuja {

    // Método para ordenar el arreglo moviendo el menor elemento a la izquierda
    public void ordenarMenorALaIzquierda(int[] arreglo) {
        int n = arreglo.length; // Longitud del arreglo
        // Bucle externo para recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {
            // Bucle interno para comparar e intercambiar elementos
            for (int j = n - 1; j > i; j--) {
                // Si el elemento actual es menor que el anterior, se intercambian
                if (arreglo[j] < arreglo[j - 1]) {
                    int temp = arreglo[j]; // Almacena el valor del elemento actual
                    arreglo[j] = arreglo[j - 1]; // Coloca el elemento anterior en la posición actual
                    arreglo[j - 1] = temp; // Coloca el valor almacenado en la posición anterior
                    mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada intercambio
                }
            }
        }
    }

    // Método para mostrar el arreglo en una ventana emergente
    private void mostrarArregloEnUnaLínea(int[] arregloPrincipal) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arregloPrincipal.length; i++) {
            sb.append(arregloPrincipal[i]).append("      ");
        }
        JOptionPane.showMessageDialog(null, "El arreglo paso a paso es:\n" + sb.toString());
    }

    // Método para ordenar el arreglo moviendo el mayor elemento a la derecha
    public void ordenarMayorAlaDerecha(int[] arreglo) {
        int n = arreglo.length; // Longitud del arreglo
        // Bucle externo para recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {
            // Bucle interno para comparar e intercambiar elementos
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j]; // Almacena el valor del elemento actual
                    arreglo[j] = arreglo[j + 1]; // Coloca el elemento siguiente en la posición actual
                    arreglo[j + 1] = temp; // Coloca el valor almacenado en la posición siguiente
                    mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada intercambio
                }
            }
        }
    }
}