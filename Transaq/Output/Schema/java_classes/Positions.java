//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.19 at 11:31:05 AM MSK 
//


package java_classes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="money_position">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="union" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="markets">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="market" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="asset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="shortname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="register" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="saldoin" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="bought" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="sold" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="ordbuy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="ordbuycond" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="comission" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "moneyPosition"
})
@XmlRootElement(name = "positions")
public class Positions {

    @XmlElement(name = "money_position", required = true)
    protected Positions.MoneyPosition moneyPosition;

    /**
     * Gets the value of the moneyPosition property.
     * 
     * @return
     *     possible object is
     *     {@link Positions.MoneyPosition }
     *     
     */
    public Positions.MoneyPosition getMoneyPosition() {
        return moneyPosition;
    }

    /**
     * Sets the value of the moneyPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Positions.MoneyPosition }
     *     
     */
    public void setMoneyPosition(Positions.MoneyPosition value) {
        this.moneyPosition = value;
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
     *         &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="union" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="markets">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="market" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="asset" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="shortname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="register" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="saldoin" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="bought" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="sold" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="ordbuy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="ordbuycond" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="comission" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
        "client",
        "union",
        "markets",
        "asset",
        "shortname",
        "register",
        "saldoin",
        "bought",
        "sold",
        "saldo",
        "ordbuy",
        "ordbuycond",
        "comission"
    })
    public static class MoneyPosition {

        @XmlElement(required = true)
        protected String client;
        @XmlElement(required = true)
        protected Object union;
        @XmlElement(required = true)
        protected Positions.MoneyPosition.Markets markets;
        @XmlElement(required = true)
        protected String asset;
        @XmlElement(required = true)
        protected String shortname;
        @XmlElement(required = true)
        protected String register;
        @XmlElement(required = true)
        protected BigDecimal saldoin;
        @XmlElement(required = true)
        protected BigDecimal bought;
        @XmlElement(required = true)
        protected BigDecimal sold;
        @XmlElement(required = true)
        protected BigDecimal saldo;
        @XmlElement(required = true)
        protected BigDecimal ordbuy;
        @XmlElement(required = true)
        protected BigDecimal ordbuycond;
        @XmlElement(required = true)
        protected BigDecimal comission;

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
         *     {@link Object }
         *     
         */
        public Object getUnion() {
            return union;
        }

        /**
         * Sets the value of the union property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setUnion(Object value) {
            this.union = value;
        }

        /**
         * Gets the value of the markets property.
         * 
         * @return
         *     possible object is
         *     {@link Positions.MoneyPosition.Markets }
         *     
         */
        public Positions.MoneyPosition.Markets getMarkets() {
            return markets;
        }

        /**
         * Sets the value of the markets property.
         * 
         * @param value
         *     allowed object is
         *     {@link Positions.MoneyPosition.Markets }
         *     
         */
        public void setMarkets(Positions.MoneyPosition.Markets value) {
            this.markets = value;
        }

        /**
         * Gets the value of the asset property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAsset() {
            return asset;
        }

        /**
         * Sets the value of the asset property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAsset(String value) {
            this.asset = value;
        }

        /**
         * Gets the value of the shortname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShortname() {
            return shortname;
        }

        /**
         * Sets the value of the shortname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShortname(String value) {
            this.shortname = value;
        }

        /**
         * Gets the value of the register property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegister() {
            return register;
        }

        /**
         * Sets the value of the register property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegister(String value) {
            this.register = value;
        }

        /**
         * Gets the value of the saldoin property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSaldoin() {
            return saldoin;
        }

        /**
         * Sets the value of the saldoin property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSaldoin(BigDecimal value) {
            this.saldoin = value;
        }

        /**
         * Gets the value of the bought property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getBought() {
            return bought;
        }

        /**
         * Sets the value of the bought property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setBought(BigDecimal value) {
            this.bought = value;
        }

        /**
         * Gets the value of the sold property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSold() {
            return sold;
        }

        /**
         * Sets the value of the sold property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSold(BigDecimal value) {
            this.sold = value;
        }

        /**
         * Gets the value of the saldo property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSaldo() {
            return saldo;
        }

        /**
         * Sets the value of the saldo property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSaldo(BigDecimal value) {
            this.saldo = value;
        }

        /**
         * Gets the value of the ordbuy property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOrdbuy() {
            return ordbuy;
        }

        /**
         * Sets the value of the ordbuy property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOrdbuy(BigDecimal value) {
            this.ordbuy = value;
        }

        /**
         * Gets the value of the ordbuycond property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOrdbuycond() {
            return ordbuycond;
        }

        /**
         * Sets the value of the ordbuycond property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOrdbuycond(BigDecimal value) {
            this.ordbuycond = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="market" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
            "market"
        })
        public static class Markets {

            @XmlSchemaType(name = "unsignedByte")
            protected short market;

            /**
             * Gets the value of the market property.
             * 
             */
            public short getMarket() {
                return market;
            }

            /**
             * Sets the value of the market property.
             * 
             */
            public void setMarket(short value) {
                this.market = value;
            }

        }

    }

}
