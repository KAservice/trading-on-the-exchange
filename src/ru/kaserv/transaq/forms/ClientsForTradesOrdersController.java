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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Client;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class ClientsForTradesOrdersController implements Initializable {
    
    
    private ClientsController choiceClientsController;
    

    
    @FXML
    TableView clientTableView;
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewMarket;    
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewCurrency;     
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewType;    
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewId;      
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewRemove; 
    @FXML
    private TableColumn<ClientForTradesOrders, String> columnClientTableViewUnion;   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        columnClientTableViewMarket.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getMarket());
                }
             });
        columnClientTableViewCurrency.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getCurrency());
                }
             });
        columnClientTableViewType.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getType());
                }
             });
        columnClientTableViewId.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getId());
                }
             });
        columnClientTableViewRemove.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getRemove());
                }
             });
        
        
        columnClientTableViewUnion.setCellValueFactory(new Callback<CellDataFeatures<ClientForTradesOrders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<ClientForTradesOrders, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getClient().getUnion());
                }
             });
              
        StorageConfig storageConfig = StorageConfig.getStorageConfig();       
        clientTableView.setItems(FXCollections.observableArrayList(storageConfig.getClientsForTradesOrders().getElements()));
        
    } 
    

    @FXML
    private void openTableSecurity(ActionEvent event) {  
        
        TableView.TableViewSelectionModel<ClientForTradesOrders> selectionModel = clientTableView.getSelectionModel();
        ClientForTradesOrders clientForTradesOrders = selectionModel.getSelectedItem();



        Stage newWindow = new Stage();    
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
          FXMLLoader loader = new FXMLLoader(getClass().getResource("SecuritiesForTradesOrders.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        SecuritiesForTradesOrdersController controller = loader.<SecuritiesForTradesOrdersController>getController();
        controller.setClientForTradesOrders(clientForTradesOrders);
            
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }



    @FXML
    private void handleNewClient(ActionEvent event) { 
               
    
        
        Stage newWindow = new Stage();    
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Clients.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        choiceClientsController = loader.<ClientsController>getController();
        
        choiceClientsController.setExternalEventListner(new EventHandler());
        choiceClientsController.setFlChoice(true);
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }  
    
    
    
    
    class EventHandler implements IExternalEvent{

        @Override
        public void ExternalEvent(int type, boolean vibor) {
            if (type == 1 ){
                if (choiceClientsController != null){
                    StorageConfig storageConfig = StorageConfig.getStorageConfig();       
                    Collection collClients = storageConfig.getClientsForTradesOrders().getElements();                    
                    Client client = choiceClientsController.getSelectionClient();
                    if (client != null){
                        ClientForTradesOrders clientForTradesOrders = new ClientForTradesOrders(client);
                        collClients.add(clientForTradesOrders);       
                        clientTableView.setItems(FXCollections.observableArrayList(storageConfig.getClientsForTradesOrders().getElements()));
                    }

                    
                }
                choiceClientsController = null;
            }
        }
        
    }
  
}

//initialize() {
//    personTableView.setItems(personTableViewData);

//    comboBox.valueProperty().addListener(new ChangeListener<String>() {
//        @Override public void changed(ObservableValue ov, String oldValue, String newValue) {
//            List<Person> filteredPersonList = 
//                           personList.stream().filter(person -> person.getFirstName().contains(newValue)).collect(Collectors.toList());

//            personTableViewData.setAll(filteredPersonList);
//        } 
//    }
