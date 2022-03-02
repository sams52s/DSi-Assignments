package com.sams.hostelmsapp.hostelmsapp.model;

public enum UserPermission {
    BORDER_READ("user:read"),
    BORDER_WRITE("user:write"),
    MEAL_READ("meal:read"),
    MEAL_WRITE("meal:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
