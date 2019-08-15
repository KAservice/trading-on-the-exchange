/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.kaserv.transaq.command.ClientLimitsCommand;
import ru.kaserv.transaq.command.PortfolioTplusCommand;
import ru.kaserv.transaq.command.PortfolioUnitedCommand;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.ClientLimits;
import ru.kaserv.transaq.object.PortfolioTplus;
import ru.kaserv.transaq.object.PortfolioUnited;
import ru.kaserv.transaq.storage.ClientLimitsStorage;
import ru.kaserv.transaq.storage.PortfolioTplusStorage;
import ru.kaserv.transaq.storage.PortfolioUnitedStorage;
import transaq.TransaqConnector;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class ClientsController implements Initializable {
    
    private IExternalEvent externalEventListner;
    private boolean flChoice;
    
    @FXML
    Button buttonChoiceClient;
    
    @FXML
    TableView clientTableView;
    @FXML
    private TableColumn<Client, String> columnClientTableViewMarket;    
    @FXML
    private TableColumn<Client, String> columnClientTableViewCurrency;     
    @FXML
    private TableColumn<Client, String> columnClientTableViewType;    
    @FXML
    private TableColumn<Client, String> columnClientTableViewId;      
    @FXML
    private TableColumn<Client, String> columnClientTableViewRemove;  
    

 
    @FXML
    private TableColumn<Client, String> columnClientTableViewUnion;      
    @FXML
    private TableColumn<Client, String> columnClientTableViewFortsAcc;   
    
    

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
        
        
        columnClientTableViewMarket.setCellValueFactory(new PropertyValueFactory<>("market"));    
        columnClientTableViewCurrency.setCellValueFactory(new PropertyValueFactory<>("currency"));        
        columnClientTableViewType.setCellValueFactory(new PropertyValueFactory<>("type")); 
        columnClientTableViewId.setCellValueFactory(new PropertyValueFactory<>("id")); 
        columnClientTableViewRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));
        columnClientTableViewUnion.setCellValueFactory(new PropertyValueFactory<>("union")); 
        columnClientTableViewFortsAcc.setCellValueFactory(new PropertyValueFactory<>("fortsAcc"));
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();   
        clientTableView.setItems(storageConfig.getClientsStorageConfig().getClientsStorage().getObservableList());
    }


    @FXML
    private void handleButtonSendQueryPortfolioTplusAction(ActionEvent event) { 
        
        PortfolioTplusCommand portfolioTplusCommand = new PortfolioTplusCommand();
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
           if (client != null){
            TransaqConnector.getTransaqConnector().sendCommandToServer(portfolioTplusCommand.createCommandGetPortfolioTplus(client.getId()));
           }
        
        } 
    
    @FXML
    private void handleButtonOpenPortfolioTplusAction(ActionEvent event) { 
        
       // PortfolioTplusCommand portfolioTplusCommand = new PortfolioTplusCommand();
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
        
           if (client != null){
                PortfolioTplusStorage portfolioTlusStorage = StorageConfig.getStorageConfig().getPortfolioTplusStorageConfig().getPortfolioTplusStorage();
                PortfolioTplus  portfolioTplus = portfolioTlusStorage.getPortfolioTplusByIdClient(client.getId());
                
                if (portfolioTplus != null){
                    
                    Stage newWindow = new Stage(); 
                    newWindow.setTitle("Портфолио клиента: "+client.getId());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PortfolioTplus.fxml"));
                    Parent root = null;

                        try {
                            root = loader.load();        
                        }
                        catch (IOException err){

                            System.out.println("ошибка " + err);
                            err.printStackTrace();
                        }  

                    PortfolioTplusController controller = loader.<PortfolioTplusController>getController();
                    controller.setPortfolioTplus(portfolioTplus);

                    Scene scene = new Scene(root);        
                    newWindow.setScene(scene);
                    newWindow.show();
                    }  
                else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Нет портфолио");
                    alert.setHeaderText("У данного клиента возможно не был запрошен клиентский потрфель");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();

                }
                        
    
            }
           else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Выберите клиента!");
                    alert.setHeaderText("No Person Selected");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();
           }
        

    }   
    
    
    
    
    
    
    @FXML
    private void handleButtonSendQueryPortfolioUnitedAction(ActionEvent event) { 
        
        PortfolioUnitedCommand command = new PortfolioUnitedCommand();
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
           if (client != null){
            TransaqConnector.getTransaqConnector().sendCommandToServer(command.createCommandGetPortfolioUnited("", client.getUnion()));
           }
        
        } 
    
    @FXML
    private void handleButtonOpenPortfolioUnitedAction(ActionEvent event) { 
        
        //PortfolioTplusCommand portfolioTplusCommand = new PortfolioTplusCommand();
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
        
           if (client != null){
                PortfolioUnitedStorage portfolioUnitedStorage = StorageConfig.getStorageConfig().getPortfolioUnitedStorageConfig().getPortfolioUnitedStorage();
                PortfolioUnited  portfolioUnited = portfolioUnitedStorage.getPortfolioUnitedByIdClient(client.getId());
                
                if (portfolioUnited != null){
                    
                    Stage newWindow = new Stage(); 
                    newWindow.setTitle("Портфолио объединенный клиента: "+client.getId());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PortfolioUnited.fxml"));
                    Parent root = null;

                        try {
                            root = loader.load();        
                        }
                        catch (IOException err){

                            System.out.println("ошибка " + err);
                            err.printStackTrace();
                        }  

                    PortfolioUnitedController controller = loader.<PortfolioUnitedController>getController();
                    controller.setPortfolioTplus(portfolioUnited);

                    Scene scene = new Scene(root);        
                    newWindow.setScene(scene);
                    newWindow.show();
                    }  
                else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Нет портфолио");
                    alert.setHeaderText("У данного клиента возможно не был запрошен объединенный потрфель");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();

                }
                        
    
            }
           else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Выберите клиента!");
                    alert.setHeaderText("No Person Selected");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();
           }
        

    }   
    
    
    
    
    @FXML
    private void handleButtonSendQueryClientLimitsAction(ActionEvent event) { 
        
        ClientLimitsCommand command = new ClientLimitsCommand();
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
           if (client != null){
            TransaqConnector.getTransaqConnector().sendCommandToServer(command.createCommandGetClientLimits(client.getId()));
           }
        
        } 
    
    @FXML
    private void handleButtonOpenClientLimitsAction(ActionEvent event) { 
        
   
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        Client client = selectionModel.getSelectedItem();
        
           if (client != null){
                ClientLimitsStorage clientLimitsStorage = StorageConfig.getStorageConfig().getClientLimitsStorageConfig().getClientLimitsStorage();
                ClientLimits  clientLimits = clientLimitsStorage.getClientLimitsByIdClient(client.getId());
                
                if (clientLimits != null){
                    
                    Stage newWindow = new Stage();
                    newWindow.setTitle("Лимиты клиента: "+client.getId());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientLimits.fxml"));
                    Parent root = null;

                        try {
                            root = loader.load();        
                        }
                        catch (IOException err){

                            System.out.println("ошибка " + err);
                            err.printStackTrace();
                        }  

                    ClientLimitsController controller = loader.<ClientLimitsController>getController();
                    controller.setClientLimits(clientLimits);

                    Scene scene = new Scene(root);        
                    newWindow.setScene(scene);
                    newWindow.show();
                    }  
                else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Нет портфолио");
                    alert.setHeaderText("У данного клиента возможно не был запрошен лимит");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();

                }
                        
    
            }
           else{
                    Alert alert = new Alert(AlertType.WARNING);
                    //alert.initOwner(mainApp.getPrimaryStage());
                    alert.setTitle("Выберите клиента!");
                    alert.setHeaderText("No Person Selected");
                    alert.setContentText("Please select a person in the table.");
                    alert.showAndWait();
           }
        

    } 
    
    @FXML
    private void handleSelectionClient(ActionEvent event) { 
        
   
        externalEventListner.ExternalEvent(1, true);
        
        Stage stage = (Stage) buttonChoiceClient.getScene().getWindow();
        stage.close();
    } 
    
    @FXML
    public void handleTableViewOnMouseClicked(MouseEvent event) {
        if (event.getClickCount()>1) {
            if (flChoice == true){
                externalEventListner.ExternalEvent(1, true);

                Stage stage = (Stage) buttonChoiceClient.getScene().getWindow();
                stage.close();                
            }

        }
    
    }
    
    public Client getSelectionClient(){
        
        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        return selectionModel.getSelectedItem();       
        
    }
    
}
