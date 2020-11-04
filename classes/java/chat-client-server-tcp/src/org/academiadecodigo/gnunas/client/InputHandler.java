package org.academiadecodigo.gnunas.client;

import java.io.*;

public class InputHandler {
    private final ChatHandler chatHandler;

    public InputHandler(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }

    public void init() {
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                chatHandler.sendPacketToServer(reader.readLine().getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
