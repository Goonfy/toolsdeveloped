package org.academiadecodigo.gnunas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;

public class Client {
    private final String HOST_NAME = "localhost";
    private final int PORT_NUMBER = 55000;

    private Socket clientSocket;

    public void init() {
        try {
            clientSocket = new Socket(HOST_NAME, PORT_NUMBER);
            client();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            Objects.requireNonNull(clientSocket).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void client() throws IOException {
        while (true) {
            byte[] inputMessage = input();
            sendPacket(inputMessage);

            BufferedReader receivedData = receivePacket();
            String receivedMessage = receivedData.readLine();
            System.out.println(receivedMessage);

            if (receivedMessage.contains("/quit")) {
                return;
            }
        }
    }

    private byte[] input() throws IOException {
        byte[] sendBuffer = new byte[1024];

        System.in.read(sendBuffer);

        return sendBuffer;
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(byte[] input) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(new String(input));
    }
}
