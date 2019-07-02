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
    @XmlRootElement(name = "command")
    public class NewOrderCommand {


        
     

        @XmlAttribute(name = "id")
        protected String id = "neworder";    

        protected NewOrderCommand.Security security = new Security();
            
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

            public String getBoard() {
                return board;
            }

            public void setBoard(String board) {
                this.board = board;
            }

            public String getSeccode() {
                return seccode;
            }

            public void setSeccode(String seccode) {
                this.seccode = seccode;
            }
  
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBuysell() {
        return buysell;
    }

    public void setBuysell(String buysell) {
        this.buysell = buysell;
    }

    public String getBrokerref() {
        return brokerref;
    }

    public void setBrokerref(String brokerref) {
        this.brokerref = brokerref;
    }

    public String getUnfilled() {
        return unfilled;
    }

    public void setUnfilled(String unfilled) {
        this.unfilled = unfilled;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public Long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }
    
    
    
    
}
