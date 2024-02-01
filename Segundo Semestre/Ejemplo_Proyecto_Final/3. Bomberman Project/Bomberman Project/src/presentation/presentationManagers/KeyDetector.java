package presentation.presentationManagers;

import presentation.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyDetector implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean bombPlace;
    public boolean pause, unpause;
    Game game;
    GameManager gameManager;

    public KeyDetector(GameManager gameManager, Game game) {
        this.game = game;
        this.gameManager = gameManager;
        keys = new boolean[256];
    }

    public void update() {
        // Option 1
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        // Option 2
//        up = keys[KeyEvent.VK_UP];
//        down = keys[KeyEvent.VK_DOWN];
//        left = keys[KeyEvent.VK_LEFT];
//        right = keys[KeyEvent.VK_RIGHT];

        bombPlace = keys[KeyEvent.VK_SPACE];

        pause = keys[KeyEvent.VK_P];
        unpause = keys[KeyEvent.VK_O];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        if (keys[e.getKeyCode()] == pause) {
            Game.paused = true;
        }
        if (keys[e.getKeyCode()] == unpause) {
            Game.paused = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
