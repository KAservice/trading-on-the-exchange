/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;


import ru.kaserv.transaq.storage.PortfolioUnitedStorage;

/**
 *
 * @author 1
 */
public class PortfolioUnitedStorageConfig {
    
    
    private PortfolioUnitedStorage portfolioUnitedStorage;

    public PortfolioUnitedStorageConfig() {
        
        portfolioUnitedStorage = new PortfolioUnitedStorage();
    }
    
    
    

    public PortfolioUnitedStorage getPortfolioUnitedStorage() {
        return portfolioUnitedStorage;
    }
    
}
