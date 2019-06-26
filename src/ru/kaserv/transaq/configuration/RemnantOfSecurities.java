/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.kaserv.transaq.object.Trades;

/**
 *
 * @author 1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "elements"
})
@XmlRootElement(name = "RemnantOfSecurities")
public class RemnantOfSecurities {
    
    protected List<RemnantOfSecurities.RemnantOfSecurityElement> elements;

    public List<RemnantOfSecurities.RemnantOfSecurityElement> getElements() {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        return this.elements;
    }


    
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "date",
        "idClient",
        "seccode",
        "market",
        "remnant",
        "purchaseValue",
        "profit"
    })
    public static class RemnantOfSecurityElement {
        

        //04.06.2019 16:03:13.279
        @XmlJavaTypeAdapter(Trades.DateAdapter.class)
        protected Date date;
        protected String idClient;    
        protected String seccode = "";
        protected String market = "";
        protected Integer remnant= 0;
        protected BigDecimal purchaseValue = BigDecimal.ZERO;
        protected BigDecimal profit = BigDecimal.ZERO;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getIdClient() {
            return idClient;
        }

        public void setIdClient(String idClient) {
            this.idClient = idClient;
        }

        public String getSeccode() {
            return seccode;
        }

        public void setSeccode(String seccode) {
            this.seccode = seccode;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public Integer getRemnant() {
            return remnant;
        }

        public void setRemnant(Integer remnant) {
            this.remnant = remnant;
        }

        public BigDecimal getPurchaseValue() {
            return purchaseValue;
        }

        public void setPurchaseValue(BigDecimal purchaseValue) {
            this.purchaseValue = purchaseValue;
        }

        public BigDecimal getProfit() {
            return profit;
        }

        public void setProfit(BigDecimal profit) {
            this.profit = profit;
        }
        
        
        
    }



    public static class DateAdapter extends XmlAdapter<String, Date> {
    ////04.06.2019 16:03:13.279
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");

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
