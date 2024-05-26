package presentation.presentationManagers;

import java.awt.image.BufferedImage;

public class AnimationManager {
    private int speed;
    private int index;
    private long lastTime, timer;
    private BufferedImage[] sprite;

    public AnimationManager(int speed, BufferedImage[] sprite) {
        this.speed = speed;
        this.sprite = sprite;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= sprite.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentSprite() {
        return sprite[index];
    }

    public BufferedImage getFrame0() {
        return sprite[0];
    }
}
