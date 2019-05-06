package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

class FuelTransaction extends Transaction {

    private BigDecimal pricePerLitre;
    private double litres;

    public FuelTransaction(Date transactionDate, String location, BigDecimal totalCost, BigDecimal pricePerLitre, double litres){
        super(transactionDate, location, totalCost);
        this.pricePerLitre = pricePerLitre;
        this.litres = litres;


    }

}
