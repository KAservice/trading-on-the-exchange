/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.PortfolioTplusStorage;

/**
 *
 * @author 1
 */
public class PortfolioTplusStorageConfig {
    
    private PortfolioTplusStorage portfolioTplusStorage;

    public PortfolioTplusStorageConfig() {
        
        portfolioTplusStorage = new PortfolioTplusStorage();
    }
    
    
    

    public PortfolioTplusStorage getPortfolioTplusStorage() {
        return portfolioTplusStorage;
    }
    
    
    
}
