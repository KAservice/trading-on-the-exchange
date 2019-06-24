/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.util.ArrayList;
import java.util.Collection;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.SecuritiesStorage;

/**
 *
 * @author 1
 */
public class ClientForTradesOrders {
    

   
    private Collection<SecurityForTradesOrders> securitiesForTradesOrders = new ArrayList<>();
    private Client client;

    public ClientForTradesOrders(Client client) {
        this.client = client;
    }
    
 
   
public SecurityForTradesOrders findClientSecurityConfig(String seccode, String board){
    SecurityForTradesOrders result = null;
    
    
        for(SecurityForTradesOrders cl_sec_config : securitiesForTradesOrders){
            if (cl_sec_config.getSecurity().getSeccode().equals(seccode) == true
                            && cl_sec_config.getSecurity().getBoard().equals(board) == true)
            {
                result = cl_sec_config;                
            }    
        }
        
        
        if (result == null) {
            SecuritiesStorageConfig  securitiesStorageConfig = StorageConfig.getStorageConfig().getSecuritiesConfig();            
            SecuritiesStorage securitiesStorage = securitiesStorageConfig.getSecuritiesStorage();
            
            Securities.Security security = null;
            Collection<Securities.Security> securities = securitiesStorage.getList();
            
            for(Securities.Security  sec : securities){
                if (sec.getSeccode().equals(seccode) == true
                                    && sec.getBoard().equals(board) == true)
                {
                    security = sec;                
                } 
            }  
            
            if (security == null){                
                security = new Securities.Security();
                security.setSeccode(seccode);
                security.setBoard(board);
                securities.add(security);
            }
            
            
            SecurityForTradesOrders newClientSecurityConfig = new  SecurityForTradesOrders(security);
            
            result = newClientSecurityConfig;
            securitiesForTradesOrders.add(result);
        }    
    
    
    return result;
    }

    public Client getClient() {
        return client;
    }

    public Collection<SecurityForTradesOrders> getSecuritiesForTradesOrders() {
        return securitiesForTradesOrders;
    }

 
    




}
