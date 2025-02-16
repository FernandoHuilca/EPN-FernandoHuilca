/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion_busqueda;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando_Huilca
 */
class OrdenamientoPorMergeSort {
    
    // Método principal para ordenar el arreglo usando el algoritmo Merge Sort
    public void ordenar(int[] arreglo) {
        mergeSort(arreglo, 0, arreglo.length - 1); // Llama al método mergeSort con los índices inicial y final
    }

    // Método recursivo para dividir el arreglo en subarreglos y ordenarlos
    private void mergeSort(int[] arreglo, int left, int right) {
        if (left < right) { // Si hay más de un elemento en el subarreglo
            int mid = (left + right) / 2; // Encuentra el punto medio del subarreglo
            mergeSort(arreglo, left, mid); // Ordena la mitad izquierda
            mergeSort(arreglo, mid + 1, right); // Ordena la mitad derecha
            merge(arreglo, left, mid, right); // Combina las dos mitades ordenadas
            mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada combinación
        }
    }

    // Método para combinar dos subarreglos ordenados en un solo arreglo ordenado
    private void merge(int[] arreglo, int left, int mid, int right) {
        int n1 = mid - left + 1; // Longitud del subarreglo izquierdo
        int n2 = right - mid; // Longitud del subarreglo derecho
        int[] L = new int[n1]; // Crea el subarreglo izquierdo
        int[] R = new int[n2]; // Crea el subarreglo derecho

        // Copia los datos a los subarreglos L y R
        System.arraycopy(arreglo, left, L, 0, n1);
        System.arraycopy(arreglo, mid + 1, R, 0, n2);

        int i = 0, j = 0; // Índices iniciales para los subarreglos izquierdo y derecho
        int k = left; // Índice inicial para el arreglo combinado

        // Combina los subarreglos L y R en el arreglo principal
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L, si hay alguno
        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R, si hay alguno
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
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
