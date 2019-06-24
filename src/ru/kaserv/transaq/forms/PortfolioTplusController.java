/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.forms;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import ru.kaserv.transaq.configuration.ClientForTradesOrders;
import ru.kaserv.transaq.object.PortfolioTplus;


/**
 * FXML Controller class
 *
 * @author 1
 */
public class PortfolioTplusController implements Initializable {
    
    private PortfolioTplus portfolioTplus;
    
    @FXML     Label captionLabel;
    @FXML     Label label1;
    @FXML     TextField textField1;
    @FXML     TextField textField2;
    @FXML     TextField textField3;
    
    @FXML     TextField textField4;
    
    
    @FXML   TableView securitiesTableView;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewMarket;   
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewSeccode;  
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewPrice; 
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewOpenBalance;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewBought;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewSold;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewBalance;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewBalancePrc;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewUnrealizedPnl;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewBuying;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewSelling;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewCover; 
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewInitMargin;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewRiskrateLong;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewRiskrateShort;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewPnlIncome;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewPnlIntraday;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewMaxbuy;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewMaxsell;
    @FXML   private TableColumn<PortfolioTplus.Security, String> columnClientTableViewSecid;
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        columnClientTableViewMarket.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getMarket());
                }
             });        
        
        columnClientTableViewSeccode.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSeccode());
                }
             });        
        
        columnClientTableViewPrice.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getPrice());
                }
             }); 
        
        columnClientTableViewOpenBalance.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getOpenBalance());
                }
             });    
        
        columnClientTableViewBought.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getBought());
                }
             });   
        
        columnClientTableViewSold.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSold());
                }
             });   
        
        columnClientTableViewBalance.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getBalance());
                }
             }); 
        
        columnClientTableViewBalancePrc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getBalancePrc());
                }
             }); 
        
        columnClientTableViewUnrealizedPnl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getUnrealizedPnl());
                }
             }); 
        
        columnClientTableViewBuying.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getBuying());
                }
             }); 
        
        columnClientTableViewSelling.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSelling());
                }
             }); 
        columnClientTableViewCover.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getCover());
                }
             }); 
        
        columnClientTableViewInitMargin.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getInitMargin());
                }
             });        
        
        columnClientTableViewRiskrateLong.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getRiskrateLong());
                }
             });            
        
        columnClientTableViewRiskrateShort.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getRiskrateShort());
                }
             });
        
        
        columnClientTableViewPnlIncome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getPnlIncome());
                }
             });   
        
        
        columnClientTableViewPnlIntraday.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getPnlIntraday());
                }
             });    
        
        columnClientTableViewMaxbuy.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getMaxbuy());
                }
             });          
        
        columnClientTableViewMaxsell.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getMaxsell());
                }
             });  
        
        columnClientTableViewSecid.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PortfolioTplus.Security, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PortfolioTplus.Security, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecid());
                }
             }); 
  

    }    
    
    
    public void setPortfolioTplus(PortfolioTplus portfolio) {
        this.portfolioTplus = portfolio;
        securitiesTableView.setItems(FXCollections.observableArrayList(portfolio.getSecurity()));
        updateForm();
        
        
    }
    
    
    
    private void updateForm(){
        
    captionLabel.setText(portfolioTplus.getClient());

    label1.setText(portfolioTplus.getCover().toString());

    textField1.setText(portfolioTplus.getCoverageCrit().toString());

    textField2.setText(portfolioTplus.getCoverageFact().toString());

    textField3.setText(portfolioTplus.getCoveragePlan().toString()); 
    
    textField4.setText(portfolioTplus.getOpenEquity().toString()); 

    }
}
