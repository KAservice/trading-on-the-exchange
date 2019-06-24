/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Trades;

/**
 * one security only
 * @author 1
 */
public class TradesStorage {
    
    private ObservableList<Trades.Trade> elements = FXCollections.observableArrayList();
    
    
    public void add(Trades.Trade el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }
    
}
