/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.PortfolioUnitedStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.PortfolioUnited;
import ru.kaserv.transaq.storage.PortfolioUnitedStorage;

/**
 *
 * @author 1
 */
public class PortfolioUnitedHandler {
    
    
       public void AddPortfolioTplusInStorage(PortfolioUnited element){

        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        PortfolioUnitedStorageConfig elementStorageConfig = storageConfig.getPortfolioUnitedStorageConfig();
        
        PortfolioUnitedStorage storage = elementStorageConfig.getPortfolioUnitedStorage();
        
        PortfolioUnited el = storage.findPortfolioUnited(element.getClient());
        
        el = element;
   
    }
    
}
