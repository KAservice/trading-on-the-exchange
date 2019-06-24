/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.SecuritiesStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.SecuritiesStorage;

/**
 *
 * @author 1
 */
public class SecuritiesHandler {
    
    
    public void AddSecurityInStorage(Securities.Security security){
        

    StorageConfig storageConfig = StorageConfig.getStorageConfig();
    
    SecuritiesStorageConfig securityStorageConfig = storageConfig.getSecuritiesConfig();
    SecuritiesStorage securitiesStrorage = securityStorageConfig.getSecuritiesStorage();
    securitiesStrorage.add(security);
        
    }
    
}
