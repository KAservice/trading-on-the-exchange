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
public class ClientLimitsCommand {
    
    
    
    public String createCommandGetClientLimits(String id_client){
   
    String result = "<command id=\"get_client_limits\" client=\""+id_client+"\"/>";    
        
    return result;   
    }
       
       
    
}
