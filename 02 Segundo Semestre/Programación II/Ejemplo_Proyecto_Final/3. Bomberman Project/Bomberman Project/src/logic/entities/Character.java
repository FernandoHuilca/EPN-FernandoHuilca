package logic.entities;

import logic.blocks.Block;
import presentation.presentationManagers.GameManager;

public abstract class Character extends Entity {

    public static final float DEFAULT_SPEED = 2.0F;
    public static final int DEFAULT_CHARACTER_WIDTH = Block.DEFAULT_BLOCK_WIDHT;
    public static final int DEFAULT_CHARACTER_HEIGHT = Block.DEFAULT_BLOCK_HEIGHT;
    protected float speed;

    public Character(GameManager gameManager, float x, float y, int width, int height) {
        super(gameManager, x, y, width, height);
        speed = DEFAULT_SPEED;
    }

    public void die() {
    }

    public void move() {
    }

    public void moveInX() {
    }

    public void moveInY() {
    }

    protected boolean collisionWithBlock(int x, int y) {
        return gameManager.getMap().getBlock(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
