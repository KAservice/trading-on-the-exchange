/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.CandlekindsStorage;
import ru.kaserv.transaq.storage.ClientsStorage;

/**
 *
 * @author 1
 */
public class CandlekindsStorageConfig {
    
        
    private CandlekindsStorage storage;

    public CandlekindsStorageConfig() {
        
        storage = new CandlekindsStorage();
    
    }
    

    public CandlekindsStorage getStorage() {
        return storage;
    }
    
}
