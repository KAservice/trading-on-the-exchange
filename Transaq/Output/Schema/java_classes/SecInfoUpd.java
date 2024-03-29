//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.27 at 11:28:27 AM MSK 
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
 *         &lt;element name="secid" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="market" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="buy_deposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="sell_deposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="minprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="maxprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "seccode",
    "market",
    "buyDeposit",
    "sellDeposit",
    "minprice",
    "maxprice"
})
@XmlRootElement(name = "sec_info_upd")
public class SecInfoUpd {

    @XmlSchemaType(name = "unsignedShort")
    protected int secid;
    @XmlElement(required = true)
    protected String seccode;
    @XmlSchemaType(name = "unsignedByte")
    protected short market;
    @XmlElement(name = "buy_deposit", required = true)
    protected BigDecimal buyDeposit;
    @XmlElement(name = "sell_deposit", required = true)
    protected BigDecimal sellDeposit;
    @XmlElement(required = true)
    protected BigDecimal minprice;
    @XmlElement(required = true)
    protected BigDecimal maxprice;

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

    /**
     * Gets the value of the buyDeposit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBuyDeposit() {
        return buyDeposit;
    }

    /**
     * Sets the value of the buyDeposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBuyDeposit(BigDecimal value) {
        this.buyDeposit = value;
    }

    /**
     * Gets the value of the sellDeposit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSellDeposit() {
        return sellDeposit;
    }

    /**
     * Sets the value of the sellDeposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSellDeposit(BigDecimal value) {
        this.sellDeposit = value;
    }

    /**
     * Gets the value of the minprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinprice() {
        return minprice;
    }

    /**
     * Sets the value of the minprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinprice(BigDecimal value) {
        this.minprice = value;
    }

    /**
     * Gets the value of the maxprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxprice() {
        return maxprice;
    }

    /**
     * Sets the value of the maxprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxprice(BigDecimal value) {
        this.maxprice = value;
    }

}
