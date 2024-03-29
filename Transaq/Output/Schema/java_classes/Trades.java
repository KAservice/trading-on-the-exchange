//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 01:37:42 PM MSK 
//


package java_classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trade" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="secid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="tradeno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="orderno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="board" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="union" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="buysell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="brokerref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="comission" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="items" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="accruedint" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="tradetype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="settlecode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="currentpos" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trade"
})
@XmlRootElement(name = "trades")
public class Trades {

    protected List<Trades.Trade> trade;

    /**
     * Gets the value of the trade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Trades.Trade }
     * 
     * 
     */
    public List<Trades.Trade> getTrade() {
        if (trade == null) {
            trade = new ArrayList<Trades.Trade>();
        }
        return this.trade;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="secid" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="tradeno" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="orderno" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="board" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="union" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="buysell" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="brokerref" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="comission" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="items" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="accruedint" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="tradetype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="settlecode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="currentpos" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "secid",
        "tradeno",
        "orderno",
        "board",
        "seccode",
        "client",
        "union",
        "buysell",
        "time",
        "brokerref",
        "value",
        "comission",
        "price",
        "items",
        "quantity",
        "yield",
        "accruedint",
        "tradetype",
        "settlecode",
        "currentpos"
    })
    public static class Trade {

        protected int secid;
        protected long tradeno;
        protected long orderno;
        @XmlElement(required = true)
        protected String board;
        @XmlElement(required = true)
        protected String seccode;
        @XmlElement(required = true)
        protected String client;
        @XmlElement(required = true)
        protected String union;
        @XmlElement(required = true)
        protected String buysell;
        @XmlElement(required = true)
        protected String time;
        @XmlElement(required = true)
        protected String brokerref;
        @XmlElement(required = true)
        protected BigDecimal value;
        @XmlElement(required = true)
        protected BigDecimal comission;
        @XmlElement(required = true)
        protected BigDecimal price;
        protected long items;
        protected int quantity;
        @XmlElement(required = true)
        protected BigDecimal yield;
        @XmlElement(required = true)
        protected BigDecimal accruedint;
        @XmlElement(required = true)
        protected String tradetype;
        @XmlElement(required = true)
        protected String settlecode;
        protected long currentpos;

        /**
         * Gets the value of the secid property.
         * 
         */
        public int getSecid() {
            return secid;
        }

        /**
         * Sets the value of the secid property.
         * 
         */
        public void setSecid(int value) {
            this.secid = value;
        }

        /**
         * Gets the value of the tradeno property.
         * 
         */
        public long getTradeno() {
            return tradeno;
        }

        /**
         * Sets the value of the tradeno property.
         * 
         */
        public void setTradeno(long value) {
            this.tradeno = value;
        }

        /**
         * Gets the value of the orderno property.
         * 
         */
        public long getOrderno() {
            return orderno;
        }

        /**
         * Sets the value of the orderno property.
         * 
         */
        public void setOrderno(long value) {
            this.orderno = value;
        }

        /**
         * Gets the value of the board property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBoard() {
            return board;
        }

        /**
         * Sets the value of the board property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBoard(String value) {
            this.board = value;
        }

        /**
         * Gets the value of the seccode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSeccode() {
            return seccode;
        }

        /**
         * Sets the value of the seccode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSeccode(String value) {
            this.seccode = value;
        }

        /**
         * Gets the value of the client property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClient() {
            return client;
        }

        /**
         * Sets the value of the client property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClient(String value) {
            this.client = value;
        }

        /**
         * Gets the value of the union property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnion() {
            return union;
        }

        /**
         * Sets the value of the union property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnion(String value) {
            this.union = value;
        }

        /**
         * Gets the value of the buysell property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBuysell() {
            return buysell;
        }

        /**
         * Sets the value of the buysell property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBuysell(String value) {
            this.buysell = value;
        }

        /**
         * Gets the value of the time property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTime() {
            return time;
        }

        /**
         * Sets the value of the time property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTime(String value) {
            this.time = value;
        }

        /**
         * Gets the value of the brokerref property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrokerref() {
            return brokerref;
        }

        /**
         * Sets the value of the brokerref property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrokerref(String value) {
            this.brokerref = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

        /**
         * Gets the value of the comission property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getComission() {
            return comission;
        }

        /**
         * Sets the value of the comission property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setComission(BigDecimal value) {
            this.comission = value;
        }

        /**
         * Gets the value of the price property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPrice(BigDecimal value) {
            this.price = value;
        }

        /**
         * Gets the value of the items property.
         * 
         */
        public long getItems() {
            return items;
        }

        /**
         * Sets the value of the items property.
         * 
         */
        public void setItems(long value) {
            this.items = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         */
        public void setQuantity(int value) {
            this.quantity = value;
        }

        /**
         * Gets the value of the yield property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getYield() {
            return yield;
        }

        /**
         * Sets the value of the yield property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setYield(BigDecimal value) {
            this.yield = value;
        }

        /**
         * Gets the value of the accruedint property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAccruedint() {
            return accruedint;
        }

        /**
         * Sets the value of the accruedint property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAccruedint(BigDecimal value) {
            this.accruedint = value;
        }

        /**
         * Gets the value of the tradetype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTradetype() {
            return tradetype;
        }

        /**
         * Sets the value of the tradetype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTradetype(String value) {
            this.tradetype = value;
        }

        /**
         * Gets the value of the settlecode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSettlecode() {
            return settlecode;
        }

        /**
         * Sets the value of the settlecode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSettlecode(String value) {
            this.settlecode = value;
        }

        /**
         * Gets the value of the currentpos property.
         * 
         */
        public long getCurrentpos() {
            return currentpos;
        }

        /**
         * Sets the value of the currentpos property.
         * 
         */
        public void setCurrentpos(long value) {
            this.currentpos = value;
        }

    }

}
