package com.example.badminton2021be.badminton_backend_2021.enumuration;

public enum StatusMessages {
    ADDED_SUCCESSFULLY("Added successfully !"),
    CREATED_SUCCESSFULLY("Created successfully !"),
    SUCCESSFULLY_UPDATED("Successfully updated!"),
    SUCCESSFULLY_DELETED("Successfully deleted!"),
    SUCCESSFULLY_GET("Get all successfully"),
    PAYMENT_NOT_DONE("Payments not done"),
    SUCCESSFULLY_LOGIN("Successfully Logged in"),
    PLEASE_PROVIDE_REQUIRED_DATA("Please provide required data !"),
    ENTITY_ALREADY_EXIST_WITH_SAMENAME("Entity already exist with same name!"),
    ENTITY_ALREADY_EXIST_WITH_SAME_EMAIL("User already exist with same Email!"),
    INVALID_USER_PASSWORD("Invalid username and password!"),
    SAME_UNI_AND_HAS_ADMIN("You can\'t make an Admin account, Please make a User account instead!"),
    ENTRY_DOESNOT_EXIST("Entry doesn\'t exist");

    private String statusMessage;

    StatusMessages(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public static String getStatusValueByKey(int key) {

        for(RoomsStatus obj: RoomsStatus.values()) {
            if(obj.getStatusKey() == key) {
                return obj.getRoomsStatus();
            }
        }
        return null;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
