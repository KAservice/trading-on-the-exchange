/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.storage.AllTradesStorage;


/**
 * FXML Controller class
 *
 * @author 1
 */
public class AllTradesController implements Initializable {
    
    private AllTradesStorage allTradesStorage;
    
    
    @FXML
    Label captionLabel;
    
    @FXML
    TableView allTradesTableView;
    @FXML
    private TableColumn<Alltrades.Trade, String> columnAllTradesTableViewTradeNo;    
    @FXML
    private TableColumn<Alltrades.Trade, String> columnAllTradesTableViewBoard;   
    @FXML
    private TableColumn<Alltrades.Trade, String> columnAllTradesTableViewTime;    
    @FXML
    private TableColumn<Alltrades.Trade, String> columnAllTradesTableViewPrice;  
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewQuantity;
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewBuysell;
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewOpeninterest;    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewSeccode;      
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewPeriod;      
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewSecid;  
    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewAveragePrice;      
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewStandardDeviation;
    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewMaxPrice;      
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllTradesTableViewMinPrice;
    
    
    
    
    
    
    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllQuantityOfPurchased;
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllQuantitySold;     
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllAmountSold;       
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllPurchasesAmount;   
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAverageSoldPrice;    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAverageBuyingPrice; 
     
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAverageBuyingAndSellingPrice;
     
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnAllAmountSellingAndBuying;  

    @FXML
    private TableColumn<Alltrades.Trade, String>   columnSellingAndBuyingQuantityAll; 
    
    

    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesBuy1;  
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesSell1;      
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesBuy2;  
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesSell2; 
    
    
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesBuy3;  
    @FXML
    private TableColumn<Alltrades.Trade, String>   columnTheRateOfChangeOfPricesSell3;  
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnAllTradesTableViewTradeNo.setCellValueFactory(new PropertyValueFactory<>("tradeno"));
        columnAllTradesTableViewBoard.setCellValueFactory(new PropertyValueFactory<>("board"));
        columnAllTradesTableViewTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        columnAllTradesTableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnAllTradesTableViewQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnAllTradesTableViewBuysell.setCellValueFactory(new PropertyValueFactory<>("buysell"));
        columnAllTradesTableViewOpeninterest.setCellValueFactory(new PropertyValueFactory<>("openinterest"));               
        columnAllTradesTableViewSeccode.setCellValueFactory(new PropertyValueFactory<>("seccode"));
        columnAllTradesTableViewPeriod.setCellValueFactory(new PropertyValueFactory<>("period"));
        columnAllTradesTableViewSecid.setCellValueFactory(new PropertyValueFactory<>("secid"));
        
        columnAllTradesTableViewAveragePrice.setCellValueFactory(new PropertyValueFactory<>("averagePrice"));
        columnAllTradesTableViewStandardDeviation.setCellValueFactory(new PropertyValueFactory<>("standardDeviation"));
        
        columnAllTradesTableViewMaxPrice.setCellValueFactory(new PropertyValueFactory<>("maxPrice"));
        columnAllTradesTableViewMinPrice.setCellValueFactory(new PropertyValueFactory<>("minPrice"));
        
        
        columnAllQuantityOfPurchased.setCellValueFactory(new PropertyValueFactory<>("allQuantityOfPurchased"));
        columnAllQuantitySold.setCellValueFactory(new PropertyValueFactory<>("allQuantitySold"));
        columnAllAmountSold.setCellValueFactory(new PropertyValueFactory<>("allAmountSold"));
        columnAllPurchasesAmount.setCellValueFactory(new PropertyValueFactory<>("allPurchasesAmount"));
        columnAverageSoldPrice.setCellValueFactory(new PropertyValueFactory<>("averageSoldPrice"));
        columnAverageBuyingPrice.setCellValueFactory(new PropertyValueFactory<>("averageBuyingPrice"));
        columnAverageBuyingAndSellingPrice.setCellValueFactory(new PropertyValueFactory<>("averageBuyingAndSellingPrice"));
        columnAllAmountSellingAndBuying.setCellValueFactory(new PropertyValueFactory<>("allAmountSellingAndBuying"));
        columnSellingAndBuyingQuantityAll.setCellValueFactory(new PropertyValueFactory<>("sellingAndBuyingQuantityAll"));
        
        
     
  
        columnTheRateOfChangeOfPricesBuy1.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesBuy1"));
        columnTheRateOfChangeOfPricesSell1.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesSell1"));
        
        columnTheRateOfChangeOfPricesBuy2.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesBuy2"));
        columnTheRateOfChangeOfPricesSell2.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesSell2"));
        
        columnTheRateOfChangeOfPricesBuy3.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesBuy3"));
        columnTheRateOfChangeOfPricesSell3.setCellValueFactory(new PropertyValueFactory<>("theRateOfChangeOfPricesSell3"));

  
    
    }  
    
    
    public void setAlltradesStorage(AllTradesStorage allTradesStorage) {
        this.allTradesStorage = allTradesStorage;
        allTradesTableView.setItems(allTradesStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    } 
    
    

    
}
