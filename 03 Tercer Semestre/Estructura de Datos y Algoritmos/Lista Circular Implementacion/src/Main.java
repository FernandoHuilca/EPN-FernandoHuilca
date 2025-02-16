import javax.swing.*;

// Author: Fernando Huilca
// 15/06/2024

public class Main {
    public static void main(String[] args) {

        int opciónMenúPrincipal;
        ListaCircular listaCircular = new ListaCircular();

        do {
            opciónMenúPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "   ______________________ MENÚ PRINCIPAL ______________________  \n\n\n" +

                    "                                1. Crear Nodos al Inicio de la Lista.       \n" +
                    "                                2. Crear Nodos al Final de la Lista.        \n\n" +
                    "                                3. Recorrer la Lista.                       \n\n" +
                    "                                4. Insertar Nodo al Inicio.                 \n" +
                    "                                5. Insertar Nodo al Final.                  \n\n" +
                    "                                6. Eliminar Nodo al Inicio de la Lista.     \n" +
                    "                                7. Eliminar Nodo al Final de la Lista.      \n\n" +
                    "                                8. Buscar un Nodo.                          \n" +
                    "                                9. Ver Lista.                               \n\n" +
                    "                                0. SALIR                                    \n\n"));
            switch (opciónMenúPrincipal) {
                case 1:
                    listaCircular.crearNodosInicioListaCircular();
                    JOptionPane.showMessageDialog(null, "Lista Circular nodos por incio: \n\n" + listaCircular);
                    break;
                case 2:
                    listaCircular.crearNodosFinalListaCircular();
                    JOptionPane.showMessageDialog(null, "Lista Circular nodos por final: \n\n" + listaCircular);
                    break;
                case 3:
                    listaCircular.recorrerLista();
                    break;
                case 4:
                    listaCircular.insertarNodoPorElInicio();
                    JOptionPane.showMessageDialog(null, "Lista con nodo agregado por el inicio: \n\n" + listaCircular);
                    break;
                case 5:
                    listaCircular.insertarNodoPorElFinal();
                    JOptionPane.showMessageDialog(null, "Lista con nodo agregado por el final: \n\n" + listaCircular);
                    break;
                case 6:
                        JOptionPane.showMessageDialog(null, "El elemento eliminado fue: " + listaCircular.eliminarNodoInicio() +" \n\nLista Resultante: \n" + listaCircular);
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "El elemento eliminado fue: " + listaCircular.eliminarNodoFinal() +" \n\nLista Resultante: \n" + listaCircular);
                    break;
                case 8:
                    listaCircular.buscarElementoListaCircular();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Lista Circular: \n\n" + listaCircular);
                    break;
                default:
                    break;


            }
        } while (opciónMenúPrincipal != 0);

    }
}