package presentation.presentationManagers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageManager {

    public static final int width = 24;
    public static final int height = 24;
    private static BufferedImage sheet;
    public static BufferedImage block, solidBlock, floorBlock, speedUp, door, fireUp;
    public static BufferedImage[] playerDown, playerUp, playerLeft, playerRight;
    public static BufferedImage[] bomb;
    public static BufferedImage[] enemyAnimation;
    public static BufferedImage[] rightExplosion, leftExplosion, topExplosion, bottomExplosion;

    public static void init() {
        sheet = loadImage("/img/sprites.png");
        playerDown = new BufferedImage[3];
        playerUp = new BufferedImage[3];
        playerRight = new BufferedImage[3];
        playerLeft = new BufferedImage[3];

        bomb = new BufferedImage[7];

        rightExplosion = new BufferedImage[4];
        leftExplosion = rightExplosion;
        topExplosion = new BufferedImage[4];
        bottomExplosion = topExplosion;

        enemyAnimation = new BufferedImage[3];

        playerDown[0] = crop(0, 0, width, height);
        playerDown[1] = crop(24, 0, width, height);
        playerDown[2] = crop(48, 0, width, height);

        playerUp[0] = crop(216, 0, width, height);
        playerUp[1] = crop(240, 0, width, height);
        playerUp[2] = crop(264, 0, width, height);

        playerRight[0] = crop(72, 0, width, height);
        playerRight[1] = crop(96, 0, width, height);
        playerRight[2] = crop(120, 0, width, height);

        playerLeft[0] = crop(144, 0, width, height);
        playerLeft[1] = crop(168, 0, width, height);
        playerLeft[2] = crop(192, 0, width, height);

        bomb[0] = crop(470, 0, 16, 16);
        bomb[1] = crop(486, 0, 16, 16);
        bomb[2] = crop(502, 0, 16, 16);
        bomb[3] = crop(390, 32, 16, 16);
        bomb[4] = crop(406, 32, 16, 16);
        bomb[5] = crop(422, 32, 16, 16);
        bomb[6] = crop(438, 32, 16, 16);

        rightExplosion[0] = crop(326, 32, 16, 16);
        rightExplosion[1] = crop(342, 32, 16, 16);
        rightExplosion[2] = crop(358, 32, 16, 16);
        rightExplosion[3] = crop(374, 32, 16, 16);

        topExplosion[0] = crop(582, 16, 16, 16);
        topExplosion[1] = crop(598, 16, 16, 16);
        topExplosion[2] = crop(614, 16, 16, 16);
        topExplosion[3] = crop(630, 16, 16, 16);

        enemyAnimation[0] = crop(394, 233, 16, 16);
        enemyAnimation[1] = crop(410, 233, 16, 16);
        enemyAnimation[2] = crop(426, 233, 16, 16);

        block = loadImage("/img/block.png");
        solidBlock = loadImage("/img/wall.png");
        floorBlock = loadImage("/img/grass2.png");
        speedUp = loadImage("/img/iSpeed.png");
        door = loadImage("/img/doors.png");
        fireUp = loadImage("/img/iFire.png");
    }

    public static BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageManager.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}