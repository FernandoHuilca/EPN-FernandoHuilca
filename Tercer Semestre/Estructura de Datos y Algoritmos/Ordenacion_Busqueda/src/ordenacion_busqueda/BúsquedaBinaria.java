
package ordenacion_busqueda;

import javax.swing.JOptionPane;

class BúsquedaBinaria {
    
    // Método para buscar un elemento en un arreglo ordenado usando búsqueda binaria
    public int buscarElementoEnArreglo(int[] arreglo, int datoABuscar) {
        int inicio = 0; // Índice inicial del arreglo
        int fin = arreglo.length - 1; // Índice final del arreglo

        // Bucle mientras haya elementos por buscar
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; // Calcula el índice del elemento medio

            // Mostrar el arreglo y el rango actual de búsqueda
            mostrarArregloConRango(arreglo, inicio, fin, medio);

            // Verificar si el dato a buscar está en el medio
            if (arreglo[medio] == datoABuscar) {
                return medio; // Retorna el índice si encuentra el elemento
            }

            // Si el dato a buscar es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < datoABuscar) {
                inicio = medio + 1; // Actualiza el índice de inicio
            }
            // Si el dato a buscar es menor, ignorar la mitad derecha
            else {
                fin = medio - 1; // Actualiza el índice de fin
            }
        }

        // Retorna -1 si el elemento no se encuentra en el arreglo
        return -1;
    }

    // Método para mostrar el arreglo y el rango actual de búsqueda
    private void mostrarArregloConRango(int[] arreglo, int inicio, int fin, int medio) {
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena a mostrar
        for (int i = 0; i < arreglo.length; i++) {
            if (i == medio) {
                sb.append("[").append(arreglo[i]).append("]").append("  "); // Indica el elemento medio
            } else if (i >= inicio && i <= fin) {
                sb.append(arreglo[i]).append("  "); // Indica los elementos en el rango de búsqueda
            } else {
                sb.append("_  "); // Indica los elementos fuera del rango de búsqueda
            }
        }
        JOptionPane.showMessageDialog(null, "El arreglo paso a paso es:\n" + sb.toString()); // Muestra el arreglo en un mensaje emergente
    }

}
