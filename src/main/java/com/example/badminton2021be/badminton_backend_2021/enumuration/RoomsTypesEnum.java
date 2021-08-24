package com.example.badminton2021be.badminton_backend_2021.enumuration;

public enum RoomsTypesEnum {
    LUXURY_DOUBLE("luxury", 1),
    LUXURY_SINGLE("luxurySingle", 2),
    SEMI_LUXURY_DOUBLE("semiLuxury", 3),
    SEMI_LUXURY_SINGLE("semiLuxurySingle", 4),
    NORMAL_DOUBLE("normal", 5),
    NORMAL_SINGLE("normalSingle", 6);

    private String roomType;

    private Integer typeKey;

    RoomsTypesEnum(String roomType, Integer typeKey){
        this.setRoomType(roomType);
        this.setTypeKey(typeKey);
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(Integer typeKey) {
        this.typeKey = typeKey;
    }
}
