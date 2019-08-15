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
    
    private String clientId;
    private String seccode;
    private String board;
    
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
    
    
    
    
    
}
