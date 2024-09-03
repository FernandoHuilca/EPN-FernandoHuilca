
package ordenacion_busqueda;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ordenacion_Busqueda {

    public static void main(String[] args) {
      int opciónMenúPrincipal;
        int[] arregloPrincipal = null;
        BúsquedaSecuencial búsquedaSecuencial = new BúsquedaSecuencial();
        BúsquedaBinaria búsquedaBinaria = new BúsquedaBinaria();

        OrdenamientoPorBurbuja ordenamientoPorBurbuja = new OrdenamientoPorBurbuja();
        OrdenamientoPorInserción ordenamientoPorInserción = new OrdenamientoPorInserción();
        OrdenamientoPorSelección ordenamientoPorSelección = new OrdenamientoPorSelección();
        OrdenamientoPorMergeSort ordenamientoPorMergeSort = new OrdenamientoPorMergeSort();

        do {
            opciónMenúPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " _______________ ELIJA UNA OPERACIÓN _______________ \n\n" +
                            "       _________ BÚSQUEDA _________\n" +
                            "1)  BÚSQUEDA SECUENCIAL\n" +
                            "2)  BÚSQUEDA SECUENCIAL Arreglo ordenado\n" +
                            "3)  BÚSQUEDA BINARIA\n\n" +
                            "       _________ ORDENAMIENTO _________\n" +
                            "4)  ORDENAMIENTO POR BURBUJA mayor \n" +
                            "5)  ORDENAMIENTO POR BURBUJA menor \n" +
                            "6)  ORDENAMIENTO POR INSERCIÓN \n" +
                            "7)  ORDENAMIENTO POR SELECCIÓN\n" +
                            "8)  ORDENAMIENTO POR MergeSort \n\n" +
                            "0)  SALIR\n\n"));

            switch (opciónMenúPrincipal) {
                case 1:
                    int indiceDelDato = búsquedaSecuencial.buscarElementoEnArreglo(pedirArreglo(), pedirDatoABuscar());
                    if (indiceDelDato == -1) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el dato en el arreglo.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El dato se ha encontrado en el índice:" + indiceDelDato);
                    }
                    break;
                case 2:
                    int indiceDelDato2 = búsquedaSecuencial.buscarElementoEnArregloOrdenado(pedirArregloOrdenado(), pedirDatoABuscar());
                    if (indiceDelDato2 == -1) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el dato en el arreglo.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El dato se ha encontrado en el índice:" + indiceDelDato2);
                    }
                    break;
                case 3:
                    int indiceDelDato3 = búsquedaBinaria.buscarElementoEnArreglo(pedirArregloOrdenado(), pedirDatoABuscar());
                    if (indiceDelDato3 == -1) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el dato en el arreglo.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El dato se ha encontrado en el índice:" + indiceDelDato3);
                    }
                    break;
                case 4:
                    arregloPrincipal = pedirArreglo();
                    mostrarArregloEnUnaLínea(arregloPrincipal);
                    ordenamientoPorBurbuja.ordenarMayorAlaDerecha(arregloPrincipal);
                    break;
                case 5:
                    arregloPrincipal = pedirArreglo();
                    mostrarArregloEnUnaLínea(arregloPrincipal);
                    ordenamientoPorBurbuja.ordenarMenorALaIzquierda(arregloPrincipal);
                    break;
                case 6:
                    arregloPrincipal = pedirArreglo();
                    mostrarArregloEnUnaLínea(arregloPrincipal);
                    ordenamientoPorInserción.ordenar(arregloPrincipal);
                    break;
                case 7:
                    arregloPrincipal = pedirArreglo();
                    mostrarArregloEnUnaLínea(arregloPrincipal);
                    ordenamientoPorSelección.ordenar(arregloPrincipal);
                    break;
                case 8:
                    arregloPrincipal = pedirArreglo();
                    mostrarArregloEnUnaLínea(arregloPrincipal);
                    ordenamientoPorMergeSort.ordenar(arregloPrincipal);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR PONGA UN NÚMERO DE LAS OPCIONES DADAS!!.");
                    break;
            }
        } while (opciónMenúPrincipal != 0);
    }

    private static int[] pedirArregloOrdenado() {
        int aux;
        int tamanioDelArreglo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo que desea crear: "));
        int[] auxArreglo = new int[tamanioDelArreglo];
        auxArreglo[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato " + 0 + " del arreglo:"));
        for (int i = 1; i < tamanioDelArreglo; i++) {
            aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato " + i + " del arreglo:"));
            if (aux < auxArreglo[i - 1]) {
                JOptionPane.showMessageDialog(null, "ERROR: Recuerde que tiene que ingresar un arreglo ordenado \ningrese un dato mayor que " + auxArreglo[i - 1]);
                i--;
            } else {
                auxArreglo[i] = aux;
            }
        }
        return auxArreglo;
    }

    private static int pedirDatoABuscar() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número que desea buscar"));
    }

    private static int[] pedirArreglo() {
        int aux;
        int tamanioDelArreglo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo que desea crear: "));
        int[] auxArreglo = new int[tamanioDelArreglo];
        for (int i = 0; i < tamanioDelArreglo; i++) {
            aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato " + i + " del arreglo:"));
            auxArreglo[i] = aux;
        }
        return auxArreglo;
    }

    private static void mostrarArregloConPeztañaPersonalizada(int[] arregloPrincipal) {
        JTextArea textArea = new JTextArea(10, 20);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arregloPrincipal.length; i++) {
            sb.append("Elemento ").append(i).append(": ").append(arregloPrincipal[i]).append("\n");
        }
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "El arreglo es", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void mostrarArregloEnUnaLínea(int[] arregloPrincipal) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arregloPrincipal.length; i++) {
            sb.append(arregloPrincipal[i]).append("      ");
        }
        JOptionPane.showMessageDialog(null, "El arreglo es:\n" + sb.toString());
    }
    
}
