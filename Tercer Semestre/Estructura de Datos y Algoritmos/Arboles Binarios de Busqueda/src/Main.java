import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        /**
         * Menu principal para acceder a cada operation en Árboles binarios de búsqueda
         */
        /**
         * @author Sebastián Ramos, Fernando Huilca, Juan Mateo Quisilema
         */
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " _______________ ELIJA UNA OPERACIÓN ÁRBOLES BINARIOS DE BÚSQUEDA _______________ \n\n" +

                            "1)  CREACIÓN DEL ÁRBOL BINARIO \n\n" +

                            "2)  BUSCAR DENTRO DEL ÁRBOL\n\n" +

                            "3)  INSERTAR EN EL ÁRBOL\n\n" +

                            "4)  ELIMINAR ALGÚN ELEMENTO\n\n" +

                            "5)  VER ÁRBOL BINARIO\n\n" +

                            "0)  SALIR\n\n"));
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO.");
                    break;


            }
        } while (opcion != 0);
    }

}