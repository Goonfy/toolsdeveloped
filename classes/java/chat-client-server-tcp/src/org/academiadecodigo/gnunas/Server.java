package org.academiadecodigo.gnunas;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class Server {
    private static final int PORT_NUMBER = 55000;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            server();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private static void close() {
        try {
            Objects.requireNonNull(serverSocket).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void server() throws IOException {
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

    private static BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private static void sendPacket(String message) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(message);
    }
}
