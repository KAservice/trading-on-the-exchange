/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import ru.kaserv.transaq.configuration.ConnectConfig;
import ru.kaserv.transaq.configuration.ConnectConfigBuilder;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class ConnectConfigFormController implements Initializable {

    @FXML     Label label1;
    
    @FXML     TextField loginTextField;
    @FXML     TextField hostTextField;
    @FXML     TextField passwordTextField;
    @FXML     Spinner<Integer> portSpinner;
    @FXML     Spinner<String> languageSpinner;
    @FXML     CheckBox autoposCheckBox;
    @FXML     CheckBox micexRegistersCheckBox;
    @FXML     CheckBox millisecondsCheckBox;
    @FXML     CheckBox utcTimeCheckBox;

    @FXML     Spinner<Integer> rqdelaySpinner;
    @FXML     Spinner<Integer> sessionTimeoutSpinner;
    @FXML     Spinner<Integer> requestTimeoutSpinner;
    @FXML     Spinner<Integer> pushULimitsSpinner;
    @FXML     Spinner<Integer> pushPosEquitySpinner;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SpinnerValueFactory<Integer> valueFactoryPortSpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        portSpinner.setValueFactory(valueFactoryPortSpinner);
        
       ObservableList<String> lang_list = FXCollections.observableArrayList("ru", "en");
       // Value factory.
       SpinnerValueFactory<String> valueFactoryLanguageSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(lang_list);      
       // Default value
       valueFactoryLanguageSpinner.setValue("ru"); 
       languageSpinner.setValueFactory(valueFactoryLanguageSpinner);       
        


        SpinnerValueFactory<Integer> valueFactoryRqdelaySpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        rqdelaySpinner.setValueFactory(valueFactoryRqdelaySpinner );
        
        SpinnerValueFactory<Integer> valueFactorySessionTimeoutSpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        sessionTimeoutSpinner.setValueFactory(valueFactorySessionTimeoutSpinner);
        
        SpinnerValueFactory<Integer> valueFactoryRequestTimeoutSpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        requestTimeoutSpinner.setValueFactory(valueFactoryRequestTimeoutSpinner);    
        
        SpinnerValueFactory<Integer> valueFactoryPushULimitsSpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        pushULimitsSpinner.setValueFactory(valueFactoryPushULimitsSpinner);
        
        SpinnerValueFactory<Integer> valueFactoryPushPosEquitySpinner =  new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 65536); 
        pushPosEquitySpinner.setValueFactory(valueFactoryPushPosEquitySpinner);        
        
        
    }  
    
    
    @FXML 
    void saveConnectConfig(){
        
        ConnectConfig cfg = new ConnectConfig();
        cfg.setLogin(loginTextField.getText());
        cfg.setPassword(passwordTextField.getText());
        cfg.setHost(hostTextField.getText());
        
        cfg.setPort((Integer) portSpinner.getValue());

        
        if (autoposCheckBox.isIndeterminate() == true){
        cfg.setAutopos(false);    
        }
        else{
            cfg.setAutopos(autoposCheckBox.isSelected());   
        }
        
        
        cfg.setLanguage(languageSpinner.getValue());
        cfg.setRqdelay(rqdelaySpinner.getValue());
        cfg.setSessionTimeout(sessionTimeoutSpinner.getValue());
        cfg.setRequestTimeout(requestTimeoutSpinner.getValue());
        cfg.setPushULimits(pushULimitsSpinner.getValue());
        cfg.setPushPosEquity(pushPosEquitySpinner.getValue());
        
        
        cfg.setMicexRegisters(micexRegistersCheckBox.isSelected());  
        cfg.setMilliseconds(millisecondsCheckBox.isSelected()); 
        cfg.setUtcTime(utcTimeCheckBox.isSelected()); 
 
    



        
        
        ConnectConfigBuilder cfg_builder = new ConnectConfigBuilder();
        
        cfg_builder.saveConnectConfig(cfg);
        
    }
    
    @FXML  
    public void loadConnectConfig(){
        
        ConnectConfig cfg = new ConnectConfig();       
        ConnectConfigBuilder cfg_builder = new ConnectConfigBuilder();
        
        cfg = cfg_builder.loadConnectConfig();        
        
        loginTextField.setText(cfg.getLogin());
        passwordTextField.setText(cfg.getPassword());
        hostTextField.setText(cfg.getHost());
        portSpinner.getValueFactory().setValue(cfg.getPort());
        
        
        autoposCheckBox.setSelected(cfg.getAutopos());
        
        
        languageSpinner.getValueFactory().setValue(cfg.getLanguage());
        rqdelaySpinner.getValueFactory().setValue(cfg.getRqdelay());
        sessionTimeoutSpinner.getValueFactory().setValue(cfg.getSessionTimeout());
        requestTimeoutSpinner.getValueFactory().setValue(cfg.getRequestTimeout());
        pushULimitsSpinner.getValueFactory().setValue(cfg.getPushULimits());
        pushPosEquitySpinner.getValueFactory().setValue(cfg.getPushPosEquity());
        
        
        micexRegistersCheckBox.setSelected(cfg.getMicexRegisters());
        millisecondsCheckBox.setSelected(cfg.getMilliseconds());
        utcTimeCheckBox.setSelected(cfg.getUtcTime());
        
        
    }
    
}
