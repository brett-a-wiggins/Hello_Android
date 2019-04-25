package com.example.hello_android;

public class VehicleOwner {
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;

    public VehicleOwner(String newName,String newAddress, String newPhone,
                            String newEmail){
        ownerName = newName;
        ownerAddress = newAddress;
        ownerPhone = newPhone;
        ownerEmail = newEmail;
    }

    public VehicleOwner(){
        ownerName = null;
        ownerAddress = null;
        ownerPhone = null;
        ownerEmail = null;
    }

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
