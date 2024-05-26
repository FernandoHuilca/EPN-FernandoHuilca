package logic.characters;

import logic.blocks.Block;
import logic.entities.Character;
import logic.logicManagers.EntityManager;
import presentation.Map;
import presentation.presentationManagers.AnimationManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Character {
    public static final int ENEMY_HEALTH = 1;
    private static int ENEMY_SPEED = 2;
    private static int POINTS_FOR_ENEMY = 500;
    public static final int UP_DIRECTION = 1;
    public static final int DOWN_DIRECTION = 2;
    public static final int RIGHT_DIRECTION = 3;
    public static final int LEFT_DIRECTION = 4;
    public static int currentDirection;
    Bomberman bomberman = EntityManager.getPlayer();

    private AnimationManager enemyAnimation;

    public Enemy(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, logic.entities.Character.DEFAULT_CHARACTER_WIDTH, logic.entities.Character.DEFAULT_CHARACTER_HEIGHT);

        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 26;
        bounds.height = 24;
        speed = ENEMY_SPEED;
        health = ENEMY_HEALTH;
        enemyAnimation = new AnimationManager(300, ImageManager.enemyAnimation);
        currentDirection = DOWN_DIRECTION;
    }


    @Override
    public void update() {
        enemyAnimation.update();
        move();
    }

    public void die() {
        bomberman.setScore(bomberman.getScore() + POINTS_FOR_ENEMY);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

    }

    private BufferedImage getCurrentAnimationFrame() {
        return enemyAnimation.getCurrentSprite();
    }

    @Override
    public void move() {
        if ((!checkCollisionWithPlayer(speed, 0f)) && (!checkCollisionWithPlayer(-speed, 0f)))
            moveInX();
        if ((!checkCollisionWithPlayer(0f, speed)) && (!checkCollisionWithPlayer(0f, -speed)))
            moveInY();
    }

    ;

    @Override
    public void moveInX() {
        if (currentDirection == RIGHT_DIRECTION) {
            int tx = (int) (x + speed + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT;
            if (collisionWithBlock(tx, (int) (y + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT) &&
                    (collisionWithBlock(tx, (int) (y + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT)) ||
                    (checkEntityCollision(speed, 0f))) {
                changeDirection();

            } else
                x += speed;

        } else if (currentDirection == LEFT_DIRECTION) {
            int tx = (int) (x - speed + bounds.x) / Block.DEFAULT_BLOCK_WIDHT;

            if (collisionWithBlock(tx, (int) (y + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT)
                    && (collisionWithBlock(tx, (int) (y + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT)) ||
                    (checkEntityCollision(-speed, 0f))) {
                changeDirection();

            } else
                x -= speed;

        }
    }

    public void moveInY() {
        if (currentDirection == UP_DIRECTION) {
            int ty = (int) (y - speed + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT;
            if (collisionWithBlock((int) (x + bounds.x) / Block.DEFAULT_BLOCK_WIDHT, ty) &&
                    collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT, ty) ||
                    (checkEntityCollision(0f, -speed))) {
                changeDirection();

            } else
                y -= speed;

        } else if (currentDirection == DOWN_DIRECTION) {

            int ty = (int) (y + speed + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT;

            if (collisionWithBlock((int) (x + bounds.x) / Block.DEFAULT_BLOCK_WIDHT, ty) &&
                    collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT, ty) ||
                    (checkEntityCollision(0f, speed))) {
                changeDirection();

            } else {
                y += speed;
            }
        }

    }

    private void changeDirection() {
        if (currentDirection == UP_DIRECTION)
            currentDirection = RIGHT_DIRECTION;
        else if (currentDirection == RIGHT_DIRECTION)
            currentDirection = DOWN_DIRECTION;
        else if (currentDirection == DOWN_DIRECTION)
            currentDirection = LEFT_DIRECTION;
        else
            currentDirection = UP_DIRECTION;
    }


    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset) {
        if (getCollisionBounds(0f, 0f).intersects(bomberman.getCollisionBounds(xOffset, yOffset))) {
            bomberman.setX(Map.BOMBERMAN_X_SPAWN);
            bomberman.setY(Map.BOMBERMAN_Y_SPAWN);
            bomberman.setHealth(bomberman.getHealth() - 1);
            return true;
        }
        return false;
    }

    ;

    @Override
    protected boolean collisionWithBlock(int x, int y) {
        return gameManager.getMap().getBlock(x, y).isSolid();
    }


}
