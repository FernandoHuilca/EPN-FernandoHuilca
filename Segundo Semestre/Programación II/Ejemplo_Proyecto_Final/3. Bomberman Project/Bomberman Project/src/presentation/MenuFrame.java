package presentation;

import logic.characters.Bomberman;
import logic.logicManagers.EntityManager;
import presentation.presentationManagers.GameManager;
import presentation.presentationManagers.ImageManager;
import presentation.presentationManagers.LevelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuFrame extends Frame {
    private BufferedImage backgroundImage;
    private BufferedImage logoImage;
    private BufferedImage startButton;
    private BufferedImage rulesButton;
    private BufferedImage scoreButton;
    private BufferedImage exitButton;

    public MenuFrame(GameManager gameManager) {
        super(gameManager);
        getMenuImages();
        gameManager.getKeyDetector();
    }


    @Override
    public void update() {
        int xAxis = gameManager.getMouseDetector().getMouseX();
        int yAxis = gameManager.getMouseDetector().getMouseY();

        if (gameManager.getMouseDetector().mouseOver(xAxis, yAxis,40 , 340, 120,  30) && (gameManager.getMouseDetector().isLeftPressed())) {
            Frame.setState(gameManager.getGame().gameFrame);
            if (gameManager.getMap().getId() == 0) {
                new Map(gameManager, 0);
                EntityManager.getPlayer().setHealth(Bomberman.PLAYER_HEALTH);
                EntityManager.getPlayer().setSpeed(Bomberman.PLAYER_SPEED);
                EntityManager.getPlayer().setScore(0);
                EntityManager.getPlayer().setRemainingTime(Bomberman.GAME_TIME * 1000);
                EntityManager.getPlayer().setFireUpLevel(0);
                Bomberman bomberman = EntityManager.getPlayer();
                gameManager.getMap().getEntityManager().getEntities().clear();
                gameManager.getMap().getEntityManager().getEntities().add(bomberman);
                gameManager.getMap().setId(1);
                gameManager.getMap().loadEntities(LevelManager.level1);
                gameManager.getMap().loadMap(LevelManager.level1);
            }
            gameManager.getMouseDetector().unpress();
        }
        if (gameManager.getMouseDetector().mouseOver(xAxis, yAxis, 170 , 370, 120,  30) && (gameManager.getMouseDetector().isLeftPressed())) {
            JOptionPane.showMessageDialog(null, getRules());
            gameManager.getMouseDetector().unpress();
        }
        if (gameManager.getMouseDetector().mouseOver(xAxis, yAxis, 270 , 340, 120,  30) && (gameManager.getMouseDetector().isLeftPressed())) {
            Scoreboard scoreboard = new Scoreboard();
            scoreboard.update();
            JOptionPane.showMessageDialog(null, scoreboard.getHighScores());
            gameManager.getMouseDetector().unpress();
        }
        if (gameManager.getMouseDetector().mouseOver(xAxis, yAxis, 450 , 360, 120,  30) && (gameManager.getMouseDetector().isLeftPressed())) {
            System.exit(0);
            gameManager.getMouseDetector().unpress();
        }
    }
    private void getMenuImages() {
        backgroundImage = ImageManager.loadImage("/img/background.png");
        logoImage = ImageManager.loadImage("/img/logo.png");
        startButton = ImageManager.loadImage("/img/start_button.png");
        rulesButton = ImageManager.loadImage("/img/rules_button.png");
        scoreButton = ImageManager.loadImage("/img/score_button.png");
        exitButton = ImageManager.loadImage("/img/exit_button.png");
    }

    @Override
    public void render(Graphics g) {

        Font bombermanFont = new Font("arial", 1, 30);

        g.drawImage(backgroundImage, 0, 0, gameManager.getGame().getWidth(), gameManager.getGame().getHeight(), null);

        int logoWidth = logoImage.getWidth();
        int logoHeight = logoImage.getHeight();
        int x = (gameManager.getGame().getWidth() - logoWidth) / 2;
        int y = 50;

        g.drawImage(logoImage, x, y, logoWidth, logoHeight, null);


        g.drawImage(startButton, 73, 360, 120, 30, null);

        g.drawImage(rulesButton, 182, 405, 120, 30, null);

        g.drawImage(scoreButton, 298, 360, 120, 30, null);

        g.drawImage(exitButton, 425 ,337, 136, 136, null);


        g.setFont(bombermanFont);
        g.setColor(Color.black);
        g.drawString("Made by Bombermansitos", 125, 505);


    }
    public static String getRules() {
        return "Bomberman NES Game Rules:\n"
                + "1. Objective: Clear each level by defeating enemies and finding the exit.\n"
                + "2. Controls: Use arrow keys to move and 'spacebar' to drop bombs.\n"
                + "3. Gameplay: Destroy soft blocks, avoid enemies and explosions, collect power-ups.\n"
                + "4. Power-ups: Find power-ups for improved abilities.\n"
                + "5. Exit: Reach the exit after defeating all enemies to advance to the next level.";
    }

}
