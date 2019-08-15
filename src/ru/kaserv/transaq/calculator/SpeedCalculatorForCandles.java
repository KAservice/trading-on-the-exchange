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
import ru.kaserv.transaq.object.Candles;
import ru.kaserv.transaq.storage.CandlesStorage;

/**
 *
 * @author 1
 */
public class SpeedCalculatorForCandles {
    
    private CandlesStorage candlesStorage;
    private BigDecimal speedPrice = BigDecimal.ZERO;     

    public void calculateSpeedPrice(){
              
        List<Candles.Candle> elements = candlesStorage.getObservableList();

        if (elements.size() < 2) return;
        
        speedPrice = elements.get(elements.size()-1).getClose().subtract(
                                elements.get(elements.size()-2).getClose());
                
    }

    public CandlesStorage getCandlesStorage() {
        return candlesStorage;
    }

    public void setCandlesStorage(CandlesStorage candlesStorage) {
        this.candlesStorage = candlesStorage;
    }

    public BigDecimal getSpeedPrice() {
        return speedPrice;
    }

    public void setSpeedPrice(BigDecimal speedPrice) {
        this.speedPrice = speedPrice;
    }
    
    

    
}
