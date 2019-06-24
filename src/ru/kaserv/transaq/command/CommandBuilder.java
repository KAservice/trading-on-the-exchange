/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.command;

import ru.kaserv.transaq.configuration.ConnectConfig;
import ru.kaserv.transaq.configuration.ConnectConfigBuilder;

/**
 *
 * @author 1
 */
public class CommandBuilder {
    
    
    
    public String createCommandConnect(){
        String result="";
        
        ConnectConfigBuilder ccb = new ConnectConfigBuilder();
        ConnectConfig cc = ccb.loadConnectConfig();
        
        XmlCommandFactory xcf = new XmlCommandFactory();        
        ConnectCommand command = new ConnectCommand();
        command.setLogin(cc.getLogin());
        command.setPassword(cc.getPassword());
        command.setHost(cc.getHost());
        command.setPort(cc.getPort());
        command.setLanguage(cc.getLanguage());
        command.setAutopos(cc.getAutopos());
        command.setMicexRegisters(cc.getMicexRegisters());
        command.setMilliseconds(cc.getMilliseconds());
        command.setUtcTime(cc.getUtcTime());
        command.setRqdelay(cc.getRqdelay());
        command.setSessionTimeout(cc.getSessionTimeout());
        command.setRequestTimeout(cc.getRequestTimeout());
        command.setPushULimits(cc.getPushULimits());
        command.setPushPosEquity(cc.getPushPosEquity());

  
        
        result = xcf.convertObjectToXml(command);      
        return result;    
    }
    
    
    public String createCommandGetPortfolio(String idClient){
        String result = "";
        
        result = "<command id=\"get_portfolio\" client=\""+idClient+"\"/>";
        return result;
    }
    
}
