package logic.bomb;

import logic.blocks.Block;
import logic.characters.Bomberman;
import logic.entities.Entity;
import presentation.presentationManagers.AnimationManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RightExplosion extends Explosion {

    private final AnimationManager rightExplosion;

    public RightExplosion(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, FIRE_X_WIDTH + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE, FIRE_X_HEIGHT);
        hurtBounds = new Rectangle(0, 10, 64 + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE, 12);
        hurtBounds.x = 0;
        hurtBounds.y = 10;
        hurtBounds.width = 64 + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE;
        hurtBounds.height = 12;
        rightExplosion = new AnimationManager(357, ImageManager.rightExplosion);
    }

    @Override
    public void die() {
    }

    @Override
    public void update() {
        rightExplosion.update();
        updateTimer();
        checkBlockCollision();
        checkExplosionCollision(0f, 0f);
    }

    @Override
    protected void checkExplosionCollision(float xOffset, float yOffset) {
        for (Entity e : gameManager.getMap().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getHurtCollisionBounds(xOffset, yOffset)))
                e.hurt();
        }
    }


    protected void checkBlockCollision() {
        for (int i = 0; i < width; i++) {
            int tx = (int) (x + i) / Block.DEFAULT_BLOCK_WIDHT;
            if (collisionWithBlock(tx, (int) (y + 8) / Block.DEFAULT_BLOCK_HEIGHT) || (collisionWithBlock(tx, (int) (y + 22) / Block.DEFAULT_BLOCK_HEIGHT))) {
                width = i;
                hurtBounds.width = i;
            }
        }
    }


    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationSpriteOfRightExplosion(), (int) (x), (int) (y), width, height, null);
    }

    protected Rectangle getHurtCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + hurtBounds.x + xOffset), (int) (y + hurtBounds.y + yOffset), hurtBounds.width, hurtBounds.height);
    }

    private BufferedImage getCurrentAnimationSpriteOfRightExplosion() {
        return rightExplosion.getCurrentSprite();
    }

}
