import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Sebastián Ramos, Fernando Huilca, Juan Mateo Quisilema
        ÁrbolBinarioDeBúsqueda árbolBinarioDeBúsqueda = new ÁrbolBinarioDeBúsqueda();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " _______________ ELIJA UNA OPERACIÓN ÁRBOLES BINARIOS DE BÚSQUEDA _______________ \n\n" +

                            "                                              1)  CREACIÓN DEL ÁRBOL BINARIO \n\n" +

                            "                                              2)  BUSCAR DENTRO DEL ÁRBOL\n\n" +

                            "                                              3)  INSERTAR EN EL ÁRBOL\n\n" +

                            "                                              4)  ELIMINAR ALGÚN ELEMENTO\n\n" +

                            "                                              5)  VER ÁRBOL BINARIO\n\n" +

                            "                                              0)  SALIR\n\n"));
            switch (opcion) {
                case 1:
                    árbolBinarioDeBúsqueda.crearÁrbol();
                    JOptionPane.showMessageDialog(null, "El árbol binario ha quedado de la siguiente manera: \n " + árbolBinarioDeBúsqueda);
                    break;
                case 2:
                    int infoABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info que se desea buscar"));
                    árbolBinarioDeBúsqueda.buscarNodoDentroDelÁrbol(árbolBinarioDeBúsqueda.getRaíz(), infoABuscar);
                    break;
                case 3:
                    int infoNuevoNodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info del nuevo nodo "));
                    árbolBinarioDeBúsqueda.agregarNodosAlÁrbolBB(árbolBinarioDeBúsqueda.getRaíz(), new Nodo(infoNuevoNodo));
                    JOptionPane.showMessageDialog(null, "El árbol binario ha quedado de la siguiente manera: \n " + árbolBinarioDeBúsqueda);
                    break;
                case 4:
                    int infoAEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info que se desea Eliminar"));
                    árbolBinarioDeBúsqueda.borrarABB(infoAEliminar);
                    JOptionPane.showMessageDialog(null, "El árbol binario ha quedado de la siguiente manera: \n " + árbolBinarioDeBúsqueda);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "El árbol binario es el siguiente: \n " + árbolBinarioDeBúsqueda);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA, gracias por usarlo bb :D.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO.");
                    break;


            }
        } while (opcion != 0);
    }

}