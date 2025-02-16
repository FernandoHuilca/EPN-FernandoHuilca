import javax.swing.*;

// Autor: Fernando Huilca
public class Main {

    public static void main(String[] args) {
        // Declaración de variables para el tamaño de la cola y la opción del menú
        int tamaño, opcion;

        // Solicitar al usuario el tamaño de la cola
        tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la cola:"));
        ColaCircular cola= new ColaCircular(tamaño);

        // Bucle para mostrar el menú y realizar las operaciones en la cola
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENÚ\nSeleccione la opción que desea realizar en la cola simple: " +
                            "\n1. Ingresar un nombre." +
                            "\n2. Eliminar un nombre." +
                            "\n3. Visualizar la cola." +
                            "\n4. Salir."));
            

            // Ejecutar la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    // Insertar un nombre en la cola
                    cola.insertarDato(JOptionPane.showInputDialog("Ingrese el nombre a insertar: "));
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 2:
                    // Eliminar un nombre de la cola
                    cola.eliminarDato();
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 3:
                    // Visualizar la cola
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 4:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "El programa ha terminado.");
                    break;
                default:
                    // Opción no válida
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 4);
    }
}
