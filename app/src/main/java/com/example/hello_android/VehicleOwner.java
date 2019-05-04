package com.example.hello_android;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class VehicleOwner implements Parcelable {
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;
    protected ArrayList<Vehicle> vehicleList;

    public VehicleOwner(String newName,String newAddress, String newPhone,
                            String newEmail){
        ownerName = newName;
        ownerAddress = newAddress;
        ownerPhone = newPhone;
        ownerEmail = newEmail;
        vehicleList = new ArrayList<>();
    }

    public VehicleOwner(String newName) {
        this.ownerName = newName;
        this.ownerAddress = null;
        this.ownerEmail = null;
        this.ownerPhone = null;
    }

    public VehicleOwner(){
        ownerName = null;
        ownerAddress = null;
        ownerPhone = null;
        ownerEmail = null;
    }

    protected VehicleOwner(Parcel in) {
        ownerName = in.readString();
//        ownerAddress = in.readString();
//        ownerPhone = in.readString();
//        ownerEmail = in.readString();
    }

    public static final Creator<VehicleOwner> CREATOR = new Creator<VehicleOwner>() {
        @Override
        public VehicleOwner createFromParcel(Parcel in) {
            return new VehicleOwner(in);
        }

        @Override
        public VehicleOwner[] newArray(int size) {
            return new VehicleOwner[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v(TAG, "writeToParcel..." + flags);
        dest.writeString(ownerName);


    }


    @Override
    public String toString() {
        return this.ownerName;
    }

    public ArrayList getVehicleList() { return this.vehicleList; }

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
