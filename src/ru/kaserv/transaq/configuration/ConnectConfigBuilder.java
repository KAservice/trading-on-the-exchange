/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 1
 */
public class ConnectConfigBuilder {
    

    
public    void saveConnectConfig(ConnectConfig cfg){
        
            String filePath="ConnectConfig.xml";
            
        try {
            JAXBContext context = JAXBContext.newInstance(ConnectConfig.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
 
            // маршаллинг объекта в файл
            marshaller.marshal(cfg, new File(filePath));
            
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }    
        
    }


public  ConnectConfig loadConnectConfig(){
    
    ConnectConfig result = null;
    String filePath="ConnectConfig.xml";
            
        try {
            JAXBContext context = JAXBContext.newInstance(ConnectConfig.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            result = (ConnectConfig) unmarshaller.unmarshal(new File(filePath));
            
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }    
    return result;    
    }

   
}
