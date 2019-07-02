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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.kaserv.transaq.command.NewOrderCommand;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.OrderToBrokerStorage;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class OrderToBrokerTableFormController implements Initializable {
    
    private OrderToBrokerStorage ordersStorage;
    
    private IExternalEvent externalEventListner;
    private boolean flChoice;
    
    private Client client;
    private Securities.Security security;

    
    @FXML
    TableView orderTableView;
    
    @FXML
    Label captionLabel;
    
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewBoard; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewSeccode; 
    
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewClient;     
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewUnion; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewPrice; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewHidden; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewQuantity;
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewBuysell; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewBrokerref;
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewUnifilled; 
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewExpdate;
    @FXML
    private TableColumn<NewOrderCommand, String> columnOrderTableViewTransactionid; 
    
    
    OrderToBrokerElementFormController orderToBrokerElementFormController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnOrderTableViewBoard.setCellValueFactory(new Callback<CellDataFeatures<NewOrderCommand, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<NewOrderCommand, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getBoard());
                }
        });  
        
        columnOrderTableViewSeccode.setCellValueFactory(new Callback<CellDataFeatures<NewOrderCommand, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<NewOrderCommand, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSeccode());
                }
        });
        
        
    columnOrderTableViewClient.setCellValueFactory(new PropertyValueFactory<>("client")); 
    columnOrderTableViewUnion.setCellValueFactory(new PropertyValueFactory<>("union"));
    columnOrderTableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price")); 
    columnOrderTableViewHidden.setCellValueFactory(new PropertyValueFactory<>("hidden"));

    
    columnOrderTableViewQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity")); 
    columnOrderTableViewBuysell.setCellValueFactory(new PropertyValueFactory<>("buysell"));
    columnOrderTableViewBrokerref.setCellValueFactory(new PropertyValueFactory<>("brokerref")); 
    columnOrderTableViewUnifilled.setCellValueFactory(new PropertyValueFactory<>("unifilled"));
    columnOrderTableViewExpdate.setCellValueFactory(new PropertyValueFactory<>("expdate")); 
    columnOrderTableViewTransactionid.setCellValueFactory(new PropertyValueFactory<>("transactionid"));

  

    }



    public void setOrdersStorage(OrderToBrokerStorage ordersStorage) {
        this.ordersStorage = ordersStorage;
        orderTableView.setItems(ordersStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    }  
    
    
        @FXML
    private void handleNewOrderToBroker(ActionEvent event) { 
               
    
        
        Stage newWindow = new Stage();    
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderToBrokerElementForm.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        orderToBrokerElementFormController = loader.getController();        
        orderToBrokerElementFormController.setExternalEventListner(new EventHandler());
        orderToBrokerElementFormController.setFlChoice(true);
        orderToBrokerElementFormController.setClient(client);
        orderToBrokerElementFormController.setSecurity(security);
        orderToBrokerElementFormController.setOrdersStorage(ordersStorage);
        
        NewOrderCommand command = new NewOrderCommand();
        orderToBrokerElementFormController.setNewOrderCommand(command);
        orderToBrokerElementFormController.updateForm();
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }  
    
    
    
    
    class EventHandler implements IExternalEvent{

        @Override
        public void ExternalEvent(int type, boolean vibor) {
            if (type == 1 ){
  
            }
        }
        
    } 

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurity(Securities.Security security) {
        this.security = security;
    }
    
    
    
    
}
