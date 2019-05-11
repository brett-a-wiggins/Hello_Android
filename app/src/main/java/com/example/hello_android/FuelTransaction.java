package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

class FuelTransaction extends Transaction {

    private double pricePerLitre;
    private double litres;
    private int odometer;
    private double totalCost;
    private String location;
    private Date transactionDate;
    private String transaction;
    private double fuelTotal;

    public FuelTransaction(String location, double totalCost, double pricePerLitre, double litres, int odometer){
        super(location, totalCost);
        this.pricePerLitre = pricePerLitre;
        this.litres = litres;
        this.location = location;
        this.totalCost = totalCost;
        this.odometer = odometer;
        this.transactionDate = Calendar.getInstance().getTime();
        this.fuelTotal = this.pricePerLitre * this.litres;


    }

    public double getPricePerLitre() {
        return pricePerLitre;
    }

    public void setPricePerLitre(double pricePerLitre) {
        this.pricePerLitre = pricePerLitre;
    }

    public double getLitres() {
        return litres;
    }

    public void setLitres(double litres) {
        this.litres = litres;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

//    public String getTransaction() {
//        return transaction;
//    }
//
//    public void setTransaction(String transaction) {
//        this.transaction = transaction;
//    }

    public double getFuelTotal() {
        return fuelTotal;
    }

    public void setFuelTotal(double fuelTotal) {
        this.fuelTotal = fuelTotal;
    }

    public String getFuelTransactionString(){
        this.transaction = "Location: " + this.location + ", Date: " + this.transactionDate + ", P.p.Litre: $" + this.pricePerLitre + ", Litres: " + this.litres + ", Odometer: " + this.odometer + ", Cost: $" + this.fuelTotal + ", Total Cost: $" + this.totalCost;
        return transaction;
    }


}
