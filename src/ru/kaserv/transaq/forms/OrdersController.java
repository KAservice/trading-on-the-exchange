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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.storage.OrdersStorage;
import ru.kaserv.transaq.storage.TradesStorage;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class OrdersController implements Initializable {
    
    
    private OrdersStorage ordersStorage;
    @FXML
    TableView orderTableView;
    
    
    @FXML
    Label captionLabel;
    
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewOrderno;     
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewSecid;  
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewBoard;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewSeccode;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewClient;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewUnion;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewStatus;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewBuysell;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewTime;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewExpdate;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewOrigin_orderno;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewAccepttime;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewBrokerref;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewValue;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewAccruedint;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewSettlecode;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewBalance;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewPrice;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewQuantity;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewHidden;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewYield;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewWithdrawtime;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewCondition;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewConditionvalue;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewValidafter;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewValidbefore;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewMaxcomission;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewResult;
    @FXML
    private TableColumn<Orders.Order, String> columnOrderTableViewTransactionid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnOrderTableViewOrderno.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("orderno"));  
        columnOrderTableViewSecid.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("secid"));  
        columnOrderTableViewBoard.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("board"));
        columnOrderTableViewSeccode.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("seccode"));
        columnOrderTableViewClient.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("client"));
        columnOrderTableViewUnion.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("union"));
        columnOrderTableViewStatus.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("status"));
        columnOrderTableViewBuysell.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("buysell"));
        columnOrderTableViewTime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("time"));
        columnOrderTableViewExpdate.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("expdate"));
        columnOrderTableViewOrigin_orderno.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("origin_orderno"));
        columnOrderTableViewAccepttime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("accepttime"));
        columnOrderTableViewBrokerref.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("brokerref"));
        columnOrderTableViewValue.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("value"));
        columnOrderTableViewAccruedint.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("accruedint"));
        columnOrderTableViewSettlecode.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("settlecode"));
        columnOrderTableViewBalance.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("balance"));
        columnOrderTableViewPrice.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("price"));
        columnOrderTableViewQuantity.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("quantity"));
        columnOrderTableViewHidden.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("hidden"));
        columnOrderTableViewYield.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("yield"));
        columnOrderTableViewWithdrawtime.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("withdrawtime"));
        columnOrderTableViewCondition.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("condition"));
        columnOrderTableViewConditionvalue.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("conditionvalue"));
        columnOrderTableViewValidafter.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("validafter"));
        columnOrderTableViewValidbefore.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("validbefore"));
        columnOrderTableViewMaxcomission.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("maxcomission"));
        columnOrderTableViewResult.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("result"));
        columnOrderTableViewTransactionid.setCellValueFactory(new PropertyValueFactory<Orders.Order, String>("transactionid"));
    }   
    
    public void setOrdersStorage(OrdersStorage ordersStorage) {
        this.ordersStorage = ordersStorage;
        orderTableView.setItems(ordersStorage.getObservableList());
    }
    
    
    public void setLabelForm(String caption) { 

     captionLabel.setText(caption);

    }   
    
}
