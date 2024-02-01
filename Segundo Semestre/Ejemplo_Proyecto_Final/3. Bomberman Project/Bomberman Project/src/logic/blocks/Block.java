package logic.blocks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block {

    public static Block[] blocks = new Block[50];
    public static Block floorBlock = new FloorBlock(0);
    public static Block solidBlock = new SolidBlock(1);

    public static final int DEFAULT_BLOCK_WIDHT = 32;

    public static final int DEFAULT_BLOCK_HEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;

    public Block(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        blocks[id] = this;
    }

    public void update() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, DEFAULT_BLOCK_WIDHT, DEFAULT_BLOCK_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

    public static Block[] getBlocks() {
        return blocks;
    }

    public static void setBlocks(Block[] blocks) {
        Block.blocks = blocks;
    }
}
