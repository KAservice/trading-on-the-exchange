/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.storage;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.object.Boards;
import ru.kaserv.transaq.object.Client;

/**
 *
 * @author 1
 */
public class BoardsStorage {
    
        private ObservableList<Boards.Board> elements = FXCollections.observableArrayList();
    
   // private ObservableList<SecurityOfClient> securityOfClientList = FXCollections.observableArrayList();
    
    
    public void add(Boards.Board el){
        
        elements.add(el);
        
    }
    
    public ObservableList getObservableList(){
        
        
        
        return elements;
    }

    public Collection<Boards.Board> getElements() {
        return elements;
    }
    
    
}
