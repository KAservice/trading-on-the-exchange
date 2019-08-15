/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.object.Candles;

/**
 *
 * @author 1
 */
public class CandlesStorage {
    
    private int period;
    private int count;
            
    private ObservableList<Candles.Candle> elements = FXCollections.observableArrayList();
    

    public void add(Candles.Candle el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
