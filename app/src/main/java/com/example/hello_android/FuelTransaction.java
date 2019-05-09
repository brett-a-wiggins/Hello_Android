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

    public String getFuelTransactionString(){
        this.transaction = "Location: " + this.location + ", Date: " + this.transactionDate + ", P.p.Litre: $" + this.pricePerLitre + ", Litres: " + this.litres + ", Odometer: " + this.odometer + ", Cost: $" + this.fuelTotal + ", Total Cost: $" + this.totalCost;
        return transaction;
    }

}
