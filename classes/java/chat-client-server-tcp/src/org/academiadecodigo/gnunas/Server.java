package org.academiadecodigo.gnunas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;

public class Server {
    private static final int PORT_NUMBER = 55000;

    private static Socket clientSocket;

    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void server() throws IOException {
        serverSocket = new ServerSocket(PORT_NUMBER);
        clientSocket = serverSocket.accept();

        sendPacket(receivePacket().readLine());

        Objects.requireNonNull(serverSocket).close();
    }

    private static BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private static void sendPacket(String message) throws IOException {
        clientSocket.getOutputStream().write(message.getBytes());
    }
}
