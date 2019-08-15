/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import ru.kaserv.transaq.calculator.AverageValuesCalculatorOnAllTrades;
import ru.kaserv.transaq.calculator.BolingerCalculatorOnAllTrades;
import ru.kaserv.transaq.calculator.SpeedCalculatorForAllTrades;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.GlobalConfigSetting;
import ru.kaserv.transaq.configuration.SecurityForAllTrades;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.object.Trades;
import ru.kaserv.transaq.storage.AllTradesStorage;
import ru.kaserv.transaq.storage.OrdersStorage;

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
    
        
    BolingerCalculatorOnAllTrades bc = new BolingerCalculatorOnAllTrades();
    bc.setAllTradesStorage(allTradesStorage);
    bc.calculateAveragePrice();
    bc.calculateStandartDeviation();
    
    trade.setAveragePrice(bc.getAveragePrice());
    trade.setStandardDeviation(bc.getStandardDeviation());
    trade.setMinPrice(trade.getAveragePrice().subtract(trade.getStandardDeviation()));
    trade.setMaxPrice(trade.getAveragePrice().add(trade.getStandardDeviation()));
    
    
    
    AverageValuesCalculatorOnAllTrades ac = new AverageValuesCalculatorOnAllTrades();
    ac.setAllTradesStorage(allTradesStorage);
    ac.calculateAveragePrice();
    
    trade.setAllQuantityOfPurchased(ac.getAllQuantityOfPurchased());                           
    trade.setAllQuantitySold(ac.getAllQuantitySold()); 
    trade.setAllAmountSold(ac.getAllAmountSold()); 
    trade.setAllPurchasesAmount(ac.getAllPurchasesAmount()); 
    trade.setAverageSoldPrice(ac.getAverageSoldPrice()); 
    trade.setAverageBuyingPrice(ac.getAverageBuyingPrice());       
    trade.setAllAmountSellingAndBuying(ac.getAllAmountSellingAndBuying()); 
    trade.setSellingAndBuyingQuantityAll(ac.getSellingAndBuyingQuantityAll()); 
    trade.setAverageBuyingAndSellingPrice(ac.getAverageBuyingAndSellingPrice());
    
    
    
    SpeedCalculatorForAllTrades sc = new SpeedCalculatorForAllTrades();    
    sc.setAllTradesStorage(allTradesStorage);

    sc.setInterval(1000);
    sc.calculateSpeedPrice();   
    trade.setTheRateOfChangeOfPricesBuy1(sc.getSpeedPriceBuy());    
    trade.setTheRateOfChangeOfPricesSell1(sc.getSpeedPriceSell());
    
    sc.setInterval(5000);
    sc.calculateSpeedPrice();   
    trade.setTheRateOfChangeOfPricesBuy2(sc.getSpeedPriceBuy());    
    trade.setTheRateOfChangeOfPricesSell2(sc.getSpeedPriceSell());
   
    sc.setInterval(10000);
    sc.calculateSpeedPrice();   
    trade.setTheRateOfChangeOfPricesBuy3(sc.getSpeedPriceBuy());    
    trade.setTheRateOfChangeOfPricesSell3(sc.getSpeedPriceSell());   
    
    if (GlobalConfigSetting.testRegime == true){
        
        addTestTrade(trade);
 
    }    
    //System.out.println("Рассчитали среднюю и отклонение: " +trade.getTime()); 
}
    
    
    private void addTestTrade (Alltrades.Trade allTrade){
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();
        ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 

        ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(GlobalConfigSetting.client); 
        SecurityForTradesOrders clientSecuritiesConfig = clientConfig.findClientSecurityConfig(allTrade.getSeccode(), allTrade.getBoard());
        OrdersStorage ordersStorage = clientSecuritiesConfig.getOrdersStorage();

        List<Orders.Order> elements = ordersStorage.getObservableList();
        int quantityRunOrderRemnants = allTrade.getQuantity();
        
        Iterator<Orders.Order> iterator =  elements.iterator();        
        while(iterator.hasNext() && quantityRunOrderRemnants > 0){
            Orders.Order el = iterator.next();
            
            if (el.getBuysell().equals(allTrade.getBuysell()) == true){
                if(el.getPrice().compareTo(allTrade.getPrice()) == 0){
                    
                    if(el.getQuantity() > quantityRunOrderRemnants){            
                        el.setQuantity(el.getQuantity() - quantityRunOrderRemnants); 
                        //создать сделку на разницу el.getQuantity() - quantityRunOrderRemnants
                        createTrade(quantityRunOrderRemnants, allTrade.getPrice(), allTrade);
                        quantityRunOrderRemnants = 0;
                    }
        
                    if(el.getQuantity() <= quantityRunOrderRemnants){            
                        //создать сделку на el.getQuantity()
                        createTrade(el.getQuantity(), allTrade.getPrice(), allTrade);
                        quantityRunOrderRemnants = quantityRunOrderRemnants - el.getQuantity();
                        iterator.remove();  
                    }
                }
            }
        }
    }
    
    private void createTrade(int quantity, BigDecimal price, Alltrades.Trade allTrade){
     
        Trades.Trade trade = new Trades.Trade();

        trade.setClient(GlobalConfigSetting.client);
        trade.setBuysell(allTrade.getBuysell());
        trade.setBoard(allTrade.getBoard());
        trade.setSeccode(allTrade.getSeccode());
        trade.setPrice(price);
        trade.setQuantity(quantity);
        


        addTestTradeInStorage(trade); 
    }
    
    
    
    private void addTestTradeInStorage(Trades.Trade trade){
        
        TradesHandler  tradesHandler = new TradesHandler();
        tradesHandler.AddTradeInStorage(trade);    
        
        
    }
    
}
