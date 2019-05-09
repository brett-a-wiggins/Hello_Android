package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceTransaction extends Transaction {

   private double laborCost;
   private double totalCost;
   private double partCost;
   private int nextServiceOdo;
   private Date serviceDate;
   private Date nextServiceDate;
   private String transaction;

   public ServiceTransaction(Date transactionDate, Date nextServiceDate, double laborCost, double partCost, int nextServiceOdo) {
       super(transactionDate, (laborCost + partCost));
       this.laborCost = laborCost;
       this.partCost = partCost;
       this.serviceDate = transactionDate;
       this.totalCost = this.laborCost + this.partCost;
       this.nextServiceOdo = nextServiceOdo;
       this.nextServiceDate = nextServiceDate;
   }

    public String getServiceTransactionString(){
        this.transaction = "Service Date: " + this.serviceDate + ", Next Date: " + this.nextServiceDate + ", Labor Cost: $" + this.laborCost + ", Part Cost: " + this.partCost + ", Next Service Odometer: " + this.nextServiceOdo +  ", Total Cost: $" + (this.laborCost + this.partCost);
        return transaction;
    }

}
