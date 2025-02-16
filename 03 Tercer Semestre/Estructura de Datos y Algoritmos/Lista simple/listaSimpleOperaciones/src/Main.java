import javax.swing.*;

//Author: Juan Mateo
public class Main {
    public static void main(String[] args) {
        int opcion;
        ListaSimple list = new ListaSimple();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "          ELIJA UNA OPCION \n" +
                    "     || Solo Para la Creación ||\n" +
                    "1. Crear Nodos al Inicio de la Lista.\n" +
                    "2. Crear Nodos al Final de la Lista.\n\n" +

                    "     || Aún no se que Hace ||\n" +
                    "3. Recorrer la Lista.\n\n" +

                    "     || Inserción en la Lista Creada ||\n" +
                    "4. Insertar Nodo al Inicio.\n" +
                    "5. Insertar Nodo al Final.\n\n" +

                    "     || Eliminación de la Lista Creada ||\n" +
                    "6. Eliminar Nodo al Inicio de la Lista.\n" +
                    "7. Eliminar Nodo al Final de la Lista.\n\n" +

                    "     || Buscar y Mostrar ||\n" +
                    "8. Buscar un Nodo.\n" +
                    "9. Ver Lista.\n\n" +

                    "     || *** ||\n" +
                    "0. SALIR"));
            switch (opcion) {
                case 1:
                    list.crearNodoInicioLista();
                    JOptionPane.showMessageDialog(null, "LISTA CREADA NODOS POR INICIO\n" + list);
                    break;
                case 2:
                    list.crearNodoFinalLista();
                    JOptionPane.showMessageDialog(null, "LISTA CREADA NODOS  POR FINAL\n" + list);
                    break;
                case 3:
                    list.recorrer2();
                    break;
                case 4:
                    list.insertarNodoInicio();
                    JOptionPane.showMessageDialog(null, "INSERTA NODO INICIO DE LISTA CREADA\n" + list);
                    break;
                case 5:
                    list.insertarNodoFinal();
                    JOptionPane.showMessageDialog(null, "INSERTA NODO AL FINAL DE LISTA CREADA\n" + list);
                    break;
                case 6:
                    int opcion2 = JOptionPane.showConfirmDialog(null, "Desea eliminar el primer nodo?");
                    if (opcion2 == JOptionPane.YES_OPTION) {
                        list.eliminarNodoInicio();
                        JOptionPane.showMessageDialog(null, " * Elemento Eliminado con Éxito * \nLista Resultante: " + list);
                    }
                    break;

                case 7:
                    int opcion3 = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el nodo final: ?");
                    if (opcion3 == JOptionPane.YES_OPTION) {
                        list.eliminarAlFinal();
                        JOptionPane.showMessageDialog(null, "* Elemento Eliminado con Éxito * \nLista Resultante: " + list);
                    }
                    break;
                case 8:
                    list.buscarListaS();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "LISTA CONCATENADA\n" + list);
                    break;
                default:
                    break;


            }
        } while (opcion != 0);

    }
}