package logic.bomb;

import logic.blocks.Block;
import logic.characters.Bomberman;
import logic.entities.Entity;
import presentation.presentationManagers.AnimationManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TopExplosion extends Explosion {

    private final AnimationManager topExplosion;

    public TopExplosion(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, FIRE_Y_WIDTH, FIRE_Y_HEIGHT + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE);
        hurtBounds = new Rectangle(10, 0, 12, 64 + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE);
        hurtBounds.x = 10;
        hurtBounds.y = 0;
        hurtBounds.width = 12;
        hurtBounds.height = 64 + Bomberman.getFireUpLevel() * Bomb.FIRE_UP_VALUE;

        topExplosion = new AnimationManager(357, ImageManager.topExplosion);
        timer = 0;
        lastTime = System.currentTimeMillis();
        updateTimer();

    }

    @Override
    public void die() {

    }

    @Override
    public void update() {
        topExplosion.update();
        updateTimer();
        checkBlockCollision();
        checkExplosionCollision(0f, 0f);

    }

    protected void checkExplosionCollision(float xOffset, float yOffset) {
        for (Entity e : gameManager.getMap().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getHurtCollisionBounds(xOffset, yOffset)))
                e.hurt();
        }
    }

    protected void checkBlockCollision() {
        for (int i = 0; i < height; i++) {
            int ty = (int) (y + i) / Block.DEFAULT_BLOCK_HEIGHT;
            if (collisionWithBlock((int) (x + 8) / Block.DEFAULT_BLOCK_WIDHT, ty) || (collisionWithBlock((int) (x + 22) / Block.DEFAULT_BLOCK_WIDHT, ty))) {
                y = y + i;
                height = height - i;
                hurtBounds.y = hurtBounds.y + i;
                hurtBounds.height = hurtBounds.height - i;

            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationSpriteOfTopExplosion(), (int) (x), (int) (y), width, height, null);
    }

    protected Rectangle getHurtCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + hurtBounds.x + xOffset), (int) (y + hurtBounds.y + yOffset), hurtBounds.width, hurtBounds.height);
    }

    private BufferedImage getCurrentAnimationSpriteOfTopExplosion() {
        return topExplosion.getCurrentSprite();
    }

}
