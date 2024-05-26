package logic.powerUps;

import presentation.presentationManagers.GameManager;
import logic.logicManagers.EntityManager;
import logic.characters.Bomberman;
import presentation.presentationManagers.ImageManager;
import logic.blocks.Block;
import logic.entities.SpecialEntity;

import java.awt.*;

public class SpeedUp extends SpecialEntity {
    Bomberman bomberman = EntityManager.getPlayer();

    public SpeedUp(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);
    }

    @Override
    public void update() {
        if (checkCollisionWithPlayer(0f, 0f))
            active = false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.speedUp, (int) (x), (int) (y), width, height, null);
    }

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset) {
        if (getCollisionBounds(0f, 0f).intersects(bomberman.getCollisionBounds(xOffset, yOffset))) {
            bomberman.setSpeed(bomberman.getSpeed() + 1);
            return true;
        }
        return false;
    }
}
