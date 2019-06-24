//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.20 at 11:24:15 AM MSK 
//


package ru.kaserv.transaq.object;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="market" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="union" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="forts_acc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="remove" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "currency",
    "market",
    "union",
    "fortsAcc"
})
@XmlRootElement(name = "client")
public class Client {

    @XmlElement()
    protected String type;
    @XmlElement()
    protected String currency;
    @XmlElement()
    protected Integer market;
    @XmlElement()
    protected String union;
    @XmlElement(name = "forts_acc")
    protected String fortsAcc;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "remove")
    protected String remove;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the market property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getMarket() {
        return market;
    }

    /**
     * Sets the value of the market property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMarket(Integer value) {
        this.market = value;
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
     * Gets the value of the fortsAcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFortsAcc() {
        return fortsAcc;
    }

    /**
     * Sets the value of the fortsAcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFortsAcc(String value) {
        this.fortsAcc = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the remove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemove() {
        return remove;
    }

    /**
     * Sets the value of the remove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemove(String value) {
        this.remove = value;
    }

}