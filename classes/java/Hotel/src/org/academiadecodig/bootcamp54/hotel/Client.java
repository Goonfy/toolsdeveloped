package org.academiadecodig.bootcamp54.hotel;

public class Client {
    private final Hotel hotel;
    private final String name;
    private Room room;

    public Client(Hotel hotel, String name) {
        this.hotel = hotel;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void checkIn() {
        if (room == null) {
            hotel.checkInRoom(this);

            return;
        }

        System.out.println("You're already in room " + room.getRoomNumber() + ".");
    }

    public void checkOut() {
        if (room != null) {
            hotel.checkOutRoom(this);

            return;
        }

        System.out.println("You're not in a room, please check in.");
    }

    public void assignRoom(Room room) {
        this.room = room;
    }

    public void removeRoom() {
        this.room = null;
    }

    public int getAttributedRoomNumber() {
        if (room != null) {
            return room.getRoomNumber();
        }

        return 0;
    }
}
