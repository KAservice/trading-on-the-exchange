/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.annotation.XmlTransient;
import ru.kaserv.transaq.object.Trades;
import ru.kaserv.transaq.storage.TradesStorage;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class TradesController implements Initializable {
    
    
    
    private TradesStorage tradesStorage;
    
    
    @FXML
    Label captionLabel;
    
    
    @FXML
    TableView tradeTableView;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewSecid;     
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewTradeno;   
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewOrderno;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBoard;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewSeccode;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewClient;   
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBuysell;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewUnion;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewTime;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBrokerref;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewValue;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewComission;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewPrice;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewItems;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewQuantity;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewYield;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewAccruedint;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewTradetype;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewSettlecode;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewCurrentpos;


    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBuyQuantity;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewSellQuantity;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewQuantityAll;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBuySum;
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewSellSum;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewCostPriceBuyTrade;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewCostPriceSellTrade;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewCostPriceAll;     
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewProfitTrade;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewProfitAllTrade;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewCostPriceUnit;   
    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewExchangeCommision;    
    @FXML
    private TableColumn<Trades.Trade, String> columnTradeTableViewBrokerCommision; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        columnTradeTableViewSecid.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("secid"));    
        columnTradeTableViewTradeno.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("tradeno"));        
        columnTradeTableViewOrderno.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("orderno")); 
        columnTradeTableViewBoard.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("board")); 
        columnTradeTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("seccode")); 
        columnTradeTableViewClient.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("client"));        
        columnTradeTableViewBuysell.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("buysell")); 
        columnTradeTableViewUnion.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("union")); 
        columnTradeTableViewTime.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("time"));
        columnTradeTableViewBrokerref.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("brokerref"));
        columnTradeTableViewValue.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("value"));
        columnTradeTableViewComission.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("comission"));
        columnTradeTableViewPrice.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("price"));
        columnTradeTableViewItems.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("items"));
        columnTradeTableViewQuantity.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("quantity"));
        columnTradeTableViewYield.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("yield"));
        columnTradeTableViewAccruedint.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("accruedint"));
        columnTradeTableViewTradetype.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("tradetype"));
        columnTradeTableViewSettlecode.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("settlecode"));
        columnTradeTableViewCurrentpos.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("currentpos"));
        
        columnTradeTableViewBuyQuantity.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("buyQuantity"));
        columnTradeTableViewSellQuantity.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("sellQuantity"));
        columnTradeTableViewQuantityAll.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("quantityAll"));
        columnTradeTableViewBuySum.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("buySum"));
        columnTradeTableViewSellSum.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("sellSum"));
        columnTradeTableViewCostPriceBuyTrade.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("costPriceBuyTrade"));
        columnTradeTableViewCostPriceSellTrade.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("costPriceSellTrade"));
        columnTradeTableViewCostPriceAll.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("costPriceAll"));
        columnTradeTableViewProfitTrade.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("profitTrade"));
        columnTradeTableViewProfitAllTrade.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("profitAll"));
        
        columnTradeTableViewCostPriceUnit.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("costPriceUnit"));
        
        columnTradeTableViewExchangeCommision.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("exchangeCommision"));
        columnTradeTableViewBrokerCommision.setCellValueFactory(new PropertyValueFactory<Trades.Trade, String>("brokerCommision"));    

    }   

    public void setTradesStorage(TradesStorage tradesStorage) {
        this.tradesStorage = tradesStorage;
        tradeTableView.setItems(tradesStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    }   
    
}
