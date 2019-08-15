package ru.kaserv.transaq.forms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.kaserv.transaq.command.CommandBuilder;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.ClientsForTradesOrders;
import ru.kaserv.transaq.configuration.GlobalConfigSetting;
import ru.kaserv.transaq.configuration.RemnantOfSecurities;
import ru.kaserv.transaq.configuration.RemnantOfSecuritiesBuilder;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Trades;
import ru.kaserv.transaq.storage.ClientsStorage;
import transaq.TransaqConnector;
import transaq.TransaqHandler;
import transaq.TransaqQueue;

/**
 *
 * @author 1
 */
public class FXMLDocumentController implements Initializable {
    
 


    
    private TransaqQueue queue = new TransaqQueue();
    
    private TransaqConnector transaqConnector;
    private TransaqHandler transaqHandler;
    Thread consumer;
    
    StorageConfig storageConfig = new StorageConfig();

    
/* 
  
    
    
    @FXML
    TableView quotationTableView;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewBoard;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewSeccode;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewPointCost;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewTradingStatus;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewLast;     
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewQuantity;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewTime;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewChange;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewPriceminusprevwaprice;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewBid; 
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewBiddepth;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewBiddeptht;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewNumbids;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewOffer;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewOfferdepth;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewOfferdeptht;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewNumoffers;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewOpen;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewHigh;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewLow;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewVoltoday;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewNumtrades;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewValtoday;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewOpenposition;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewDeltapositions;  
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewWaprice;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewCloseprice;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewMarketpricetoday;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewLcurrentprice;    
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewBuydeposit;
    @FXML
    private TableColumn<Quotations.Quotation, String> columnQuotationTableViewSelldeposit;
 
    

    
    
    @FXML
    TableView quoteTableView;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewBoard;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewSeccode;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewPrice;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewYield;      
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewSell;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewBuy;
    @FXML
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewSecId;    
    
    


    
    
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderActiveorderno;    
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderSecid;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderBoard;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderSeccode;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderClient;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderBuysell;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderCanceller;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderAlltradeno;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderValidbefore;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderAuthor;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderAccepttime;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderLinkedorderno;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderExpdate;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStatus;
    
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossActivationprice;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossGuardtime;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossBrokerref;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossQuantity;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossOrderprice;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderStoplossUsecredit;

    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitActivationprice;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitGuardtime;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitBrokerref;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitQuantity;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitExtremum;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitLevel;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitCorrection;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTakeprofitGuardspread;

    
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderWithdrawtime;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderResult;
    @FXML
    private TableColumn<Orders.Stoporder, String> columnOrderTableViewStoporderTransactionid;   */
    



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   
        
        if (GlobalConfigSetting.testRegime == true){
            Client client = new Client();
            client.setId(GlobalConfigSetting.client);
            
            
            ClientsStorage cs = StorageConfig.getStorageConfig().getClientsStorageConfig().getClientsStorage();                    
            cs.add(client);
        }
        
    /*    columnShortName.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("shortname"));
        columnSecTz.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("secTz"));    
        columnSeccode.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("seccode"));      
        columnBoard.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("board"));    
        columnDecimals.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("decimals"));    
        columnMarket.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("market"));       
        columnSectype.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("sectype"));     
        columnMinstep.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("minstep"));    
        columnlotsize.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("lotsize"));       
        columnPointCost.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("pointCost"));    
        columnQuotestype.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("quotestype"));     
        columnSecid.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("secid"));      
        columnActive.setCellValueFactory(new PropertyValueFactory<Securities.Security, String>("active"));       
        securityTableView.setItems(storageConfig.getSecuritiesConfig().getSecuritiesStorage().getObservableList());
        
        
        columnBoardTableViewName.setCellValueFactory(new PropertyValueFactory<Boards.Board, String>("name"));
        columnBoardTableViewMarket.setCellValueFactory(new PropertyValueFactory<Boards.Board, String>("market"));
        columnBoardTableViewType.setCellValueFactory(new PropertyValueFactory<Boards.Board, String>("type"));
        columnBoardTableViewId.setCellValueFactory(new PropertyValueFactory<Boards.Board, String>("id"));      
        boardTableView.setItems(boardObList);
        
        
        
        columnCandlekindTableViewId.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("id"));
        columnCandlekindTableViewPeriod.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("period"));
        columnCandlekindTableViewName.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("name"));
        candlekindTableView.setItems(candlekindObList);    
        
        
        columnQuotationTableViewBoard.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("board"));
        columnQuotationTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("seccode"));
        columnQuotationTableViewPointCost.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("pointCost"));
        columnQuotationTableViewTradingStatus.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("tradingstatus"));                
        columnQuotationTableViewLast.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("last"));
        columnQuotationTableViewQuantity.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("quantity"));
        columnQuotationTableViewTime.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("time"));
        columnQuotationTableViewChange.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("change"));                    
        columnQuotationTableViewPriceminusprevwaprice.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("priceminusprevwaprice"));
        columnQuotationTableViewBid.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("bid"));
        columnQuotationTableViewBiddepth.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("biddepth"));
        columnQuotationTableViewBiddeptht.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("biddeptht"));                  
        columnQuotationTableViewNumbids.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("numbids"));
        columnQuotationTableViewOffer.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("offer"));
        columnQuotationTableViewOfferdepth.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("offerdepthost"));
        columnQuotationTableViewOfferdeptht.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("offerdeptht"));                        
        columnQuotationTableViewNumoffers.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("numoffers"));
        columnQuotationTableViewOpen.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("open"));
        columnQuotationTableViewHigh.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("high"));
        columnQuotationTableViewLow.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("low"));                  
        columnQuotationTableViewVoltoday.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("voltoday"));
        columnQuotationTableViewNumtrades.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("numtrades"));
        columnQuotationTableViewValtoday.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("valtoday"));
        columnQuotationTableViewOpenposition.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("openposition"));           
        columnQuotationTableViewDeltapositions.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("deltapositions"));
        columnQuotationTableViewWaprice.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("waprice"));
        columnQuotationTableViewCloseprice.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("closeprice"));
        columnQuotationTableViewMarketpricetoday.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("marketpricetoday"));        
        columnQuotationTableViewLcurrentprice.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("lcurrentprice"));
        columnQuotationTableViewBuydeposit.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("buydeposit"));
        columnQuotationTableViewSelldeposit.setCellValueFactory(new PropertyValueFactory<Quotations.Quotation, String>("selldeposit")); 
        quotationTableView.setItems(quotationObList);  
        
        
        columnQuoteTableViewBoard.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("board"));
        columnQuoteTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("seccode"));
        columnQuoteTableViewPrice.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("price"));
        columnQuoteTableViewYield.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("yield"));
        columnQuoteTableViewSell.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("sell"));
        columnQuoteTableViewBuy.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("buy"));
        columnQuoteTableViewSecId.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("secid"));
        quoteTableView.setItems(quoteObList); 
        
        
        columnAllTradeTableViewTradeNo.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("tradeno"));
        columnAllTradeTableViewBoard.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("board"));
        columnAllTradeTableViewTime.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("time"));
        columnAllTradeTableViewPrice.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("price"));
        columnAllTradeTableViewQuantity.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("quantity"));
        columnAllTradeTableViewBuysell.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("buysell"));
        columnAllTradeTableViewOpeninterest.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("openinterest"));               
        columnAllTradeTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("seccode"));
        columnAllTradeTableViewPeriod.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("period"));
        columnAllTradeTableViewSecid.setCellValueFactory(new PropertyValueFactory<Alltrades.Trade, String>("secid"));
        allTradeTableView.setItems(alltradeObList);      
        
        
        columnClientTableViewMarket.setCellValueFactory(new PropertyValueFactory<Client, String>("market"));    
        columnClientTableViewCurrency.setCellValueFactory(new PropertyValueFactory<Client, String>("currency"));        
        columnClientTableViewType.setCellValueFactory(new PropertyValueFactory<Client, String>("type")); 
        columnClientTableViewId.setCellValueFactory(new PropertyValueFactory<Client, String>("id")); 
        columnClientTableViewRemove.setCellValueFactory(new PropertyValueFactory<Client, String>("remove")); 
        clientTableView.setItems(storageConfig.getClientsStorageConfig().getClientsStorage().getObservableList());
        
            
    
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
        tradeTableView.setItems(tradeObList); 
        
        
 
    
        
       
   
        columnOrderTableViewOrderno.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("orderno"));  
        columnOrderTableViewSecid.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("secid"));  
        columnOrderTableViewBoard.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("board"));
        columnOrderTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("seccode"));
        columnOrderTableViewClient.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("client"));
        columnOrderTableViewUnion.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("union"));
        columnOrderTableViewStatus.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("status"));
        columnOrderTableViewBuysell.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("buysell"));
        columnOrderTableViewTime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("time"));
        columnOrderTableViewExpdate.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("expdate"));
        columnOrderTableViewOrigin_orderno.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("origin_orderno"));
        columnOrderTableViewAccepttime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("accepttime"));
        columnOrderTableViewBrokerref.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("brokerref"));
        columnOrderTableViewValue.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("value"));
        columnOrderTableViewAccruedint.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("accruedint"));
        columnOrderTableViewSettlecode.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("settlecode"));
        columnOrderTableViewBalance.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("balance"));
        columnOrderTableViewPrice.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("price"));
        columnOrderTableViewQuantity.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("quantity"));
        columnOrderTableViewHidden.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("hidden"));
        columnOrderTableViewYield.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("yield"));
        columnOrderTableViewWithdrawtime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("withdrawtime"));
        columnOrderTableViewCondition.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("condition"));
        columnOrderTableViewConditionvalue.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("conditionvalue"));
        columnOrderTableViewValidafter.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("validafter"));
        columnOrderTableViewValidbefore.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("validbefore"));
        columnOrderTableViewMaxcomission.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("maxcomission"));
        columnOrderTableViewResult.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("result"));
        columnOrderTableViewTransactionid.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("transactionid"));
        orderTableView.setItems(orderObList);*/
   
    //этих полей нет поэтому NullPointerExeption!!!
   /**     columnOrderTableViewStoporderActiveorderno.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("activeorderno"));
        columnOrderTableViewStoporderSecid.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("secid"));
        columnOrderTableViewStoporderBoard.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("board"));
        columnOrderTableViewStoporderSeccode.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("seccode"));
        columnOrderTableViewStoporderClient.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("client"));
        columnOrderTableViewStoporderBuysell.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("buysell"));
        columnOrderTableViewStoporderCanceller.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("canceller"));
        columnOrderTableViewStoporderAlltradeno.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("alltradeno"));
        columnOrderTableViewStoporderValidbefore.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("validbefore"));
        columnOrderTableViewStoporderAuthor.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("author"));
        columnOrderTableViewStoporderAccepttime.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("accepttime"));
        columnOrderTableViewStoporderLinkedorderno.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("linkedorderno"));
        columnOrderTableViewStoporderExpdate.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("expdate"));
        columnOrderTableViewStoporderStatus.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("status"));
        columnOrderTableViewStoporderStoplossActivationprice.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("activationprice"));
        columnOrderTableViewStoporderStoplossGuardtime.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("guardtime"));
        columnOrderTableViewStoporderStoplossBrokerref.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("brokerref"));
        columnOrderTableViewStoporderStoplossQuantity.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("quantity"));
        columnOrderTableViewStoporderStoplossOrderprice.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("orderprice"));
        columnOrderTableViewStoporderStoplossUsecredit.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("usecredit"));
        columnOrderTableViewStoporderTakeprofitActivationprice.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("activationprice"));
        columnOrderTableViewStoporderTakeprofitGuardtime.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("guardtime"));
        columnOrderTableViewStoporderTakeprofitBrokerref.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("brokerref"));
        columnOrderTableViewStoporderTakeprofitQuantity.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("quantity"));
        columnOrderTableViewStoporderTakeprofitExtremum.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("extremum"));
        columnOrderTableViewStoporderTakeprofitLevel.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("level"));
        columnOrderTableViewStoporderTakeprofitCorrection.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("correction"));
        columnOrderTableViewStoporderTakeprofitGuardspread.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("guardspread"));
        columnOrderTableViewStoporderWithdrawtime.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("withdrawtime"));
        columnOrderTableViewStoporderResult.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("result"));
        columnOrderTableViewStoporderTransactionid.setCellValueFactory(new PropertyValueFactory<Orders.Stoporder, String>("transactionid"));**/


                 
        
        
    }  
    
    
        public static void JNICallTest()
            {
            File file = new File("D://trading-on-the-exchange//Transaq//Output//kasTXmlConnector.dll");
            
            if (file.exists()) {
                    try {
                    String path = file.getAbsolutePath();
                    int idx = path.indexOf(File.separatorChar
                    + "kasTXmlConnector.dll");
                    path = path.substring(0, idx);
                    addLibraryPath(path);

                    } catch (Exception e1) {
                    e1.printStackTrace();
                    }
            } else {
            System.out.println("DLL NOT EXISTS");
            }
            }
    
    public static void addLibraryPath(String pathToAdd) throws Exception
        {
        Field usrPathsField;
        usrPathsField = ClassLoader.class.getDeclaredField("usr_paths");
        usrPathsField.setAccessible(true);
        // get array of paths
        final String[] paths = (String[])usrPathsField.get(null);
        // check if the path to add is already present
        for (String path : paths) {
        if(path.equals(pathToAdd)) {
        return;
        }
        }
        // add the new path
        String[] newPaths = Arrays.copyOf(paths, paths.length + 1);
        newPaths[newPaths.length-1] = pathToAdd;
        usrPathsField.set(null, newPaths);
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    

    
    @FXML
    private void handleMainMenuOpenTableClientsForTradesOrders(ActionEvent event) { 
               
        Stage newWindow = new Stage(); 
        newWindow.setTitle("Клиенты для заявок и сделок");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("ClientsTableForTradesOrders.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }

    @FXML
    private void handleMainMenuOpenTableSecuritiesForAllTrades(ActionEvent event) { 
               
        Stage newWindow = new Stage();
        newWindow.setTitle("Инструменты для всех сделок: ");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("SecuritiesForAllTrades.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
    
        @FXML
    private void handleMainMenuOpenTableSecuritiesForQuotes(ActionEvent event) { 
               
        Stage newWindow = new Stage();  
        newWindow.setTitle("Инструменты для стакана");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("SecuritiesForQuotes.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
    
    @FXML
    private void handleMainMenuOpenTableClients(ActionEvent event) { 
               
        Stage newWindow = new Stage(); 
        newWindow.setTitle("Клиенты");
        
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("Clients.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
    
    @FXML
    private void handleMainMenuOpenTableSecurities(ActionEvent event) { 
               
        Stage newWindow = new Stage(); 
        newWindow.setTitle("Инструменты");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("Securities.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }    
    
    @FXML
    private void handleMainMenuConnectToServer(ActionEvent event){ 
               
    JNICallTest();   
        
    
    Object blockObject = new Object();

    transaqConnector = new TransaqConnector();
    transaqConnector.LoadDllTransaq();
    transaqConnector.SetCallback();
    transaqConnector.setQueue(queue);
    transaqConnector.setBlockObject(blockObject);
    String logPath="D:\\trading-on-the-exchange\\Transaq\\Output\\Log\\"; 
    
    byte[] b=logPath.getBytes();
    transaqConnector.Initialize(b, 3);
    
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        transaqHandler = new TransaqHandler();
        transaqHandler.setBlockObject(blockObject);
        consumer = new Thread(transaqHandler);
        transaqHandler.setQueue(queue);
        consumer.setName("Consumer");
        System.out.println("Запусаем поток, текущий поток:" + Thread.currentThread().getName()); 


        consumer.start();
        
        
        
            String z;




    System.out.println("Выполняем команду, текущий поток:" + Thread.currentThread().getName());     
        

    
    CommandBuilder cb = new CommandBuilder();
    String command = cb.createCommandConnect();
    System.out.println(command); 
    byte[] b2=command.getBytes();
    transaqConnector.SendCommand(b2);
    
    
    //после этого должны получить асинхронный ответ connect  
    
    }
    
    
    @FXML
    private void handleMainMenuDisconnectServer(ActionEvent event) { 
        
        String z=	"<command id=\"disconnect\"/>";

        byte[] b=z.getBytes();
        transaqConnector.SendCommand(b); 
        
        saveBalance();

        consumer.interrupt();

        transaqConnector.UnInitialize();
        

        transaqConnector.UnLoadDllTransaq();

//после этого должны получить асинхронный ответ disconnect    
        
    }
    
    
    @FXML
    private void handleMainMenuOpenConfigConnect(ActionEvent event) {     
        
        Stage newWindow = new Stage(); 
        newWindow.setTitle("Параметры подключения к серверу Transaq");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnectConfigForm.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        ConnectConfigFormController connectConfigFormController = loader.<ConnectConfigFormController>getController();
        connectConfigFormController.loadConnectConfig();
        
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
   
    }
    
    
    private void saveBalance(){
        
        
        
    StorageConfig storageConfig = StorageConfig.getStorageConfig();
    ClientsForTradesOrders clientsConfig = storageConfig.getClientsForTradesOrders();
    
    Collection<ClientForTradesOrders> clients = clientsConfig.getElements();

    //ClientForTradesOrders result = null;

        RemnantOfSecuritiesBuilder builder = new RemnantOfSecuritiesBuilder();
        RemnantOfSecurities remnants =  builder.load();
        
        if (remnants == null){            
            remnants = new RemnantOfSecurities();
        }

        
        for(ClientForTradesOrders cl : clients){
            
                       
            Collection<SecurityForTradesOrders> secirities = cl.getSecuritiesForTradesOrders();
            
            for (SecurityForTradesOrders sec : secirities){
                List<Trades.Trade> trades = sec.getTradesStorage().getObservableList();
                
                if (trades.size() > 0){
                    Trades.Trade trade = trades.get(trades.size()-1);

                    RemnantOfSecurities.RemnantOfSecurityElement remnantOfSecurityElement = new RemnantOfSecurities.RemnantOfSecurityElement();
                    remnantOfSecurityElement.setDate(trade.getTime());
                    remnantOfSecurityElement.setIdClient(trade.getClient());
                    remnantOfSecurityElement.setPurchaseValue(trade.getCostPriceAll());
                    remnantOfSecurityElement.setRemnant(trade.getQuantityAll());
                    remnantOfSecurityElement.setSeccode(trade.getSeccode());
                    remnantOfSecurityElement.setProfit(trade.getProfitAll());
                    remnants.getElements().add(remnantOfSecurityElement);                    
                }

            }

        }

    builder.save(remnants);
    }
    
    
    @FXML
    private void handleMainMenuOpenTableSecuritiesForCandles(ActionEvent event) { 
               
        Stage newWindow = new Stage();
        newWindow.setTitle("Инструменты для свечей");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("SecuritiesForCandlesForm.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
    




    @FXML
    private void handleMainMenuOpenTableCandlekinds(ActionEvent event) { 
               
        Stage newWindow = new Stage();
        newWindow.setTitle("Периоды для свечей");
        Parent root = null;          
   
            try {
                root = FXMLLoader.load(getClass().getResource("CandlekindsForm.fxml"));        
            }
            catch (IOException err){
                System.out.println("ошибка " + err);
                err.printStackTrace();    
            }
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
    
}