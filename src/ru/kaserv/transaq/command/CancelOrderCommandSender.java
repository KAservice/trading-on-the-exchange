/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import java.util.List;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.GlobalConfigSetting;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.OrdersStorage;
import transaq.TransaqConnector;

/**
 *
 * @author 1
 */
public class CancelOrderCommandSender {
    
    public boolean sendCommand(CancelOrderCommand command){
    boolean result = false;
    
 
        if (GlobalConfigSetting.testRegime == true){
        
            cancelTestOrder(command);
            return true;
        }
   
        TransaqConnector tr = TransaqConnector.getTransaqConnector();
        String response = "";
        response = tr.sendCommandToServer(command.getStringCommand());

    return result;    
    } 
    
    private void cancelTestOrder(CancelOrderCommand command){
        

        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders();    
        ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(command.getClientId());    
        SecurityForTradesOrders clientSecuritiesConfig = clientConfig.findClientSecurityConfig(command.getSeccode(), command.getBoard()); 
        OrdersStorage ordersStorage = clientSecuritiesConfig.getOrdersStorage();
        

        List<Orders.Order> elements = ordersStorage.getObservableList();                
/*        Iterator<Orders.Order> iterator =  elements.iterator();        
        while(iterator.hasNext()){
            Orders.Order el = iterator.next();
            
            if (el.getTransactionid() == command.getTransactionid()) {
                iterator.remove();                
            }
        }*/
        
        //Orders.Order el;
        elements.removeIf(el -> el.getTransactionid() == command.getTransactionid());
    }
    
}
