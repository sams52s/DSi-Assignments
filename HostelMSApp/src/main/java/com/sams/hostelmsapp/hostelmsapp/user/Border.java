package com.sams.hostelmsapp.hostelmsapp.user;

public class Border {
    private final Integer borderId;
    private final String borderName;

    public Border(Integer borderId, String borderName) {
        this.borderId = borderId;
        this.borderName = borderName;
    }

    public Integer getBorderId() {
        return borderId;
    }

    public String getBorderName() {
        return borderName;
    }

    @Override
    public String toString() {
        return "Border{" +
                "borderId=" + borderId +
                ", borderName='" + borderName + '\'' +
                '}';
    }
}
