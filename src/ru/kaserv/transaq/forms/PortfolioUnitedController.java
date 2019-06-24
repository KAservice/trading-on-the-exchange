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
import javafx.scene.control.TextField;
import ru.kaserv.transaq.object.PortfolioUnited;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class PortfolioUnitedController implements Initializable {

    private PortfolioUnited portfolio;
    
    @FXML
    Label captionLabel;
    @FXML
    Label label1;
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    @FXML
    TextField textField3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    
    
    
    public void setPortfolioTplus(PortfolioUnited portfolio) {
        this.portfolio = portfolio;
        //orderTableView.setItems(ordersStorage.getObservableList());
        updateForm();
    }
    
    
    
    private void updateForm(){
        
    captionLabel.setText(portfolio.getClient());

    label1.setText(String.valueOf(portfolio.getChrgoffIr()));

    textField1.setText(String.valueOf(portfolio.getChrgoffMr()));

    textField2.setText(String.valueOf(portfolio.getEquity()));

    textField3.setText(String.valueOf(portfolio.getFinres()));       
        
        
    }
}
