package org.academiadecodigo.gnunas;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class Server {
    private final int PORT_NUMBER = 55000;

    private ServerSocket serverSocket;
    private Socket clientSocket;

    public void init() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            server();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            Objects.requireNonNull(serverSocket).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void server() throws IOException {
        clientSocket = serverSocket.accept();

        while (true) {
            BufferedReader bufferedReader = receivePacket();
            String message = bufferedReader.readLine();
            sendPacket(message);

            if (message == null || message.contains("/quit")) {
                break;
            }
        }

        server();
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(String message) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(message);
    }
}
