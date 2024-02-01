package logic.entities;

import logic.characters.Enemy;
import presentation.presentationManagers.GameManager;

import java.awt.*;

public abstract class Entity {

    protected GameManager gameManager;

    protected float x, y;

    protected int width, height;

    protected Rectangle bounds;
    protected int health;
    public static final int DEFAULT_HEALTH = Enemy.ENEMY_HEALTH;
    protected boolean active = true;

    public Entity(GameManager gameManager, float x, float y, int width, int height) {
        this.gameManager = gameManager;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;
        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void die();

    public void hurt() {
        health -= 1;
        if (health <= 0) {
            active = false;
            die();
        }
    }

    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : gameManager.getMap().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
