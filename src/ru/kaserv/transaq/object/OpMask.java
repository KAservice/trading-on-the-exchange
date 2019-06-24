/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.object;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public  class OpMask {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "usecredit")
            protected String usecredit;
            @XmlAttribute(name = "bymarket")
            protected String bymarket;
            @XmlAttribute(name = "nosplit")
            protected String nosplit;
            @XmlAttribute(name = "immorcancel")
            protected String immorcancel;
            @XmlAttribute(name = "cancelbalance")
            protected String cancelbalance;

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
             * Gets the value of the usecredit property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUsecredit() {
                return usecredit;
            }

            /**
             * Sets the value of the usecredit property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUsecredit(String value) {
                this.usecredit = value;
            }

            /**
             * Gets the value of the bymarket property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBymarket() {
                return bymarket;
            }

            /**
             * Sets the value of the bymarket property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBymarket(String value) {
                this.bymarket = value;
            }

            /**
             * Gets the value of the nosplit property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNosplit() {
                return nosplit;
            }

            /**
             * Sets the value of the nosplit property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNosplit(String value) {
                this.nosplit = value;
            }

            /**
             * Gets the value of the immorcancel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getImmorcancel() {
                return immorcancel;
            }

            /**
             * Sets the value of the immorcancel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setImmorcancel(String value) {
                this.immorcancel = value;
            }

            /**
             * Gets the value of the cancelbalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCancelbalance() {
                return cancelbalance;
            }

            /**
             * Sets the value of the cancelbalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCancelbalance(String value) {
                this.cancelbalance = value;
            }

        }