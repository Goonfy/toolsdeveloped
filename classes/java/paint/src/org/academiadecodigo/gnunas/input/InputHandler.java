package org.academiadecodigo.gnunas.input;

import org.academiadecodigo.gnunas.Paint;
import org.academiadecodigo.gnunas.tools.Brush;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {

    private final Brush brush;

    public InputHandler(Brush brush) {
        this.brush = brush;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            brush.move(KeyType.UP);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            brush.move(KeyType.DOWN);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            brush.move(KeyType.LEFT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            brush.move(KeyType.RIGHT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (brush.isDrawing()) {
                return;
            }

            brush.draw();
            brush.setDrawing(true);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            Paint.saveDraw();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            Paint.loadDraw();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            Paint.clean();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            brush.setDrawing(false);
        }
    }
}
