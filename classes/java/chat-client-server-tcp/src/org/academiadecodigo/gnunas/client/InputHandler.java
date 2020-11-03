package org.academiadecodigo.gnunas.client;

import java.io.IOException;

public class InputHandler implements Runnable {
    private final byte[] message;

    public InputHandler() {
        message = new byte[1024];
    }

    public byte[] getInput() {
        return message;
    }

    @Override
    public void run() {
        try {
            System.in.read(message);
        } catch (IOException e) {
            System.out.println("Input error " + e.getMessage());
        }
    }
}
