/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.PortfolioTplus;

/**
 *
 * @author 1
 */
public class PortfolioTplusStorage {
    
       private ObservableList<PortfolioTplus> elements = FXCollections.observableArrayList();//по клиентам
    
  
    
    
    public void add(PortfolioTplus el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public Collection<PortfolioTplus> getElements() {
        return elements;
    }
    
public PortfolioTplus findPortfolioTplus(String clientId){
    PortfolioTplus result = null;
    
    
        for(PortfolioTplus el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }
        
        
        if (result == null) {
            
            result = new PortfolioTplus();
            result.setClient(clientId);
            this.add(result);

        }    
    
    
    return result;
    }   

public PortfolioTplus getPortfolioTplusByIdClient(String clientId){
    PortfolioTplus result = null;
    
    
        for(PortfolioTplus el: elements){
            if (el.getClient().equals(clientId) == true)
            {
                result = el;                
            }    
        }

    return result;
    } 
    
    
}
