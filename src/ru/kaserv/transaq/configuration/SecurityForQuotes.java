/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.QuotesStorage;

/**
 *
 * @author 1
 */
public class SecurityForQuotes {
    
    private QuotesStorage quotesStorage ;
    private Securities.Security security;
    

    public SecurityForQuotes(Securities.Security security) {
        
        this.security = security;
        quotesStorage = new QuotesStorage();
    }

    public QuotesStorage getQuotesStorage() {
        return quotesStorage;
    }

    public Securities.Security getSecurity() {
        return security;
    }
    
    
}
