package com.example.hello_android;

import java.util.ArrayList;

public class VehicleOwner {
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;
    private static ArrayList<Vehicle> vehicleList;

    public VehicleOwner(String newName,String newAddress, String newPhone,
                            String newEmail){
        ownerName = newName;
        ownerAddress = newAddress;
        ownerPhone = newPhone;
        ownerEmail = newEmail;
        vehicleList = new ArrayList<>();
    }

    public VehicleOwner(){
        ownerName = null;
        ownerAddress = null;
        ownerPhone = null;
        ownerEmail = null;
    }
    public static ArrayList getVehicleList() { return vehicleList; }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
