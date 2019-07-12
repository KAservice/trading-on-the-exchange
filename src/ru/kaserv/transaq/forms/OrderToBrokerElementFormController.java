/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;


import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import ru.kaserv.transaq.command.NewOrderCommand;
import ru.kaserv.transaq.command.NewOrderCommandSender;
import ru.kaserv.transaq.command.XmlCommandFactory;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.OrderToBrokerStorage;
import transaq.TransaqConnector;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class OrderToBrokerElementFormController implements Initializable {
    
    private OrderToBrokerStorage ordersStorage;
    
    private IExternalEvent externalEventListner;
    private boolean flChoice;
    private Client client;
    private Securities.Security security;
    
    private NewOrderCommand newOrderCommand;

    @FXML
    private Button okButton;
    @FXML
    private RadioButton sellRadioButton;
    @FXML
    private RadioButton buyRadioButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;
    
    private ToggleGroup groupBS;
    
    @FXML private Label boardLabel;
    @FXML private Label seccodeLabel;
    @FXML private Label unionLabel;
    @FXML private Label clientLabel;
    
    @FXML
    private RadioButton putInQueueRadioButton;
    @FXML
    private RadioButton fOKRadioButton;
    @FXML
    private RadioButton iOCRadioButton;
    
    private ToggleGroup groupUnfilled;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        groupBS = new ToggleGroup();
        // set the group
        sellRadioButton.setToggleGroup(groupBS);
        buyRadioButton.setToggleGroup(groupBS);
        
        
        groupUnfilled = new ToggleGroup();
        // set the group
        putInQueueRadioButton.setToggleGroup(groupUnfilled);
        fOKRadioButton.setToggleGroup(groupUnfilled);
        iOCRadioButton.setToggleGroup(groupUnfilled);

    }   
    
    public void setExternalEventListner(IExternalEvent externalEventListner) {
        this.externalEventListner = externalEventListner;
    }

    public void setFlChoice(boolean flChoice) {
        this.flChoice = flChoice;
    }    
    
    @FXML 
    private void handleClickOnButtonOk(ActionEvent event) {
        
        RadioButton selection = (RadioButton) groupBS.getSelectedToggle();
        
        if (selection.equals(sellRadioButton) == true){
            newOrderCommand.setBuysell("S");
        }
        
        if (selection.equals(buyRadioButton) == true){
            newOrderCommand.setBuysell("B");
        }

        selection = (RadioButton) groupUnfilled.getSelectedToggle();
        
        if (selection.equals(putInQueueRadioButton) == true){
            newOrderCommand.setUnfilled("PutInQueue");
        }
        
        if (selection.equals(fOKRadioButton) == true){
            newOrderCommand.setUnfilled("FOK");
        }
        
        if (selection.equals(iOCRadioButton) == true){
            newOrderCommand.setUnfilled("IOC");
        }

        
        newOrderCommand.setClient(client.getId());
        newOrderCommand.setUnion(client.getUnion());
        newOrderCommand.getSecurity().setBoard(security.getBoard());
        newOrderCommand.getSecurity().setSeccode(security.getSeccode());
        newOrderCommand.setPrice(new BigDecimal(priceTextField.getText()));
        newOrderCommand.setQuantity(Integer.parseInt(quantityTextField.getText()));
        
        NewOrderCommandSender sender = new NewOrderCommandSender();
        
        if (sender.sendCommand(newOrderCommand) ==  true){
            newOrderCommand.setTransactionid(sender.getTransactionId());
            ordersStorage.add(newOrderCommand);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();             
            
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Новая заявка");
            alert.setHeaderText("Создание новой заявки");
            alert.setContentText("Ошибка при создании новой заявки");
            alert.showAndWait();
        }           
   
    }
    
    @FXML 
    private void handleClickOnButtonCancel(ActionEvent event) { 
        
    }
    
    public void updateForm(){
        
        boardLabel.setText(newOrderCommand.getSecurity().getBoard());
        seccodeLabel.setText(newOrderCommand.getSecurity().getSeccode());
        unionLabel.setText(newOrderCommand.getUnion());
        clientLabel.setText(newOrderCommand.getClient());        
        
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurity(Securities.Security security) {
        this.security = security;
    }

    public void setNewOrderCommand(NewOrderCommand newOrderCommand) {
        this.newOrderCommand = newOrderCommand;
    }

    public void setOrdersStorage(OrderToBrokerStorage ordersStorage) {
        this.ordersStorage = ordersStorage;
    }
    
   
    
}
