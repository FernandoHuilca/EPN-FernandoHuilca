package presentation.presentationManagers;


import presentation.Game;
import presentation.Map;

public class GameManager {
    private Game game;
    private Map map;


    public GameManager(Game game) {
        this.game = game;
    }
    public MouseDetector getMouseDetector() {
        return game.getMouseDetector();
    }

    public KeyDetector getKeyDetector() {
        return game.getKeyDetector();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
