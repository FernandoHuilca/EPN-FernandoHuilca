import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        arbol.insertarNodo(50);
        arbol.insertarNodo(30);
        arbol.insertarNodo(70);
        arbol.insertarNodo(20);
        arbol.insertarNodo(40);
        arbol.insertarNodo(60);
        arbol.insertarNodo(80);

        System.out.println("Recorrido Inorden:");
        arbol.recorridoInorden();

        int clave = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la clave a buscar:"));
        arbol.buscarABB(clave);

        int claveBorrar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la clave a borrar:"));
        arbol.borrarABB(claveBorrar);

        System.out.println("Recorrido Inorden después de borrar:");
        arbol.recorridoInorden();
    }


}