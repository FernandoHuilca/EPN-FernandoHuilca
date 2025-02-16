import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Declaración de variables
        int opción, número;
        Recursividad x;
        x = new Recursividad(); // Creación de un objeto de la clase Recursividad

        // Menú de opciones utilizando JOptionPane
        do {
            // Mostrar el menú y obtener la opción seleccionada por el usuario
            opción = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menú Recursividad - Casos Matemáticos" +
                            "\n 1. Factorial" +
                            "\n 2. Fibonacci" +
                            "\n 3. Potencia" +
                            "\n 4. Torres de Hanoi" +
                            "\n\n 5. Salir" +
                            "\nIngrese una opción", "Menú", JOptionPane.INFORMATION_MESSAGE));
            // Procesar la opción seleccionada por el usuario
            switch (opción) {
                case 1:
                    // Solicitar al usuario el número para calcular su factorial
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número"));
                    // Mostrar el resultado del cálculo del factorial
                    JOptionPane.showMessageDialog(null,
                            "El Factorial del número " + número + " es: " + x.factorial(número));
                    break;
                case 2:
                    // Solicitar al usuario el número para calcular su serie de Fibonacci
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número"));
                    // Mostrar el resultado del cálculo de la serie de Fibonacci
                    JOptionPane.showMessageDialog(null,
                            "El Fibonacci del número " + número + " es: " + x.fibonacci(número));
                    break;
                case 3: {
                    // Solicitar al usuario la base y el exponente para calcular la potencia
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la base"));
                    int exp = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el exponente"));
                    // Mostrar el resultado del cálculo de la potencia
                    JOptionPane.showMessageDialog(null,
                            "La potencia del número " + número +
                                    " elevado a " + exp + " es: " + x.potencia(número, exp));
                    break;
                }
                case 4: {
                    // Solicitar al usuario el número de discos para resolver las Torres de Hanoi
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número de discos"));
                    // Mostrar los pasos necesarios para resolver las Torres de Hanoi
                    JOptionPane.showMessageDialog(null,
                            "Para mover " + número +
                                    " discos, se usaron " +
                                    x.torresDeHanoi(número, " Origen ", " Destino ", " Auxiliar ") +
                                    " pasos");
                    break;
                }
                case 5:
                    // Salir del programa si el usuario selecciona la opción 5
                    opción = 5;
                    break;
                default:
                    // Mostrar un mensaje de error si la opción seleccionada no es válida
                    JOptionPane.showMessageDialog(null, "ERROR, opción incorrecta");
            }
        } while (opción != 5); // Repetir el menú hasta que el usuario seleccione la opción de salir
    }
}
