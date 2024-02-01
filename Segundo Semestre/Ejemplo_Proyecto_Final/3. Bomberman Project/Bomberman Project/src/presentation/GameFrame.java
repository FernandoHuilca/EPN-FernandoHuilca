package presentation;

import logic.logicManagers.EntityManager;
import presentation.presentationManagers.GameManager;

import java.awt.*;

public class GameFrame extends Frame {
    private Map map;

    public GameFrame(GameManager gameManager) {
        super(gameManager);
        map = new Map(gameManager, 1);
        gameManager.setMap(map);
    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);

        Font bombermanFont = new Font("arial", 1, 20);

        g.setFont(bombermanFont);
        g.setColor(Color.black);
        g.drawString("Lives: ", 50, 505);
        g.drawString(Integer.toString(EntityManager.getPlayer().getHealth()), 110, 505);
//        g.drawString("Speed: ", 120, 505);
//        g.drawString(Float.toString(EntityManager.getPlayer().getSpeed()), 220, 505);
        g.drawString("Score: ", 475, 505);
        g.drawString(Integer.toString(EntityManager.getPlayer().getScore()), 540, 505);
        g.drawString("Remaining time: ", 200, 505);
        g.drawString(Integer.toString(EntityManager.getPlayer().getRemainingTime() / 1000), 355, 505);
    }

}
