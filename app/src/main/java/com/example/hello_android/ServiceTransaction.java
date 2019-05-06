package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceTransaction extends Transaction {

   private BigDecimal laborCost;
   private BigDecimal partCost;
   private Date nextServiceDate;
   private int nextServiceOdo;

   public ServiceTransaction(Date transactionDate, String location, BigDecimal totalCost, BigDecimal laborCost, BigDecimal partCost, Date nextServiceDate, int nextServiceOdo) {
       super(transactionDate, location, totalCost);
       this.laborCost = laborCost;
       this.partCost = partCost;
       this.nextServiceDate = nextServiceDate;
       this.nextServiceOdo = nextServiceOdo;
   }

}
