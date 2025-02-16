import javax.swing.*;

// Autor: Fernando Huilca
public class Main {

    public static void main(String[] args) {
        // Declaración de variables para el tamaño de la biCola y la opción del menú
        int tamaño, opcion;

        // Solicitar al usuario el tamaño de la biCola
        tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la BiCola:"));
        BiCola biCola = new BiCola(tamaño);

        // Bucle para mostrar el menú y realizar las operaciones en la biCola
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                            "\nBiCola con Entrada Restringida." +
                            "\n1. Eliminar fin." +
                            "\n2. Eliminar frente." +
                            "\n3. Insertar fin." +
                            "\nBiCola con Salida Restringida." +
                            "\n4. Eliminar frente." +
                            "\n5. Insertar frente." +
                            "\n6. Insertar fin." +
                            //"\n_______________________________" +
                            "\n7. Ver BiCola." +
                            "\n8. Salir."));

            // Ejecutar la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    // Eliminar elemento al final de la biCola
                    biCola.eliminarFin();
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 2:
                    // Eliminar elemento al frente de la biCola
                    biCola.eliminarFrente();
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 3:
                    // Insertar elemento al final de la biCola
                    biCola.insertarFin(JOptionPane.showInputDialog("Ingrese el nombre a insertar al final: "));
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 4:
                    // Eliminar elemento al frente de la biCola
                    biCola.eliminarFrente();
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 5:
                    // Insertar elemento al frente de la biCola
                    biCola.insertarFrente(JOptionPane.showInputDialog("Ingrese el nombre a insertar al frente: "));
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 6:
                    // Insertar elemento al final de la biCola
                    biCola.insertarFin(JOptionPane.showInputDialog("Ingrese el nombre a insertar al final: "));
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 7:
                    // Mostrar el estado actual de la biCola
                    JOptionPane.showMessageDialog(null, biCola.toString());
                    break;
                case 8:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "El programa ha terminado.");
                    break;
                default:
                    // Opción no válida
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 8);
    }
}
