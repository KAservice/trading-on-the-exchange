/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.ClientLimits;


/**
 *
 * @author 1
 */
public class ClientLimitsStorage {
           private ObservableList<ClientLimits> elements = FXCollections.observableArrayList();//по клиентам
    
  
    
    
    public void add(ClientLimits el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public Collection<ClientLimits> getElements() {
        return elements;
    }
    
public ClientLimits findClientLimits(String clientId){
    ClientLimits result = null;
    
    
        for(ClientLimits el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }
        
        
        if (result == null) {
            
            result = new ClientLimits();
            result.setClient(clientId);
            this.add(result);

        }    
    
    
    return result;
    }   

public ClientLimits getClientLimitsByIdClient(String clientId){
    ClientLimits result = null;
    
    
        for(ClientLimits el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }

    return result;
    } 
    
    
}
