package presentation;

import presentation.presentationManagers.GameManager;

import java.awt.*;

public abstract class Frame {
    private static Frame currentFrame = null;

    protected GameManager gameManager;

    public static void setState(Frame frame) {
        currentFrame = frame;
    }

    public Frame(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static Frame getState() {
        return currentFrame;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
