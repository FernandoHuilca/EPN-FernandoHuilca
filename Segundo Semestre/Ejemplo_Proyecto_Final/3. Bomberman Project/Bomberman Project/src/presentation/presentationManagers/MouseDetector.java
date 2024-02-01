package presentation.presentationManagers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDetector implements MouseMotionListener, MouseListener {
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void unpress() {
        leftPressed = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if (e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public boolean mouseOver(int xAxis, int yAxis, int x, int y, int width, int height) {
        if (xAxis > x && xAxis < x + width) {
            if (yAxis > y && yAxis < y + height) {
                return true;
            } else return false;
        } else return false;
    }
}
