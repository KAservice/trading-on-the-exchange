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
public class SecurityForAllTrades {
    
    private AllTradesStorage allTradesStorage ;
    private Securities.Security security;
    

    

    public SecurityForAllTrades(Securities.Security security) {
        
        this.security = security;
        allTradesStorage = new AllTradesStorage();
        
      }

    public AllTradesStorage getAllTradesStorage() {
        return allTradesStorage;
    }

    public Securities.Security getSecurity() {
        return security;
    }
    
    
    
    
}
