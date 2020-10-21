package org.academiadecodigo.gnunas.input;

import org.academiadecodigo.gnunas.tools.Brush;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Keyboard {
    public Keyboard(Brush brush) {
        InputHandler keyBindings = new InputHandler(brush);
        org.academiadecodigo.simplegraphics.keyboard.Keyboard keyboard = new org.academiadecodigo.simplegraphics.keyboard.Keyboard(keyBindings);

        KeyboardEvent moveUp = new KeyboardEvent();
        KeyboardEvent moveDown = new KeyboardEvent();
        KeyboardEvent moveLeft = new KeyboardEvent();
        KeyboardEvent moveRight = new KeyboardEvent();
        KeyboardEvent draw = new KeyboardEvent();
        KeyboardEvent save = new KeyboardEvent();
        KeyboardEvent load = new KeyboardEvent();
        KeyboardEvent clean = new KeyboardEvent();

        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);
        draw.setKey(KeyboardEvent.KEY_SPACE);
        draw.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(draw);
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);
        clean.setKey(KeyboardEvent.KEY_C);
        clean.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clean);

        KeyboardEvent drawReleased = new KeyboardEvent();

        drawReleased.setKey(KeyboardEvent.KEY_SPACE);
        drawReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(drawReleased);
    }
}
