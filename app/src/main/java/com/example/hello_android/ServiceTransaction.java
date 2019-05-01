package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceTransaction extends Transaction {
    private BigDecimal partCost;
    private BigDecimal laborCost;

    public ServiceTransaction(Date transactionDate, BigDecimal partCost, BigDecimal laborCost, BigDecimal totalCost) {
        super(transactionDate, totalCost);
        this.partCost = partCost;
        this.laborCost = laborCost;
    }
}
