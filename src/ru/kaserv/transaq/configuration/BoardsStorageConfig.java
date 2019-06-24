/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.storage.BoardsStorage;
import ru.kaserv.transaq.storage.ClientsStorage;

/**
 *
 * @author 1
 */
public class BoardsStorageConfig {
    
    private BoardsStorage boardsStorage;

    public BoardsStorageConfig() {
        
        boardsStorage = new BoardsStorage();
    }
    
    
    

    public BoardsStorage getBoardsStorage() {
        return boardsStorage;
    }
}
