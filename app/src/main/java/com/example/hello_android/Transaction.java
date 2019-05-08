package com.example.hello_android;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


abstract class Transaction {
    private Date transactionDate;
    private String location;
    private double totalCost;

    public Transaction( String location, double totalCost) {
        this.transactionDate = Calendar.getInstance().getTime();
        this.location = location;
        this.totalCost = totalCost;
    }


    public Transaction(Date transactionDate, double totalCost){
        this.transactionDate = transactionDate;
        this.totalCost = totalCost;
    }
}
