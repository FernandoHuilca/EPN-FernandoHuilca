import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private int contador = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AnimacionJava().iniciarAnimacion();
        });
    }

    private void iniciarAnimacion() {
        JFrame frame = new JFrame("Animación Java");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Inicio");
        frame.add(label);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de la animación
                contador++;
                label.setText("Frame " + contador);

                // Detener la animación después de un cierto número de frames (en este caso, 5)
                if (contador == 5) {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(null, "Animación completa");
                }
            }
        });

        // Iniciar el temporizador (Timer) para la animación
        timer.start();

        frame.setVisible(true);
    }
}
