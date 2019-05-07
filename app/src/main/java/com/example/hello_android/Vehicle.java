package com.example.hello_android;


import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Vehicle {
    private String registration;
    private int odometer;
    private ArrayList<FuelTransaction> fuelTransList;
    private ArrayList<ServiceTransaction> serviceTransList;

    public Vehicle (String registration) {
        this.registration = registration;
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
