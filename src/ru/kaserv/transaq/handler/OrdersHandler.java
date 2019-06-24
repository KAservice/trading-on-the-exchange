/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;

import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.OrdersStorage;

/**
 *
 * @author 1
 */
public class OrdersHandler {
    
    public void AddOrderInStorage(Orders.Order order){
        
     //find client config
    StorageConfig storageConfig = StorageConfig.getStorageConfig();
    ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 
    
    ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(order.getClient());    
    SecurityForTradesOrders clientSecuritiesConfig = clientConfig.findClientSecurityConfig(order.getSeccode(), order.getBoard());
    
  
    OrdersStorage ordersStorage = clientSecuritiesConfig.getOrdersStorage();
    
    ordersStorage.add(order);
    System.out.println("Добавили запись в таблицу заявок: " +order.getTime()); 
        
    }
    
}
