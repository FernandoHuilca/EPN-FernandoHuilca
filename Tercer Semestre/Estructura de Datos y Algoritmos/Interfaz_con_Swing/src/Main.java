import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame frame = new JFrame("Mi Ventana Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un panel para agregar componentes
        JPanel panel = new JPanel();

        // Crear un botón
        JButton button = new JButton("Presionar");

        // Crear un campo de texto
        JTextField textField = new JTextField(20);

        // Agregar los componentes al panel
        panel.add(button);
        panel.add(textField);

        // Agregar el panel al marco
        frame.add(panel);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
