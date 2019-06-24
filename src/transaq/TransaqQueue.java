/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaq;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author 1
 */
public class TransaqQueue {
    
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();
    
    
    public void add(String str){
        
        queue.add(str); 
        
    } 
    
    
   public String poll(){
       
       return queue.poll();
       
   }
    
  public int size(){
      return queue.size();
  } 
   
}
