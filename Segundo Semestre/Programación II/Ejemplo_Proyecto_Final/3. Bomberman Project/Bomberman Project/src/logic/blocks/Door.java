package logic.blocks;

import presentation.Map;
import logic.entities.SpecialEntity;
import presentation.presentationManagers.GameManager;
import presentation.Frame;
import presentation.presentationManagers.LevelManager;
import logic.logicManagers.EntityManager;
import logic.characters.Bomberman;
import presentation.presentationManagers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class Door extends SpecialEntity {
    private static final int POINTS_FOR_PASSING_LEVEL = 1000;
    private static final int POINTS_PER_LIFE = 1500;
    JFrame frame;
    Bomberman bomberman = EntityManager.getPlayer();

    public Door(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);
    }

    @Override
    public void update() {
        if (checkCollisionWithPlayer(0f, 0f))
            active = false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.door, (int) (x), (int) (y), width, height, null);
    }

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset) {
        if (getCollisionBounds(0f, 0f).intersects(bomberman.getCollisionBounds(xOffset, yOffset))) {
            if (gameManager.getMap().getId() == 1) {
                gameManager.getMap().getSpecialEntityManager().getSpecialEntities().clear();
                Bomberman bomberman2 = EntityManager.getPlayer();
                gameManager.getMap().getEntityManager().getEntities().clear();
                gameManager.getMap().getEntityManager().getEntities().add(bomberman2);
                EntityManager.getPlayer().setSpeed(Bomberman.PLAYER_SPEED);
                EntityManager.getPlayer().setX(Map.BOMBERMAN_X_SPAWN);
                EntityManager.getPlayer().setY(Map.BOMBERMAN_Y_SPAWN);
                EntityManager.getPlayer().setFireUpLevel(0);
                bomberman2.setScore(bomberman2.getScore() + POINTS_FOR_PASSING_LEVEL);
                bomberman2.setCanSetBomb(true);
                gameManager.getMap().setId(2);
                gameManager.getMap().loadEntities(LevelManager.level2);
                gameManager.getMap().loadMap(LevelManager.level2);
                return true;
            }
            if (gameManager.getMap().getId() == 2) {
                gameManager.getMap().getSpecialEntityManager().getSpecialEntities().clear();
                Bomberman bomberman3 = EntityManager.getPlayer();
                gameManager.getMap().getEntityManager().getEntities().clear();
                gameManager.getMap().getEntityManager().getEntities().add(bomberman3);
                EntityManager.getPlayer().setSpeed(Bomberman.PLAYER_SPEED);
                EntityManager.getPlayer().setX(Map.BOMBERMAN_X_SPAWN);
                EntityManager.getPlayer().setY(Map.BOMBERMAN_Y_SPAWN);
                EntityManager.getPlayer().setFireUpLevel(0);
                bomberman3.setScore(bomberman3.getScore() + POINTS_FOR_PASSING_LEVEL);
                bomberman3.setCanSetBomb(true);
                gameManager.getMap().setId(3);
                gameManager.getMap().loadEntities(LevelManager.level3);
                gameManager.getMap().loadMap(LevelManager.level3);
                return true;
            }
            if (gameManager.getMap().getId() == 3) {
                gameManager.getMap().getEntityManager().getEntities().clear();
                gameManager.getMap().getSpecialEntityManager().getSpecialEntities().clear();
                gameManager.getMap().setId(0);
                EntityManager.getPlayer().setScore(EntityManager.getPlayer().getScore() + POINTS_FOR_PASSING_LEVEL);
                EntityManager.getPlayer().setScore(EntityManager.getPlayer().getScore() + (EntityManager.getPlayer().getHealth() * POINTS_PER_LIFE) + (EntityManager.getPlayer().getRemainingTime() / 1000));
                EntityManager.getPlayer().endGame("Congratulations! You Win");
                Frame.setState(gameManager.getGame().menuFrame);
            }

        }
        return false;
    }
}
