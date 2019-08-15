/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.calculator;

import java.math.BigDecimal;
import java.util.List;
import ru.kaserv.transaq.object.Candles;
import ru.kaserv.transaq.storage.CandlesStorage;

/**
 *
 * @author 1
 */
public class BolingerCalculatorForCandles {
    

    private int countCandle = 4;
        
    private BigDecimal averagePrice = BigDecimal.ZERO;
    private BigDecimal standardDeviation = BigDecimal.ZERO;
    private CandlesStorage candlesStorage;
    
    public void calculateAveragePrice(){
        
        averagePrice = BigDecimal.ZERO;        
        List<Candles.Candle> elements = candlesStorage.getObservableList();

        if (elements.isEmpty() == true) return;       

        for (int i = elements.size()-1; (i >= 0) && (elements.size()-i <= countCandle); i-- ){
            
            Candles.Candle el = elements.get(i);
            averagePrice = averagePrice.add(el.getClose()); 
        }
  
    averagePrice = averagePrice.divide(BigDecimal.valueOf(countCandle),3,BigDecimal.ROUND_HALF_UP);  
    }
    
    public void calculateStandartDeviation(){
        
        standardDeviation = BigDecimal.ZERO;
       
        List<Candles.Candle> elements = candlesStorage.getObservableList();

        if (elements.isEmpty() == true) return;       

        for (int i = elements.size()-1; (i >= 0) && (elements.size()-i <= countCandle); i-- ){
            
            Candles.Candle el = elements.get(i);
            averagePrice = averagePrice.add(el.getClose()); 
            
            BigDecimal a = el.getClose().subtract(averagePrice);  
            BigDecimal b = a.multiply(a);
        
            standardDeviation = standardDeviation.add(b); 
        }
 
    standardDeviation = TransaqMath.bigSqrt(standardDeviation);   
    }
    


    public void setCandlesStorage(CandlesStorage candlesStorage) {
        this.candlesStorage = candlesStorage;
    }


    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public BigDecimal getStandardDeviation() {
        return standardDeviation;
    }

    public int getCountCandle() {
        return countCandle;
    }

    public void setCountCandle(int countCandle) {
        this.countCandle = countCandle;
    }
    
    
}
