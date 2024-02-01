package logic.logicManagers;

import logic.entities.SpecialEntity;
import presentation.presentationManagers.GameManager;

import java.awt.*;
import java.util.ArrayList;

public class SpecialEntityManager {
    private GameManager gameManager;
    private static ArrayList<SpecialEntity> specialEntities;

    public SpecialEntityManager(GameManager gameManager) {
        this.gameManager = gameManager;
        specialEntities = new ArrayList<SpecialEntity>();
    }

    public void update() {
        for (int i = 0; i < specialEntities.size(); i++) {
            SpecialEntity specialEntity = specialEntities.get(i);
            specialEntity.update();
            if (!specialEntity.isActive())
                specialEntities.remove(specialEntity);
        }
    }

    public void render(Graphics g) {
        for (SpecialEntity specialEntity : specialEntities) {
            specialEntity.render(g);
        }
    }

    public static ArrayList<SpecialEntity> getSpecialEntities() {
        return specialEntities;
    }

    public void addSpecialEntity(SpecialEntity se) {
        specialEntities.add(se);
    }
}
