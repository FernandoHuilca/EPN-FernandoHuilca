package presentation;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;

    public GamePanel(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();

    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        ImageIcon icon = new ImageIcon("/resources/img/bomb1.png");
        this.getFrame().setIconImage(icon.getImage());
    }
    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getWidth() {
        return width;
    }


}
