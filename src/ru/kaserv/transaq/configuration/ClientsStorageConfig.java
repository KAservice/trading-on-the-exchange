/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.ClientsStorage;
import ru.kaserv.transaq.storage.SecuritiesStorage;

/**
 *
 * @author 1
 */
public class ClientsStorageConfig {
    
       private ClientsStorage clientsStorage;

    public ClientsStorageConfig() {
        
        clientsStorage = new ClientsStorage();
    }
    
    
    

    public ClientsStorage getClientsStorage() {
        return clientsStorage;
    }
       
   
    
}
