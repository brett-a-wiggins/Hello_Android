package com.example.hello_android;
import java.math.BigDecimal;
import java.util.Date;


abstract class Transaction {
    private Date transactionDate;
    private BigDecimal totalCost;


    public Transaction(Date transactionDate, BigDecimal totalCost){
        this.transactionDate = transactionDate;
        this.totalCost = totalCost;
    }
}
