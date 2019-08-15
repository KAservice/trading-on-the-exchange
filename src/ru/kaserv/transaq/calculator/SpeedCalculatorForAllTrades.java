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
public class SpeedCalculatorForAllTrades {
     
    private int interval = 1000;//millisec
    private AllTradesStorage allTradesStorage;

    private BigDecimal speedPriceBuy = BigDecimal.ZERO;     
    private BigDecimal speedPriceSell = BigDecimal.ZERO;    

    public void calculateSpeedPrice(){
              
        List<Alltrades.Trade> elements = allTradesStorage.getObservableList();

        if (elements.isEmpty() == true) return;

        Date startInterval = elements.get(elements.size()-1).getTime(); 
        
        BigDecimal startPriceBuy = BigDecimal.ZERO;  
        BigDecimal startPriceSell = BigDecimal.ZERO;  
        
        BigDecimal endPriceBuy = BigDecimal.ZERO;  
        BigDecimal endPriceSell = BigDecimal.ZERO;  

            long finish = interval;
            long milliseconds=0;
            boolean firstBuy = true;
            boolean firstSell = true;
 
            for (int i = elements.size()-1; i >= 0; i-- ){

                Alltrades.Trade el = elements.get(i);
                milliseconds = startInterval.getTime() - el.getTime().getTime();                

                if (milliseconds < finish){  

                        if (el.getBuysell().equals("B")){
                            
                            if (firstBuy == true){                                
                                startPriceBuy = el.getPrice();
                                endPriceBuy = el.getPrice();
                                firstBuy = false;
                            }
                            else{
                                endPriceBuy = el.getPrice();  
                            } 
                        }
                    
                        if (el.getBuysell().equals("S")){

                            if (firstSell == true){                                
                                startPriceSell = el.getPrice();
                                endPriceSell = el.getPrice(); 
                                firstSell = false;
                            }
                            else{
                                endPriceSell = el.getPrice();  
                            }                             
                        }                          
                }
                else
                {
                    
                break;    
                }
            }
            
    speedPriceSell = endPriceSell.subtract(startPriceSell);
    speedPriceBuy = endPriceBuy.subtract(startPriceBuy);
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setAllTradesStorage(AllTradesStorage allTradesStorage) {
        this.allTradesStorage = allTradesStorage;
    }

    public BigDecimal getSpeedPriceBuy() {
        return speedPriceBuy;
    }

    public BigDecimal getSpeedPriceSell() {
        return speedPriceSell;
    }
    
    

    
}
