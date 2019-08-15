/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.robot;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import ru.kaserv.transaq.command.CancelOrderCommand;
import ru.kaserv.transaq.command.CancelOrderCommandSender;
import ru.kaserv.transaq.command.NewOrderCommand;
import ru.kaserv.transaq.command.NewOrderCommandSender;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.SecurityForAllTrades;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.AllTradesStorage;
import ru.kaserv.transaq.storage.OrderToExchangeStorage;

/**
 *
 * @author 1
 */
public class RobotKalikin {
 
    public String seccode = "";
    public String board = "";
    public String clientId ="";
    
    
    private BigDecimal priceBuy = BigDecimal.ZERO;
    private BigDecimal priceSell = BigDecimal.ZERO;
    
    public void run(){
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 

        ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(clientId);    
        SecurityForTradesOrders clientSecuritiesConfig = clientConfig.findClientSecurityConfig(seccode, board);


        OrderToExchangeStorage ordersStorage = clientSecuritiesConfig.getOrderToExchangeStorage();
        List<Orders.Order> orders = ordersStorage.getObservableList();
        List<Orders.Order> ordersCopy = null; 



        SecurityForAllTrades allTradesStorageConfig = StorageConfig.getStorageConfig().
                                getSecuritiesForAllTrades().
                                findAllTradesStorageConfigByAllTrade(seccode,board); 

        AllTradesStorage allTradesStorage = allTradesStorageConfig.getAllTradesStorage();

        List<Alltrades.Trade> alltrades = allTradesStorage.getObservableList();

        if (alltrades.size() < 20) return;

        getBuySellPrice(alltrades);
    
        //удаляем не нужные заявки
        Iterator<Orders.Order> iterator =  ordersCopy.iterator();        
        while(iterator.hasNext()){
            Orders.Order el = iterator.next();
            
            if (el.getBuysell().equals("B") && el.getPrice().compareTo(priceBuy) != 0) {
                createCancelOrder(el.getTransactionid());              
            }
            
            if (el.getBuysell().equals("S") && el.getPrice().compareTo(priceSell) != 0) {
                createCancelOrder(el.getTransactionid());              
            }
        }
    
        //проверяем есть ли нужные
        iterator =  ordersCopy.iterator();
        boolean okBuy = false;   
        boolean okSell = false;  
        while(iterator.hasNext()){
            Orders.Order el = iterator.next();
            
            if (el.getBuysell().equals("B") && el.getPrice().compareTo(priceBuy) == 0) {
                okBuy = true;              
            }
            
            if (el.getBuysell().equals("S") && el.getPrice().compareTo(priceSell) == 0) {
                okSell = true;            
            }
        }
    
        if (okBuy == false){
            createNewBuyOrder();
        }
        
        if (okSell == false){
            createNewSellOrder();
        }
    }
    
    
    private void getBuySellPrice(List<Alltrades.Trade> alltrades){
        
        Alltrades.Trade tradeLast = alltrades.get(alltrades.size()-1);
        
        if (tradeLast.getAllQuantityOfPurchased() > tradeLast.getAllQuantitySold()){
            priceBuy = tradeLast.getPrice();
            priceSell = tradeLast.getPrice().subtract(BigDecimal.valueOf(0.01));            
        }

        if (tradeLast.getAllQuantityOfPurchased() < tradeLast.getAllQuantitySold()){
            priceBuy = tradeLast.getPrice().subtract(BigDecimal.valueOf(0.01));
            priceSell = tradeLast.getPrice();            
        }
        
        if (tradeLast.getAllQuantityOfPurchased() == tradeLast.getAllQuantitySold()){
            priceBuy = tradeLast.getPrice().subtract(BigDecimal.valueOf(0.01));
            priceSell = tradeLast.getPrice().add(BigDecimal.valueOf(0.01));            
        }
    } 
    
    private void createCancelOrder(int transactionId){
     
        Orders.Order order = new Orders.Order();
        order.setClient(clientId);
        order.setBoard(board);
        order.setSeccode(seccode);
        order.setTransactionid(transactionId);
     
        CancelOrderCommand command =  new CancelOrderCommand();
        command.setTransactionid(transactionId);
        command.setClientId(clientId);
        command.setBoard(board);
        command.setSeccode(seccode);

        CancelOrderCommandSender sender = new CancelOrderCommandSender();
        sender.sendCommand(command); 
    } 
    
    private void createNewBuyOrder(){

        NewOrderCommand newOrderCommand = new NewOrderCommand();

        newOrderCommand.setBuysell("B");
        newOrderCommand.setUnfilled("PutInQueue");
        newOrderCommand.setClient(clientId);
      //  newOrderCommand.setUnion(client.getUnion());
        newOrderCommand.getSecurity().setBoard(board);
        newOrderCommand.getSecurity().setSeccode(seccode);
        newOrderCommand.setPrice(priceBuy);
        newOrderCommand.setQuantity(1);
        
        NewOrderCommandSender sender = new NewOrderCommandSender();
        
        sender.sendCommand(newOrderCommand);

    }   
    
    private void createNewSellOrder(){

        NewOrderCommand newOrderCommand = new NewOrderCommand();

        newOrderCommand.setBuysell("S");
        newOrderCommand.setUnfilled("PutInQueue");
        newOrderCommand.setClient(clientId);
      //  newOrderCommand.setUnion(client.getUnion());
        newOrderCommand.getSecurity().setBoard(board);
        newOrderCommand.getSecurity().setSeccode(seccode);
        newOrderCommand.setPrice(priceBuy);
        newOrderCommand.setQuantity(1);
        
        NewOrderCommandSender sender = new NewOrderCommandSender();
        
        sender.sendCommand(newOrderCommand);

    } 
}
