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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ru.kaserv.transaq.command.NewOrderCommand;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.storage.OrderToBrokerStorage;

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
    private RadioButton sellRadioButton;
    @FXML
    private RadioButton buyRadioButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setExternalEventListner(IExternalEvent externalEventListner) {
        this.externalEventListner = externalEventListner;
    }

    public void setFlChoice(boolean flChoice) {
        this.flChoice = flChoice;
    }    
    
    @FXML 
    private void handleClickOnButtonOk(ActionEvent event) {
        
        
        newOrderCommand.setPrice(new BigDecimal(priceTextField.getText()));
        newOrderCommand.setQuantity(Integer.parseInt(quantityTextField.getText()));
        ordersStorage.add(newOrderCommand);
    }
    
    @FXML 
    private void handleClickOnButtonCancel(ActionEvent event) { 
        
    }
    
    public void updateForm(){
        
        
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
