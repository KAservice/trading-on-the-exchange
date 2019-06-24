/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 1
 */
public class RemnantOfSecuritiesBuilder {
    
    String filePath="RemnantOfSecurities.xml";
    
    public    void save(RemnantOfSecurities obj){
        
        try {
            JAXBContext context = JAXBContext.newInstance(RemnantOfSecurities.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
 
            // маршаллинг объекта в файл
            marshaller.marshal(obj, new File(filePath));
            
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }    
        
    }


public  RemnantOfSecurities load(){
    
    RemnantOfSecurities result = null;
    
    
        File file = new File(filePath);
        boolean f=false;

        f = file.exists();

        
        if (f == false) return result;
            
        try {
            JAXBContext context = JAXBContext.newInstance(RemnantOfSecurities.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            result = (RemnantOfSecurities) unmarshaller.unmarshal(new File(filePath));
            
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }    
    return result;    
    }

    
}
