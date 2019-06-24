/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.kaserv.transaq.configuration.SecurityForAllTrades;
import ru.kaserv.transaq.configuration.StorageConfig;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class SecuritiesForAllTradesController implements Initializable {
    
    
    @FXML
    TableView securitiesTableView;
        
    @FXML
    private TableColumn<SecurityForAllTrades, String> columnShortName;
    @FXML
    private TableColumn<SecurityForAllTrades, String> columnSecTz;
    @FXML
    private TableColumn<SecurityForAllTrades, String>  columnSeccode;
    @FXML   
    private TableColumn<SecurityForAllTrades, String>  columnBoard;
    @FXML   
    private TableColumn<SecurityForAllTrades, String>  columnDecimals;
    @FXML
    private TableColumn<SecurityForAllTrades, String>  columnMarket;
    @FXML    
    private TableColumn<SecurityForAllTrades, String>  columnSectype;        
    @FXML
    private TableColumn<SecurityForAllTrades, String>  columnMinstep;
    @FXML
    private TableColumn<SecurityForAllTrades, String>  columnLotsize;
    @FXML    
    private TableColumn<SecurityForAllTrades, String>  columnPointCost;
    @FXML
    private TableColumn<SecurityForAllTrades, String> columnQuotestype;
    @FXML  
    private TableColumn<SecurityForAllTrades, String>  columnSecid;
    @FXML   
    private TableColumn<SecurityForAllTrades, String>  columnActive;        
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        columnShortName.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
        });    
        
        columnSecTz.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
        });  
        columnSeccode.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSeccode());
                }
        });  
        columnBoard.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getBoard());
                }
        });   
        columnDecimals.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getDecimals());
                }
        });          
        columnMarket.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMarket());
                }
        });        
        columnSectype.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSectype());
                }
        });        
        columnMinstep.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMinstep());
                }
        });           
        columnLotsize.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getLotsize());
                }
        });  
        columnPointCost.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getPointCost());
                }
        });         
        columnQuotestype.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getQuotestype());
                }
        });  
        columnSecid.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecid());
                }
        });  
        columnActive.setCellValueFactory(new Callback<CellDataFeatures<SecurityForAllTrades, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<SecurityForAllTrades, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getActive());
                }
        });          
         
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();       
        securitiesTableView.setItems(FXCollections.observableArrayList(storageConfig.getSecuritiesForAllTrades().getElements()));
    } 
    
    

    @FXML
    private void openAllTradesTable(ActionEvent event) {
        
        TableView.TableViewSelectionModel<SecurityForAllTrades> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForAllTrades securityForAllTrades = selectionModel.getSelectedItem();



        Stage newWindow = new Stage();    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllTrades.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        AllTradesController controller = loader.<AllTradesController>getController();
        controller.setAlltradesStorage(securityForAllTrades.getAllTradesStorage());
        controller.setLabelForm("Все сделки по инструменту: " +
                                    securityForAllTrades.getSecurity().getBoard()+
                                    " "+securityForAllTrades.getSecurity().getSeccode());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
        

    
}
