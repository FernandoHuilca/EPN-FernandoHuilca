import javax.swing.*;

public class OrdenamientoPorInserción {

        // Método para ordenar el arreglo usando el algoritmo de inserción
        public void ordenar(int[] arreglo) {
            int n = arreglo.length; // Longitud del arreglo

            // Bucle externo que recorre el arreglo desde el segundo elemento hasta el final
            for (int i = 1; i < n; i++) {
                int j = i - 1; // Índice del último elemento de la parte ordenada
                int aux = arreglo[i]; // El elemento actual que se va a insertar en la parte ordenada del arreglo

                // Bucle interno que mueve los elementos de la parte ordenada del arreglo que son mayores que aux
                while (j >= 0 && aux < arreglo[j]) {
                    arreglo[j + 1] = arreglo[j]; // Desplaza el elemento hacia la derecha
                    j--; // Decrementa el índice
                    mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada desplazamiento
                }

                arreglo[j + 1] = aux; // Inserta aux en la posición correcta
                mostrarArregloEnUnaLínea(arreglo); // Muestra el arreglo después de cada inserción
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