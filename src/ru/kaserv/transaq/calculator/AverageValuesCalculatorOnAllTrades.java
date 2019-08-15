/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.calculator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.storage.AllTradesStorage;

/**
 *
 * @author 1
 */
public class AverageValuesCalculatorOnAllTrades {
    
  
    private int interval = 4*60000;//millisec

    private Integer allQuantityOfPurchased = 0;                           
    private Integer allQuantitySold = 0;
    private BigDecimal allAmountSold = BigDecimal.ZERO;
    private BigDecimal allPurchasesAmount = BigDecimal.ZERO;
    private BigDecimal averageSoldPrice = BigDecimal.ZERO;
    private BigDecimal averageBuyingPrice = BigDecimal.ZERO;        
    private BigDecimal allAmountSellingAndBuying = BigDecimal.ZERO;
    private Integer sellingAndBuyingQuantityAll = 0; 
    private BigDecimal averageBuyingAndSellingPrice = BigDecimal.ZERO;  
        
        
    private AllTradesStorage allTradesStorage;
    
    public void calculateAveragePrice(){
              
        List<Alltrades.Trade> elements = allTradesStorage.getObservableList();

        if (elements.isEmpty() == true) return;

        Date startInterval = elements.get(elements.size()-1).getTime();              

 
            long finish = interval;
            long start = 0;
            long milliseconds=0;
 
            for (int i = elements.size()-1; i >= 0; i-- ){

                Alltrades.Trade el = elements.get(i);
                milliseconds = startInterval.getTime() - el.getTime().getTime();                

                if (milliseconds < finish){  
                    
                        if (el.getBuysell().equals("B")){
                           
                            allQuantityOfPurchased = allQuantityOfPurchased + el.getQuantity();
                            allPurchasesAmount = allPurchasesAmount.add(
                                                                            (el.getPrice().multiply(BigDecimal.valueOf(el.getQuantity())))
                                                                             );     
                            allAmountSellingAndBuying = BigDecimal.ZERO;                           
                       }
                    
                        if (el.getBuysell().equals("S")){                            
                           
                            allQuantitySold = allQuantitySold + el.getQuantity();
                            allAmountSold = allAmountSold.add(
                                                       (el.getPrice().multiply(BigDecimal.valueOf(el.getQuantity())))
                                                                             );
                            }                       
                      
                        sellingAndBuyingQuantityAll = sellingAndBuyingQuantityAll + el.getQuantity(); 
                        allAmountSellingAndBuying = allAmountSellingAndBuying.add(
                                                                            (el.getPrice().multiply(BigDecimal.valueOf(el.getQuantity())))
                                                                             );    
                }
                else
                {
                    
                break;    
                }
            }
            
            
        if (allQuantityOfPurchased != 0){
            averageBuyingPrice = allPurchasesAmount.divide(BigDecimal.valueOf(allQuantityOfPurchased),4,BigDecimal.ROUND_HALF_UP);      
        }    
        if (allQuantitySold !=0) {
            averageSoldPrice = allAmountSold.divide(BigDecimal.valueOf(allQuantitySold),4,BigDecimal.ROUND_HALF_UP);
        }             
        if(sellingAndBuyingQuantityAll !=0){
            averageBuyingAndSellingPrice = allAmountSellingAndBuying.divide(BigDecimal.valueOf(sellingAndBuyingQuantityAll),4,BigDecimal.ROUND_HALF_UP);
        }    
              
            
            
            
            
            
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Integer getAllQuantityOfPurchased() {
        return allQuantityOfPurchased;
    }

    public void setAllQuantityOfPurchased(Integer allQuantityOfPurchased) {
        this.allQuantityOfPurchased = allQuantityOfPurchased;
    }

    public Integer getAllQuantitySold() {
        return allQuantitySold;
    }

    public void setAllQuantitySold(Integer allQuantitySold) {
        this.allQuantitySold = allQuantitySold;
    }

    public BigDecimal getAllAmountSold() {
        return allAmountSold;
    }

    public void setAllAmountSold(BigDecimal allAmountSold) {
        this.allAmountSold = allAmountSold;
    }

    public BigDecimal getAllPurchasesAmount() {
        return allPurchasesAmount;
    }

    public void setAllPurchasesAmount(BigDecimal allPurchasesAmount) {
        this.allPurchasesAmount = allPurchasesAmount;
    }

    public BigDecimal getAverageSoldPrice() {
        return averageSoldPrice;
    }

    public void setAverageSoldPrice(BigDecimal averageSoldPrice) {
        this.averageSoldPrice = averageSoldPrice;
    }

    public BigDecimal getAverageBuyingPrice() {
        return averageBuyingPrice;
    }

    public void setAverageBuyingPrice(BigDecimal averageBuyingPrice) {
        this.averageBuyingPrice = averageBuyingPrice;
    }

    public BigDecimal getAllAmountSellingAndBuying() {
        return allAmountSellingAndBuying;
    }

    public void setAllAmountSellingAndBuying(BigDecimal allAmountSellingAndBuying) {
        this.allAmountSellingAndBuying = allAmountSellingAndBuying;
    }

    public Integer getSellingAndBuyingQuantityAll() {
        return sellingAndBuyingQuantityAll;
    }

    public void setSellingAndBuyingQuantityAll(Integer sellingAndBuyingQuantityAll) {
        this.sellingAndBuyingQuantityAll = sellingAndBuyingQuantityAll;
    }

    public BigDecimal getAverageBuyingAndSellingPrice() {
        return averageBuyingAndSellingPrice;
    }

    public void setAverageBuyingAndSellingPrice(BigDecimal averageBuyingAndSellingPrice) {
        this.averageBuyingAndSellingPrice = averageBuyingAndSellingPrice;
    }

    public AllTradesStorage getAllTradesStorage() {
        return allTradesStorage;
    }

    public void setAllTradesStorage(AllTradesStorage allTradesStorage) {
        this.allTradesStorage = allTradesStorage;
    }
    
    
    
    
}
