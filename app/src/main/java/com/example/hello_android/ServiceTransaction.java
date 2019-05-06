package com.example.hello_android;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceTransaction extends Transaction {

   private BigDecimal laborCost;
   private BigDecimal partCost;

   public ServiceTransaction(Date transactionDate, BigDecimal totalCost, BigDecimal laborCost, BigDecimal partCost) {
       super(transactionDate, totalCost);
       this.laborCost = laborCost;
       this.partCost = partCost;
   }

}
