package com.example.hello_android;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceTransaction extends Transaction {

   private double laborCost;
   private double totalCost;
   private double partCost;
   private int nextServiceOdo;
   private String serviceDate;
   private String nextServiceDate;
   private String transaction;
   private SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yy");

   public ServiceTransaction(Date transactionDate, Date nextServiceDate, double laborCost, double partCost, int nextServiceOdo) {
       super(transactionDate, (laborCost + partCost));
       this.laborCost = laborCost;
       this.partCost = partCost;
       this.serviceDate = format1.format(transactionDate);
       this.totalCost = this.laborCost + this.partCost;
       this.nextServiceOdo = nextServiceOdo;
       this.nextServiceDate = format1.format(nextServiceDate);
   }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getPartCost() {
        return partCost;
    }

    public void setPartCost(double partCost) {
        this.partCost = partCost;
    }

    public int getNextServiceOdo() {
        return nextServiceOdo;
    }

    public void setNextServiceOdo(int nextServiceOdo) {
        this.nextServiceOdo = nextServiceOdo;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = format1.format(serviceDate);
    }

    public String getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = format1.format(nextServiceDate);
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getServiceTransactionString(){
        this.transaction = "Service Date: " + this.serviceDate + ", Next Date: " + this.nextServiceDate + ", Labor Cost: $" + this.laborCost + ", Part Cost: " + this.partCost + ", Next Service Odometer: " + this.nextServiceOdo +  ", Total Cost: $" + (this.laborCost + this.partCost);
        return transaction;
    }

}
