package com.example.hello_android;


import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Vehicle {
    private String registration;
    private int startOdometer;
    private int odometer;
    private ArrayList<FuelTransaction> fuelTransList;
    private ArrayList<ServiceTransaction> serviceTransList;

    public Vehicle (String registration, int startOdometer) {
        this.registration = registration;
        this.startOdometer = startOdometer;
        this.odometer = 0;
        this.fuelTransList = new ArrayList<>();
        this.serviceTransList = new ArrayList<>();
    }

    public String getRegistration(){
        return this.registration;
    }

    public String toString() {
        return this.registration;
    }

    public String addFuelTransaction(String location, double totalCost, double pricePerLitre, double litres, int odometer){
        getFuelTransList().add(new FuelTransaction(location, totalCost, pricePerLitre, litres, odometer));
        this.odometer = this.odometer + odometer;
        return "Fuel Transaction added";
    }

    public String addServiceTransaction(Date transactionDate, Date nextServiceDate, double partCost, double laborCost, int nextServiceOdo){
        getServiceTransList().add(new ServiceTransaction(transactionDate, nextServiceDate, partCost, laborCost, nextServiceOdo));
        return "Service Transaction added";
    }

    public ArrayList getFuelTransList(){
        return this.fuelTransList;
    }

    public ArrayList getServiceTransList() {
        return this.serviceTransList;
    }

    public void setNewOdometer(int odometer) {
        int remaining = odometer - this.odometer;
        this.odometer += remaining;
    }

    public int getOdometer() {
        return this.odometer;
    }

    public int getStartOdometer() {
        return this.startOdometer;
    }



}
