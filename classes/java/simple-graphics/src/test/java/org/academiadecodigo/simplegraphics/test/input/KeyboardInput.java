package org.academiadecodigo.simplegraphics.test.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardInput implements KeyboardHandler {
    @Override
    public void keyPressed(KeyboardEvent e) {
        System.out.println(e);
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        System.out.println(e);
    }
}
