package org.academiadecodigo.gnunas.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Server server;

    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            String user = registerNewClient();
            if (user == null) {
                return;
            }

            handle(user);

            server.disconnect(clientSocket);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handle(String username) throws IOException {
        while (true) {
            BufferedReader bufferedReader = server.receivePacket(clientSocket);
            String message = bufferedReader.readLine();

            if (message == null || server.logout(clientSocket, message)) {
                break;
            }

            if (message.isEmpty()) {
                continue;
            }

            message = username + ": " + message;
            System.out.println(message);
            server.sendPacketToAll(message);
        }
    }

    private String registerNewClient() throws IOException {
        server.sendPacketTo(clientSocket, "Please write an username and then click enter...");

        BufferedReader bufferedReader = server.receivePacket(clientSocket);
        String username = bufferedReader.readLine();

        if (username == null || username.isEmpty() || server.usernameExists(username)) {
            return null;
        }

        server.connect(clientSocket, username);

        return username;
    }
}
