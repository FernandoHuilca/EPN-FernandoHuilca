package logic.blocks;

import presentation.presentationManagers.ImageManager;

public class SolidBlock extends Block {
    public SolidBlock(int id) {
        super(ImageManager.solidBlock, id);
    }

    public boolean isSolid() {
        return true;
    }
}
