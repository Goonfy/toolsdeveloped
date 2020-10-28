package org.academiadecodigo.gnunas;

import java.io.IOException;
import java.net.*;
import java.util.Objects;

public class Server {
    private static final int PORT_NUMBER = 55000;

    private static DatagramSocket socket;

    public static void main(String[] args) {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void server() throws IOException {
        socket = new DatagramSocket(PORT_NUMBER);

        while (socket.isBound()) {
            DatagramPacket receivePacket = receivePacket();

            sendPacket(receivePacket);

            System.out.println(convertToUppercase(new String(receivePacket.getData())));
        }

        Objects.requireNonNull(socket).close();
    }

    private static DatagramPacket receivePacket() throws IOException {
        byte[] recvBuffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);

        return receivePacket;
    }

    private static void sendPacket(DatagramPacket receivePacket) throws IOException {
        byte[] sendBuffer = convertToUppercase(new String(receivePacket.getData())).getBytes();

        receivePacket.setData(sendBuffer);
        socket.send(receivePacket);
    }

    private static String convertToUppercase(String word) {
        return word.toUpperCase();
    }
}
