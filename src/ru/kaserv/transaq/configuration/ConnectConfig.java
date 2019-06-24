/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.configuration;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author 1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "login",
    "password",
    "host",
    "port",
    "language",
    "autopos",
    "micexRegisters",
    "milliseconds",
    "utcTime",
    "proxy",
    "rqdelay",
    "sessionTimeout",
    "requestTimeout",
    "pushULimits",
    "pushPosEquity"
})
@XmlRootElement(name = "command")
public class ConnectConfig {

    @XmlElement(required = true)
    protected String login = "";
    @XmlElement(required = true)
    protected String password = "";
    @XmlElement(required = true)
    protected String host = "";
    protected Integer port = 0;
    @XmlElement(required = true)
    protected String language = "";
    
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    protected Boolean autopos = false;
    
    @XmlElement(name = "micex_registers", required = true)
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    protected Boolean micexRegisters = false;
    
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    protected Boolean milliseconds = false;
    
    @XmlElement(name = "utc_time", required = true)
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    protected Boolean utcTime = false;
    
    @XmlElement(required = true)
    protected ConnectConfig.Proxy proxy;
    
    protected Integer rqdelay = 0;
    @XmlElement(name = "session_timeout")
    protected Integer sessionTimeout = 0;
    @XmlElement(name = "request_timeout")
    protected Integer requestTimeout = 0;
    @XmlElement(name = "push_u_limits")
    protected Integer pushULimits = 0;
    @XmlElement(name = "push_pos_equity")
    protected Integer pushPosEquity = 0;
    @XmlAttribute(name = "id")
    protected String id = "";

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Gets the value of the port property.
     * 
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the autopos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public boolean getAutopos() {
        return autopos;
    }

    /**
     * Sets the value of the autopos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutopos(boolean value) {
        this.autopos = value;
    }

    /**
     * Gets the value of the micexRegisters property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public boolean getMicexRegisters() {
        return micexRegisters;
    }

    /**
     * Sets the value of the micexRegisters property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMicexRegisters(boolean value) {
        this.micexRegisters = value;
    }

    /**
     * Gets the value of the milliseconds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public boolean getMilliseconds() {
        return milliseconds;
    }

    /**
     * Sets the value of the milliseconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMilliseconds(boolean value) {
        this.milliseconds = value;
    }

    /**
     * Gets the value of the utcTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public boolean getUtcTime() {
        return utcTime;
    }

    /**
     * Sets the value of the utcTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtcTime(boolean value) {
        this.utcTime = value;
    }

    /**
     * Gets the value of the proxy property.
     * 
     * @return
     *     possible object is
     *     {@link Command.Proxy }
     *     
     */
    public ConnectConfig.Proxy getProxy() {
        return proxy;
    }

    /**
     * Sets the value of the proxy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Command.Proxy }
     *     
     */
    public void setProxy(ConnectConfig.Proxy value) {
        this.proxy = value;
    }

    /**
     * Gets the value of the rqdelay property.
     * 
     */
    public Integer getRqdelay() {
        return rqdelay;
    }

    /**
     * Sets the value of the rqdelay property.
     * 
     */
    public void setRqdelay(Integer value) {
        this.rqdelay = value;
    }

    /**
     * Gets the value of the sessionTimeout property.
     * 
     */
    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    /**
     * Sets the value of the sessionTimeout property.
     * 
     */
    public void setSessionTimeout(Integer value) {
        this.sessionTimeout = value;
    }

    /**
     * Gets the value of the requestTimeout property.
     * 
     */
    public Integer getRequestTimeout() {
        return requestTimeout;
    }

    /**
     * Sets the value of the requestTimeout property.
     * 
     */
    public void setRequestTimeout(Integer value) {
        this.requestTimeout = value;
    }

    /**
     * Gets the value of the pushULimits property.
     * 
     */
    public Integer getPushULimits() {
        return pushULimits;
    }

    /**
     * Sets the value of the pushULimits property.
     * 
     */
    public void setPushULimits(Integer value) {
        this.pushULimits = value;
    }

    /**
     * Gets the value of the pushPosEquity property.
     * 
     */
    public Integer getPushPosEquity() {
        return pushPosEquity;
    }

    /**
     * Sets the value of the pushPosEquity property.
     * 
     */
    public void setPushPosEquity(Integer value) {
        this.pushPosEquity = value;
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="addr" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="port" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="login" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Proxy {

        @XmlValue
        protected String value = "";
        @XmlAttribute(name = "type")
        protected String type = "";
        @XmlAttribute(name = "addr")
        protected String addr = "";
        @XmlAttribute(name = "port")
        protected Integer port = 0;
        @XmlAttribute(name = "login")
        protected String login = "";
        @XmlAttribute(name = "password")
        protected String password = "";

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

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
         * Gets the value of the addr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddr() {
            return addr;
        }

        /**
         * Sets the value of the addr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddr(String value) {
            this.addr = value;
        }

        /**
         * Gets the value of the port property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Integer getPort() {
            return port;
        }

        /**
         * Sets the value of the port property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setPort(Integer value) {
            this.port = value;
        }

        /**
         * Gets the value of the login property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLogin() {
            return login;
        }

        /**
         * Sets the value of the login property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLogin(String value) {
            this.login = value;
        }

        /**
         * Gets the value of the password property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the value of the password property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPassword(String value) {
            this.password = value;
        }

    }
    
    


static class BooleanAdapter extends XmlAdapter<String, Boolean> {
    
        @Override
        public Boolean unmarshal(String v) throws Exception
        {
            if ("1".equals(v))
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
                return "0";
            }
            if (v)
            {
                return "1";
            }
            return "0";
        }
    }    
    
}
