import javax.swing.*;

public class OrdenamientoPorSelección {

    // Método para ordenar el arreglo usando el algoritmo de selección
    public void ordenar(int[] arreglo) {
        int n = arreglo.length; // Longitud del arreglo

        // Bucle externo que recorre el arreglo
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Índice del elemento mínimo

            // Bucle interno para encontrar el elemento mínimo en la sublista no ordenada
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[min_idx]) {
                    min_idx = j; // Actualiza el índice del elemento mínimo
                }
            }

            // Intercambia el elemento mínimo encontrado con el primer elemento de la sublista no ordenada
            int temp = arreglo[min_idx];
            arreglo[min_idx] = arreglo[i];
            arreglo[i] = temp;

            mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada intercambio
        }
    }

    // Método para mostrar el arreglo en una ventana emergente
    private void mostrarArregloEnUnaLínea(int[] arregloPrincipal) {
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena a mostrar
        for (int i = 0; i < arregloPrincipal.length; i++) {
            sb.append(arregloPrincipal[i]).append("      "); // Añade cada elemento del arreglo al StringBuilder
        }
        JOptionPane.showMessageDialog(null, "El arreglo paso a paso es:\n" + sb.toString()); // Muestra el arreglo en un mensaje emergente
    }

}
