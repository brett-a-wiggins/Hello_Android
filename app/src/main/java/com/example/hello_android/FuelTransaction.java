package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class FuelTransaction extends Transaction {
    private BigDecimal costPerLitre;
    private double litresPumped;

    public FuelTransaction(Date transactionDate, BigDecimal totalCost, BigDecimal costPerLitre, double litresPumped) {
        super(transactionDate, totalCost);
        this.costPerLitre = costPerLitre;
        this.litresPumped = litresPumped;
    }

}
