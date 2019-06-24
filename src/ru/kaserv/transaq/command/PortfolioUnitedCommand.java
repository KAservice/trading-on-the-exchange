/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

/**
 *
 * @author 1
 */
public class PortfolioUnitedCommand {
    
    public String createCommandGetPortfolioUnited(String id_client, String id_union){
        
    String result = "";  
    
    if (id_client.length() != 0 && id_union.length() == 0){
        result = "<command id=\"get_united_portfolio\" client=\""+id_client+"\"/>";        
    }
    
    if (id_client.length() == 0 && id_union.length() != 0){
        result = "<command id=\"get_united_portfolio\" client=\"\" union=\""+id_union+"\"/>"; 
    }        
    
    return result;   
    }
    
}
