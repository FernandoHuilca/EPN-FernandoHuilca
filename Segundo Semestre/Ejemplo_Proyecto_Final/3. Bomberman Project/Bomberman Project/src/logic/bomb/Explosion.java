package logic.bomb;

import logic.entities.Entity;
import presentation.presentationManagers.GameManager;

import java.awt.*;

public abstract class Explosion extends Entity {

    protected static final int FIRE_X_WIDTH = 64;
    protected static final int FIRE_X_HEIGHT = 32;
    protected static final int FIRE_Y_WIDTH = 32;
    protected static final int FIRE_Y_HEIGHT = 64;
    protected int FIRE_TIME_OF_LIFE = 1429;
    protected long timer, lastTime;

    protected Rectangle hurtBounds;


    public Explosion(GameManager gameManager, float x, float y, int width, int height) {
        super(gameManager, x, y, width, height);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
        updateTimer();
    }

    protected void updateTimer() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer >= FIRE_TIME_OF_LIFE) {
            hurt();
        }
    }

    protected boolean collisionWithBlock(int x, int y) {
        return gameManager.getMap().getBlock(x, y).isSolid();
    }
    protected abstract void checkBlockCollision();
    protected abstract void checkExplosionCollision(float xOffset, float yOffset);
}
