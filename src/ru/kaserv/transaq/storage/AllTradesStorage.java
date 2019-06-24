/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.object.Orders;

/**
 *
 * @author 1
 */
public class AllTradesStorage {
    
    private ObservableList<Alltrades.Trade> elements = FXCollections.observableArrayList();
    
    
    public void add(Alltrades.Trade el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }
    
    
}
