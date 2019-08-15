/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.CandlekindsStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Candlekinds;
import ru.kaserv.transaq.storage.CandlekindsStorage;

/**
 *
 * @author 1
 */
public class CandlekindsHandler {
    
    public void AddCandlesInStorage(Candlekinds.Kind kind){
        
     //find client config
    CandlekindsStorageConfig storageConfig = StorageConfig.getStorageConfig().
                            getCandlekindsStorageConfig(); 
     
    CandlekindsStorage storage = storageConfig.getStorage(); 
    storage.add(kind);
    }
    
}
