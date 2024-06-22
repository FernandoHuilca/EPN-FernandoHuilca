import javax.swing.JOptionPane;

/**
 * @author Sebastián Ramos, Juan Mateo Quisilema
 */
public class App {
    public static void main(String[] args) {
        /**
         * Menu principal para acceder a cada operation en el arbol
         */
        int opcion;
        arbolBinario arbolBinario = new arbolBinario();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, " ELIJA UNA OPERACION PARA EL ARBOL \n" +
                    "1. CREAR NODOS \n" +
                    "2. RECORRER PRE-ORDEN \n" +
                    "3. RECORRER IN-ORDEN\n" +
                    "4. RECORRER POS-ORDEN\n" +
                    "5.SALIR"));
            switch (opcion) {
                case 1:
                    arbolBinario.crearNodos();
                    JOptionPane.showMessageDialog(null, "ARBOL CREADO \n" + arbolBinario);
                    break;
                case 2:
                    arbolBinario.recorridoPreOrden(arbolBinario.getNodo());
                    break;
                case 3:
                    arbolBinario.recorridoInOrden(arbolBinario.getNodo());
                    break;
                case 4:
                    arbolBinario.recorridoPosOrden(arbolBinario.getNodo());
                    break;
                case 5:
                    opcion = 5;
                default:
                    break;
            }
        } while (opcion != 5);
    }

}
