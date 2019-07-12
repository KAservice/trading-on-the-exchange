/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.object.Quotes;

/**
 *
 * @author 1
 */
public class QuotesStorage {
           private ObservableList<Quotes.Quote> elements = FXCollections.observableArrayList();
    
    
    public void add(Quotes.Quote el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){

        return elements;
    }
    
    public void addMyOrder(Orders.Order  order){

        for (Quotes.Quote el : elements){
 
                if (el.getPrice().compareTo(order.getPrice()) == 0){
                    el.setMyQuantityOrder(el.getMyQuantityOrder() + order.getQuantity());
                }   

            if (order.getBuysell().equals("B")){
                
            }
                        
            if (order.getBuysell().equals("S")){
                
            }            

        }   
    }
    
}
