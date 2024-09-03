package hashimplementacion;

import javax.swing.JOptionPane;

public class HasImplementacion {

    public static void main(String[] args) {
        int opcion;
        Hash vectorClaves = new Hash();
        Hash vectorGuardar = new Hash();

        do {
            // Muestra el menú principal y lee la opción ingresada por el usuario
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENU INICIAL:\n1.CREAR TABLA HASH (ARREGLO)\n2.SELECCIONAR METODOS HASH\n3.Salida", "Menu", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    // Opción para crear una nueva tabla hash
                    vectorClaves = new Hash("TABLA HASH(ARREGLO) CON CLAVES");
                    vectorGuardar = new Hash(vectorClaves.getTamanio());
                    vectorClaves.ingresarClaves(); // Ingresa claves en la tabla hash
                    break;
                case 2:
                    // Muestra el submenú para seleccionar el método hash
                    int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "SELECCIONE QUE DESEA REALIZAR:\n1.Hash Módulo\n2.Hash cuadrado\n3.Hash por plegamiento\n4.Hash por truncamiento", "MENU", JOptionPane.INFORMATION_MESSAGE));
                    switch (opcion1) {
                        case 1:
                            // Aplica el método hash módulo y muestra el resultado
                            vectorGuardar.hashModulo(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 2:
                            // Aplica el método hash cuadrado y muestra el resultado
                            vectorGuardar.hashCuadrado(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 3:
                            // Aplica el método hash por plegamiento y muestra el resultado
                            vectorGuardar.hashPlegamento(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 4:
                            // Aplica el método hash por truncamiento y muestra el resultado
                            vectorGuardar.hashTruncamiento(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        default:
                            // Muestra un mensaje si la opción no es válida
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break;
                    }
                    break;
                case 3:
                    // Opción para salir del programa
                    JOptionPane.showMessageDialog(null, "Salida");
                    break;
                default:
                    // Muestra un mensaje si la opción no es válida
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } while (opcion != 3); // Repite el menú hasta que el usuario elija salir
    }
}
