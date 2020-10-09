package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.test.input.KeyboardInput;
import org.academiadecodigo.simplegraphics.test.input.MouseInput;

public class Game {
    public Game() {
        Mouse mouse = new Mouse(new MouseInput());

        Keyboard keyboard = new Keyboard(new KeyboardInput());
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEvent);
    }

    public void play() throws InterruptedException {
        Rectangle rect = new Rectangle(10, 10, 400, 400);
        rect.setColor(Color.BLACK);
        rect.draw();

        Thread.sleep(2000);
    }
}
