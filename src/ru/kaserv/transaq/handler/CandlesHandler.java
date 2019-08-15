/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import ru.kaserv.transaq.calculator.BolingerCalculatorForCandles;
import ru.kaserv.transaq.calculator.SpeedCalculatorForCandles;
import ru.kaserv.transaq.configuration.GlobalConfigSetting;
import ru.kaserv.transaq.configuration.SecurityForCandles;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Candles;
import ru.kaserv.transaq.storage.CandlesStorage;

/**
 *
 * @author 1
 */
public class CandlesHandler {
    
    public void AddCandlesInStorage(Candles candles){
        
     //find client config
    SecurityForCandles candlesStorageConfig = StorageConfig.getStorageConfig().
                            getSecuritiesForCandles().
                            findCandlesStorageConfigBySecurity(candles.getSeccode(),candles.getBoard()); 
     
    CandlesStorage candlesStorage1 = candlesStorageConfig.getCandlesStrorage1(); 
    CandlesStorage candlesStorage2 = candlesStorageConfig.getCandlesStrorage2();
    CandlesStorage candlesStorage3 = candlesStorageConfig.getCandlesStrorage3();
    
    if (candles.getPeriod() == candlesStorage1.getPeriod()){        
        for (Candles.Candle el : candles.getCandle()){        
            candlesStorage1.add(el);
            Calculate1(candlesStorage1,el);
        }      
    }
    
    if (candles.getPeriod() == candlesStorage2.getPeriod()){        
        for (Candles.Candle el : candles.getCandle()){        
            candlesStorage2.add(el);
            Calculate2(candlesStorage1,el);
            
        }      
    }   

    if (candles.getPeriod() == candlesStorage3.getPeriod()){        
        for (Candles.Candle el : candles.getCandle()){        
            candlesStorage3.add(el);
            Calculate3(candlesStorage1,el);
        }      
    }
    //System.out.println("Добавили запись в таблицу alltrades: " +trade.getTime());  

    }
    
    
    void Calculate1(CandlesStorage candlesStorage, Candles.Candle el){

        BolingerCalculatorForCandles bc =new BolingerCalculatorForCandles();
        bc.setCandlesStorage(candlesStorage);
        bc.setCountCandle(GlobalConfigSetting.candleCountForCalculateBoligerLine1);
        bc.calculateAveragePrice();
        bc.calculateStandartDeviation();
        
        el.setbAveragePrice(bc.getAveragePrice());
        el.setbDeviationPrice(bc.getStandardDeviation());
        el.setbMaxPrice(el.getbAveragePrice().add(el.getbDeviationPrice()));
        el.setbMaxPrice(el.getbAveragePrice().subtract(el.getbDeviationPrice()));
        
        SpeedCalculatorForCandles sc = new SpeedCalculatorForCandles();
        sc.setCandlesStorage(candlesStorage);
        sc.calculateSpeedPrice();
        el.setPriceChangeSpeed(sc.getSpeedPrice());
    }
    
    void Calculate2(CandlesStorage candlesStorage, Candles.Candle el){

        BolingerCalculatorForCandles bc =new BolingerCalculatorForCandles();
        bc.setCandlesStorage(candlesStorage);
        bc.setCountCandle(GlobalConfigSetting.candleCountForCalculateBoligerLine2);
        bc.calculateAveragePrice();
        bc.calculateStandartDeviation();
        
        el.setbAveragePrice(bc.getAveragePrice());
        el.setbDeviationPrice(bc.getStandardDeviation());
        el.setbMaxPrice(el.getbAveragePrice().add(el.getbDeviationPrice()));
        el.setbMaxPrice(el.getbAveragePrice().subtract(el.getbDeviationPrice()));
        
        SpeedCalculatorForCandles sc = new SpeedCalculatorForCandles();
        sc.setCandlesStorage(candlesStorage);
        sc.calculateSpeedPrice();
        el.setPriceChangeSpeed(sc.getSpeedPrice());
    }
        
    void Calculate3(CandlesStorage candlesStorage, Candles.Candle el){

        BolingerCalculatorForCandles bc =new BolingerCalculatorForCandles();
        bc.setCandlesStorage(candlesStorage);
        bc.setCountCandle(GlobalConfigSetting.candleCountForCalculateBoligerLine3);
        bc.calculateAveragePrice();
        bc.calculateStandartDeviation();
        
        el.setbAveragePrice(bc.getAveragePrice());
        el.setbDeviationPrice(bc.getStandardDeviation());
        el.setbMaxPrice(el.getbAveragePrice().add(el.getbDeviationPrice()));
        el.setbMaxPrice(el.getbAveragePrice().subtract(el.getbDeviationPrice()));
        
        SpeedCalculatorForCandles sc = new SpeedCalculatorForCandles();
        sc.setCandlesStorage(candlesStorage);
        sc.calculateSpeedPrice();
        el.setPriceChangeSpeed(sc.getSpeedPrice());
    }
    
}
