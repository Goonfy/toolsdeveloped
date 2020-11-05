package org.academiadecodigo.gnunas.client;

import java.io.*;

public class InputHandler {
    private final Client client;

    public InputHandler(Client client) {
        this.client = client;
    }

    public void init() {
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                client.sendMessagePacketToServer(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
