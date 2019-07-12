/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kaserv.transaq.handler;

import java.util.Collections;
import javafx.collections.ObservableList;
import ru.kaserv.transaq.configuration.SecurityForQuotes;
import ru.kaserv.transaq.configuration.StorageConfig;
import ru.kaserv.transaq.object.Quotes;
import ru.kaserv.transaq.storage.QuotesStorage;

/**
 *
 * @author 1
 */
public class QuotesHandler {
    
    public void AddQuoteInStorage(Quotes.Quote quote){
        
     //find client config
    SecurityForQuotes quotesStorageConfig = StorageConfig.getStorageConfig().
                            getSecuritiesForQuotes().
                            findQuotesStorageConfigByQuotes(quote.getSeccode(),quote.getBoard()); 
     
    QuotesStorage quotesStorage = quotesStorageConfig.getQuotesStorage();

    ObservableList<Quotes.Quote> quoteObList = quotesStorage.getObservableList();

            int index = quoteObList.indexOf(quote); 
            if (index == -1){
                quoteObList.add(quote); 
                
            }
            else{
                    Quotes.Quote quote_old=quoteObList.get(index);

                    if (quote.getSell() == null){
                        System.out.println("el.getSell() == null");
                    }
                    if (quote.getBuy() == null){
                        System.out.println("el.getBuy() == null");
                    }

                    if(quote.getSell() == -1 && quote.getBuy() == -1){//удаляем строку
                        quoteObList.remove(index);
                        quoteObList.sorted(); 
                    }

                    if(quote.getSell() == -1 && quote.getBuy() == 0){//удаляем строку
                        quoteObList.remove(index);
                        quoteObList.sorted(); 
                    }               

                    if(quote.getSell() == 0 && quote.getBuy() == -1){//удаляем строку
                        quoteObList.remove(index);
                        quoteObList.sorted(); 
                    } 

                    quote_old.setBuy(quote.getBuy());
                    quote_old.setSell(quote.getSell());

                    quote_old.setBoard(quote.getBoard());
                    quote_old.setPrice(quote.getPrice());
                    quote_old.setSeccode(quote.getSeccode());

            }
                       
    Collections.sort(quoteObList);   
    //System.out.println("Добавили запись в таблицу quotes: ");    
    }
    
}
