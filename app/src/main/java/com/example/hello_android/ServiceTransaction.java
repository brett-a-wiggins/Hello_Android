package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceTransaction extends Transaction {

   private double laborCost;
   private double partCost;

   public ServiceTransaction(Date transactionDate, double totalCost, double laborCost, double partCost) {
       super(transactionDate, totalCost);
       this.laborCost = laborCost;
       this.partCost = partCost;
   }

}
