/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.AllTradesStorage;
import ru.kaserv.transaq.storage.CandlesStorage;

/**
 *
 * @author 1
 */
public class SecurityForCandles {
    
    private Securities.Security security;
    
    private CandlesStorage candlesStrorage1;
    private CandlesStorage candlesStrorage2;
    private CandlesStorage candlesStrorage3;
    

    public SecurityForCandles(Securities.Security security) {
        
        this.security = security;

        
        candlesStrorage1 = new CandlesStorage();
        candlesStrorage1.setPeriod(1);
        candlesStrorage2 = new CandlesStorage();
        candlesStrorage2.setPeriod(2);
        candlesStrorage3 = new CandlesStorage();
        candlesStrorage3.setPeriod(3);
    }

    public CandlesStorage getCandlesStrorage1() {
        return candlesStrorage1;
    }

    public CandlesStorage getCandlesStrorage2() {
        return candlesStrorage2;
    }

    public CandlesStorage getCandlesStrorage3() {
        return candlesStrorage3;
    }

    public Securities.Security getSecurity() {
        return security;
    }


    
    
}
