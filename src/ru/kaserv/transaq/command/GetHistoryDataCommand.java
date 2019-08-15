//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.17 at 10:30:36 AM MSK 
//


package ru.kaserv.transaq.command;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="security">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="board" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "security",
    "period",
    "count",
    "reset"
})
@XmlRootElement(name = "command")
public class GetHistoryDataCommand {

    @XmlElement(required = true)
    protected GetHistoryDataCommand.Security security;
    protected int period;
    protected int count;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(ConnectCommand.BooleanAdapter.class)
    protected Boolean reset;
    @XmlAttribute(name = "id")
    protected String id = "gethistorydata";

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link Command.Security }
     *     
     */
    public GetHistoryDataCommand.Security getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link Command.Security }
     *     
     */
    public void setSecurity(GetHistoryDataCommand.Security value) {
        this.security = value;
    }

    /**
     * Gets the value of the period property.
     * 
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     */
    public void setPeriod(int value) {
        this.period = value;
    }

    /**
     * Gets the value of the count property.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(int value) {
        this.count = value;
    }

    /**
     * Gets the value of the reset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean getReset() {
        return reset;
    }

    /**
     * Sets the value of the reset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReset(Boolean value) {
        this.reset = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="board" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "board",
        "seccode"
    })
    public static class Security {

        @XmlElement(required = true)
        protected String board;
        @XmlElement(required = true)
        protected String seccode;

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

    }
    
    
    static class BooleanAdapter extends XmlAdapter<String, Boolean> {
    
        @Override
        public Boolean unmarshal(String v) throws Exception
        {
            if ("true".equals(v))
            {
                return true;
            }
            return false;
        }

        @Override
        public String marshal(Boolean v) throws Exception
        {
            if (v == null)
            {
                return "false";
            }
            if (v)
            {
                return "true";
            }
            return "false";
        }
    }  

}
