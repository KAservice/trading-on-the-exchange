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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Securities;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class SecuritiesController implements Initializable {
    
    private IExternalEvent externalEventListner;
    private boolean flChoice;
    
   
    
    
    @FXML
    TableView securityTableView;
    @FXML
    private TableColumn<Securities.Security, String> columnShortName;
    @FXML
    private TableColumn<Securities.Security, String> columnSecTz;
    @FXML
    private TableColumn<Securities.Security, String>  columnSeccode;
    @FXML   
    private TableColumn<Securities.Security, String>  columnBoard;
    @FXML   
    private TableColumn<Securities.Security, String>  columnDecimals;
    @FXML
    private TableColumn<Securities.Security, String>  columnMarket;
    @FXML    
    private TableColumn<Securities.Security, String>  columnSectype;        
    @FXML
    private TableColumn<Securities.Security, String>  columnMinstep;
    @FXML
    private TableColumn<Securities.Security, String>  columnLotsize;
    @FXML    
    private TableColumn<Securities.Security, String>  columnPointCost;
    @FXML
    private TableColumn<Securities.Security, String> columnQuotestype;
    @FXML  
    private TableColumn<Securities.Security, String>  columnSecid;
    @FXML   
    private TableColumn<Securities.Security, String>  columnActive;
    
    
    public void setExternalEventListner(IExternalEvent externalEventListner) {
        this.externalEventListner = externalEventListner;
    }

    public void setFlChoice(boolean flChoice) {
        this.flChoice = flChoice;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnShortName.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        columnSecTz.setCellValueFactory(new PropertyValueFactory<>("secTz"));    
        columnSeccode.setCellValueFactory(new PropertyValueFactory<>("seccode"));      
        columnBoard.setCellValueFactory(new PropertyValueFactory<>("board"));    
        columnDecimals.setCellValueFactory(new PropertyValueFactory<>("decimals"));    
        columnMarket.setCellValueFactory(new PropertyValueFactory<>("market"));       
        columnSectype.setCellValueFactory(new PropertyValueFactory<>("sectype"));     
        columnMinstep.setCellValueFactory(new PropertyValueFactory<>("minstep"));    
        columnLotsize.setCellValueFactory(new PropertyValueFactory<>("lotsize"));       
        columnPointCost.setCellValueFactory(new PropertyValueFactory<>("pointCost"));    
        columnQuotestype.setCellValueFactory(new PropertyValueFactory<>("quotestype"));     
        columnSecid.setCellValueFactory(new PropertyValueFactory<>("secid"));      
        columnActive.setCellValueFactory(new PropertyValueFactory<>("active")); 
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();   
  
        securityTableView.setItems(storageConfig.getSecuritiesConfig().getSecuritiesStorage().getObservableList());
    }   
    
    
 
    
    @FXML
    public void handleTableViewOnMouseClicked(MouseEvent event) {
        if (event.getClickCount()>1) {
            if (flChoice == true){
                externalEventListner.ExternalEvent(1, true);

                Stage stage = (Stage) securityTableView.getScene().getWindow();
                stage.close();                
            }

        }
    
    }
    
    public Securities.Security getSelectionElement(){
        
        TableView.TableViewSelectionModel<Securities.Security> selectionModel = securityTableView.getSelectionModel();
        return selectionModel.getSelectedItem();       
        
    }
    
}
