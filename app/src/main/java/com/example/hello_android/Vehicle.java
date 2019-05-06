package com.example.hello_android;


import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Vehicle implements Parcelable {
    private String registration;

    //private Date serviceDate; Shouldnt this be in service transaction inherited from transaction?
    private int odometer;
    private ArrayList<FuelTransaction> fuelTransList;
    private ArrayList<ServiceTransaction> serviceTransList;

    public Vehicle (String registration) {
        this.registration = registration;
        this.odometer = 0;
        this.fuelTransList = new ArrayList<>();
        this.serviceTransList = new ArrayList<>();
    }

    public Vehicle() {

    }

    private Vehicle(Parcel in) {
        this.registration = in.readString();
        this.odometer = in.readInt();
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(registration);
        out.writeInt(odometer);
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getRegistration(){
        return this.registration;
    }


    public String toString() {
        return this.registration;
    }

    private String addFuelTransaction(Date transactionDate, String location, BigDecimal costPerLitre, BigDecimal totalCost, double litresPumped){
        fuelTransList.add(new FuelTransaction(transactionDate, totalCost, costPerLitre, litresPumped));
        return "Fuel Transaction added";
    }

    private String addServiceTransaction(Date transactionDate, BigDecimal partCost, BigDecimal laborCost, BigDecimal totalCost){
        serviceTransList.add(new ServiceTransaction(transactionDate, partCost, laborCost, totalCost));
        return "Service Transaction added";
    }

    private ArrayList getFuelTransList(){
        return this.fuelTransList;
    }

    private ArrayList getServiceTransList() {
        return this.serviceTransList;
    }

}
