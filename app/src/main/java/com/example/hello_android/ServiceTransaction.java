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

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
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
