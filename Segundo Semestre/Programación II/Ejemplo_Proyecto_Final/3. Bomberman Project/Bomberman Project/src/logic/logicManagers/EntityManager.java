package logic.logicManagers;

import logic.characters.Bomberman;
import logic.entities.Entity;
import presentation.presentationManagers.GameManager;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private GameManager gameManager;
    private static Bomberman bomberman;
    private Character enemy;
    private ArrayList<Entity> entities;


    public EntityManager(GameManager gameManager, Bomberman bomberman) {
        this.gameManager = gameManager;
        this.bomberman = bomberman;
        entities = new ArrayList<Entity>();
        addEntity(bomberman);
    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.update();
            if (!e.isActive())
                entities.remove(e);
        }
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public GameManager getManager() {
        return gameManager;
    }

    public void setManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public static Bomberman getPlayer() {
        return bomberman;
    }

    public void setPlayer(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public Character getEnemy() {
        return enemy;
    }

    public void setEnemy(Character enemy) {
        this.enemy = enemy;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
