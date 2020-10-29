package org.academiadecodigo.gnunas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;

public class Client {
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 55000;

    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void client() throws IOException {
        clientSocket = new Socket(HOST_NAME, PORT_NUMBER);

        while (clientSocket.isBound()) {
            sendPacket(input());

            BufferedReader receivedData = receivePacket();
            System.out.println(receivedData.readLine());
        }

        Objects.requireNonNull(clientSocket).close();
    }

    private static byte[] input() throws IOException {
        byte[] sendBuffer = new byte[1024];

        System.in.read(sendBuffer);

        return sendBuffer;
    }

    private static BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private static void sendPacket(byte[] input) throws IOException {
        clientSocket.getOutputStream().write(input);
    }
}
