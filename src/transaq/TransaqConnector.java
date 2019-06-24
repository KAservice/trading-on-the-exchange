/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaq;

/**
 *
 * @author 1
 */
public class TransaqConnector {
    
    private static TransaqConnector transaqConnector;
    private TransaqQueue queue = null;
    private Object blockObject = null;
    long currentTime = 0;

    Thread thread;

 
    
    static {
    System.loadLibrary("kasTXmlConnector");
    }

    public native int GetServiceInfo(byte[] request, byte[] response);

    public native byte[] Initialize(byte[] logPath, int logLevel);
    public native byte[] SetLogLevel(int logLevel);
    public native byte[] SendCommand(byte[] pData);
    public native byte[] UnInitialize();
    
    
    public native byte[] LoadDllTransaq();
    public native byte[] UnLoadDllTransaq();
    public native byte[] SetCallback();

    public TransaqConnector() {
        transaqConnector = this;        
    }
    
    
    
    


    public void ReceiveBlock(byte[] block) { 
        
      //  System.out.println("Connector начал обрабатывать принятый блок, время: " + System.nanoTime()); 
      //  System.out.println("Connector разница: " + (System.nanoTime() - currentTime));
      //  currentTime = System.nanoTime();
     //   System.out.println("Приняли блок, текущий поток: " + Thread.currentThread().getName()); 
     //   System.out.println("Приняли блок, всего потоков: " + Thread.activeCount()); 
     //   thread = Thread.currentThread();
        
        String str = new String (block);
        
        
        str = str.trim();
        
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
    //System.out.println(" ");     
    //System.out.println("Тип данных: " + typeData1); 
    //System.out.println(" "); 
   // System.out.println("Принято: " + str); 
        
        synchronized (blockObject){
         queue.add(str); 
         blockObject.notifyAll();
        }
        
    
   // System.out.println("Connector количество записей в очереди: " + queue.size());
   // System.out.println("Connector закончил обрабатывать принятый блок, время: " + System.nanoTime()); 
   // System.out.println("Connector разница: " + (System.nanoTime() - currentTime));
   // currentTime = System.nanoTime();   
    
    
    

    
    
    }
    
    
    
    
    
    
    public TransaqQueue getQueue() {
        return queue;
    }

    public void setQueue(TransaqQueue queue) {
        this.queue = queue;
    }   
    
    
    public void StopThread() {
        
        
    }
    
    public Object getBlockObject() {
        return blockObject;
    }

    public void setBlockObject(Object blockObject) {
        this.blockObject = blockObject;
    }

    public static TransaqConnector getTransaqConnector() {
        return transaqConnector;
    }

    
    public String sendCommandToServer(String command){
        System.out.println("Посылаем команду: \n" + command); 
        
        String result = "";
        byte[] resultCommand = SendCommand(command.getBytes());  
        if (resultCommand != null){
            if (resultCommand.length != 0){
                result = new String (resultCommand);    
            }
        }
            
        
        return result;
    }
    
}
