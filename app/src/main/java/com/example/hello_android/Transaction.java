package com.example.hello_android;
import java.math.BigDecimal;
import java.util.Date;

abstract class Transaction {
    private Date transactionDate;
    private String location;
    private BigDecimal totalCost;

    public Transaction(Date transactionDate, String location, BigDecimal totalCost) {
        this.transactionDate = transactionDate;
        this.location = location;
        this.totalCost = totalCost;
    }

}
