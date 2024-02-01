package logic.blocks;

import logic.entities.Entity;
import logic.entities.SpecialEntity;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;
import logic.logicManagers.SpecialEntityManager;
import logic.powerUps.FireUp;

import java.awt.*;
import java.util.ArrayList;


public class BlockWithFireUp extends Entity {

    public BlockWithFireUp(GameManager gameManager, float x, float y) {
        super(gameManager, x, y, Block.DEFAULT_BLOCK_WIDHT, Block.DEFAULT_BLOCK_HEIGHT);
        bounds.x = 1;
        bounds.y = 1;
        bounds.width = 31;
        bounds.height = 31;
    }

    @Override
    public void die() {
        ArrayList<SpecialEntity> specialEntities = SpecialEntityManager.getSpecialEntities();
        FireUp fireUp = new FireUp(gameManager, x, y);
        specialEntities.add(fireUp);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.block, (int) (x), (int) (y), width, height, null);
    }
}
