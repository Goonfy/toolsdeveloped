package org.academiadecodigo.gnunas.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

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
            server.connect(clientSocket);

            while (true) {

                BufferedReader bufferedReader = receivePacket();
                String message = bufferedReader.readLine();

                if (message == null) {
                    break;
                }

                System.out.println("Received Message: " + message);

                sendPacket(message);

            }

            server.disconnect(clientSocket);
        } catch (IOException e) {
            System.out.println("Error communicating to server " + e.getMessage());
        }
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(String message) throws IOException {
        for (Socket clientSocket : server.getConnectedClients()) {
            PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            fileWriter.println(message);
        }
    }
}
