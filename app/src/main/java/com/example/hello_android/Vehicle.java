package com.example.hello_android;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

abstract class Vehicle {
    private VehicleOwner owner;
    private String registration;
    //private Date serviceDate; Shouldnt this be in service transaction inherited from transaction?
    protected int odometer;
    private ArrayList<FuelTransaction> fuelTransList;
    private ArrayList<ServiceTransaction> serviceTransList;

    public Vehicle (VehicleOwner owner, String registration) {
        this.owner = owner;
        this.registration = registration;
        this.odometer = 0;
        this.fuelTransList = new ArrayList<>();
        this.serviceTransList = new ArrayList<>();
    }

    private String addFuelTransaction(Date transactionDate, BigDecimal costPerLitre, BigDecimal totalCost, double litresPumped){
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
