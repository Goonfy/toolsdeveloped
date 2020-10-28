package org.academiadecodigo.gnunas;

import java.io.IOException;
import java.net.*;
import java.util.Objects;

public class Client {
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 55000;

    private static DatagramSocket socket;

    public static void main(String[] args) {
        try {
            client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void client() throws IOException {
        socket = new DatagramSocket();

        while (socket.isBound()) {
            sendPacket(input());

            DatagramPacket receivedData = receivePacket();
            System.out.println(new String(receivedData.getData()));
        }

        Objects.requireNonNull(socket).close();
    }

    private static byte[] input() throws IOException {
        byte[] sendBuffer = new byte[1024];

        int i = System.in.read(sendBuffer);

        return sendBuffer;
    }

    private static void sendPacket(byte[] input) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(input,
                input.length, InetAddress.getByName(HOST_NAME), PORT_NUMBER);
        socket.send(sendPacket);
    }

    private static DatagramPacket receivePacket() throws IOException {
        byte[] recvBuffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);

        return receivePacket;
    }
}
