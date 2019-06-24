/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Client;

/**
 *
 * @author 1
 */
public class ClientsStorage {
    
    private ObservableList<Client> elements = FXCollections.observableArrayList();
    
   // private ObservableList<SecurityOfClient> securityOfClientList = FXCollections.observableArrayList();
    
    
    public void add(Client el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public Collection<Client> getElements() {
        return elements;
    }
    
    

}


