/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 *
 * @author 1
 */
public class XmlCommandFactory {
    
    
    
    // сохраняем объект в XML файл
    public String convertObjectToXml(ConnectCommand command) {
        String result="";
        try {
            JAXBContext context = JAXBContext.newInstance(ConnectCommand.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            
            StringWriter sw = new StringWriter();
 
            // маршаллинг объекта в файл
            marshaller.marshal(command, sw);
            result = sw.toString();
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }
        
    return result;    
    }
    
    public String convertObjectNewOrderCommandToXml(NewOrderCommand command) {
        String result="";
        try {
            JAXBContext context = JAXBContext.newInstance(NewOrderCommand.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            
            StringWriter sw = new StringWriter();
 
            // маршаллинг объекта в файл
            marshaller.marshal(command, sw);
            result = sw.toString();
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }
        
    return result;    
    }
    
    
    public String convertSubscribeCommandToXml(SubscribeCommand command) {
        String result="";
        try {
            JAXBContext context = JAXBContext.newInstance(SubscribeCommand.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            
            StringWriter sw = new StringWriter();
 
            // маршаллинг объекта в файл
            marshaller.marshal(command, sw);
            result = sw.toString();
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }
        
    return result;    
    }    
    
    
}


