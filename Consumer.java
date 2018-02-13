/**
 * Consumer.java
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * @author Christopher Blair
 * @original program creators Greg Gagne, Peter Galvin, Avi Silberschatz
 * 
 * @date 2/10/2018
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread
{
    String consumerName;
    
   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }

   public void run()
   {
   int message;
   String message2 = null;

     while (true)
      {
          //Determines sleep time
         int sleeptime = (int) ThreadLocalRandom.current().nextInt(1, 12 + 1);

         System.out.println("Consumer "+ consumerName+" sleeping for " + sleeptime + " seconds");
              
         
         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println("Consumer "+ consumerName+" wants to consume.");

         message = (int)buffer.remove();
        
         //Retrieves a Prime Message
        if (isPrime(message)){
            message2 = "IT IS PRIME";
        }
        else{
            message2 = "IT IS NOT PRIME";
        }
         
         System.out.println("Consumer " + consumerName + " consumed "+message+ " and " +message2);
      }
   }

   private  BoundedBuffer buffer;

   //Determines if the consumed number is prime or not
   boolean isPrime(int message){      
        if(message%2==0)
            return false;
        for(int i=3;i*i<message; i+=2){
            if(message%i == 0)
                return false;
        }
        return true;
   }
   //Sets the name of the consumer
   public void setNme(String inputName){
       consumerName = inputName;
   }
}


