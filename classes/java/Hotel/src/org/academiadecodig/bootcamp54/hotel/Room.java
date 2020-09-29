package org.academiadecodig.bootcamp54.hotel;

public class Room {
    private boolean isOccupied;
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
