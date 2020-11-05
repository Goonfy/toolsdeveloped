package org.academiadecodigo.gnunas.client;

import org.academiadecodigo.gnunas.server.Server;

import java.io.*;
import java.net.Socket;

public class ChatHandler implements Runnable {
    private final Client client;

    public ChatHandler(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = client.decodePacketFromServer();

                if (message == null) {
                    System.out.println("Connection terminated, goodbye...");
                    System.exit(0);
                }

                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
