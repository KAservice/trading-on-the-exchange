/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.SecurityForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Securities;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class SecuritiesForTradesOrdersController implements Initializable {
    
    
    private ClientForTradesOrders clientForTradesOrders = null;
    
    private IExternalEvent externalEventListner;
    private boolean flChoice;
    
    private SecuritiesController choiceSecuritiesController;
    
    
    @FXML
    TableView securityTableView;
    @FXML
    private TableColumn<SecurityForTradesOrders, String> columnShortName;
    @FXML
    private TableColumn<SecurityForTradesOrders, String> columnSecTz;
    @FXML
    private TableColumn<SecurityForTradesOrders, String>  columnSeccode;
    @FXML   
    private TableColumn<SecurityForTradesOrders, String>  columnBoard;
    @FXML   
    private TableColumn<SecurityForTradesOrders, String>  columnDecimals;
    @FXML
    private TableColumn<SecurityForTradesOrders, String>  columnMarket;
    @FXML    
    private TableColumn<SecurityForTradesOrders, String>  columnSectype;        
    @FXML
    private TableColumn<SecurityForTradesOrders, String>  columnMinstep;
    @FXML
    private TableColumn<SecurityForTradesOrders, String>  columnLotsize;
    @FXML    
    private TableColumn<SecurityForTradesOrders, String>  columnPointCost;
    @FXML
    private TableColumn<SecurityForTradesOrders, String> columnQuotestype;
    @FXML  
    private TableColumn<SecurityForTradesOrders, String>  columnSecid;
    @FXML   
    private TableColumn<SecurityForTradesOrders, String>  columnActive;
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
            columnShortName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
             });    
            
            columnSecTz.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
             });  
            
            columnSeccode.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
             });    
            
            columnBoard.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
             });  
            columnDecimals.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
             });    
            
            columnMarket.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
             });  
            
            columnSectype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
             });    
            
            columnMinstep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
             });         
        
         
            
                columnMinstep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMinstep());
                }
             });    
            
            columnLotsize.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getLotsize());
                }
             });  
            columnPointCost.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getPointCost());
                }
             });    
            
            columnQuotestype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getQuotestype());
                }
             });  
            
            columnSecid.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecid());
                }
             });    
            
            columnActive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForTradesOrders, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getActive());
                }
             });     
        
             
        
    }  

    public void setClientForTradesOrders(ClientForTradesOrders clientForTradesOrders) {
        this.clientForTradesOrders = clientForTradesOrders;
        securityTableView.setItems(FXCollections.observableArrayList(clientForTradesOrders.getSecuritiesForTradesOrders()));
    }
    
    
    @FXML
    private void openTradesTable(ActionEvent event) { 
        
        TableView.TableViewSelectionModel<SecurityForTradesOrders> selectionModel = securityTableView.getSelectionModel();
        SecurityForTradesOrders securityForTradesOrders = selectionModel.getSelectedItem();



        Stage newWindow = new Stage();    

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Trades.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
                
            }

        TradesController controller = loader.<TradesController>getController();
        controller.setTradesStorage(securityForTradesOrders.getTradesStorage());
        controller.setLabelForm("Сделки для инструмента: "+securityForTradesOrders.getSecurity().getBoard()+" "+securityForTradesOrders.getSecurity().getSeccode()+
                ", клиент: "+clientForTradesOrders.getClient().getId());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
          
         
    }
    
    @FXML
    private void openOrdersTable(ActionEvent event){
        
        TableView.TableViewSelectionModel<SecurityForTradesOrders> selectionModel = securityTableView.getSelectionModel();
        SecurityForTradesOrders securityForTradesOrders = selectionModel.getSelectedItem();



        Stage newWindow = new Stage();    

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Orders.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
                
            }

        OrdersController controller = loader.<OrdersController>getController();
        controller.setOrdersStorage(securityForTradesOrders.getOrdersStorage());
        controller.setLabelForm("Заявки для инструмента: "+securityForTradesOrders.getSecurity().getBoard()+" "+securityForTradesOrders.getSecurity().getSeccode()+
                ", клиент: "+clientForTradesOrders.getClient().getId());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();

    }
    
    
        @FXML
    private void handleNewElement(ActionEvent event) { 
               
    
        
        Stage newWindow = new Stage();    
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Securities.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        choiceSecuritiesController = loader.<SecuritiesController>getController();
        
        choiceSecuritiesController.setExternalEventListner(new EventHandler());
        choiceSecuritiesController.setFlChoice(true);
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }  
    
    
    
    
    class EventHandler implements IExternalEvent{

        @Override
        public void ExternalEvent(int type, boolean vibor) {
            if (type == 1 ){
                if (choiceSecuritiesController != null){
                    StorageConfig storageConfig = StorageConfig.getStorageConfig();       
                    Collection collSecurities = clientForTradesOrders.getSecuritiesForTradesOrders();  
                    
                    Securities.Security security = choiceSecuritiesController.getSelectionElement();
                    if (security != null){
                        SecurityForTradesOrders securityForTradesOrders = new SecurityForTradesOrders(security);
                        collSecurities.add(securityForTradesOrders);       
                        securityTableView.setItems(FXCollections.observableArrayList(clientForTradesOrders.getSecuritiesForTradesOrders()));
                    }

                    
                }
                choiceSecuritiesController = null;
            }
        }
        
    }
    

    
}
