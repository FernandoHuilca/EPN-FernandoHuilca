import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int opcion;

        ArbolBinario aB = new ArbolBinario();
        do{


            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "ARBOLES BINARIOS\n" +
                    "ELIJA UNA OPCION\n" +
                    "1. CREAR NODOS EN EL ARBOL\n"+
                    "2. RECORRER PREORDEN\n"+
                    "3. RECORRER INORDEN\n" +
                    "4. RECORRER POSORDEN\n" +
                    "5. VER ARBOL\n" +
                    "6. SALIR"));

            switch(opcion){
                case 1 :
                    aB.crearNodo();
                    break;
                case 2:
                    aB.recorridoPreOrden(aB.getApNodo());
                    break;
                case 3:
                    aB.recorridoInOrden(aB.getApNodo());
                    break;
                case 4:
                    aB.recorridoPosOrden(aB.getApNodo());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "ARBOL BINARIO\n"+ aB);
                    break;
                case 6:
                    break;

                default :
                    break;

            }
        }while (opcion != 6);
    }
}