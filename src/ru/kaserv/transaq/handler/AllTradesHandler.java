/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import ru.kaserv.transaq.configuration.SecurityForAllTrades;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.storage.AllTradesStorage;

/**
 *
 * @author 1
 */
public class AllTradesHandler {
    
    public void AddAllTradeInStorage(Alltrades.Trade trade){
        
     //find client config
    SecurityForAllTrades allTradesStorageConfig = StorageConfig.getStorageConfig().
                            getSecuritiesForAllTrades().
                            findAllTradesStorageConfigByAllTrade(trade.getSeccode(),trade.getBoard()); 
     
    AllTradesStorage allTradesStorage = allTradesStorageConfig.getAllTradesStorage();
    
    allTradesStorage.add(trade);
    //System.out.println("Добавили запись в таблицу alltrades: " +trade.getTime());         
    }
    
}
