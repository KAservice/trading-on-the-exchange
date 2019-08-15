/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.GlobalConfigSetting;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.handler.OrdersHandler;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.OrdersStorage;
import transaq.TransaqConnector;

/**
 *
 * @author 1
 */
public class NewOrderCommandSender {
    
    private long transactionId;
    
    
    
public boolean sendCommand(NewOrderCommand command){
    boolean result = false;
    
    
    if (GlobalConfigSetting.testRegime == true){
        
        sendTestOrder(command);
        return true;
    }
    
        
        TransaqConnector tr = TransaqConnector.getTransaqConnector();
        
        XmlCommandFactory xcf = new XmlCommandFactory(); 
 
        String command_xml = xcf.convertObjectNewOrderCommandToXml(command);
        System.out.println(command_xml); 
        byte[] b2=command_xml.getBytes();
        byte[] resultCommand;  
        resultCommand = tr.SendCommand(b2);
        //resultCommand = "<result success=\"true\" transactionid=\"12345\"/>".getBytes();
        String responce = "";
        long transaction_id = 0;

        if (resultCommand != null){
            if (resultCommand.length != 0){
                responce = new String (resultCommand);    //<result success="true" transactionid="id"/>
                int index_tr_id = responce.lastIndexOf("transactionid");
                String tr_id="";
                if(index_tr_id != 0){
                    for(int i=index_tr_id+15; i<responce.length();i++){

                        char symbol = responce.charAt(i);

                        if (symbol == '"'){
                            break;    
                            }
                        tr_id = tr_id + symbol;
                        
                    }                    
                transaction_id = Long.parseLong(tr_id);
                transactionId = transaction_id;
                }                
            }
        }
            
        if (transaction_id != 0 ){
            
            result = true;  
            
        }
        else{
            result = false;
        }    
    
    return result;    
    }    

    public long getTransactionId() {
        return transactionId;
    }


    private void sendTestOrder(NewOrderCommand command){
        
        
        
        
        Orders orders = new Orders();
        Orders.Order order = new Orders.Order();
        orders.getOrder().add(order);
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 
    
        ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(command.getClient());    
        SecurityForTradesOrders clientSecuritiesConfig = clientConfig.findClientSecurityConfig(command.getSecurity().getSeccode(), command.getSecurity().getBoard());
    
  
        OrdersStorage ordersStorage = clientSecuritiesConfig.getOrdersStorage();
        
        order.setTransactionid(ordersStorage.getObservableList().size() + 10);
        order.setClient(GlobalConfigSetting.client);
        order.setBoard(command.getSecurity().getBoard());
        order.setSeccode(command.getSecurity().getSeccode());
        order.setPrice(command.getPrice());
        order.setQuantity(command.getQuantity());
        order.setBuysell(command.getBuysell());
        
        OrdersHandler orderHandlers = new OrdersHandler();
        orderHandlers.AddOrderInStorage(order);
        
    }

}
