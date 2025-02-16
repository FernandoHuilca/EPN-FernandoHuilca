public class BúsquedaSecuencial {
    public int buscarElementoEnArreglo(int[] arregloPrincipal, int datoABuscar) {
        for (int i = 0; i < arregloPrincipal.length; i++){
            if (arregloPrincipal[i] == datoABuscar){
                return i;
            }
        }
        return -1;
    }
    public int buscarElementoEnArregloOrdenado(int[] arreglo, int datoABuscar) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == datoABuscar) {
                return i; // Retorna el índice donde se encontró el elemento
            } else if (arreglo[i] > datoABuscar) {
                // Si el elemento actual es mayor que el buscado, no tiene sentido seguir buscando
                break;
            }
        }
        return -1; // Retorna -1 si el elemento no se encuentra en el arreglo
    }
}
