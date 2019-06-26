/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.command.NewOrderCommand;


/**
 *
 * @author 1
 */
public class OrderToBrokerStorage {
    
    private ObservableList<NewOrderCommand> elements = FXCollections.observableArrayList();
    
    
    public void add(NewOrderCommand el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }
    
}
