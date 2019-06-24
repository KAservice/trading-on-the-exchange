/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;



import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Securities;

/**
 *
 * @author 1
 */
public class SecuritiesStorage {
    
    private ObservableList<Securities.Security> elements = FXCollections.observableArrayList();
    
    
    public void add(Securities.Security el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }
           
    public List<Securities.Security> getList(){
        
        
        
        return elements;
    }    
}
