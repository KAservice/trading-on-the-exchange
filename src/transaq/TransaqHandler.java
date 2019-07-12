/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaq;

import java.util.Collections;
import ru.kaserv.transaq.handler.AllTradesHandler;
import ru.kaserv.transaq.handler.BoardsHandler;
import ru.kaserv.transaq.handler.ClientLimitsHandler;
import ru.kaserv.transaq.handler.ClientsHandler;
import ru.kaserv.transaq.handler.OrdersHandler;
import ru.kaserv.transaq.handler.PortfolioTplusHandler;
import ru.kaserv.transaq.handler.PortfolioUnitedHandler;
import ru.kaserv.transaq.handler.QuotesHandler;
import ru.kaserv.transaq.object.Securities;
import ru.kaserv.transaq.object.Alltrades;
import ru.kaserv.transaq.object.Boards;
import ru.kaserv.transaq.object.Client;
import ru.kaserv.transaq.object.Orders;
import ru.kaserv.transaq.object.PortfolioTplus;
import ru.kaserv.transaq.object.Trades;
import ru.kaserv.transaq.object.XmlObjectFactory;
import ru.kaserv.transaq.handler.SecuritiesHandler;
import ru.kaserv.transaq.handler.TradesHandler;
import ru.kaserv.transaq.object.ClientLimits;
import ru.kaserv.transaq.object.PortfolioUnited;
import ru.kaserv.transaq.object.Quotes;

/**
 *
 * @author 1
 */
public class TransaqHandler implements Runnable {
    
  
    
 
    
    
    
    //public ObservableList<Boards.Board> boardObList;
   // public ObservableList<Candlekinds.Kind> candlekindObList;
    
   // public ObservableList<Quotes.Quote> quoteObList;
   // public ObservableList<Quotations.Quotation> quotationObList;
    

    
    
    
    
    private TransaqQueue queue = null;
    private Object blockObject = null;

    public Object getBlockObject() {
        return blockObject;
    }

    public void setBlockObject(Object blockObject) {
        this.blockObject = blockObject;
    }

    public TransaqQueue getQueue() {
        return queue;
    }

    public void setQueue(TransaqQueue queue) {
        this.queue = queue;
    }
    
   
    
    @Override
    public void run() { 
        System.out.println("Handler начал работать, количество записей в очереди: " + queue.size());
        
        String str="";
        long currentTime = 0;
        
        while (! Thread.currentThread().isInterrupted()) {
            
            
                synchronized (blockObject){
     
                    try {
                            if ((str = queue.poll()) == null){
                                
                               // System.out.println("Handler разница: " + (System.nanoTime() - currentTime));
                               // currentTime = System.nanoTime();
                               // System.out.println("Handler засыпает, нечего делать, время: " + System.nanoTime());
                                blockObject.wait();
                               // System.out.println("Handler проснулся начал обрабатывать принятый блок, время: " + System.nanoTime()); 
                               // System.out.println("Handler разница: " + (System.nanoTime() - currentTime));
                               // currentTime = System.nanoTime();
                                }
                            else {
                                handleElement(str); 
                               // System.out.println("Handler обработал принятый блок, время: " + System.nanoTime());
                               // System.out.println("Handler разница: " + (System.nanoTime() - currentTime));
                              //  currentTime = System.nanoTime();
                            }
                    }
                     catch (InterruptedException e) { 
                     System.out.println("Исключение: InterruptedException"); 
                     return;
                    } 
                }
            
            
            //System.out.println("Handler количество записей в очереди: " + queue.size());
                
                
        }
    }
    
    public void handleElement(String str){
        
        
        String typeData = "";
        String typeData1 = "";
        
        for (int i=0; i< str.length();i++){
            
          char symbol = str.charAt(i);
          
          if (symbol == '>'){
            break;    
          }
          
          if (symbol == ' '){
            break;    
          }
        
        typeData = typeData + symbol; 
        typeData = typeData.trim();
        //удалим первый символ
        typeData1 = typeData.substring(1,typeData.length());
        }
        
    boolean flProcessed = false;    
        
    if (typeData1.equals("securities") == true){ 
        
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        Securities elements;
        elements = factory.fromXmlToSecuritiesObject(str);      
        for (int i = 0; i < elements.getSecurity().size(); i++) {
            Securities.Security el = elements.getSecurity().get(i);  
            
            
            SecuritiesHandler securitiesOperation = new SecuritiesHandler();            
            securitiesOperation.AddSecurityInStorage(el);            
        }         
    }        

    
    if (typeData1.equals("boards") == true){ 
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        Boards elements;
        elements = factory.fromXmlToBoardsObject(str);      
        for (int i = 0; i < elements.getBoard().size(); i++) {
            Boards.Board el = elements.getBoard().get(i); 
            BoardsHandler boardsHandler= new BoardsHandler();
            boardsHandler.AddBoardInStorage(el);
          
        }         
    }

/*    if (typeData1.equals("candlekinds") == true){    
        XmlObjectFactory factory = new XmlObjectFactory();        
        Candlekinds elements;
        elements = factory.fromXmlToCandlekindsObject(str);      
        for (int i = 0; i < elements.getKind().size(); i++) {
            Candlekinds.Kind el = elements.getKind().get(i);            
            candlekindObList.add(el);            
        }         
    }

     if (typeData1.equals("quotations") == true){    
        XmlObjectFactory factory = new XmlObjectFactory();        
        Quotations elements;
        elements = factory.fromXmlToQuatationsObject(str);  
        Quotations.Quotation el = elements.getQuotation();
        quotationObList.add(el);
        
        
       // for (int i = 0; i < elements.getQuotation().size(); i++) {
       //     Quotations.Quotation el = elements.getQuotation().get(i);            
       //     quotationObList.add(el);            
        }         */
  
    if (typeData1.equals("quotes") == true){ 
        flProcessed = true; 
        //System.out.println("Получили alltrades ");
        XmlObjectFactory factory = new XmlObjectFactory();        
        Quotes elements;
        elements = factory.fromXmlToQuatesObject(str);      
        for (int i = 0; i < elements.getQuote().size(); i++) {
            Quotes.Quote el = elements.getQuote().get(i);           
            QuotesHandler quotesOperation = new QuotesHandler();            
            quotesOperation.AddQuoteInStorage(el);
          
            } 
 
    }
    
    if (typeData1.equals("alltrades") == true){ 
        flProcessed = true; 
        System.out.println("Получили alltrades ");
        XmlObjectFactory factory = new XmlObjectFactory();        
        Alltrades elements;
        elements = factory.fromXmlToAllTradesObject(str);               
        //alltradeObList.add(elements.getTrade()); 
        AllTradesHandler allTradesHandler= new AllTradesHandler();
        for (int i = 0; i < elements.getTrade().size(); i++) {
            Alltrades.Trade el = elements.getTrade().get(i);            
            AllTradesHandler allTradesOperation = new AllTradesHandler();            
            allTradesOperation.AddAllTradeInStorage(el);
          
            } 
        }         
    
     if (typeData1.equals("client") == true){   
         flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        Client elements;
        elements = factory.fromXmlToClientObject(str);   
        
        ClientsHandler clientsHandler= new ClientsHandler();            
        clientsHandler.AddClientInStorage(elements); 
    
        }
     
    if (typeData1.equals("trades") == true){  
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        Trades elements;
        elements = factory.fromXmlToTradesObject(str);
        for (int i = 0; i < elements.getTrade().size(); i++) {
            Trades.Trade el = elements.getTrade().get(i);            
            //tradeObList.add(el); 
            
                        
            TradesHandler tradesOperation = new TradesHandler();            
            tradesOperation.AddTradeInStorage(el);
            } 
        }  
    
    if (typeData1.equals("orders") == true){   
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        Orders elements;
        elements = factory.fromXmlToOrdersObject(str);
        for (int i = 0; i < elements.getOrder().size(); i++) {
            Orders.Order el = elements.getOrder().get(i); 
            
            OrdersHandler orderOperation = new OrdersHandler();            
            orderOperation.AddOrderInStorage(el);
          
            } 
        } 
    
 
        
    if (typeData1.equals("portfolio_tplus") == true){   
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        PortfolioTplus currencyPortfolioTplus = factory.fromXmlToPortfolioTplusObject(str);  
        
        PortfolioTplusHandler handler = new PortfolioTplusHandler ();
        handler.AddPortfolioTplusInStorage(currencyPortfolioTplus);
        }  
    
    if (typeData1.equals("united_portfolio") == true){ 
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        PortfolioUnited  currencyPortfolioUnited = factory.fromXmlToPortfolioUnitedObject(str);  
        
        PortfolioUnitedHandler handler = new PortfolioUnitedHandler ();
        handler.AddPortfolioTplusInStorage(currencyPortfolioUnited);
        }
    
    
    if (typeData1.equals("clientlimits") == true){  
        flProcessed = true; 
        XmlObjectFactory factory = new XmlObjectFactory();        
        ClientLimits  currencyClientLimits = factory.fromXmlToClientLimitsObject(str);  
        
        ClientLimitsHandler handler = new ClientLimitsHandler ();
        handler.AddClientLimitsInStorage(currencyClientLimits);
        }
    
    if (flProcessed != true){        
    System.out.println("Не обработанный пакет: " + typeData1);    
    }
        
    }
    
    
    public void StopThread() {
        
    Thread.currentThread().interrupt();   
    }

    
}
