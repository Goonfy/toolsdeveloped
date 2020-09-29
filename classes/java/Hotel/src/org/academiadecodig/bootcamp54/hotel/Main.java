package org.academiadecodig.bootcamp54.hotel;

public class Main {
    public static void main(String[] args) {
        Client[] clients = new Client[5];

        Hotel hotel = new Hotel(10);

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client(hotel, "Client " + i);
            clients[i].checkIn();
        }

        for (Client client : clients) {
            client.checkOut();
        }
    }
}
