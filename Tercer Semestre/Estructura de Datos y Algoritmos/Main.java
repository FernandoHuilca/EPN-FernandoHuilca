import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opción, número;
        Recursividad x;
        x = new Recursividad();

        do {
            opción = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menú Recursividad - Casos Matemáticos" +
                            "\n 1. Factorial" +
                            "\n 2. Fibonacci" +
                            "\n 3. Potencia" +
                            "\n 4. Torres de Hanoi" +
                            "\n\n 5. Salir" +
                            "\nIngrese una opción", "Menú", JOptionPane.INFORMATION_MESSAGE));
            switch (opción) {
                case 1:
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número"));
                    JOptionPane.showMessageDialog(null,
                            "El Factorial del número " + número + " es: " + x.factorial(número));
                    break;
                case 2:
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número"));
                    JOptionPane.showMessageDialog(null,
                            "El Fibonacci del número " + número + " es: " + x.fibonacci(número));
                    break;
                case 3: {
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la base"));
                    int exp = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el exponente"));
                    JOptionPane.showMessageDialog(null,
                            "La potencia del número " + número +
                                    " elevado a " + exp + " es: " + x.potencia(número, exp));
                    break;
                }
                case 4: {
                    número = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el número de discos"));
                    JOptionPane.showMessageDialog(null,
                            "Para mover " + número +
                                    " discos, se usaron " +
                                    x.torresDeHanoi(número, " Origen ", " Destino ", " Auxiliar ") +
                                    " pasos");
                    break;
                }
                case 5:
                    opción = 5;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR, opción incorrecta");
            }
        } while (opción != 5);
    }
}