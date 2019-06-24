/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.ClientsStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.storage.ClientsStorage;

/**
 *
 * @author 1
 */
public class ClientsHandler {
    
    public void AddClientInStorage(Client client){
        

    StorageConfig storageConfig = StorageConfig.getStorageConfig();    
    ClientsStorageConfig clientsStorageConfig = storageConfig.getClientsStorageConfig();
    ClientsStorage clientsStrorage = clientsStorageConfig.getClientsStorage();
    clientsStrorage.add(client);
        
    }
    
}
