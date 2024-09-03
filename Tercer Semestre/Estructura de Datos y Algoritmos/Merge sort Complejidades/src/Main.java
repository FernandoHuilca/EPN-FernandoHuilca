public class Main {

    // Método principal que ordena un array utilizando Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del array
            int mid = (left + right) / 2;

            // División del array en dos mitades
            // Complejidad de División: O(log n)
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Combinación de las dos mitades ordenadas
            // Complejidad de Combinar: O(n)
            merge(array, left, mid, right);
        }
    }

    // Método que combina dos mitades de un array
    public static void merge(int[] array, int left, int mid, int right) {
        // Encuentra los tamaños de los subarrays para combinar
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporales
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copia los datos a los arrays temporales
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        // Índices iniciales de los subarrays
        int i = 0, j = 0;

        // Índice inicial del array combinado
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de leftArray, si quedan
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de rightArray, si quedan
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }







    // Método para imprimir el array
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }






    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);

        // Llamada inicial al método mergeSort
        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArray ordenado:");
        printArray(array);
    }
}
