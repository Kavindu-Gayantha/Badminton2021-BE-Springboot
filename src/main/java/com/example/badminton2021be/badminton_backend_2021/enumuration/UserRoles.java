package com.example.badminton2021be.badminton_backend_2021.enumuration;

public enum UserRoles {
    ADMIN("admin", 1),
    CUSTOMER("customer", 2),
    KITCHEN_ADMIN("kitchenadmin", 3),
    SUPER_ADMIN("superAdmin", 4);

    private String userRole;

    private Integer userKey;

    UserRoles(String userRole,Integer userKey){
        this.setUserRole(userRole);
        this.setUserKey(userKey);
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserKey() {
        return userKey;
    }

    public void setUserKey(Integer userKey) {
        this.userKey = userKey;
    }
}
