/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Orders;

/**
 *
 * @author 1
 */
public class OrdersStorage {
    
       private ObservableList<Orders.Order> elements = FXCollections.observableArrayList();
    
    
    public void add(Orders.Order el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }
    
}
