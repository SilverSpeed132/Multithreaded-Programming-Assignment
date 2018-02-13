/**
 * Producer.java
 *
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Christopher Blair
 * @original program creators Greg Gagne, Peter Galvin, Avi Silberschatz
 * 
 * @date 2/10/2018
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread
{
    
   String producerName;
   
   
   public Producer(BoundedBuffer b) {     
        buffer = b;
   }

   public void run()
   {
   int message;

    
      while (true)
      {
         //Determines amount of time asleep
         int sleeptime = (int) ThreadLocalRandom.current().nextInt(1, 7 + 1);
         
         System.out.println("Producer "+ producerName + " sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // produce an item & enter it into the buffer
         message = ThreadLocalRandom.current().nextInt(8000, 50000 + 1);
         System.out.println("Producer "+ producerName +" produced " + message);

         buffer.enter(message);
      }
   }
   
   //sets name for the producer
   public void setNme(String inputName){
       producerName = inputName;
   }

   private  BoundedBuffer buffer;

}
