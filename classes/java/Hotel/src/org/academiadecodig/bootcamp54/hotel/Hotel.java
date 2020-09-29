package org.academiadecodig.bootcamp54.hotel;

public class Hotel {
    private final Room[] rooms;

    public Hotel(int availableRooms) {
        rooms = new Room[availableRooms];

        generateRooms(availableRooms);
    }

    private void generateRooms(int availableRooms) {
        for (int i = 0; i < availableRooms; i++) {
            rooms[i] = new Room(i + 1);
        }
    }

    public void checkInRoom(Client client) {
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i].isOccupied()) {
                rooms[i].setOccupied(true);
                client.assignRoom(rooms[i]);

                System.out.println("Added " + client.getName() + " to room " + rooms[i].getRoomNumber() + ".");

                return;
            }

            System.out.println("Room " + rooms[i].getRoomNumber() + " occupied, trying another one.");
        }

        System.out.println("Sorry no rooms left.");
    }

    public void checkOutRoom(Client client) {
        for (int i = 0; i < rooms.length; i++) {
            if (client.getAttributedRoomNumber() == rooms[i].getRoomNumber()) {
                rooms[i].setOccupied(false);
                client.removeRoom();

                System.out.println("Checkout complete, " + client.getName() + " thank you for your stay.");

                return;
            }
        }

        System.out.println("Client is not hosted on our hotel.");
    }
}
