//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.23 at 12:02:54 PM MSK 
//


package java_classes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="quotation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="board" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="seccode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="point_cost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="tradingstatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="last" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="priceminusprevwaprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="bid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="biddepth" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="biddeptht" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="numbids" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="offer" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="offerdepth" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="offerdeptht" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="numoffers" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="open" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="high" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="low" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="voltoday" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="numtrades" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="valtoday" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="openpositions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="deltapositions" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   &lt;element name="waprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="closeprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="marketpricetoday" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="lcurrentprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="buydeposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="selldeposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="secid" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
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
    "quotation"
})
@XmlRootElement(name = "quotations")
public class Quotations {

    @XmlElement(required = true)
    protected Quotations.Quotation quotation;

    /**
     * Gets the value of the quotation property.
     * 
     * @return
     *     possible object is
     *     {@link Quotations.Quotation }
     *     
     */
    public Quotations.Quotation getQuotation() {
        return quotation;
    }

    /**
     * Sets the value of the quotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Quotations.Quotation }
     *     
     */
    public void setQuotation(Quotations.Quotation value) {
        this.quotation = value;
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
     *         &lt;element name="point_cost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="tradingstatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="last" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="priceminusprevwaprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="bid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="biddepth" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="biddeptht" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="numbids" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="offer" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="offerdepth" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="offerdeptht" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="numoffers" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="open" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="high" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="low" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="voltoday" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="numtrades" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="valtoday" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="openpositions" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="deltapositions" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         &lt;element name="waprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="closeprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="marketpricetoday" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="lcurrentprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="buydeposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="selldeposit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *       &lt;attribute name="secid" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
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
        "seccode",
        "pointCost",
        "tradingstatus",
        "last",
        "quantity",
        "time",
        "change",
        "priceminusprevwaprice",
        "bid",
        "biddepth",
        "biddeptht",
        "numbids",
        "offer",
        "offerdepth",
        "offerdeptht",
        "numoffers",
        "open",
        "high",
        "low",
        "voltoday",
        "numtrades",
        "valtoday",
        "openpositions",
        "deltapositions",
        "waprice",
        "closeprice",
        "marketpricetoday",
        "lcurrentprice",
        "buydeposit",
        "selldeposit"
    })
    public static class Quotation {

        @XmlElement(required = true)
        protected String board;
        @XmlElement(required = true)
        protected String seccode;
        @XmlElement(name = "point_cost", required = true)
        protected BigDecimal pointCost;
        @XmlSchemaType(name = "unsignedByte")
        protected short tradingstatus;
        @XmlElement(required = true)
        protected BigDecimal last;
        @XmlSchemaType(name = "unsignedByte")
        protected short quantity;
        @XmlElement(required = true)
        protected String time;
        @XmlElement(required = true)
        protected BigDecimal change;
        @XmlElement(required = true)
        protected BigDecimal priceminusprevwaprice;
        @XmlElement(required = true)
        protected BigDecimal bid;
        @XmlSchemaType(name = "unsignedShort")
        protected int biddepth;
        @XmlSchemaType(name = "unsignedShort")
        protected int biddeptht;
        @XmlSchemaType(name = "unsignedByte")
        protected short numbids;
        @XmlElement(required = true)
        protected BigDecimal offer;
        @XmlSchemaType(name = "unsignedByte")
        protected short offerdepth;
        @XmlSchemaType(name = "unsignedShort")
        protected int offerdeptht;
        @XmlSchemaType(name = "unsignedByte")
        protected short numoffers;
        @XmlElement(required = true)
        protected BigDecimal open;
        @XmlElement(required = true)
        protected BigDecimal high;
        @XmlElement(required = true)
        protected BigDecimal low;
        @XmlSchemaType(name = "unsignedShort")
        protected int voltoday;
        @XmlSchemaType(name = "unsignedShort")
        protected int numtrades;
        @XmlElement(required = true)
        protected BigDecimal valtoday;
        @XmlSchemaType(name = "unsignedInt")
        protected long openpositions;
        protected short deltapositions;
        @XmlElement(required = true)
        protected BigDecimal waprice;
        @XmlElement(required = true)
        protected BigDecimal closeprice;
        @XmlElement(required = true)
        protected BigDecimal marketpricetoday;
        @XmlElement(required = true)
        protected BigDecimal lcurrentprice;
        @XmlElement(required = true)
        protected BigDecimal buydeposit;
        @XmlElement(required = true)
        protected BigDecimal selldeposit;
        @XmlAttribute(name = "secid", required = true)
        @XmlSchemaType(name = "unsignedShort")
        protected int secid;

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
         * Gets the value of the pointCost property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPointCost() {
            return pointCost;
        }

        /**
         * Sets the value of the pointCost property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPointCost(BigDecimal value) {
            this.pointCost = value;
        }

        /**
         * Gets the value of the tradingstatus property.
         * 
         */
        public short getTradingstatus() {
            return tradingstatus;
        }

        /**
         * Sets the value of the tradingstatus property.
         * 
         */
        public void setTradingstatus(short value) {
            this.tradingstatus = value;
        }

        /**
         * Gets the value of the last property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLast() {
            return last;
        }

        /**
         * Sets the value of the last property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLast(BigDecimal value) {
            this.last = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         */
        public short getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         */
        public void setQuantity(short value) {
            this.quantity = value;
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
         * Gets the value of the change property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getChange() {
            return change;
        }

        /**
         * Sets the value of the change property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setChange(BigDecimal value) {
            this.change = value;
        }

        /**
         * Gets the value of the priceminusprevwaprice property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPriceminusprevwaprice() {
            return priceminusprevwaprice;
        }

        /**
         * Sets the value of the priceminusprevwaprice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPriceminusprevwaprice(BigDecimal value) {
            this.priceminusprevwaprice = value;
        }

        /**
         * Gets the value of the bid property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getBid() {
            return bid;
        }

        /**
         * Sets the value of the bid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setBid(BigDecimal value) {
            this.bid = value;
        }

        /**
         * Gets the value of the biddepth property.
         * 
         */
        public int getBiddepth() {
            return biddepth;
        }

        /**
         * Sets the value of the biddepth property.
         * 
         */
        public void setBiddepth(int value) {
            this.biddepth = value;
        }

        /**
         * Gets the value of the biddeptht property.
         * 
         */
        public int getBiddeptht() {
            return biddeptht;
        }

        /**
         * Sets the value of the biddeptht property.
         * 
         */
        public void setBiddeptht(int value) {
            this.biddeptht = value;
        }

        /**
         * Gets the value of the numbids property.
         * 
         */
        public short getNumbids() {
            return numbids;
        }

        /**
         * Sets the value of the numbids property.
         * 
         */
        public void setNumbids(short value) {
            this.numbids = value;
        }

        /**
         * Gets the value of the offer property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOffer() {
            return offer;
        }

        /**
         * Sets the value of the offer property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOffer(BigDecimal value) {
            this.offer = value;
        }

        /**
         * Gets the value of the offerdepth property.
         * 
         */
        public short getOfferdepth() {
            return offerdepth;
        }

        /**
         * Sets the value of the offerdepth property.
         * 
         */
        public void setOfferdepth(short value) {
            this.offerdepth = value;
        }

        /**
         * Gets the value of the offerdeptht property.
         * 
         */
        public int getOfferdeptht() {
            return offerdeptht;
        }

        /**
         * Sets the value of the offerdeptht property.
         * 
         */
        public void setOfferdeptht(int value) {
            this.offerdeptht = value;
        }

        /**
         * Gets the value of the numoffers property.
         * 
         */
        public short getNumoffers() {
            return numoffers;
        }

        /**
         * Sets the value of the numoffers property.
         * 
         */
        public void setNumoffers(short value) {
            this.numoffers = value;
        }

        /**
         * Gets the value of the open property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOpen() {
            return open;
        }

        /**
         * Sets the value of the open property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOpen(BigDecimal value) {
            this.open = value;
        }

        /**
         * Gets the value of the high property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getHigh() {
            return high;
        }

        /**
         * Sets the value of the high property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setHigh(BigDecimal value) {
            this.high = value;
        }

        /**
         * Gets the value of the low property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLow() {
            return low;
        }

        /**
         * Sets the value of the low property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLow(BigDecimal value) {
            this.low = value;
        }

        /**
         * Gets the value of the voltoday property.
         * 
         */
        public int getVoltoday() {
            return voltoday;
        }

        /**
         * Sets the value of the voltoday property.
         * 
         */
        public void setVoltoday(int value) {
            this.voltoday = value;
        }

        /**
         * Gets the value of the numtrades property.
         * 
         */
        public int getNumtrades() {
            return numtrades;
        }

        /**
         * Sets the value of the numtrades property.
         * 
         */
        public void setNumtrades(int value) {
            this.numtrades = value;
        }

        /**
         * Gets the value of the valtoday property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValtoday() {
            return valtoday;
        }

        /**
         * Sets the value of the valtoday property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValtoday(BigDecimal value) {
            this.valtoday = value;
        }

        /**
         * Gets the value of the openpositions property.
         * 
         */
        public long getOpenpositions() {
            return openpositions;
        }

        /**
         * Sets the value of the openpositions property.
         * 
         */
        public void setOpenpositions(long value) {
            this.openpositions = value;
        }

        /**
         * Gets the value of the deltapositions property.
         * 
         */
        public short getDeltapositions() {
            return deltapositions;
        }

        /**
         * Sets the value of the deltapositions property.
         * 
         */
        public void setDeltapositions(short value) {
            this.deltapositions = value;
        }

        /**
         * Gets the value of the waprice property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getWaprice() {
            return waprice;
        }

        /**
         * Sets the value of the waprice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setWaprice(BigDecimal value) {
            this.waprice = value;
        }

        /**
         * Gets the value of the closeprice property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getCloseprice() {
            return closeprice;
        }

        /**
         * Sets the value of the closeprice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setCloseprice(BigDecimal value) {
            this.closeprice = value;
        }

        /**
         * Gets the value of the marketpricetoday property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMarketpricetoday() {
            return marketpricetoday;
        }

        /**
         * Sets the value of the marketpricetoday property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMarketpricetoday(BigDecimal value) {
            this.marketpricetoday = value;
        }

        /**
         * Gets the value of the lcurrentprice property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLcurrentprice() {
            return lcurrentprice;
        }

        /**
         * Sets the value of the lcurrentprice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLcurrentprice(BigDecimal value) {
            this.lcurrentprice = value;
        }

        /**
         * Gets the value of the buydeposit property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getBuydeposit() {
            return buydeposit;
        }

        /**
         * Sets the value of the buydeposit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setBuydeposit(BigDecimal value) {
            this.buydeposit = value;
        }

        /**
         * Gets the value of the selldeposit property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSelldeposit() {
            return selldeposit;
        }

        /**
         * Sets the value of the selldeposit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSelldeposit(BigDecimal value) {
            this.selldeposit = value;
        }

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

    }

}
