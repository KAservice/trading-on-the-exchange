/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

/**
 *
 * @author 1
 * 

    }
 */


public class CancelOrderCommand {
    
    private int transactionid;
    
    public String createCommandCancelOrder(int id){
   
        String result = "<command id=\"cancelorder\">"
                + " <transactionid>"+id+"</transactionid>"
                + "</command>";  
        
        
    return result;   
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }
    
    public String getStringCommand(){
        String result = "<command id=\"cancelorder\">"
                + " <transactionid>"+transactionid+"</transactionid>"
                + "</command>";  
        
        
    return result;        
        
        
    }
    
}
