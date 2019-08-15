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
import ru.kaserv.transaq.object.Candlekinds;
import ru.kaserv.transaq.object.Securities;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class CandlekindsFormController implements Initializable {

    private IExternalEvent externalEventListner;
    private boolean flChoice;

    
    @FXML
    TableView candlekindsTableView;
    @FXML
    private TableColumn<Candlekinds.Kind, String> columnCandlekindTableViewId;
    @FXML
    private TableColumn<Candlekinds.Kind, String> columnCandlekindTableViewPeriod;  
    @FXML
    private TableColumn<Candlekinds.Kind, String> columnCandlekindTableViewName; 
    
    
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
        
        
        columnCandlekindTableViewId.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("id"));
        columnCandlekindTableViewPeriod.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("period"));
        columnCandlekindTableViewName.setCellValueFactory(new PropertyValueFactory<Candlekinds.Kind, String>("name"));

        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();   
        candlekindsTableView.setItems(storageConfig.getCandlekindsStorageConfig().getStorage().getObservableList());
    }   
    
    
 
    
    @FXML
    public void handleTableViewOnMouseClicked(MouseEvent event) {
        if (event.getClickCount()>1) {
            if (flChoice == true){
                externalEventListner.ExternalEvent(1, true);

                Stage stage = (Stage) candlekindsTableView.getScene().getWindow();
                stage.close();                
            }

        }
    
    }
    
    public Candlekinds.Kind getSelectionElement(){
        
        TableView.TableViewSelectionModel<Candlekinds.Kind> selectionModel = candlekindsTableView.getSelectionModel();
        return selectionModel.getSelectedItem();       
        
    }   
    
}
