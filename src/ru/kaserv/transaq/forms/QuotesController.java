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
import ru.kaserv.transaq.object.Quotes;
import ru.kaserv.transaq.storage.QuotesStorage;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class QuotesController implements Initializable {

    private QuotesStorage quotesStorage;
    
    
    @FXML
    Label captionLabel;
    
    @FXML
    TableView quotesTableView;
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
    private TableColumn<Quotes.Quote, String> columnQuoteTableViewMyQuantityOrder;     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnQuoteTableViewBoard.setCellValueFactory(new PropertyValueFactory<>("board"));
        columnQuoteTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("seccode"));
        columnQuoteTableViewPrice.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("price"));
        columnQuoteTableViewYield.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("yield"));
        columnQuoteTableViewSell.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("sell"));
        columnQuoteTableViewBuy.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("buy"));
        columnQuoteTableViewSecId.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("secid"));
        
        columnQuoteTableViewMyQuantityOrder.setCellValueFactory(new PropertyValueFactory<Quotes.Quote, String>("myQuantityOrder"));
    }  
    
    
    public void setQuotesStorage(QuotesStorage quotesStorage) {
        this.quotesStorage = quotesStorage;
        quotesTableView.setItems(quotesStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    }  
    
}
