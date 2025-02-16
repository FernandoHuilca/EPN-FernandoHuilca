package presentation;

import logic.blocks.*;
import logic.characters.Bomberman;
import logic.characters.Enemy;
import logic.logicManagers.EntityManager;
import logic.logicManagers.SpecialEntityManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.LevelManager;

import java.awt.*;

public class Map {
    private int LEVEL_WIDTH = 19;
    private int LEVEL_HEIGHT = 15;
    public static final int BOMBERMAN_X_SPAWN = 32;
    public static final int BOMBERMAN_Y_SPAWN = 32;
    private GameManager gameManager;
    private int width, height;
    private int xSpawn = 32;
    private int ySpawn = 32;
    private int[][] blocks;
    private EntityManager entityManager;
    private SpecialEntityManager specialEntityManager;
    private int id;
    private String level;


    public Map(GameManager gameManager, int id) {
        this.gameManager = gameManager;
        this.id = id;
        entityManager = new EntityManager(gameManager, new Bomberman(gameManager, 32, 32));
        specialEntityManager = new SpecialEntityManager(gameManager);
        level = LevelManager.level0;
        loadMap(level);
        loadEntities(level);
        entityManager.getPlayer().setX(xSpawn);
        entityManager.getPlayer().setY(ySpawn);

    }

    public void update() {
        entityManager.update();
        specialEntityManager.update();

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getBlock(x, y).render(g, x * Block.DEFAULT_BLOCK_WIDHT, y * Block.DEFAULT_BLOCK_HEIGHT);
            }
        }
        entityManager.render(g);
        specialEntityManager.render(g);
    }


    public Block getBlock(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Block.floorBlock;

        Block temporal = Block.blocks[blocks[x][y]];
        if (temporal == null)
            return Block.floorBlock;
        return temporal;
    }


    public void loadMap(String level) {
        String[] tokens = level.split("\\s+");
        width = LEVEL_WIDTH;
        height = LEVEL_HEIGHT;
        xSpawn = BOMBERMAN_X_SPAWN;
        ySpawn = BOMBERMAN_Y_SPAWN;

        blocks = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                blocks[x][y] = Integer.parseInt(tokens[x + y * width]);
            }
        }
    }

    public void loadEntities(String area) {
        int x = 0;
        int y = 0;
        int z = 0;
        int k = 0;

        for (int i = 0; i < area.length(); i++) {
            char item = area.charAt(i);
            switch (item) {
                case '\n':
                    y += 32;
                    if (0 < x) {
                        z = x;
                    }
                    x = 0;
                    break;
                case ' ':
                    x += 32;
                    break;
                case '2':
                    entityManager.addEntity(new SoftBlock(gameManager, x, y));
                    x += 32;
                    break;
                case '3':
                    entityManager.addEntity(new Enemy(gameManager, x, y));
                    x += 32;
                case '6':
                    entityManager.addEntity(new BlockWithFireUp(gameManager, x, y));
                    x += 32;
                    break;
                case '7':
                    entityManager.addEntity(new BlockWithSpeedUp(gameManager, x, y));
                    x += 32;
                    break;
                case '8':
                    entityManager.addEntity(new BlockWithDoor(gameManager, x, y));
                    x += 32;
            }
            k = y;
        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public SpecialEntityManager getSpecialEntityManager() {
        return specialEntityManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
