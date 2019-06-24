/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.ClientLimitsStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.ClientLimits;
import ru.kaserv.transaq.storage.ClientLimitsStorage;

/**
 *
 * @author 1
 */
public class ClientLimitsHandler {
    
    public void AddClientLimitsInStorage(ClientLimits element){

        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        ClientLimitsStorageConfig elementStorageConfig = storageConfig.getClientLimitsStorageConfig();
        
        ClientLimitsStorage storage = elementStorageConfig.getClientLimitsStorage();
        
        ClientLimits el = storage.findClientLimits(element.getClient());
        
        el = element;
   
    }
    
}
