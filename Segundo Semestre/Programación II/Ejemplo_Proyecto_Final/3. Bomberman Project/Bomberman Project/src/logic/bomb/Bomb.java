package logic.bomb;

import logic.blocks.Block;
import logic.characters.Bomberman;
import logic.entities.Entity;
import logic.logicManagers.EntityManager;
import presentation.presentationManagers.AnimationManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bomb extends Entity {
    private static boolean bombed;
    private static boolean rightExplosionPlaced, leftExplosionPlaced, topExplosionPlaced, bottomExplosionPlaced;
    private long timer, lastTime;
    private final int TIME_TO_EXPLODE = 2500;

    protected static final int FIRE_UP_VALUE = 16;
    private final AnimationManager bomb;

    public Bomb(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;

        rightExplosionPlaced = false;
        leftExplosionPlaced = false;
        topExplosionPlaced = false;
        bottomExplosionPlaced = false;

        bombed = false;

        bomb = new AnimationManager(357, ImageManager.bomb);

        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public static boolean isBombed() {
        return bombed;
    }

    public void setBombed(boolean bombed) {
        Bomb.bombed = bombed;
    }

    @Override
    public void update() {
        bomb.update();
        timerUpdate();
    }

    public void die() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame() {
        return bomb.getCurrentSprite();
    }

    public void timerUpdate() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer >= TIME_TO_EXPLODE) {
            hurt();
            EntityManager.getPlayer().setCanSetBomb(true);
        }
        if (timer >= 1071 && !rightExplosionPlaced) {
            ArrayList<Entity> entities = gameManager.getMap().getEntityManager().getEntities();
            RightExplosion rightExplosion = new RightExplosion(gameManager, x + 32, y + 0);
            entities.add(rightExplosion);
            rightExplosionPlaced = true;
        }
        if (timer >= 1071 && !leftExplosionPlaced) {
            ArrayList<Entity> entities = gameManager.getMap().getEntityManager().getEntities();
            LeftExplosion leftExplosion = new LeftExplosion(gameManager, x - 64 - (Bomberman.getFireUpLevel() * FIRE_UP_VALUE), y + 0);
            entities.add(leftExplosion);
            leftExplosionPlaced = true;
        }
        if (timer >= 1071 && !topExplosionPlaced) {
            ArrayList<Entity> entities = gameManager.getMap().getEntityManager().getEntities();
            TopExplosion topExplosion = new TopExplosion(gameManager, x, y - 64 - (Bomberman.getFireUpLevel() * FIRE_UP_VALUE));
            entities.add(topExplosion);
            topExplosionPlaced = true;
        }
        if (timer >= 1071 && !bottomExplosionPlaced) {
            ArrayList<Entity> entities = gameManager.getMap().getEntityManager().getEntities();
            BottomExplosion bottomExplosion = new BottomExplosion(gameManager, x, y + 32);
            entities.add(bottomExplosion);
            bottomExplosionPlaced = true;
        }
    }

    public long getTimer() {
        return timer;
    }
}
