/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.object;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 1
 */
public class XmlObjectFactory {
    
            // сохраняем объект в XML файл
    public void convertObjectToXml(Securities sec_list) {
        String result_xml="";
        try {
            JAXBContext context = JAXBContext.newInstance(Securities.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            // маршаллинг объекта в файл
            marshaller.marshal(sec_list, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
        // восстанавливаем объект из XML файла
    public  Securities fromXmlToSecuritiesObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Securities.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Securities) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
    
    
    public  Boards  fromXmlToBoardsObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Boards.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Boards) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
        
    public  Candlekinds  fromXmlToCandlekindsObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Candlekinds.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Candlekinds) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
    
    
       public  Quotations fromXmlToQuatationsObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Quotations.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Quotations) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
       
       
    public  Quotes fromXmlToQuatesObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Quotes.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Quotes) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
 
    
    public  Alltrades fromXmlToAllTradesObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Alltrades.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Alltrades) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
    
    public  Client fromXmlToClientObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Client) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
    
    public  Trades fromXmlToTradesObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Trades.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Trades) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }   
    
    public  PortfolioTplus fromXmlToPortfolioTplusObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(PortfolioTplus.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (PortfolioTplus) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }   
    
    public  PortfolioUnited fromXmlToPortfolioUnitedObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(PortfolioUnited.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (PortfolioUnited) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    } 
    
    
        public  Orders fromXmlToOrdersObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (Orders) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
        
        public  ClientLimits fromXmlToClientLimitsObject(String xml_data) {
        StringReader reader = new StringReader(xml_data);
        
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(ClientLimits.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //this. = (SecurityList) un.unmarshal(reader);
            return (ClientLimits) un.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;      
   
    }
        
        
        
        
        
}
