package com.example.ss01;

public class Bai7 {
    private String fullName;
    private String className;
    private String vehicleType;
    private String plateNumber;

    public Bai7(String fullName, String className, String vehicleType, String plateNumber) {
        this.fullName = fullName;
        this.className = className;
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getClassName() {
        return className;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
