package com.example.badminton2021be.badminton_backend_2021.enumuration;

public enum UserRoles {
    ADMIN("Admin", 1),
    USER("Admin not", 2);

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
