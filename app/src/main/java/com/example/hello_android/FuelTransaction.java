package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class FuelTransaction extends Transaction {
    private BigDecimal pricePerLitre;
    private int litres;

    public FuelTransaction(Date transactionDate, String location, BigDecimal totalCost, BigDecimal pricePerLitre, int litres){
        super(transactionDate, location, totalCost);
        this.pricePerLitre = pricePerLitre;
        this.litres = litres;

    }

}
