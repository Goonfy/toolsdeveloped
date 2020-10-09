package org.academiadecodigo.simplegraphics.test.input;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseInput implements MouseHandler {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse Input: " + e.getX());
    }
}
