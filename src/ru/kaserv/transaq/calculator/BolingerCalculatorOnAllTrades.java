/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.storage.AllTradesStorage;

/**
 *
 * @author 1
 */
public class BolingerCalculatorOnAllTrades {
    
    private int interval = 60000;//millisec
    private int countInterval = 4;
        
    private BigDecimal averagePrice = BigDecimal.ZERO;
    private BigDecimal standardDeviation = BigDecimal.ZERO;
    private AllTradesStorage allTradesStorage;
    
    public void calculateAveragePrice(){
        
        averagePrice = BigDecimal.ZERO;
        
        List<Alltrades.Trade> elements = allTradesStorage.getObservableList();
        
        
        if (elements.isEmpty() == true) return;
        
        
        Date initialDate = elements.get(elements.size()-1).getTime();
        Date startInterval = initialDate;                
        

        int currentInterval = 1;//это удаление от конца
        
       
        BigDecimal closePrice = BigDecimal.ZERO;
        
        closePrice = elements.get(elements.size()-1).getPrice();
    
                                            
        
        while(currentInterval <= countInterval){
            
            long finish = currentInterval * interval;
            long start = (currentInterval - 1) * interval;
            long milliseconds=0;
            
            
            for (int i = elements.size()-1; i >= 0; i-- ){
                Alltrades.Trade el = elements.get(i);

                milliseconds = startInterval.getTime() - el.getTime().getTime();                
                
                if (milliseconds > finish){//пропущены ли интервалы, возможно какое-то время цена не менялась 
                    break;                    
                }

                if (milliseconds >= start && milliseconds < finish){                    
                    closePrice = el.getPrice();
                    break;
                }        
            }
            
        averagePrice = averagePrice.add(closePrice); 
        currentInterval++;
        }
      
        
    averagePrice = averagePrice.divide(BigDecimal.valueOf(countInterval),3,BigDecimal.ROUND_HALF_UP);
        
    }
    
    public void calculateStandartDeviation(){
        
        standardDeviation = BigDecimal.ZERO;
        
        List<Alltrades.Trade> elements = allTradesStorage.getObservableList();
        
        
        if (elements.isEmpty() == true) return;
        
        
        Date initialDate = elements.get(elements.size()-1).getTime();
        Date startInterval = initialDate;                
        

        int currentInterval = 1;//это удаление от конца
        
       
        BigDecimal closePrice = BigDecimal.ZERO;
        
        closePrice = elements.get(elements.size()-1).getPrice();
    
                                            
                                            
        while(currentInterval <= countInterval){
            
            long finish = currentInterval * interval;
            long start = (currentInterval - 1) * interval;
            long milliseconds=0;
            
            
            for (int i = elements.size()-1; i >= 0; i-- ){
                Alltrades.Trade el = elements.get(i);

                milliseconds = startInterval.getTime() - el.getTime().getTime();                
                
                if (milliseconds > finish){//пропущены ли интервалы, возможно какое-то время цена не менялась 
                    break;                    
                }

                if (milliseconds >= start && milliseconds < finish){                    
                    closePrice = el.getPrice();
                    break;
                }        
            }
        
        BigDecimal a = closePrice.subtract(averagePrice);  
        BigDecimal b = a.multiply(a);
        
        standardDeviation = standardDeviation.add(b); 
        currentInterval++;
        }
      
        
    standardDeviation = TransaqMath.bigSqrt(standardDeviation);
        
    }
    
    


    public void setAllTradesStorage(AllTradesStorage allTradesStorage) {
        this.allTradesStorage = allTradesStorage;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public BigDecimal getStandardDeviation() {
        return standardDeviation;
    }
    
    
    
}
