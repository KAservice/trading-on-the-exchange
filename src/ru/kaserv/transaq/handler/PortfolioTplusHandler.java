/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.PortfolioTplusStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.PortfolioTplus;
import ru.kaserv.transaq.storage.PortfolioTplusStorage;

/**
 *
 * @author 1
 */
public class PortfolioTplusHandler {
    
    public void AddPortfolioTplusInStorage(PortfolioTplus element){

        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        PortfolioTplusStorageConfig elementStorageConfig = storageConfig.getPortfolioTplusStorageConfig();
        
        PortfolioTplusStorage storage = elementStorageConfig.getPortfolioTplusStorage();
        
        PortfolioTplus el = storage.findPortfolioTplus(element.getClient());
        
        el = element;
   
    }
    
}
