package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

class FuelTransaction extends Transaction {

    private BigDecimal pricePerLitre;
    private double litres;

    public FuelTransaction(Date transactionDate, BigDecimal totalCost, BigDecimal pricePerLitre, double litres){
        super(transactionDate, totalCost);
        this.pricePerLitre = pricePerLitre;
        this.litres = litres;


    }

}
