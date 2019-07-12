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
import ru.kaserv.transaq.command.SubscribeCommand;
import ru.kaserv.transaq.command.SubscribeCommandSender;
import ru.kaserv.transaq.configuration.SecurityForAllTrades;
import ru.kaserv.transaq.configuration.SecurityForQuotes;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Securities;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class SecuritiesForQuotesController implements Initializable {

    
    @FXML
    TableView securitiesTableView;
        
    @FXML
    private TableColumn<SecurityForQuotes, String> columnShortName;
    @FXML
    private TableColumn<SecurityForQuotes, String> columnSecTz;
    @FXML
    private TableColumn<SecurityForQuotes, String>  columnSeccode;
    @FXML   
    private TableColumn<SecurityForQuotes, String>  columnBoard;
    @FXML   
    private TableColumn<SecurityForQuotes, String>  columnDecimals;
    @FXML
    private TableColumn<SecurityForQuotes, String>  columnMarket;
    @FXML    
    private TableColumn<SecurityForQuotes, String>  columnSectype;        
    @FXML
    private TableColumn<SecurityForQuotes, String>  columnMinstep;
    @FXML
    private TableColumn<SecurityForQuotes, String>  columnLotsize;
    @FXML    
    private TableColumn<SecurityForQuotes, String>  columnPointCost;
    @FXML
    private TableColumn<SecurityForQuotes, String> columnQuotestype;
    @FXML  
    private TableColumn<SecurityForQuotes, String>  columnSecid;
    @FXML   
    private TableColumn<SecurityForQuotes, String>  columnActive;        
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        columnShortName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
        });    
        
        columnSecTz.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
        });  
        columnSeccode.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSeccode());
                }
        });  
        columnBoard.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getBoard());
                }
        });   
        columnDecimals.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getDecimals());
                }
        });          
        columnMarket.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMarket());
                }
        });        
        columnSectype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSectype());
                }
        });        
        columnMinstep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMinstep());
                }
        });           
        columnLotsize.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getLotsize());
                }
        });  
        columnPointCost.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getPointCost());
                }
        });         
        columnQuotestype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getQuotestype());
                }
        });  
        columnSecid.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecid());
                }
        });  
        columnActive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForQuotes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForQuotes, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getActive());
                }
        });          
         
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();       
        securitiesTableView.setItems(FXCollections.observableArrayList(storageConfig.getSecuritiesForQuotes().getElements()));
    } 
    
    

    @FXML
    private void openQuotesTable(ActionEvent event) {
        
        TableView.TableViewSelectionModel<SecurityForQuotes> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForQuotes securityForQuotes = selectionModel.getSelectedItem();



        Stage newWindow = new Stage();    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Quotes.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        QuotesController controller = loader.<QuotesController>getController();
        controller.setQuotesStorage(securityForQuotes.getQuotesStorage());
        controller.setLabelForm("Стакан по инструменту: " +
                                    securityForQuotes.getSecurity().getBoard()+
                                    " "+securityForQuotes.getSecurity().getSeccode());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
        }
        
    @FXML
    public void handleUnSubscribeForQuotes (ActionEvent event){
        
        TableView.TableViewSelectionModel<SecurityForQuotes> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForQuotes security_for_quotes = selectionModel.getSelectedItem(); 
        
        Securities.Security security = security_for_quotes.getSecurity();
        
        SubscribeCommand command =  new SubscribeCommand();
        command.setId("unsubscribe");
                
        SubscribeCommand.Quotes quotes = new SubscribeCommand.Quotes();        
        SubscribeCommand.Quotes.Security sec = new SubscribeCommand.Quotes.Security();
        sec.setBoard(security.getBoard());
        sec.setSeccode(security.getSeccode());
        
        quotes.getSecurity().add(sec);  
        
        command.setQuotes(quotes);

        SubscribeCommandSender sender = new SubscribeCommandSender();
        sender.sendCommand(command);
  
    }
}
