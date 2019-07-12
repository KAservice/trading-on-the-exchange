/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.util.ArrayList;
import java.util.Collection;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.SecuritiesStorage;

/**
 *
 * @author 1
 */
public class SecuritiesForQuotes {
    
    private Collection<SecurityForQuotes> securityConfigCollection = new ArrayList<>();
    
    
    public SecurityForQuotes findQuotesStorageConfigByQuotes(String seccode, String board){
        SecurityForQuotes result = null;
    
    
        for(SecurityForQuotes el : securityConfigCollection){
            if (el.getSecurity().getSeccode().equals(seccode) == true
                            && el.getSecurity().getBoard().equals(board) == true)
            {
                result = el;                
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
            
            
            SecurityForQuotes newQuotesStorageConfig = new  SecurityForQuotes(security);
            
            result = newQuotesStorageConfig;
            securityConfigCollection.add(result);
            }    
    
    
    return result;
    }
    
    
    public Collection<SecurityForQuotes> getElements() {
        return securityConfigCollection;
    }
    
}
