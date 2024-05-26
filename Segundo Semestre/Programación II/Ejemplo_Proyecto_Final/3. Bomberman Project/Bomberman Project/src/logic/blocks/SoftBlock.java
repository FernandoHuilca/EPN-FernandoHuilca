package logic.blocks;

import logic.entities.Entity;
import presentation.presentationManagers.ImageManager;
import presentation.presentationManagers.GameManager;

import java.awt.*;

public class SoftBlock extends Entity {

    public SoftBlock(GameManager gameManager, float x, float y) {
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
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageManager.block, (int) (x), (int) (y), width, height, null);
    }
}
