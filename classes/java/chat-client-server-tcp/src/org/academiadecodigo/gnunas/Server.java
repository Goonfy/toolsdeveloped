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

    public static void main(String[] args) {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        clientSocket = serverSocket.accept();

        while (clientSocket.isBound()) {
            if (clientSocket.isClosed()) {
                break;
            }

            sendPacket(receivePacket());
        }

        Objects.requireNonNull(serverSocket).close();
    }

    private static byte[] receivePacket() throws IOException {
        byte[] receiveBuffer = new byte[1024];
        clientSocket.getInputStream().read(receiveBuffer);

        return receiveBuffer;
    }

    private static void sendPacket(byte[] message) throws IOException {
        clientSocket.getOutputStream().write(message);
    }
}
