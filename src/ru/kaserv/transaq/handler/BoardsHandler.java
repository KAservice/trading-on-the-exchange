/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import ru.kaserv.transaq.configuration.BoardsStorageConfig;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Boards;
import ru.kaserv.transaq.storage.BoardsStorage;

/**
 *
 * @author 1
 */
public class BoardsHandler {
    
    public void AddBoardInStorage(Boards.Board element){
        

    StorageConfig storageConfig = StorageConfig.getStorageConfig();    
    BoardsStorageConfig boardsStorageConfig = storageConfig.getBoardsConfig();
    BoardsStorage boardsStrorage = boardsStorageConfig.getBoardsStorage();
    boardsStrorage.add(element);
        
    }
    
}
