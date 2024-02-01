package logic.entities;

import presentation.presentationManagers.GameManager;

import java.awt.*;

public abstract class SpecialEntity {

    protected GameManager gameManager;

    protected float x, y;

    protected int width, height;

    protected Rectangle bounds;
    protected boolean active = true;

    public SpecialEntity(GameManager gameManager, float x, float y, int width, int height) {
        this.gameManager = gameManager;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
