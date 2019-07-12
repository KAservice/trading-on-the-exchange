/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import transaq.TransaqConnector;

/**
 *
 * @author 1
 */
public class CancelOrderCommandSender {
    
    public boolean sendCommand(CancelOrderCommand command){
    boolean result = false;
   
        TransaqConnector tr = TransaqConnector.getTransaqConnector();
        String response = "";
        response = tr.sendCommandToServer(command.getStringCommand());

    return result;    
    }   
    
}
