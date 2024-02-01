package logic.blocks;

import logic.entities.Entity;
import logic.entities.SpecialEntity;
import presentation.presentationManagers.ImageManager;
import presentation.presentationManagers.GameManager;
import logic.logicManagers.SpecialEntityManager;
import logic.powerUps.SpeedUp;

import java.awt.*;
import java.util.ArrayList;

public class BlockWithSpeedUp extends Entity {

    public BlockWithSpeedUp(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);

        bounds.x = 1;
        bounds.y = 1;
        bounds.width = 31;
        bounds.height = 31;
    }

    @Override
    public void update() {
    }

    public void die() {
        ArrayList<SpecialEntity> specialEntities = SpecialEntityManager.getSpecialEntities();
        SpeedUp speedUp = new SpeedUp(gameManager, x, y);
        specialEntities.add(speedUp);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.block, (int) (x), (int) (y), width, height, null);
    }
}
