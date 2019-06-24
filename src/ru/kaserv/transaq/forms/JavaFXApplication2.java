package ru.kaserv.transaq.forms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.kaserv.transaq.object.XmlObjectFactory;

/**
 *
 * @author 1
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Transaq connector");
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();         
        
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
