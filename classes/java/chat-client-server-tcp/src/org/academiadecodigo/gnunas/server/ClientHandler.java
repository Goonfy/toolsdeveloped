package org.academiadecodigo.gnunas.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Server server;

    private final CommandListener commandListener;

    public ClientHandler(Socket clientSocket, Server server, CommandListener commandListener) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.commandListener = commandListener;
    }

    @Override
    public void run() {
        try {
            handle(registerNewClient());

            server.disconnect(clientSocket);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handle(String username) throws IOException {
        if (username == null) {
            return;
        }

        while (true) {
            String message = server.decodePacketFrom(clientSocket);

            if (message == null) {
                break;
            }

            if (message.isEmpty()) {
                continue;
            }

            message = username + ": " + message;
            System.out.println(message);
            server.sendPacketToAll(message.getBytes());
        }
    }

    private String registerNewClient() throws IOException {
        server.sendPacketTo(clientSocket, "Please write an username and then click enter...".getBytes());

        String username = server.decodePacketFrom(clientSocket);

        if (username == null || username.isEmpty() || server.usernameExists(username)) {
            server.sendPacketTo(clientSocket, ("User with same name already connected " +
                    "or you entered an empty username, try with different name...").getBytes());
            return null;
        }

        server.connect(clientSocket, username);

        return username;
    }
}
