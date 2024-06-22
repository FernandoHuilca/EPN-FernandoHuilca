import javax.swing.*;

// Author: Fernando Huilca
// 21/06/2024

public class Main {
    public static void main(String[] args) {

        int opciónMenúPrincipal;
        ArbolBinario arbolBinario = new ArbolBinario();

        do {
            opciónMenúPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "   ______________________ OPERACIONES CON ÁRBOL ______________________  \n\n" +

                            "                                1. Crear Nodos.       \n" +
                            "                                2. Recorrer Pre-Orden.        \n" +
                            "                                3. Recorrer In-Orden.                       \n" +
                            "                                4. Recorrer Pos-Orden.                 \n" +
                            "                                5. Mostrar árbol.                 \n" +
                            "                                0. SALIR                                    \n\n"));
            switch (opciónMenúPrincipal) {
                case 1:
                    arbolBinario.crearNodo();
                    JOptionPane.showMessageDialog(null, "ARBOL CREADO \n" + arbolBinario);
                    break;
                case 2:
                    arbolBinario.recorridoPreOrden(arbolBinario.getApNodo());
                    break;
                case 3:
                    arbolBinario.recorridoInOrden(arbolBinario.getApNodo());
                    break;
                case 4:
                    arbolBinario.recorridoPosOrden(arbolBinario.getApNodo());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "ARBOL BINARIO\n"+ arbolBinario);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    break;


            }
        } while (opciónMenúPrincipal != 0);

    }
}