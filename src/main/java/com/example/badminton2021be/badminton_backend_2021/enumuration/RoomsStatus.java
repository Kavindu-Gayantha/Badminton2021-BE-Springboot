package com.example.badminton2021be.badminton_backend_2021.enumuration;

public enum RoomsStatus {
    ROOM_AVAILABLE(0, "Room is available!"),
    ROOM_BOOKED(1, "Room is now booked !");

    private String roomsStatus;
    private Integer roomStatusKey;

    RoomsStatus(int key, String status) {
        this.roomsStatus = status;
        this.roomStatusKey = key;

    }

    public String getRoomsStatus() {
        return roomsStatus;
    }

    public void setRoomsStatus(String roomsStatus) {
        this.roomsStatus = roomsStatus;
    }

    public Integer getStatusKey() {
        return roomStatusKey;
    }

    public void setStatusKey(Integer statusKey) {
        this.roomStatusKey = statusKey;
    }
}
