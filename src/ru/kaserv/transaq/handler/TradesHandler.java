/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.RemnantOfSecurities;
import ru.kaserv.transaq.configuration.RemnantOfSecuritiesBuilder;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Trades;
import ru.kaserv.transaq.storage.TradesStorage;


/**
 *
 * @author 1
 */
public class TradesHandler {
    
    
    public void AddTradeInStorage(Trades.Trade trade){
        
     //find client config
    StorageConfig storageConfig = StorageConfig.getStorageConfig();
    ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 
    
    ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(trade.getClient());    
      
    SecurityForTradesOrders securityConfig = clientConfig.findClientSecurityConfig(trade.getSeccode(), trade.getBoard());

    TradesStorage tradesStorage = securityConfig.getTradesStorage(); 

    List<Trades.Trade> tradesList = tradesStorage.getObservableList();
    
    
    if (tradesList.isEmpty()){
        addInitialBalance(trade,tradesList );
    }
    
    
            if (trade.getBuysell().equals("B")){
                handleBuy(trade, tradesList );
            }

            if (trade.getBuysell().equals("S")){
                handleSell(trade,tradesList );
            }
     
        if(trade.getQuantityAll() != 0) {
            trade.setCostPriceUnit(trade.getCostPriceAll().divide(BigDecimal.valueOf(trade.getQuantityAll()),3,BigDecimal.ROUND_HALF_UP));
        } 
            
    tradesStorage.add(trade);
    System.out.println("Добавили запись в таблицу сделок: " +trade.getTime()); 
        
    }
    

    void handleBuy(Trades.Trade trade, List<Trades.Trade> tradesList ) {
    
        
    
            if (tradesList.isEmpty()){    
                    handleFirstBuy(trade, tradesList);
                }
            else
                {
                    handleSecondBuy(trade, tradesList);

                }
    }   
 
    void handleSell(Trades.Trade trade, List<Trades.Trade> tradesList ) {
    
                if (tradesList.isEmpty()){ 
                       
                    handleFirstSell(trade, tradesList);
                }
                else{
                    
                    handleSecondSell(trade, tradesList);
                }    
    } 

    void handleFirstBuy(Trades.Trade trade, List<Trades.Trade> tradesList ){
    
    trade.setBuyQuantity(trade.getQuantity());
    trade.setSellQuantity(0);
    trade.setSellSum(BigDecimal.ZERO);
    trade.setCostPriceSellTrade(BigDecimal.ZERO);
    trade.setBuySum(trade.getPrice().multiply(BigDecimal.valueOf(trade.getQuantity())));
    trade.setQuantityAll(0 + trade.getBuyQuantity()); 
                    
    int balance = 0;
    BigDecimal costPriceAll = BigDecimal.ZERO;
                    
                    if (balance >= 0){  
                        trade.setCostPriceBuyTrade(trade.getBuySum());
                        trade.setCostPriceAll(costPriceAll.add(trade.getBuySum())) ;                        
                        trade.setProfitTrade(BigDecimal.ZERO);
                    }
                    else{//balance < 0
                        int purchasedQuantity = trade.getQuantity();
                        
                        if (purchasedQuantity == -(balance)){//списываем все                           
                            trade.setQuantityAll(0);                                              
                            trade.setCostPriceAll(BigDecimal.ZERO) ;                        
                            trade.setProfitTrade(trade.getBuySum().subtract(costPriceAll)); 
                            trade.setCostPriceBuyTrade(costPriceAll);
                        }
                        else{

                            if(purchasedQuantity > -(balance)){
                                //списываем остаток
                                
                                int kol_menshe_null = -(balance);
                                int kol_bolshe_null = purchasedQuantity + balance;  
                                BigDecimal sebest_balanca = costPriceAll;   
                                trade.setProfitTrade(sebest_balanca.subtract(trade.getPrice().multiply(BigDecimal.valueOf(kol_menshe_null))));
                                
                                trade.setCostPriceAll(BigDecimal.ZERO);//все списали
                                                              
                                trade.setCostPriceBuyTrade(trade.getPrice().multiply(BigDecimal.valueOf(kol_bolshe_null))); 
                                trade.setCostPriceAll(trade.getCostPriceBuyTrade());
                                
                                
   
                            }
                            else{
                                
                                //себестоимость остатка делим на количество остатка, получаем себестоимость одной штуки
                                //себестоимость одной штуки умножаем на купленное количество, получаем себестоимость списанного количества
                                //из себестоимости остатка вычитаем сумму строки, получаем доход
                                //
                                BigDecimal seb_sht = costPriceAll.divide(BigDecimal.valueOf(-balance),3,BigDecimal.ROUND_HALF_UP);
                                BigDecimal seb_spisat = seb_sht.multiply(BigDecimal.valueOf(trade.getQuantity()));                                
                                trade.setProfitTrade(seb_spisat.subtract(trade.getBuySum()));                                
                                trade.setCostPriceAll(costPriceAll.subtract(seb_spisat));
                                trade.setCostPriceBuyTrade(seb_spisat);
                            }
                            
                        }
                           
                        
                    }
                    
    trade.setProfitAll(trade.getProfitTrade());
             
                    
    }

    void handleSecondBuy(Trades.Trade trade, List<Trades.Trade> tradesList ){
    
    trade.setBuyQuantity(trade.getQuantity());
    trade.setSellQuantity(0);
    trade.setSellSum(BigDecimal.ZERO);
    trade.setCostPriceSellTrade(BigDecimal.ZERO);
    trade.setBuySum(trade.getPrice().multiply(BigDecimal.valueOf(trade.getQuantity())));
    trade.setQuantityAll(tradesList.get(tradesList.size()-1).getQuantityAll() + trade.getBuyQuantity()); 
                    
    int balance = tradesList.get(tradesList.size()-1).getQuantityAll();
    BigDecimal costPriceAll = tradesList.get(tradesList.size()-1).getCostPriceAll();
                    
                    if (balance >= 0){  
                        trade.setCostPriceBuyTrade(trade.getBuySum());
                        trade.setCostPriceAll(costPriceAll.add(trade.getBuySum())) ;                        
                        trade.setProfitTrade(BigDecimal.ZERO);
                    }
                    else{//balance < 0
                        int purchasedQuantity = trade.getQuantity();
                        
                        if (purchasedQuantity == -(balance)){//списываем все                           
                            trade.setQuantityAll(0);                                              
                            trade.setCostPriceAll(BigDecimal.ZERO) ;                        
                            trade.setProfitTrade(trade.getBuySum().subtract(costPriceAll)); 
                            trade.setCostPriceBuyTrade(costPriceAll);
                        }
                        else{

                            if(purchasedQuantity > -(balance)){
                                //списываем остаток
                                
                                int kol_menshe_null = -(balance);
                                int kol_bolshe_null = purchasedQuantity + balance;  
                                BigDecimal sebest_balanca = costPriceAll;   
                                trade.setProfitTrade(sebest_balanca.subtract(trade.getPrice().multiply(BigDecimal.valueOf(kol_menshe_null))));
                                
                                trade.setCostPriceAll(BigDecimal.ZERO);//все списали
                                                              
                                trade.setCostPriceBuyTrade(trade.getPrice().multiply(BigDecimal.valueOf(kol_bolshe_null))); 
                                trade.setCostPriceAll(trade.getCostPriceBuyTrade());
                                
                                
   
                            }
                            else{
                                
                                //себестоимость остатка делим на количество остатка, получаем себестоимость одной штуки
                                //себестоимость одной штуки умножаем на купленное количество, получаем себестоимость списанного количества
                                //из себестоимости остатка вычитаем сумму строки, получаем доход
                                //
                                BigDecimal seb_sht = costPriceAll.divide(BigDecimal.valueOf(-balance),3,BigDecimal.ROUND_HALF_UP);
                                BigDecimal seb_spisat = seb_sht.multiply(BigDecimal.valueOf(trade.getQuantity()));                                
                                trade.setProfitTrade(seb_spisat.subtract(trade.getBuySum()));                                
                                trade.setCostPriceAll(costPriceAll.subtract(seb_spisat));
                                trade.setCostPriceBuyTrade(seb_spisat);
                            }
                            
                        }
                           
                        
                    }
                    
    trade.setProfitAll((tradesList.get(tradesList.size()-1).getProfitAll()).add(trade.getProfitTrade()));

    }

    void handleFirstSell(Trades.Trade trade, List<Trades.Trade> tradesList ){
    
        trade.setBuyQuantity(0);
        trade.setBuySum(BigDecimal.ZERO);
        trade.setCostPriceBuyTrade(BigDecimal.ZERO);
        trade.setSellQuantity(trade.getQuantity());
        trade.setSellSum(trade.getPrice().multiply(BigDecimal.valueOf(trade.getQuantity())));
        
        trade.setQuantityAll(0 - trade.getQuantity());
        
        int balance = 0;
        BigDecimal costPriceAll = BigDecimal.ZERO;
                    
        if (balance < 0){
            trade.setCostPriceSellTrade(trade.getSellSum());
            trade.setCostPriceAll(costPriceAll.add(trade.getCostPriceSellTrade())) ;                        
            trade.setProfitTrade(BigDecimal.ZERO);
        }
        else{
            int sellQuantity = trade.getQuantity();
                        
            if (sellQuantity == balance){//списываем все                                                                       
                            trade.setCostPriceAll(BigDecimal.ZERO) ;                        
                            trade.setProfitTrade(trade.getSellSum().subtract(costPriceAll));                            
                        }  
            else{
                if (sellQuantity < balance){
                    BigDecimal seb_k_spis = (costPriceAll.divide(BigDecimal.valueOf(balance),3,BigDecimal.ROUND_HALF_UP)).multiply(BigDecimal.valueOf(sellQuantity));
                    trade.setCostPriceSellTrade(seb_k_spis);
                    trade.setProfitTrade(trade.getSellSum().subtract(trade.getCostPriceSellTrade())); 
                    trade.setCostPriceAll(costPriceAll.subtract(seb_k_spis));
                }
                else{//>balance
                    BigDecimal seb_k_spis = costPriceAll;
                    int rasniza = sellQuantity - balance;   
                    
                    trade.setCostPriceSellTrade(costPriceAll);                    
                    trade.setProfitTrade(trade.getPrice().multiply(BigDecimal.valueOf(balance)).subtract(trade.getCostPriceSellTrade()));
                    
                    trade.setCostPriceAll(BigDecimal.ZERO);//все списали
                    
                    //осталось еще
                    trade.setCostPriceAll(trade.getPrice().multiply(BigDecimal.valueOf(rasniza)));
    
                }
            }
            
        }
            
    trade.setProfitAll(trade.getProfitTrade());    
    }

    void handleSecondSell(Trades.Trade trade, List<Trades.Trade> tradesList ){
    
        trade.setBuyQuantity(0);
        trade.setBuySum(BigDecimal.ZERO);
        trade.setCostPriceBuyTrade(BigDecimal.ZERO);
        trade.setSellQuantity(trade.getQuantity());
        trade.setSellSum(trade.getPrice().multiply(BigDecimal.valueOf(trade.getQuantity())));
        
        trade.setQuantityAll(tradesList.get(tradesList.size()-1).getQuantityAll() - trade.getQuantity());
        
        int balance = tradesList.get(tradesList.size()-1).getQuantityAll();
        BigDecimal costPriceAll = tradesList.get(tradesList.size()-1).getCostPriceAll();
                    
        if (balance < 0){
            trade.setCostPriceSellTrade(trade.getSellSum());
            trade.setCostPriceAll(costPriceAll.add(trade.getCostPriceSellTrade())) ;                        
            trade.setProfitTrade(BigDecimal.ZERO);
        }
        else{
            int sellQuantity = trade.getQuantity();
                        
            if (sellQuantity == balance){//списываем все                                                                       
                            trade.setCostPriceAll(BigDecimal.ZERO) ;                        
                            trade.setProfitTrade(trade.getSellSum().subtract(costPriceAll));                            
                        }  
            else{
                if (sellQuantity < balance){
                    BigDecimal seb_k_spis = (costPriceAll.divide(BigDecimal.valueOf(balance),3,BigDecimal.ROUND_HALF_UP)).multiply(BigDecimal.valueOf(sellQuantity));
                    trade.setCostPriceSellTrade(seb_k_spis);
                    trade.setProfitTrade(trade.getSellSum().subtract(trade.getCostPriceSellTrade())); 
                    trade.setCostPriceAll(costPriceAll.subtract(seb_k_spis));
                }
                else{//>balance
                    BigDecimal seb_k_spis = costPriceAll;
                    int rasniza = sellQuantity - balance;   
                    
                    trade.setCostPriceSellTrade(costPriceAll);                    
                    trade.setProfitTrade(trade.getPrice().multiply(BigDecimal.valueOf(balance)).subtract(trade.getCostPriceSellTrade()));
                    
                    trade.setCostPriceAll(BigDecimal.ZERO);//все списали
                    
                    //осталось еще
                    trade.setCostPriceAll(trade.getPrice().multiply(BigDecimal.valueOf(rasniza)));
    
                }
            }
            
        }
            
        trade.setProfitAll((tradesList.get(tradesList.size()-1).getProfitAll()).add(trade.getProfitTrade()));      
    
    }
    
    
    void addInitialBalance(Trades.Trade trade, List<Trades.Trade> tradesList ){
        

        
        RemnantOfSecuritiesBuilder builder = new RemnantOfSecuritiesBuilder();
        RemnantOfSecurities remnant =  builder.load();
        
        if (remnant == null) return;
        
        Date currentDate = new Date(0L);
        RemnantOfSecurities.RemnantOfSecurityElement currentEl = null;
        
        Iterator<RemnantOfSecurities.RemnantOfSecurityElement> it = remnant.getElements().iterator();
        
            while (it.hasNext()){                
               RemnantOfSecurities.RemnantOfSecurityElement el = it.next();
               
                if (el.getIdClient().equals(trade.getClient()) &&
                       el.getSeccode().equals(trade.getSeccode())){
                    
                    if (currentDate.compareTo(el.getDate()) < 0){
                        currentDate = el.getDate();
                        currentEl = el;
                    }                   
                }
 
            }

        if(currentEl != null){
            StorageConfig storageConfig = StorageConfig.getStorageConfig();
            ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders(); 

            ClientForTradesOrders clientConfig = clientsConfig.findClientConfig(trade.getClient());    

            SecurityForTradesOrders securityConfig = clientConfig.findClientSecurityConfig(trade.getSeccode(), trade.getBoard());

            TradesStorage tradesStorage = securityConfig.getTradesStorage();
            
            Trades.Trade newTrade = new Trades.Trade();
            newTrade.setClient(currentEl.getIdClient());
            newTrade.setSeccode(currentEl.getSeccode());
            newTrade.setQuantityAll(currentEl.getRemnant());
            newTrade.setCostPriceAll(currentEl.getPurchaseValue());
            newTrade.setProfitAll(currentEl.getProfit());
            tradesStorage.add(trade);    
            
            
        }   

    }    
    
}
