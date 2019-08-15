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
import ru.kaserv.transaq.configuration.SecurityForCandles;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Securities;

/**
 * FXML Controller class
 *
 * @author 1
 */
public class SecuritiesForCandlesFormController implements Initializable {

   @FXML
    TableView securitiesTableView;
        
    @FXML
    private TableColumn<SecurityForCandles, String> columnShortName;
    @FXML
    private TableColumn<SecurityForCandles, String> columnSecTz;
    @FXML
    private TableColumn<SecurityForCandles, String>  columnSeccode;
    @FXML   
    private TableColumn<SecurityForCandles, String>  columnBoard;
    @FXML   
    private TableColumn<SecurityForCandles, String>  columnDecimals;
    @FXML
    private TableColumn<SecurityForCandles, String>  columnMarket;
    @FXML    
    private TableColumn<SecurityForCandles, String>  columnSectype;        
    @FXML
    private TableColumn<SecurityForCandles, String>  columnMinstep;
    @FXML
    private TableColumn<SecurityForCandles, String>  columnLotsize;
    @FXML    
    private TableColumn<SecurityForCandles, String>  columnPointCost;
    @FXML
    private TableColumn<SecurityForCandles, String> columnQuotestype;
    @FXML  
    private TableColumn<SecurityForCandles, String>  columnSecid;
    @FXML   
    private TableColumn<SecurityForCandles, String>  columnActive;     
    

        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        columnShortName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getShortname());
                }
        });    
        
        columnSecTz.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecTz());
                }
        });  
        columnSeccode.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSeccode());
                }
        });  
        columnBoard.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getBoard());
                }
        });   
        columnDecimals.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getDecimals());
                }
        });          
        columnMarket.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMarket());
                }
        });        
        columnSectype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSectype());
                }
        });        
        columnMinstep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getMinstep());
                }
        });           
        columnLotsize.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getLotsize());
                }
        });  
        columnPointCost.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getPointCost());
                }
        });         
        columnQuotestype.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getQuotestype());
                }
        });  
        columnSecid.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getSecid());
                }
        });  
        columnActive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SecurityForCandles, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SecurityForCandles, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSecurity().getActive());
                }
        });          
         
        
        StorageConfig storageConfig = StorageConfig.getStorageConfig();       
        securitiesTableView.setItems(FXCollections.observableArrayList(storageConfig.getSecuritiesForCandles().getElements()));
    } 
    
    

    @FXML
    private void openCandlesTableOn1Period(ActionEvent event) {
        
        TableView.TableViewSelectionModel<SecurityForCandles> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForCandles securityForCandles = selectionModel.getSelectedItem();



        Stage newWindow = new Stage(); 
        newWindow.setTitle("Период 1 свечи для инструмента: "+securityForCandles.getSecurity().getBoard()
                                            +" "+securityForCandles.getSecurity().getSeccode());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandlesForm.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        CandlesFormController controller = loader.<CandlesFormController>getController();
        controller.setCandlesStorage(securityForCandles.getCandlesStrorage1());
        controller.setLabelForm("Свечи по инструменту period 1: " +
                                    securityForCandles.getSecurity().getBoard()+
                                    " "+securityForCandles.getSecurity().getSeccode());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
    }
    
        @FXML
    private void openCandlesTableOn2Period(ActionEvent event) {
        
        TableView.TableViewSelectionModel<SecurityForCandles> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForCandles securityForCandles = selectionModel.getSelectedItem();



        Stage newWindow = new Stage(); 
        newWindow.setTitle("Период 2 свечи для инструмента: "+securityForCandles.getSecurity().getBoard()
                                            +" "+securityForCandles.getSecurity().getSeccode());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandlesForm.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        CandlesFormController controller = loader.<CandlesFormController>getController();
        controller.setCandlesStorage(securityForCandles.getCandlesStrorage2());
        controller.setLabelForm("Свечи по инструменту period 1: " +
                                    securityForCandles.getSecurity().getBoard()+
                                    " "+securityForCandles.getSecurity().getSeccode());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
    }
    
        @FXML
    private void openCandlesTableOn3Period(ActionEvent event) {
        
        TableView.TableViewSelectionModel<SecurityForCandles> selectionModel = securitiesTableView.getSelectionModel();
        SecurityForCandles securityForCandles = selectionModel.getSelectedItem();



        Stage newWindow = new Stage(); 
        newWindow.setTitle("Период 3 свечи для инструмента: "+securityForCandles.getSecurity().getBoard()
                                            +" "+securityForCandles.getSecurity().getSeccode());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandlesForm.fxml"));
        Parent root = null;
   
            try {
                root = loader.load();        
            }
            catch (IOException err){
                
                System.out.println("ошибка " + err);
                err.printStackTrace();
            }  

        CandlesFormController controller = loader.<CandlesFormController>getController();
        controller.setCandlesStorage(securityForCandles.getCandlesStrorage3());
        controller.setLabelForm("Свечи по инструменту period 1: " +
                                    securityForCandles.getSecurity().getBoard()+
                                    " "+securityForCandles.getSecurity().getSeccode());
            
            
        Scene scene = new Scene(root);        
        newWindow.setScene(scene);
        newWindow.show();
       }
        
  
}
