/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

/**
 *
 * @author 1
 */
public class StorageConfig {
    /**  javadoc место для хранения */
    
    private static StorageConfig storageConfig;
    
    private BoardsStorageConfig boardsConfig;
    private SecuritiesStorageConfig securitiesConfig;//чисто инструменты
    private ClientsStorageConfig clientsStorageConfig;
    
    private CandlekindsStorageConfig candlekindsStorageConfig;
    
    
    private ClientsForTradesOrders clientsForTradesOrders; //это структура не чисто место хранения клиентов здесь trade, order
    
    
    //private ClientSecuriesForTradesOrders
    
    //список инструментов по которым надо alltrades  и стакан в принципе попадает сюда
    private SecuritiesForAllTrades securitiesForAllTrades;
    private SecuritiesForQuotes securitiesForQuotes;
    //private securitiesForQuotations;
    private SecuritiesForCandles securitiesForCandles;
    
    private PortfolioTplusStorageConfig portfolioTplusStorageConfig;
    private PortfolioUnitedStorageConfig portfolioUnitedStorageConfig;
    private ClientLimitsStorageConfig clientLimitsStorageConfig;
    
 
    

    public StorageConfig() {
        storageConfig = this;
        
        boardsConfig = new BoardsStorageConfig();
        securitiesConfig = new SecuritiesStorageConfig();
        clientsStorageConfig = new ClientsStorageConfig();
        candlekindsStorageConfig = new CandlekindsStorageConfig();
        
   
        clientsForTradesOrders = new ClientsForTradesOrders();      
        securitiesForAllTrades = new SecuritiesForAllTrades();
        securitiesForQuotes = new SecuritiesForQuotes();
        securitiesForCandles = new SecuritiesForCandles();
        
        portfolioTplusStorageConfig = new PortfolioTplusStorageConfig();
        portfolioUnitedStorageConfig = new PortfolioUnitedStorageConfig();
        clientLimitsStorageConfig = new ClientLimitsStorageConfig();
    }

    public ClientsStorageConfig getClientsStorageConfig() {
        return clientsStorageConfig;
    }


    
    public static StorageConfig getStorageConfig() {
        return storageConfig;
    }


 


    public SecuritiesStorageConfig getSecuritiesConfig() {
        return securitiesConfig;
    }

    public SecuritiesForAllTrades getSecuritiesForAllTrades() {
        return securitiesForAllTrades;
    }

    public SecuritiesForQuotes getSecuritiesForQuotes() {
        return securitiesForQuotes;
    }

    public SecuritiesForCandles getSecuritiesForCandles() {
        return securitiesForCandles;
    }
    

    public ClientsForTradesOrders getClientsForTradesOrders() {
        return clientsForTradesOrders;
    }

    public BoardsStorageConfig getBoardsConfig() {
        return boardsConfig;
    }

    public PortfolioTplusStorageConfig getPortfolioTplusStorageConfig() {
        return portfolioTplusStorageConfig;
    }

    public PortfolioUnitedStorageConfig getPortfolioUnitedStorageConfig() {
        return portfolioUnitedStorageConfig;
    }

    public ClientLimitsStorageConfig getClientLimitsStorageConfig() {
        return clientLimitsStorageConfig;
    }

    public CandlekindsStorageConfig getCandlekindsStorageConfig() {
        return candlekindsStorageConfig;
    }
    
    
    
    
}
