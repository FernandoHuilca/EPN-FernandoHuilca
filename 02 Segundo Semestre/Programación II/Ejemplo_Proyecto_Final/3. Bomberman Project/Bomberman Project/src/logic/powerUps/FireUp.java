package logic.powerUps;

import presentation.presentationManagers.GameManager;
import logic.logicManagers.EntityManager;
import logic.characters.Bomberman;
import presentation.presentationManagers.ImageManager;
import logic.blocks.Block;
import logic.entities.SpecialEntity;

import java.awt.*;

public class FireUp extends SpecialEntity {
    Bomberman bomberman = EntityManager.getPlayer();

    public FireUp(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);
    }

    @Override
    public void update() {
        if (checkCollisionWithPlayer(0f, 0f))
            active = false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.fireUp, (int) (x), (int) (y), width, height, null);
    }

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset) {
        if (getCollisionBounds(0f, 0f).intersects(bomberman.getCollisionBounds(xOffset, yOffset))) {
            bomberman.setFireUpLevel(bomberman.getFireUpLevel() + 1);
            return true;
        }
        return false;
    }
}
