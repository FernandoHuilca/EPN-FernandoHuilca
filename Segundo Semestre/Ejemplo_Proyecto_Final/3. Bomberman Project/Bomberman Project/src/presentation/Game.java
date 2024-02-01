package presentation;

import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;
import presentation.presentationManagers.KeyDetector;
import presentation.presentationManagers.MouseDetector;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private GamePanel gamePanel;

    public int width, height;
    public String title;
    private boolean running = false;
    public static boolean paused = false;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    public presentation.Frame gameFrame;
    public presentation.Frame menuFrame;
    private KeyDetector keyDetector;
    private MouseDetector mouseDetector;
    private GameManager gameManager;
    private float xScale = 1, yScale = 1;
    private int GAME_WINDOW_WIDTH = 608;
    private int GAME_WINDOW_HEIGHT = 480;
    double FRAMES_PER_SECOND = 1000000000 / 60;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyDetector = new KeyDetector(gameManager, this);
        mouseDetector = new MouseDetector();

    }

    public void init() {
        gamePanel = new GamePanel(title, width, height);
        gamePanel.getFrame().addKeyListener(keyDetector);
        gamePanel.getFrame().addMouseListener(mouseDetector);
        gamePanel.getFrame().addMouseMotionListener(mouseDetector);
        gamePanel.getCanvas().addMouseListener(mouseDetector);
        gamePanel.getCanvas().addMouseMotionListener(mouseDetector);
        ImageManager.init();
        gameManager = new GameManager(this);
        gameFrame = new GameFrame(gameManager);
        menuFrame = new MenuFrame(gameManager);
        presentation.Frame.setState(menuFrame);
    }

    private void update() {
        gamePanel.getFrame().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                xScale = (1f + (gamePanel.getFrame().getWidth() - GAME_WINDOW_WIDTH) / (float) GAME_WINDOW_WIDTH);
                yScale = (1f + (gamePanel.getFrame().getHeight() - GAME_WINDOW_HEIGHT) / (float) (GAME_WINDOW_HEIGHT));
            }
        });
        keyDetector.update();

        if (!paused) {
            keyDetector.update();
            if (presentation.Frame.getState() != null)
                presentation.Frame.getState().update();
        }
        if (paused) {
            keyDetector.update();
        }
    }

    private void render() {
        bufferStrategy = gamePanel.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            gamePanel.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) graphics;
        graphics.setColor(Color.WHITE);
        graphics.clearRect(0, 0, gamePanel.getFrame().getWidth(), gamePanel.getFrame().getHeight());
        graphics.fillRect(0, 0, gamePanel.getFrame().getWidth(), gamePanel.getFrame().getHeight());
        AffineTransform scaleMatrix = new AffineTransform();
        scaleMatrix.concatenate(g2.getTransform());
        scaleMatrix.scale(xScale, yScale - 0.07);
        g2.setTransform(scaleMatrix);

        // Draw your game elements here
        if (presentation.Frame.getState() != null) {
            Frame.getState().render(g2);
        }

        bufferStrategy.show();
        g2.dispose();
    }


    @Override
    public void run() {
        init();
        double elapsedTime = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            elapsedTime += (now - lastTime) / FRAMES_PER_SECOND;
            lastTime = now;

            if (elapsedTime >= 1) {
                update();
                render();
                elapsedTime--;
            }
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyDetector getKeyDetector() {
        return keyDetector;
    }
    public MouseDetector getMouseDetector() {
        return mouseDetector;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public Thread getThread() {
        return thread;
    }
    public GamePanel getDisplay() {
        return gamePanel;
    }
    public float getxScale() {
        return xScale;
    }
    public float getyScale() {
        return yScale;
    }
}
