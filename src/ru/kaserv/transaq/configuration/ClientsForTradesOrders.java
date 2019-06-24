/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.util.ArrayList;
import java.util.Collection;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.storage.ClientsStorage;

/**
 *
 * @author 1
 */
public class ClientsForTradesOrders {
    
    private Collection<ClientForTradesOrders> elements = new ArrayList<>();
    
    private ClientsStorage clientsStorage = StorageConfig.getStorageConfig().getClientsStorageConfig().getClientsStorage();  //here collection Client


    
    
    public ClientForTradesOrders findClientConfig(String id_client){
        ClientForTradesOrders result = null;
        
        for(ClientForTradesOrders cl_config : elements){
            if (cl_config.getClient().getId().equals(id_client) == true)
            {
                result = cl_config;                
            }    
        }
       
        if (result == null){            
            
            //find client
            Client client = null;
            Collection<Client> clients = clientsStorage.getObservableList();
            
            for(Client  cl : clients){
                if (cl.getId().equals(id_client) == true)
                {
                    client = cl;                
                } 
            }  
            
            if (client == null){                
                client = new Client();
                client.setId(id_client);
                clients.add(client);
            }
            
            result = new ClientForTradesOrders(client);
            elements.add(result);
        
        }      
        
    return result;    
    }

    public Collection<ClientForTradesOrders> getElements() {
        return elements;
    }
    
    

    
}
