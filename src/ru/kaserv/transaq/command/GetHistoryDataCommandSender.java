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
public class GetHistoryDataCommandSender {
    
    public boolean sendCommand(GetHistoryDataCommand command){
    boolean result = true;
    
        TransaqConnector tr = TransaqConnector.getTransaqConnector();
        
        XmlCommandFactory xcf = new XmlCommandFactory(); 
 
        String command_xml = xcf.convertGetHistoryDataCommandToXml(command);
        
        tr.sendCommandToServer(command_xml);  
    
    
    return result;
    }
    
}
