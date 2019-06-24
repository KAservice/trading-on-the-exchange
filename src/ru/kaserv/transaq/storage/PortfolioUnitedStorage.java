/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.PortfolioUnited;

/**
 *
 * @author 1
 */
public class PortfolioUnitedStorage {
        
       private ObservableList<PortfolioUnited> elements = FXCollections.observableArrayList();//по клиентам
    
  
    
    
    public void add(PortfolioUnited el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public Collection<PortfolioUnited> getElements() {
        return elements;
    }
    
public PortfolioUnited findPortfolioUnited(String clientId){
    PortfolioUnited result = null;
    
    
        for(PortfolioUnited el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }
        
        
        if (result == null) {
            
            result = new PortfolioUnited();
            result.setClient(clientId);
            this.add(result);

        }    
    
    
    return result;
    }   

public PortfolioUnited getPortfolioUnitedByIdClient(String clientId){
    PortfolioUnited result = null;
    
    
        for(PortfolioUnited el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }

    return result;
    } 
    
}
