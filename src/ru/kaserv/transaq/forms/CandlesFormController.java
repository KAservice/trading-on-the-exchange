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
import ru.kaserv.transaq.object.Candles;
import ru.kaserv.transaq.storage.AllTradesStorage;
import ru.kaserv.transaq.storage.CandlesStorage;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class CandlesFormController implements Initializable {

    private CandlesStorage candlesStorage;
    
    
    @FXML
    Label captionLabel;
    
    @FXML
    TableView candlesTableView;
    @FXML
    private TableColumn<Candles.Candle, String> columnDate;    
    @FXML
    private TableColumn<Candles.Candle, String> columnOpen;   
    @FXML
    private TableColumn<Candles.Candle, String> columnClose;    
    @FXML
    private TableColumn<Candles.Candle, String> columnHigh;  
    @FXML
    private TableColumn<Candles.Candle, String>   columnLow;
    @FXML
    private TableColumn<Candles.Candle, String>   columnVolume;
    @FXML
    private TableColumn<Candles.Candle, String>   columnBAveragePrice;    
    @FXML
    private TableColumn<Candles.Candle, String>   columnBDeviationPrice;    
    @FXML
    private TableColumn<Candles.Candle, String>   columnBMaxPrice;   
    @FXML
    private TableColumn<Candles.Candle, String>   columnBMinPrice;      
    @FXML
    private TableColumn<Candles.Candle, String>   columnPriceChangeSpeed;     
    
    




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnOpen.setCellValueFactory(new PropertyValueFactory<>("open"));
        columnClose.setCellValueFactory(new PropertyValueFactory<>("close"));
        columnHigh.setCellValueFactory(new PropertyValueFactory<>("high"));
        columnLow.setCellValueFactory(new PropertyValueFactory<>("low"));
        columnVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        columnBAveragePrice.setCellValueFactory(new PropertyValueFactory<>("bAveragePrice"));
        columnBDeviationPrice.setCellValueFactory(new PropertyValueFactory<>("bDeviationPrice"));
        columnBMaxPrice.setCellValueFactory(new PropertyValueFactory<>("bMaxPrice"));
        columnBMinPrice.setCellValueFactory(new PropertyValueFactory<>("bMinPrice"));
        columnPriceChangeSpeed.setCellValueFactory(new PropertyValueFactory<>("priceChangeSpeed"));
        
        
    }  
    
    
    public void setCandlesStorage(CandlesStorage candlesStorage) {
        this.candlesStorage = candlesStorage;
        candlesTableView.setItems(candlesStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    } 
    
}
