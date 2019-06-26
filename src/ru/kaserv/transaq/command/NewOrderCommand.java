/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author 1
 */

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "security",
        "client",
        "union",
        "price",
        "hidden",
        "quantity",
        "buysell",
        "brokerref",
        "unfilled",
        "expdate"
    })
    @XmlRootElement(name = "commaand")
    public class NewOrderCommand {

        @XmlAttribute(name = "id")
        protected String id = "neworder";    

        protected NewOrderCommand.Security security;
            
        protected String client;
        protected String union;
        protected BigDecimal price;
        protected Integer hidden;
        protected Integer quantity;
        protected String buysell; //B or S
        protected String brokerref;
        protected String unfilled;//PutInQueue, FOK, IOC
                //04.06.2019 16:03:13.279
        @XmlJavaTypeAdapter(NewOrderCommand.DateAdapter.class)
        protected Date expdate;
        
        
        @XmlTransient
        protected Long transactionid;
    


        
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "board",
            "seccode"
        })        
        public static class Security {
            
            protected String board;
            protected String seccode;
            
        }
        
        
    public static class DateAdapter extends XmlAdapter<String, Date> {
        ////04.06.2019 16:03:13.279
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        @Override
        public String marshal(Date v) throws Exception {
            synchronized (dateFormat) {
                return dateFormat.format(v);
            }
        }

        @Override
        public Date unmarshal(String v) throws Exception {
            synchronized (dateFormat) {
                return dateFormat.parse(v);
            }
        }

    }
    
}
