/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.SecuritiesStorage;

/**
 *
 * @author 1
 */
public class SecuritiesStorageConfig {
    
    private SecuritiesStorage securitiesStorage;

    public SecuritiesStorageConfig() {
        
        
        securitiesStorage = new SecuritiesStorage();
    }

    public SecuritiesStorage getSecuritiesStorage() {
        return securitiesStorage;
    }
    
    
    
}
