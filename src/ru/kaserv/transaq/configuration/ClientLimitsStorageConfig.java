/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.ClientLimitsStorage;


/**
 *
 * @author 1
 */
public class ClientLimitsStorageConfig {
    
        private ClientLimitsStorage storage;

    public ClientLimitsStorageConfig() {
        
        storage = new ClientLimitsStorage();
    }
    
    
    

    public ClientLimitsStorage getClientLimitsStorage() {
        return storage;
    }
    
    
}
