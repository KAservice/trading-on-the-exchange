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
  
    }  
    
    
    public void setAlltradesStorage(AllTradesStorage allTradesStorage) {
        this.allTradesStorage = allTradesStorage;
        allTradesTableView.setItems(allTradesStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    } 
    
}
