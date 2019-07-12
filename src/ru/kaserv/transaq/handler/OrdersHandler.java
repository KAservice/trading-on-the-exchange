/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import java.util.Collection;
import java.util.List;
import ru.kaserv.transaq.command.NewOrderCommand;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.SecuritiesForQuotes;
import ru.kaserv.transaq.configuration.SecurityForQuotes;

import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.OrderToBrokerStorage;
import ru.kaserv.transaq.storage.OrderToExchangeStorage;
import ru.kaserv.transaq.storage.OrdersStorage;
import ru.kaserv.transaq.storage.QuotesStorage;

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
    
    
        OrderToBrokerStorage orderToBrokerStorage = clientSecuritiesConfig.getOrderToBrokerStorage();
        List<NewOrderCommand> elements = orderToBrokerStorage.getObservableList();
        
        for(int i = 0; i < elements.size(); i++){
            NewOrderCommand command = elements.get(i);
            if (command.getTransactionid() == (long) order.getTransactionid()){
                elements.remove(i);
                break;
            }
        }
        
        OrderToExchangeStorage orderToExchangeStorage = clientSecuritiesConfig.getOrderToExchangeStorage();
        orderToExchangeStorage.add(order);
        
        
        AddOrderInQuotes(order);
        
    }
    
    public void AddOrderInQuotes(Orders.Order  order){
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        SecuritiesForQuotes securitiesForQuotes = storageConfig.getSecuritiesForQuotes(); 
        
        if (securitiesForQuotes == null) return;
        
        SecurityForQuotes securityForQuotes = securitiesForQuotes.findQuotesStorageConfigByQuotes(order.getSeccode(), order.getBoard());
        
        if (securityForQuotes == null) return;
        
        QuotesStorage quotesStorage = securityForQuotes.getQuotesStorage();
        
         if (quotesStorage == null) return;
         
        quotesStorage.addMyOrder(order);
                
    }
    
}
