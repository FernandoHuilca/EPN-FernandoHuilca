package logic.characters;

import logic.blocks.Block;
import logic.bomb.Bomb;
import logic.entities.Character;
import logic.entities.Entity;
import presentation.Frame;
import presentation.Scoreboard;
import presentation.presentationManagers.AnimationManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Bomberman extends Character {
    public static final int GAME_TIME = 150;
    public static final float PLAYER_SPEED = 2.0F;
    public static int PLAYER_HEALTH = 3;
    private AnimationManager downAnimation, upAnimation, leftAnimation, rightAnimation;
    protected float xMovement, yMovement;
    Bomb bomb;
    private boolean canSetBomb = true;
    private static int score;
    private static String name;
    private static int remainingTime, lastTime;
    private static int fireUpLevel;

    JFrame f;

    public Bomberman(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);

        bounds.x = 8;
        bounds.y = 8;
        bounds.width = 16;
        bounds.height = 20;

        health = PLAYER_HEALTH;
        score = 0;
        fireUpLevel = 0;

        speed = PLAYER_SPEED;
        downAnimation = new AnimationManager(300, ImageManager.playerDown);
        upAnimation = new AnimationManager(300, ImageManager.playerUp);
        leftAnimation = new AnimationManager(300, ImageManager.playerLeft);
        rightAnimation = new AnimationManager(300, ImageManager.playerRight);

        xMovement = 0;
        yMovement = 0;

        this.bomb = bomb;

        remainingTime = GAME_TIME * 1000;

        lastTime = (int) System.currentTimeMillis();
    }

    @Override
    public void update() {
        downAnimation.update();
        rightAnimation.update();
        leftAnimation.update();
        upAnimation.update();

        checkHealth();
        getInput();
        move();
        timerUpdate();
    }

    public void move() {
        if (!checkEntityCollision(xMovement, 0f))
            moveInX();
        if (!checkEntityCollision(0f, yMovement))
            moveInY();
    }

    public void moveInX() {
        if (xMovement > 0) {
            int targetX = (int) (x + xMovement + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT;
            if (!collisionWithBlock(targetX, (int) (y + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT) && (!collisionWithBlock(targetX, (int) (y + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT))) {
                x += xMovement;
            }
        } else if (xMovement < 0) {
            int targetX = (int) (x + xMovement + bounds.x) / Block.DEFAULT_BLOCK_WIDHT;
            if (!collisionWithBlock(targetX, (int) (y + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT) && (!collisionWithBlock(targetX, (int) (y + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT))) {
                x += xMovement;
            }
        }
    }

    public void moveInY() {
        if (yMovement < 0) {
            int targetY = (int) (y + yMovement + bounds.y) / Block.DEFAULT_BLOCK_HEIGHT;
            if (!collisionWithBlock((int) (x + bounds.x) / Block.DEFAULT_BLOCK_WIDHT, targetY) && !collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT, targetY)) {
                y += yMovement;
            }
        } else if (yMovement > 0) {
            int targetY = (int) (y + yMovement + bounds.y + bounds.height) / Block.DEFAULT_BLOCK_HEIGHT;
            if (!collisionWithBlock((int) (x + bounds.x) / Block.DEFAULT_BLOCK_WIDHT, targetY) && !collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.DEFAULT_BLOCK_WIDHT, targetY)) {
                y += yMovement;
            }
        }
    }

    public void checkHealth() {
        if (this.health == 0) {
            endGame("Game Over! You died");
        }
    }

    public void setBomb(float x, float y) {
        ArrayList<Entity> entities = gameManager.getMap().getEntityManager().getEntities();
        Bomb bomb = new Bomb(gameManager, x, y);
        entities.add(bomb);

    }

    private void getInput() {
        xMovement = 0;
        yMovement = 0;

        if (gameManager.getKeyDetector().up)
            yMovement = -speed;
        if (gameManager.getKeyDetector().down)
            yMovement = speed;
        if (gameManager.getKeyDetector().left)
            xMovement = -speed;
        if (gameManager.getKeyDetector().right)
            xMovement = speed;
        if (gameManager.getKeyDetector().bombPlace) {
            if (canSetBomb) {
                setBomb(x, y);
                if (bomb.isBombed())
                    canSetBomb = true;
                else
                    canSetBomb = false;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

    }

    public void die() {
    }

    public void hurt() {
        health -= 1;
        x = 32;
        y = 32;
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMovement < 0) {
            return leftAnimation.getCurrentSprite();
        } else if (xMovement > 0) {
            return rightAnimation.getCurrentSprite();
        } else if (yMovement < 0) {
            return upAnimation.getCurrentSprite();
        } else if (yMovement > 0) {
            return downAnimation.getCurrentSprite();
        } else {
            return downAnimation.getFrame0();
        }
    }

    private void timerUpdate() {
        remainingTime -= System.currentTimeMillis() - lastTime;
        lastTime = (int) System.currentTimeMillis();

        if (remainingTime / 1000 <= 0) {
            endGame("Game Over! You've run out of time");
        }

    }

    public void endGame(String endGameMessage) {
        f = new JFrame();
        name = JOptionPane.showInputDialog(f, endGameMessage + "\nYour score: " + score + "\nEnter nickname: ");
        Scoreboard.writeScore(name, score);
        Frame.setState(gameManager.getGame().menuFrame);
        gameManager.getMap().setId(0);
    }


    public void setCanSetBomb(boolean canSetBomb) {
        this.canSetBomb = canSetBomb;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Bomberman.score = score;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Bomberman.name = name;
    }

    public float getxMovement() {
        return xMovement;
    }

    public void setxMovement(float xMovement) {
        this.xMovement = xMovement;
    }

    public float getyMovement() {
        return yMovement;
    }

    public void setyMovement(float yMovement) {
        this.yMovement = yMovement;
    }

    public static int getRemainingTime() {
        return remainingTime;
    }

    public static void setRemainingTime(int remainingTime) {
        Bomberman.remainingTime = remainingTime;
    }

    public static int getFireUpLevel() {
        return fireUpLevel;
    }

    public static void setFireUpLevel(int fireUpLevel) {
        Bomberman.fireUpLevel = fireUpLevel;
    }
}
