package org.academiadecodigo.gnunas.server;

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

            if (message.isEmpty() || commandListener.check(username, message)) {
                continue;
            }

            message = username + ": " + message;
            System.out.println(message);
            server.sendMessagePacketToAll(message);
        }
    }

    private String registerNewClient() throws IOException {
        server.sendMessagePacketTo(clientSocket, "Please write an username and then click enter...");

        String username = server.decodePacketFrom(clientSocket);

        if (username == null || username.isEmpty() || server.getUser(username) != null) {
            server.sendMessagePacketTo(clientSocket, ("User with same name already connected " +
                    "or you entered an empty username, try with different name..."));
            return null;
        }

        server.connect(clientSocket, username);

        return username;
    }
}
