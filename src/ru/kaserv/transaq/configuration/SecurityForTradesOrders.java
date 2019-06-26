/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.OrderToBrokerStorage;
import ru.kaserv.transaq.storage.OrderToExchangeStorage;
import ru.kaserv.transaq.storage.OrdersStorage;
import ru.kaserv.transaq.storage.TradesStorage;

/**
 *
 * @author 1
 */
public class SecurityForTradesOrders {

    Securities.Security security;   
    
    
    private TradesStorage tradesStorage; //reference to the table of trades
    private OrdersStorage ordersStorage; //reference to the table of orders
    private OrderToBrokerStorage orderToBrokerStorage;
    private OrderToExchangeStorage orderToExchangeStorage;

    public SecurityForTradesOrders(Securities.Security security) {
        this.security = security;

        tradesStorage = new TradesStorage();
        ordersStorage = new OrdersStorage();
        orderToBrokerStorage = new OrderToBrokerStorage();
        orderToExchangeStorage = new OrderToExchangeStorage();
    }

    public TradesStorage getTradesStorage() {
        return tradesStorage;
    }

    public OrdersStorage getOrdersStorage() {
        return ordersStorage;
    }

    public Securities.Security getSecurity() {
        return security;
    }

    public OrderToBrokerStorage getOrderToBrokerStorage() {
        return orderToBrokerStorage;
    }

    public OrderToExchangeStorage getOrderToExchangeStorage() {
        return orderToExchangeStorage;
    }



  

    
    
    
}
